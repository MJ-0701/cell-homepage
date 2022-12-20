package com.example.websevicedemo.domain.photobook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoBookWebController {

    @GetMapping("/photo-book")
    public String photoBookView() {

        return "photobook";
    }
}
