package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Post;
import dnlhng.webtech.dnlhng.web.api.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PostController {

    @Autowired
    PostService service;

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post){
        return service.save(post);
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id){
        Long postId = Long.parseLong(id);
        return service.get(postId);
    }
}
