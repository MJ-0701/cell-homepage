package com.example.websevicedemo.domain.bible.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BibleWebController {

    @GetMapping("/today-bible")
    public String bibleWeb() {
        return "bible";
    }

    @GetMapping("/bible-test")
    public String bibleTest() {
        return  "bible_test";
    }
}
