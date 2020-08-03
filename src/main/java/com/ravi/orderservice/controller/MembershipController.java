package com.ravi.orderservice.controller;

import com.ravi.orderservice.enums.ProductType;
import com.ravi.orderservice.externalservice.RazorPayProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ravi Verma at 01/08/20 11:20 PM
 */
@Controller
public class MembershipController {
    @Value("${monthly}")
    private Integer monthly;
    @Value("${yearly}")
    private Integer yearly;
    @Autowired
    private RazorPayProxy razorPayProxy;

    @PostMapping("/memberships")
    public String greeting(@RequestParam(name = "plan") String plan, Model model) {
        Integer amount = plan.equalsIgnoreCase("monthly")?monthly:yearly;
        model.addAttribute("product", ProductType.MEMBERSHIP.name());
        model.addAttribute("amount", amount);
        model.addAttribute("variant", plan);
        model.addAttribute("orderId", "1234");
        razorPayProxy.generatePaymentLink(amount);
        return "order";
    }

    @GetMapping("/memberships")
    public String getMemberships(Model model) {
        model.addAttribute("monthly", monthly);
        model.addAttribute("yearly", yearly);
        return "membershipList";
    }

}