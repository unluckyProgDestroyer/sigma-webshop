package hu.sigmalimited.sigmawebshop.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootRouteController {
    @RequestMapping( value = "/")
    public String productsView(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")){
            return "admin/admin_default";
        }else if(request.isUserInRole("ROLE_SUPPORT")){
            return "admin/admin_recepient";
        }
        return "customer/customer_default";
    }
}
