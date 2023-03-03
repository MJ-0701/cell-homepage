package com.example.websevicedemo.domain.file.entity.repository;

import com.example.websevicedemo.domain.file.entity.BoardFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFilesRepository extends JpaRepository<BoardFiles, Long> {
}
