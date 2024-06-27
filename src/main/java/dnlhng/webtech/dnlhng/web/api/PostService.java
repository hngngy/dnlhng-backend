package dnlhng.webtech.dnlhng.web.api;


import dnlhng.webtech.dnlhng.web.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repo;

    public Post addPost (final Post post){
        return repo.save(post);
    }

    public Optional<Post> getPost(Long id) {
        return this.repo.findById(id);
    }

    public Iterable<Post> getPosts() {
        return this.repo.findAll();
    }

    public Post get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public boolean removePost(final Long id) {
        final boolean exists = repo.existsById(id);
        if (exists) repo.deleteById(id);
        return exists;
    }
}
