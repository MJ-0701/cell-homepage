package com.example.websevicedemo.domain.board.entity.repository;


import com.example.websevicedemo.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("UPDATE Board B SET B.viewCount = B.viewCount + 1 WHERE B.id = :id")
    void updateViewCount(Long id);

    @Modifying
    @Query("UPDATE Board B SET B.likeCount = B.likeCount + 1 WHERE B.id = :id")
    int updatePlusLikeCount(Long id);

    @Modifying
    @Query("UPDATE Board B SET B.likeCount = B.likeCount - 1 WHERE B.id = :id")
    int updateMinusLikeCount(Long id);
}
