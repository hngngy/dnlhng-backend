package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.api.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
        final Post post = new Post(body.getUsername(), body.getMessage());
        final Post createdPost = postService.addPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") final Long id) {
        return postService.removePost(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> updatePost(@PathVariable("id") final Long id, @RequestBody Post body) {
        body.setId(id);
        final Post updatedPost = postService.editPost(body);
        if (updatedPost == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedPost);
    }

}