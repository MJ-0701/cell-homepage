package com.example.websevicedemo.domain.board.service;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.domain.board.entity.repository.BoardRepository;
import com.example.websevicedemo.domain.board.web.dto.BoardDto;
import com.example.websevicedemo.domain.file.entity.BoardFiles;
import com.example.websevicedemo.domain.file.entity.repository.BoardFilesRepository;
import com.example.websevicedemo.domain.file.service.BoardFileService;
import com.example.websevicedemo.domain.file.service.S3Uploader;
import com.example.websevicedemo.global.utils.FileFolder;
import com.example.websevicedemo.global.utils.S3FileProcessService;
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
    private final BoardFilesRepository boardFilesRepository;
    private final BoardFileService boardFileService;
    private final S3Uploader s3Uploader;
    private final S3FileProcessService s3FileProcessService;



    @Transactional
    public Long create(BoardDto dto) throws Exception {

        Board board = Board
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .build();

        List<BoardFiles> boardFilesList = boardFileService.fileInfo(dto.getFiles());
        // 파일이 존재할 때에만 처리
        if(!boardFilesList.isEmpty()) {
            for(BoardFiles file : boardFilesList) {
                // 파일을 DB에 저장
                board.addFiles(boardFilesRepository.save(file));
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
        boardRepository.save(board);
    }

    @Transactional
    public void s3Upload2(MultipartFile image, BoardDto dto) throws IOException {
        String storedFileName = "";

        if(!image.isEmpty()) {
            System.out.println("진입 확인 : " + image.getOriginalFilename());
            storedFileName = s3FileProcessService.uploadImage(image, FileFolder.YOOJINCELL_IMAGES);
        }

        Board board = Board
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .imageUrl(storedFileName)
                .build();
        boardRepository.save(board);
    }
}
