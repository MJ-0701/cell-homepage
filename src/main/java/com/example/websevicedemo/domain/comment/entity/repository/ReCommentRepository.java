package com.example.websevicedemo.domain.comment.entity.repository;

import com.example.websevicedemo.domain.comment.entity.ReComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCommentRepository extends JpaRepository<ReComment, Long> {
}
