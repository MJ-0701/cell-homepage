package com.example.websevicedemo.domain.file.entity;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardFiles extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String filePath;

    private Long fileSize;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


    @Builder
    public BoardFiles(String originalFileName, String filePath, Long fileSize){
        this.originalFileName = originalFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    // board 정보 저장
    public void setBoard(Board board){ // 연관관계 매핑
        this.board = board;

        // 게시글에 현재 파일이 존재하지 않는다면.
        if(!board.getFiles().contains(this)){
            board.getFiles().add(this);
        }
    }

}
