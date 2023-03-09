package com.example.websevicedemo.domain.test.service;

import com.example.websevicedemo.domain.test.entity.Test;
import com.example.websevicedemo.domain.test.entity.repository.TestRepository;
import com.example.websevicedemo.domain.test.web.dto.TestDto;
import com.example.websevicedemo.domain.test.web.dto.TestSearchCondition;
import com.example.websevicedemo.domain.test.web.dto.UserTestDto;
import com.example.websevicedemo.domain.test.web.dto.UserTestSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;


    @Transactional
    public void create(TestDto dto) {
        Test test = Test
                .builder()
                .age(dto.getAge())
                .job(dto.getJob())
                .nationality(dto.getNationality())
                .schoolAttended(dto.getSchoolAttended())
                .build();

        testRepository.save(test);
    }

    @Transactional(readOnly = true)
    public List<TestDto> read() {
        return testRepository.findAll().stream().map(TestDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, TestDto dto) {
        Test test = testRepository.findById(id).orElseThrow();
        test.testUpdate(dto);
        testRepository.save(test);
    }

    @Transactional
    public void delete(Long id) {
        Test test = testRepository.findById(id).orElseThrow();
        testRepository.delete(test);
    }

    @Transactional(readOnly = true)
    public List<TestDto> searchCondition(TestSearchCondition condition) {
        return testRepository.search(condition);
    }

    @Transactional(readOnly = true)
    public List<UserTestDto> userTestLeftJoinSearch(UserTestSearchCondition condition) {
        return testRepository.userTestLeftJoin(condition);
    }

    @Transactional(readOnly = true)
    public List<UserTestDto> userTestThetaJoin(UserTestSearchCondition condition) {
        return testRepository.userTestThetaJoin(condition);
    }

    @Transactional(readOnly = true)
    public Page<UserTestDto> userTestPaging(UserTestSearchCondition condition, Pageable pageable) {
        return testRepository.userTestPageComplex(condition, pageable);
    }

}
