package com.example.websevicedemo.domain.photobook.entity.repository;

import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookFileDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoBookRepositoryCustom {

    List<PhotoBookFileDto> search(PhotoBookSearchCondition condition);

    Page<PhotoBookFileDto> searchPageSimple(PhotoBookSearchCondition condition, Pageable pageable);

    Page<PhotoBookFileDto> searchPageComplex(PhotoBookSearchCondition condition, Pageable pageable);
}
