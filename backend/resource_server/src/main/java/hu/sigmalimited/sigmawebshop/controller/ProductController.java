package hu.sigmalimited.sigmawebshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProductController {

    @GetMapping( value = "/admin/home")
    public String adminProductsView() {
        return "admin/admin_default";
    }

    @GetMapping( value = "/product/{id}")
    public String oneProductView() {
        return "customer/customer_product";
    }
}
