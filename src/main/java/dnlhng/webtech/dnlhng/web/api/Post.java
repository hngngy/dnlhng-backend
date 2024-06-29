package dnlhng.webtech.dnlhng.web.api;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String message;


    public Post(String username, String message) {
        this.username = username;
        this.message = message;
    }
}



