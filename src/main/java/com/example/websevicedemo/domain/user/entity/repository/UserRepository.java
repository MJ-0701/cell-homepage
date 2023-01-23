package com.example.websevicedemo.domain.user.entity.repository;

import com.example.websevicedemo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
