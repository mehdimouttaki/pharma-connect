package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.User;
import ma.pharmaconnect.app.pharmaconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
