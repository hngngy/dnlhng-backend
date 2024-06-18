package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.api.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Post>> getPost() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") final Long id) {
        final Optional<Post> found = postService.getPost(id);
        return found.isPresent() ? ResponseEntity.ok(found.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> addPost(@Valid @RequestBody Post body) {
        final Post post = new Post(body.getId(), body.getUsername(), body.getMessage());
        final Post createdPost = postService.addPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

}
