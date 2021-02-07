package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final  ChatService chatService;

    @GetMapping("/chats")
    public String allChat(Model model) {
        List<Chat> list = chatService.getAll();
        model.addAttribute("chats", list);
        return "/chats/all_chats";
    }

}
