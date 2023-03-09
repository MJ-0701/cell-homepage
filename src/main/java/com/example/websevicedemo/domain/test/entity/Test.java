package com.example.websevicedemo.domain.test.entity;

import com.example.websevicedemo.domain.test.web.dto.TestDto;
import com.example.websevicedemo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String job;

    private String nationality;

    private Boolean schoolAttended;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public void testUpdate(TestDto dto) {
        this.age = dto.getAge();
        this.job = dto.getJob();
        this.nationality = dto.getNationality();
        this.schoolAttended = dto.getSchoolAttended();
    }


}
