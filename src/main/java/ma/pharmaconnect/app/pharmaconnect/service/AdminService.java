package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin save(Admin admin) {

        return adminRepository.save(admin);
    }

    public void delete(Integer id) {

        adminRepository.deleteById(id);
    }

    public Admin update(Admin admin) {

        return adminRepository.save(admin);
    }

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    public boolean existByUsername(String username) {
        return adminRepository.existsByUsername(username);
    }
}
