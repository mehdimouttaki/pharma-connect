package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminRestController {
    @Autowired
    public AdminService adminService;
    @PostMapping("/api/admins")
    public Admin createAdmin(@RequestBody Admin admin){

        return adminService.save(admin);
    }

    @DeleteMapping("/api/admins/{id}")
    public void deleteAdmin(@PathVariable Integer id) {
        adminService.delete(id);
    }

    @PutMapping("/api/admins")
    public  Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
}
