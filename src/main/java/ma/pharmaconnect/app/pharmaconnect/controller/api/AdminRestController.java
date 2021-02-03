package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class AdminRestController {

    @Autowired
    public AdminService adminService;



    @PutMapping("/api/admins")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.update(admin);
    }



    @PostConstruct
    public void init(){
        boolean existed= adminService.existByUsername("admin");
        if (!existed){
            Admin admin =new Admin();
            admin.setFirstName("Mehdi");
            admin.setLastName("Mouttaki");
            admin.setUsername("admin");
            admin.setPassword("123456");
            adminService.save(admin);
        }

    }
}
