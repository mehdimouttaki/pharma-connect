package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.chat.ChatCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.chat.ChatShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.service.ChatService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatRestController {

    public final ChatService chatService;

    @PostMapping("/api/chats")
    public ChatShowDTO createChat(@RequestBody ChatCreationDTO chatDTO) {
        Chat chat = new ModelMapper().map(chatDTO,Chat.class);
        Chat chatsaved=chatService.save(chat);
        return new ModelMapper().map(chatsaved, ChatShowDTO.class);
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

