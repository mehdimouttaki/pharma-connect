package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public String allChat(Model model) {
        List<Chat> list = chatService.getAll();
        model.addAttribute("chats", list);
        return "/chats/all_chats";
    }

}
