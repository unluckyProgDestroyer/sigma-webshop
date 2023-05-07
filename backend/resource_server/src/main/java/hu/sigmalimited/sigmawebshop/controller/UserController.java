package hu.sigmalimited.sigmawebshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping( value = "/admin/user")
    public String productsView() {
        return "admin/admin_user";
    }

}
