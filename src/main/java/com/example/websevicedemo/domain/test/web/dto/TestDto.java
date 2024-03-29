package com.example.websevicedemo.domain.test.web.dto;

import com.example.websevicedemo.domain.test.entity.Test;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class TestDto {

    private Long id;

    private Integer age;

    private String job;

    private String nationality;

    @JsonProperty("school_attended")
    private Boolean schoolAttended;

    @QueryProjection
    public TestDto(Long id, Integer age, String job, String nationality, Boolean schoolAttended) {
        this.id = id;
        this.age = age;
        this.job = job;
        this.nationality = nationality;
        this.schoolAttended = schoolAttended;
    }

    public TestDto(Test entity) {
        this.age = entity.getAge();
        this.job = entity.getJob();
        this.nationality = entity.getNationality();
        this.schoolAttended = entity.getSchoolAttended();
    }


}
