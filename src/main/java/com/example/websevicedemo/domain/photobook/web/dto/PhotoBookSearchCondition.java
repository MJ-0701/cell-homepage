package com.example.websevicedemo.domain.photobook.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhotoBookSearchCondition {

    @JsonProperty("photo_book_id")
    private Long photoBookId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("contents")
    private String contents;

    @JsonProperty("photo_book_file_id")
    private Long photoBookFileId;
}
