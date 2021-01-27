package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {

        return adminRepository.save(admin);
    }

    public void delete(Integer id) {

        adminRepository.deleteById(id);
    }
    public Admin update(Admin admin){

        return adminRepository.save(admin);
    }

    public boolean existByUsername(String username) {
        return adminRepository.existsByUsername(username);
    }
}
