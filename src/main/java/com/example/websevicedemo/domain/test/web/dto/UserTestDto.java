package com.example.websevicedemo.domain.test.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
public class UserTestDto {

    private Integer age;

    private String job;

    private String nationality;

    @JsonProperty("school_attended")
    private Boolean schoolAttended;

    private String userName;

    private String email;

    private String birth;

    private String nickName;

    private String callNumber;

    @QueryProjection
    public UserTestDto(Integer age, String job, String nationality, Boolean schoolAttended, String userName, String email, String birth, String nickName, String callNumber) {
        this.age = age;
        this.job = job;
        this.nationality = nationality;
        this.schoolAttended = schoolAttended;
        this.userName = userName;
        this.email = email;
        this.birth = birth;
        this.nickName = nickName;
        this.callNumber = callNumber;
    }
}
