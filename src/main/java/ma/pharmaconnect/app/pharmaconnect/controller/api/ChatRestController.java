package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRestController {

    public final ChatService chatService;

    @PostMapping("/api/chats")
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.save(chat);
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

