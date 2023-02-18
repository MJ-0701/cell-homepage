package com.example.websevicedemo.domain.board.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {

    private String title;

    private String contents;

    @JsonProperty("nick_name")
    private String nickName;

    private String password;

    private List<MultipartFile> files = new ArrayList<>();

    private String imageUrl;
}
