package com.example.websevicedemo.domain.comment.web.controller;

import com.example.websevicedemo.domain.comment.service.CommentService;
import com.example.websevicedemo.domain.comment.web.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/save")
    public void createComment(
            @RequestBody CommentDto dto
            ) {
        commentService.createComment(dto);
    }
}
