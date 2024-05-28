package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Benutzer;
import dnlhng.webtech.dnlhng.web.api.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class PostController {

    private List<Post> posts;

    public PostController(){
        posts = new ArrayList<>();
        posts.add(new Post(1, "Hoang", "hallo"));
    }

    @GetMapping(path = "/posts")
    public ResponseEntity<List<Post>> fetchPosts() {
        return ResponseEntity.ok(posts);
    }
}
