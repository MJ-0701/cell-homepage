package com.example.websevicedemo.domain.test.service;

import com.example.websevicedemo.domain.test.entity.Test;
import com.example.websevicedemo.domain.test.entity.TestRepository;
import com.example.websevicedemo.domain.test.web.dto.TestDto;
import lombok.RequiredArgsConstructor;
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

}
