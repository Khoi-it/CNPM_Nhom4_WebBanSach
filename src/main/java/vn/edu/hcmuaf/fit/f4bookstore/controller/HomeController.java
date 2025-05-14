package vn.edu.hcmuaf.fit.f4bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Sẽ tìm file index.html trong src/main/resources/templates/
    }
}
