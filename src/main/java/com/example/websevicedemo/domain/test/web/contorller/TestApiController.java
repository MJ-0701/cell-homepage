package com.example.websevicedemo.domain.test.web.contorller;

import com.example.websevicedemo.domain.test.entity.Test;
import com.example.websevicedemo.domain.test.service.TestService;
import com.example.websevicedemo.domain.test.web.dto.TestDto;
import com.example.websevicedemo.domain.test.web.dto.TestSearchCondition;
import com.example.websevicedemo.domain.test.web.dto.UserTestDto;
import com.example.websevicedemo.domain.test.web.dto.UserTestSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/search")
    public ResponseEntity<List<TestDto>> search(
            @RequestBody TestSearchCondition condition
            ) {

        return ResponseEntity.ok(testService.searchCondition(condition));

    }

    @GetMapping("/theta/join/search")
    public ResponseEntity<List<UserTestDto>> thetaJoin(
            @RequestBody UserTestSearchCondition condition
    ) {
       return ResponseEntity.ok(testService.userTestThetaJoin(condition));
    }

    @GetMapping("/left/join/search")
    public ResponseEntity<List<UserTestDto>> leftJoin(
            @RequestBody UserTestSearchCondition condition
    ) {
        return ResponseEntity.ok(testService.userTestLeftJoinSearch(condition));
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<UserTestDto>> paging(
            @RequestBody UserTestSearchCondition condition,
            Pageable pageable
    ) {
        return ResponseEntity.ok(testService.userTestPaging(condition, pageable));
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
