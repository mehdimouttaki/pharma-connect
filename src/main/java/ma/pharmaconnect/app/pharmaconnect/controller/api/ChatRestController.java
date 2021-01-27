package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatRestController {
    @Autowired
    public ChatService chatService;

    @PostMapping("/api/chats")
    public Chat createChat(@RequestBody Chat chat) {

        return chatService.save(chat);
    }

    @DeleteMapping("/api/chats/{id}")
    public void deleteChat(@PathVariable Integer id) {
        chatService.delete(id);
    }

    @GetMapping("/api/chats")
    public List<Chat> getAll() {
        return chatService.getAll();
    }

    @GetMapping("/api/chats/{id}")
    public Chat getOne(@PathVariable Integer id) {

        return chatService.getOne(id);
    }


}

