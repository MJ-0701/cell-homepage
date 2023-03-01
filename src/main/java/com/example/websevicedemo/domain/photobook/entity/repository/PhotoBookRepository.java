package com.example.websevicedemo.domain.photobook.entity.repository;

import com.example.websevicedemo.domain.photobook.entity.PhotoBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoBookRepository extends JpaRepository<PhotoBook, Long> {
}
