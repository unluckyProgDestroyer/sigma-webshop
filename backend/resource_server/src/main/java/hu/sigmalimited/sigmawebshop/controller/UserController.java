package hu.sigmalimited.sigmawebshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping( value = "/admin/user")
    public String productsView() {
        return "admin/admin_user";
    }

}
