package vn.edu.hcmuaf.fit.f4bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

    @GetMapping("/gioithieu")
    public String intro() {
        return "gioithieu";
    }
}
