package hu.sigmalimited.sigmawebshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class AuthController {
    @GetMapping( value = "/login")
    public String adminProductsView(Authentication authentication,HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (authentication!=null && authentication.isAuthenticated()){
            RedirectStrategy redirect = new DefaultRedirectStrategy();
            redirect.sendRedirect(request, response, "/");
        }
        return "auth/login";
    }

}
