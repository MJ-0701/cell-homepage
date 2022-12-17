package com.example.websevicedemo.domain.comment.entity.repository;

import com.example.websevicedemo.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
