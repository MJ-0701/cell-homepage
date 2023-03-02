package com.example.websevicedemo.domain.photobook.service;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.domain.board.web.dto.BoardDto;
import com.example.websevicedemo.domain.file.entity.Files;
import com.example.websevicedemo.domain.file.entity.PhotoBookFiles;
import com.example.websevicedemo.domain.file.entity.repository.FilesRepository;
import com.example.websevicedemo.domain.file.entity.repository.PhotoBookFilesRepository;
import com.example.websevicedemo.domain.file.service.FileService;
import com.example.websevicedemo.domain.file.service.PhotoBookFileService;
import com.example.websevicedemo.domain.photobook.entity.PhotoBook;
import com.example.websevicedemo.domain.photobook.entity.repository.PhotoBookRepository;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookFileDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoBookService {

    private final PhotoBookRepository photoBookRepository;
    private final PhotoBookFilesRepository photoBookFilesRepository;
    private final PhotoBookFileService fileService;

    @Transactional
    public Long create(PhotoBookDto dto) throws Exception {

        System.out.println(dto);

        PhotoBook photoBook = PhotoBook
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .build();

        List<PhotoBookFiles> filesList = fileService.fileInfo(dto.getFiles());
        // 파일이 존재할 때에만 처리
        if(!filesList.isEmpty()) {
            for(PhotoBookFiles file : filesList) {
                // 파일을 DB에 저장
                photoBook.addFiles(photoBookFilesRepository.save(file));
            }
        }

        return photoBookRepository.save(photoBook).getId();
    }

    @Transactional(readOnly = true)
    public Page<PhotoBookFileDto> pagination(PhotoBookSearchCondition condition, Pageable pageable) {

        return photoBookRepository.searchPageComplex(condition, pageable);
    }
}
