package com.example.websevicedemo.domain.file.entity.repository;

import com.example.websevicedemo.domain.file.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
