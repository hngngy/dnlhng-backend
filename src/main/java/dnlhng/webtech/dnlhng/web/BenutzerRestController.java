package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Benutzer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BenutzerRestController {

    private List<Benutzer> users;

    public BenutzerRestController() {
        users = new ArrayList<>();
        users.add(new Benutzer(1, "Dinh Hoang", "Nguyen", "Wirtschaftsinformatik"));
        users.add(new Benutzer(2, "Daniel", "Nothelfer", "Wirtschaftsinformatik"));
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<Benutzer>> fetchUsers() {
        return ResponseEntity.ok(users);
    }
}
