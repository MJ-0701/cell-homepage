package com.example.websevicedemo.domain.photobook.web.controller;

import com.example.websevicedemo.domain.photobook.service.PhotoBookService;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookFileDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookSearchCondition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/photo-book")
@RequiredArgsConstructor
@ApiResponses({
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
})
public class PhotoBookApiController {

    private final PhotoBookService photoBookService;

    @PostMapping("/save")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PhotoBookDto.class)))
    @Operation(summary = "사진첩 게시물 저장",description = "제목 + 사진 + 내용", tags = {"PHOTO_BOOK"})
    public Long photoBookSave(
            PhotoBookDto photoBookDto
    ) throws Exception {

        return photoBookService.create(photoBookDto);
    }

    @GetMapping("/pagination")
    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = PhotoBookFileDto.class)))
    @Operation(summary = "쿼리 dsl",description = "쿼리 dsl 이용한 페이징 코드", tags = {"PHOTO_BOOK"})
    public ResponseEntity<Page<PhotoBookFileDto>> pagination(
            PhotoBookSearchCondition condition,
            Pageable pageable
    ) {
        return ResponseEntity.ok(photoBookService.pagination(condition, pageable));
    }
}
