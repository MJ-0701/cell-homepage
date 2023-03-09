package com.example.websevicedemo.domain.test.web.dto;

import com.example.websevicedemo.domain.test.entity.Test;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto {

    private Integer age;

    private String job;

    private String nationality;

    @JsonProperty("school_attended")
    private Boolean schoolAttended;

    public TestDto(Test entity) {
        this.age = entity.getAge();
        this.job = entity.getJob();
        this.nationality = entity.getNationality();
        this.schoolAttended = entity.getSchoolAttended();
    }


}
