package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Nachricht;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final List<Nachricht> nachrichten = new ArrayList<>();

    @GetMapping
    public List<Nachricht> alleNachrichten() {
        return nachrichten;
    }

    @PostMapping
    public void sendeNachricht(@RequestBody Nachricht nachricht) {
        nachrichten.add(nachricht);
    }
}