package dnlhng.webtech.dnlhng.web;

import dnlhng.webtech.dnlhng.web.api.Nachricht;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final List<Nachricht> nachrichten = new ArrayList<>();

    @GetMapping
    public String alleNachrichten(Model model) {
        model.addAttribute("nachrichten", nachrichten);
        return "chat";
    }

    @PostMapping
    public String sendeNachricht(@RequestParam("benutzername") String benutzername, @RequestParam("text") String text, Model model) {
        nachrichten.add(new Nachricht(benutzername, text));
        model.addAttribute("nachrichten", nachrichten);
        return "redirect:/chat";
    }
}
