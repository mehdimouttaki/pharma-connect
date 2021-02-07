package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.UserRole;
import ma.pharmaconnect.app.pharmaconnect.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;

    public Client save(Client client) {
        client.setRole(UserRole.CLIENT);
        String normalPassword = client.getPassword();

        String passwordEncoded = passwordEncoder.encode(normalPassword);

        client.setPassword(passwordEncoded);

        return clientRepository.save(client);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client getByUsername(String username) {
        return clientRepository.findByUsername(username);
    }
}
