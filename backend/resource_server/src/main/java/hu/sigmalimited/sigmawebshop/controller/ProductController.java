package hu.sigmalimited.sigmawebshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProductController {

    @RequestMapping( value = "/admin/home")
    public String adminProductsView() {
        return "admin/admin_default";
    }

    @RequestMapping( value = "/product/{id}")
    public String oneProductView() {
        return "customer/customer_product";
    }
}
