package hu.sigmalimited.sigmawebshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping( "/orders")
    public String personalOrdersView() {
        return "customer/customer_orderhistory";
    }

    @RequestMapping("/admin/orders")
    public String ordersAdminView() {
        return "admin/admin_recepient";
    }

    @RequestMapping("/support/orders")
    public String ordersSupportView() {
        return "admin/admin_recepient";
    }
}