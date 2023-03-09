package com.example.websevicedemo.domain.test.entity.repository;

import com.example.websevicedemo.domain.test.entity.QTest;
import com.example.websevicedemo.domain.test.entity.Test;
import com.example.websevicedemo.domain.test.web.dto.*;
import com.example.websevicedemo.domain.user.entity.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.websevicedemo.domain.test.entity.QTest.test;
import static com.example.websevicedemo.domain.user.entity.QUser.user;


public class TestRepositoryCustomImpl extends QuerydslRepositorySupport implements TestRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param em must not be {@literal null}.
     */
    public TestRepositoryCustomImpl(EntityManager em) {
        super(Test.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<TestDto> search(TestSearchCondition condition) {

        return queryFactory.select(
                new QTestDto(
                        test.id,
                        test.age,
                        test.job,
                        test.nationality,
                        test.schoolAttended
                ))
                .from(test)
                .where(
                    ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                    schoolAttended(condition.getSchoolAttended()),
                    jobLike(condition.getJob()),
                    nationalityEq(condition.getNationality())
                ).fetch();
    }

    @Override
    public List<UserTestDto> userTestLeftJoin(UserTestSearchCondition condition) {
        return queryFactory.select(
                new QUserTestDto(
                        test.age,
                        test.job,
                        test.nationality,
                        test.schoolAttended,
                        user.userName,
                        user.email,
                        user.birth,
                        user.nickName,
                        user.callNumber
                ))
                .from(test)
                .leftJoin(test.user, user)
                .where(
                        ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                        schoolAttended(condition.getSchoolAttended()),
                        jobLike(condition.getJob()),
                        nationalityEq(condition.getNationality()),
                        userNameEq(condition.getUserName()),
                        emailEq(condition.getEmail()),
                        birthEq(condition.getBirth()),
                        nickNameEq(condition.getNickName()),
                        callNumberEq(condition.getCallNumber())
                )
                .fetch();

    }

    @Override
    public List<UserTestDto> userTestThetaJoin(UserTestSearchCondition condition) {
        return queryFactory.select(
                        new QUserTestDto(
                                test.age,
                                test.job,
                                test.nationality,
                                test.schoolAttended,
                                user.userName,
                                user.email,
                                user.birth,
                                user.nickName,
                                user.callNumber
                        ))
                .from(test, user)
                .fetch();
    }

    @Override
    public Page<TestDto> pageComplex(TestSearchCondition condition, Pageable pageable) {

        List<TestDto> content = queryFactory
                .select(new QTestDto(
                        test.id,
                        test.age,
                        test.job,
                        test.nationality,
                        test.schoolAttended))
                .from(test)
                .where(
                        ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                        schoolAttended(condition.getSchoolAttended()),
                        jobLike(condition.getJob()),
                        nationalityEq(condition.getNationality())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(test.count())
                .from(test)
                .where(
                        ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                        schoolAttended(condition.getSchoolAttended()),
                        jobLike(condition.getJob()),
                        nationalityEq(condition.getNationality())
                );


        return PageableExecutionUtils.getPage(content, pageable, count::fetchOne);
    }

    @Override
    public Page<UserTestDto> userTestPageComplex(UserTestSearchCondition condition, Pageable pageable) {

        List<UserTestDto> content = queryFactory.select(
                        new QUserTestDto(
                                test.age,
                                test.job,
                                test.nationality,
                                test.schoolAttended,
                                user.email,
                                user.userName,
                                user.birth,
                                user.nickName,
                                user.callNumber
                        ))
                .from(test)
                .leftJoin(test.user, user)
                .where(
                        ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                        schoolAttended(condition.getSchoolAttended()),
                        jobLike(condition.getJob()),
                        nationalityEq(condition.getNationality()),
                        userNameEq(condition.getUserName()),
                        emailEq(condition.getEmail()),
                        birthEq(condition.getBirth()),
                        nickNameEq(condition.getNickName()),
                        callNumberEq(condition.getCallNumber())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> count = queryFactory
                .select(test.count())
                .from(test)
                .leftJoin(test.user, user)
                .where(
                        ageBetween(condition.getAgeLoe(), condition.getAgeGoe()),
                        schoolAttended(condition.getSchoolAttended()),
                        jobLike(condition.getJob()),
                        nationalityEq(condition.getNationality()),
                        userNameEq(condition.getUserName()),
                        emailEq(condition.getEmail()),
                        birthEq(condition.getBirth()),
                        nickNameEq(condition.getNickName()),
                        callNumberEq(condition.getCallNumber())
                );

        return PageableExecutionUtils.getPage(content,pageable,count::fetchOne);
    }

    private BooleanExpression ageBetween(int ageLoe, int ageGoe) {

        return ageGoe(ageGoe).and(ageLoe(ageLoe));
    }

    private BooleanExpression ageGoe(Integer ageGoe) {

        return ageGoe != null ? test.age.goe(ageGoe) : null;
    }

    private BooleanExpression ageLoe(Integer ageLoe) {
        return ageLoe != null ? test.age.loe(ageLoe) : null;
    }

    private BooleanExpression schoolAttended(Boolean schoolAttended) {
        return schoolAttended ? test.schoolAttended.isTrue() : test.schoolAttended.isFalse();
    }

    private BooleanExpression jobLike(String job) {
        return job != null ? test.job.like(job) : null;
    }

    private BooleanExpression nationalityEq(String nationality) {
        return nationality != null ? test.nationality.eq(nationality) : null;
    }

    private BooleanExpression userNameEq(String userName) {
        return userName != null ? user.userName.eq(userName) : null;
    }

    private BooleanExpression emailEq(String email) {
        return email != null ? user.email.eq(email) : null;
    }

    private BooleanExpression birthEq(String birth) {
        return birth != null ? user.birth.eq(birth) : null;
    }

    private BooleanExpression nickNameEq(String nickName) {
        return nickName != null ? user.nickName.eq(nickName) : null;
    }

    private BooleanExpression callNumberEq(String callNumber) {
        return callNumber != null ? user.callNumber.eq(callNumber) : null;
    }


}
