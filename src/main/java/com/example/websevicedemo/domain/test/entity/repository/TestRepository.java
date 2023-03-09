package com.example.websevicedemo.domain.test.entity.repository;


import com.example.websevicedemo.domain.test.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long>, TestRepositoryCustom {

}
