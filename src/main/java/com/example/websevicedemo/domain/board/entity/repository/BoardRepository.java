package com.example.websevicedemo.domain.board.entity.repository;


import com.example.websevicedemo.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
