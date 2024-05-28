package dnlhng.webtech.dnlhng.web.api;

public class Post {

    private long id;
    private String username;
    private String message;


    public Post(long id, String username, String message){
        this.id = id;
        this.username = username;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
