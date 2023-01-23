package com.example.websevicedemo.domain.user.service;

import com.example.websevicedemo.domain.user.entity.repository.UserRepository;
import com.example.websevicedemo.global.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
}
