package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Admin;
import ma.pharmaconnect.app.pharmaconnect.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admins")
    public String allAdmin(Model model) {
        List<Admin> list = adminService.getAll();
        model.addAttribute("admins", list);
        return "/admins/all_admins";
    }
}
