package com.puppiespassion.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "/static-pages/about.html";
    }

    @GetMapping("/faq")
    public String faq() {
        return "/static-pages/faq.html";
    }

    @GetMapping("/refund")
    public String refundPolicy() {
        return "/static-pages/refund.html";
    }


}
