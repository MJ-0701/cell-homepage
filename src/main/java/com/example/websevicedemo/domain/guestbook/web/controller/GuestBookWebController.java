package com.example.websevicedemo.domain.guestbook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestBookWebController {

    @GetMapping("/guest-book")
    public String guestBookView() {
        return "guest-book/guestbook";
    }
}
