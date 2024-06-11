package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
