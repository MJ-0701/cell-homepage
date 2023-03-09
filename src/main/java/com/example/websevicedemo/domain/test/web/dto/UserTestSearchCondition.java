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
public class UserTestSearchCondition {

    private Long id;

    private Integer ageGoe;

    private Integer ageLoe;

    private String job;

    private String nationality;

    @JsonProperty("school_attended")
    private Boolean schoolAttended;

    private String userName;

    private String email;

    private String birth;

    private String nickName;

    private String callNumber;
}
