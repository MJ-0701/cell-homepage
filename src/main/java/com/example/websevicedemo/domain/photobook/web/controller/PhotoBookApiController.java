package com.example.websevicedemo.domain.photobook.web.controller;

import com.example.websevicedemo.domain.photobook.service.PhotoBookService;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/photo-book")
@RequiredArgsConstructor
public class PhotoBookApiController {

    private final PhotoBookService photoBookService;

    @PostMapping("/save")
    public Long photoBookSave(
            PhotoBookDto photoBookDto
    ) throws Exception {

        return photoBookService.create(photoBookDto);
    }
}
