package com.example.websevicedemo.domain.board.service;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.domain.board.entity.repository.BoardRepository;
import com.example.websevicedemo.domain.board.web.dto.BoardDto;
import com.example.websevicedemo.domain.file.entity.Files;
import com.example.websevicedemo.domain.file.entity.repository.FilesRepository;
import com.example.websevicedemo.domain.file.service.FileService;
import com.example.websevicedemo.domain.file.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;
    private final FilesRepository filesRepository;
    private final FileService fileService;
    private final S3Uploader s3Uploader;



    @Transactional
    public Long create(BoardDto dto) throws Exception {

        System.out.println("타이틀 : " + dto.getTitle());
        Board board = Board
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .build();

        List<Files> filesList = fileService.fileInfo(dto.getFiles());
        // 파일이 존재할 때에만 처리
        if(!filesList.isEmpty()) {
            for(Files file : filesList) {
                // 파일을 DB에 저장
                board.addFiles(filesRepository.save(file));
            }
        }

        return boardRepository.save(board).getId();
    }

    @Transactional
    public void s3Upload(MultipartFile image, BoardDto dto) throws IOException {
        String storedFileName = "";
        if(!image.isEmpty()) {
            System.out.println("진입 확인 : " + image.getOriginalFilename());
            storedFileName = s3Uploader.upload(image,"images");
        }

        Board board = Board
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .imageUrl(storedFileName)
                .build();
    }
}
