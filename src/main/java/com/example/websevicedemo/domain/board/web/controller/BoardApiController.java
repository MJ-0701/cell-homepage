package com.example.websevicedemo.domain.board.web.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.websevicedemo.domain.board.service.BoardService;
import com.example.websevicedemo.domain.board.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:real-application.yml")
public class BoardApiController {

    private final BoardService boardService;

    private static String accessKey;

    private static String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.credentials.access-key}")
    public void setAccessKey(String ymlAccessValue){
        accessKey = ymlAccessValue;
    }

    @Value("${cloud.aws.credentials.secret-key}")
    public void setSecretKey(String ymlSecretValue){
        secretKey = ymlSecretValue;
    }



    @GetMapping("/test")
    public void ymlValueTest() {
        System.out.println("AccessKey :  " + accessKey);
        System.out.println("SecretKey :  " + secretKey);
        System.out.println("region :  " + region);
        System.out.println("bucket :  " + bucket);
    }

    @PostMapping("/upload")
    public Long fileUpload(
            BoardDto dto
            ) throws Exception {

        System.out.println("dto :" + dto);

        return boardService.create(dto);
    }

    @PostMapping("/s3-upload")
    public void s3FileUpload(
            @RequestParam(value = "image")MultipartFile image,
            BoardDto dto
            ) throws IOException {

        System.out.println("이미지 파일" + image);
        System.out.println("dto : " + dto);

        boardService.s3Upload(image, dto);

    }


}
