package com.example.websevicedemo.domain.file.entity.repository;

import com.example.websevicedemo.domain.file.entity.PhotoBookFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoBookFilesRepository extends JpaRepository<PhotoBookFiles, Long> {
}
