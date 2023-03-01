package com.example.websevicedemo.domain.photobook.service;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.domain.board.web.dto.BoardDto;
import com.example.websevicedemo.domain.file.entity.Files;
import com.example.websevicedemo.domain.file.entity.repository.FilesRepository;
import com.example.websevicedemo.domain.file.service.FileService;
import com.example.websevicedemo.domain.photobook.entity.PhotoBook;
import com.example.websevicedemo.domain.photobook.entity.repository.PhotoBookRepository;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoBookService {

    private final PhotoBookRepository photoBookRepository;
    private final FilesRepository filesRepository;
    private final FileService fileService;

    @Transactional
    public Long create(PhotoBookDto dto) throws Exception {

        System.out.println(dto);

        PhotoBook photoBook = PhotoBook
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .build();

        List<Files> filesList = fileService.fileInfo(dto.getFiles());
        // 파일이 존재할 때에만 처리
        if(!filesList.isEmpty()) {
            for(Files file : filesList) {
                // 파일을 DB에 저장
                photoBook.addFiles(filesRepository.save(file));
            }
        }

        return photoBookRepository.save(photoBook).getId();
    }
}
