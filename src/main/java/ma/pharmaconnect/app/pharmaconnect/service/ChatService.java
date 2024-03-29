package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
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

        return chatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chat", id));
    }

    public void createChat(Order order, DeliveryMan deliveryMan, String message) {
        Chat chat = new Chat();
        chat.setClient(order.getClient());
        chat.setOrder(order);
        chat.setDeliveryMan(deliveryMan);
        chat.setMessage(message);

        save(chat);
    }

    public void createChat(Order order, Client client, String message) {
        Chat chat = new Chat();
        chat.setClient(client);
        chat.setOrder(order);
        chat.setDeliveryMan(order.getDeliveryMan());
        chat.setMessage(message);

        save(chat);
    }
}
