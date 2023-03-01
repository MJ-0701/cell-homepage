package com.example.websevicedemo.domain.photobook.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequiredArgsConstructor
public class PhotoBookWebController {



    @GetMapping("/photo-book")
    public String photoBookView() {

        return "photo-book/photo-book";
    }

    @GetMapping("/photo-book/write")
    public String photoBookWrite() {

        return "photo-book/photo-book-write";
    }


}
