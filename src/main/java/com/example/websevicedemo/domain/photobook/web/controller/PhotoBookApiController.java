package com.example.websevicedemo.domain.photobook.web.controller;

import com.example.websevicedemo.domain.photobook.service.PhotoBookService;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookFileDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/pagination")
    public ResponseEntity<Page<PhotoBookFileDto>> pagination(
            PhotoBookSearchCondition condition,
            Pageable pageable
    ) {
        return ResponseEntity.ok(photoBookService.pagination(condition, pageable));
    }
}
