package hu.sigmalimited.sigmawebshop.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/")
    public String helloGuest() {
        return "hello guest";
    }

    @RequestMapping("/authenticated")
    public String helloAdmin() {
        return "hello admin";
    }

    @RequestMapping("/admin/home")
    public String adminHome() {
        return "hello admin home";
    }
}