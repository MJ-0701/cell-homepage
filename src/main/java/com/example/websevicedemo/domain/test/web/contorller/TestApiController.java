package com.example.websevicedemo.domain.test.web.contorller;

import com.example.websevicedemo.domain.test.entity.Test;
import com.example.websevicedemo.domain.test.service.TestService;
import com.example.websevicedemo.domain.test.web.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestApiController {

    private final TestService testService;


    @PostMapping("/save")
    public void create(
            @RequestBody TestDto dto
            ) {

        testService.create(dto);
    }

    @GetMapping("/read")
    public ResponseEntity<List<TestDto>> read() {
        return ResponseEntity.ok().body(testService.read());
    }

    @PutMapping("/update/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody TestDto dto
    ) {
        testService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        testService.delete(id);
    }


}
