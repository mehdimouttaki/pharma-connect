package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public Chat save(Chat chat) {

        return chatRepository.save(chat);
    }



    public List<Chat> getAll() {

        return (List<Chat>) chatRepository.findAll();
    }

    public Chat getOne(Integer id) {

        return chatRepository.findById(id).get();
    }
}

