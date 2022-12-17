package com.example.websevicedemo.domain.comment.service;

import com.example.websevicedemo.domain.comment.entity.Comment;
import com.example.websevicedemo.domain.comment.entity.repository.CommentRepository;
import com.example.websevicedemo.domain.comment.entity.repository.ReCommentRepository;
import com.example.websevicedemo.domain.comment.web.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final ReCommentRepository reCommentRepository;


    public void createComment(CommentDto dto) {
        Comment comment = Comment
                .builder()
                .comment(dto.getComment())
                .replyUserInfo(dto.getReplyUserInfo())
                .build();
        commentRepository.save(comment);
    }
}
