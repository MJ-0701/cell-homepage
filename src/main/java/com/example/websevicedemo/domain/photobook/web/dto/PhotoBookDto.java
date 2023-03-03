package com.example.websevicedemo.domain.photobook.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "사진첩 저장 코드")
public class PhotoBookDto {

    @JsonProperty("title")
    @Schema(description = "제목", example = "제목")
    private String title;

    @JsonProperty("contents")
    @Schema(description = "내용", example = "내용")
    private String contents;

    @JsonProperty("files")
    @Schema(description = "사진 파일", allowableValues = {"image/jpeg", "image/png", "image/gif", "pdf", "mp4"})
    private List<MultipartFile> files = new ArrayList<>();
}
