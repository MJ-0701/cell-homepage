package com.example.websevicedemo.domain.test.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestSearchCondition {

    private Integer ageGoe;

    private Integer ageLoe;

    private String job;

    private String nationality;

    @JsonProperty("school_attended")
    private Boolean schoolAttended;

}
