package hu.sigmalimited.sigmawebshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping( "/orders")
    public String personalOrdersView() {
        return "customer/customer_orderhistory";
    }

    @GetMapping("/admin/orders")
    public String ordersAdminView() {
        return "admin/admin_recepient";
    }

    @GetMapping("/support/orders")
    public String ordersSupportView() {
        return "admin/admin_recepient";
    }
}