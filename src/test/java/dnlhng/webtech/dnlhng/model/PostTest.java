package dnlhng.webtech.dnlhng.model;

import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.api.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostTest {
    private PostService postService;

    @Test
    void testPostToString() {
        // Create a new Post object
        Post post = new Post("user1", "Hello World");
        post.setId(1L);
        String expectation = "Post(id=1, username=user1, message=Hello World)";
        String result = post.toString();
        assertEquals(expectation, result);
    }
}
