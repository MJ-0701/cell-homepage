package com.example.websevicedemo.domain.test.entity.repository;

import com.example.websevicedemo.domain.test.web.dto.TestDto;
import com.example.websevicedemo.domain.test.web.dto.TestSearchCondition;
import com.example.websevicedemo.domain.test.web.dto.UserTestDto;
import com.example.websevicedemo.domain.test.web.dto.UserTestSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TestRepositoryCustom {

    List<TestDto> search(TestSearchCondition condition);

    List<UserTestDto> userTestLeftJoin(UserTestSearchCondition condition);

    List<UserTestDto> userTestThetaJoin(UserTestSearchCondition condition);

    Page<TestDto> pageComplex(TestSearchCondition condition, Pageable pageable);

    Page<UserTestDto> userTestPageComplex(UserTestSearchCondition condition, Pageable pageable);
}
