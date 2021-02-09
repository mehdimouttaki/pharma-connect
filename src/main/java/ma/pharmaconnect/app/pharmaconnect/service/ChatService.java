package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

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

