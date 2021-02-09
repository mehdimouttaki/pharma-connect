package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.model.UserRole;
import ma.pharmaconnect.app.pharmaconnect.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class AdminRestController {

    private final AdminService adminService;

    private final  PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        boolean existed= adminService.existByUsername("admin");
        if (!existed){
            Admin admin =new Admin();
            admin.setFirstName("Mehdi");
            admin.setLastName("Mouttaki");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRole(UserRole.ADMIN);
            adminService.save(admin);
        }

    }
}
