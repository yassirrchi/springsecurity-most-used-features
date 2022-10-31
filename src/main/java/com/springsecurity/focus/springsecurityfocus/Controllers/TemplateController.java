package com.springsecurity.focus.springsecurityfocus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping("login")
    public String getLoginView() {
        return "login";


    }
    @GetMapping("content")
    public String getContentView() {
        return "content";


    }
}
