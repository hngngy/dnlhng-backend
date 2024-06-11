package dnlhng.webtech.dnlhng.web.api;


import dnlhng.webtech.dnlhng.web.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository repo;

    public Post save (Post post){
        return repo.save(post);
    }

    public Post get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
