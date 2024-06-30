package dnlhng.webtech.dnlhng.service;

import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.PostRepository;
import dnlhng.webtech.dnlhng.web.api.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    private List<Post> mockPosts;

    @BeforeEach
    void setUpMockRepository() {
        // Mock data setup
        mockPosts = new ArrayList<>();
        mockPosts.add(new Post(1L, "user1", "First post"));
        mockPosts.add(new Post(2L, "user2", "Second post"));

        // Mock repository methods
        when(postRepository.findAll()).thenReturn(mockPosts);
        when(postRepository.findById(1L)).thenReturn(Optional.of(mockPosts.get(0)));
    }

    @Test
    void testGetAllPosts() {
        Iterable<Post> result = postService.getPosts();

        // Convert Iterable to List for easier assertion
        List<Post> resultList = new ArrayList<>();
        result.forEach(resultList::add);

        // Assert size and content
        assertEquals(mockPosts.size(), resultList.size(), "Number of posts should match");
        assertEquals(mockPosts.get(0).getMessage(), resultList.get(0).getMessage(), "First post message should match");
        assertEquals(mockPosts.get(1).getUsername(), resultList.get(1).getUsername(), "Second post username should match");
    }

    @Test
    void testGetPostById() {
        Long postId = 1L;
        Optional<Post> result = postService.getPost(postId);

        // Assert post is present and matches expected data
        assertEquals(true, result.isPresent(), "Post should be present");
        assertEquals(mockPosts.get(0).getId(), result.get().getId(), "Post ID should match");
        assertEquals(mockPosts.get(0).getUsername(), result.get().getUsername(), "Post username should match");
    }
}
