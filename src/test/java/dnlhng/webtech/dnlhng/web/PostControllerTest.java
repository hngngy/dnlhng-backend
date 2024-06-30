package dnlhng.webtech.dnlhng.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.PostController;
import dnlhng.webtech.dnlhng.web.api.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private List<Post> mockPosts;

    @BeforeEach
    void setUpMockService() {
        // Mock data setup
        mockPosts = new ArrayList<>();
        mockPosts.add(new Post(1L, "user1", "First post"));
        mockPosts.add(new Post(2L, "user2", "Second post"));

        // Mock service methods
        when(postService.getPost(1L)).thenReturn(Optional.of(mockPosts.get(0)));
        when(postService.getPosts()).thenReturn(mockPosts);
    }

    @Test
    void testGetPostById() throws Exception {
        final String expectation = "{\"id\":1,\"username\":\"user1\",\"message\":\"First post\"}";
        this.mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }

    @Test
    void testGetAllPosts() throws Exception {
        final String expectation = "[{\"id\":1,\"username\":\"user1\",\"message\":\"First post\"},{\"id\":2,\"username\":\"user2\",\"message\":\"Second post\"}]";
        this.mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectation));
    }

    @Test
    void testDeletePost() throws Exception {
        when(postService.removePost(1L)).thenReturn(true);

        this.mockMvc.perform(delete("/posts/1"))
                .andExpect(status().isNoContent());
    }
}
