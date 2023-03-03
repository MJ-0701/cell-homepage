package com.example.websevicedemo.domain.photobook.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Schema(description = "쿼리 dsl 조회용 조인 DTO")
public class PhotoBookFileDto {

    @JsonProperty("photo_book_id")
    private Long photoBookId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("contents")
    private String contents;

    @JsonProperty("photo_book_file_id")
    private Long photoBookFileId;

    @JsonProperty("file_path")
    private String filePath;

    @JsonProperty("created_at")
    private String createdAt;

    @QueryProjection
    public PhotoBookFileDto(Long photoBookId, String title, String contents, Long photoBookFileId, String filePath, LocalDateTime createdAt) {
        this.photoBookId = photoBookId;
        this.title = title;
        this.contents = contents;
        this.photoBookFileId = photoBookFileId;
        this.filePath = filePath;
        this.createdAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(createdAt);

    }

}
