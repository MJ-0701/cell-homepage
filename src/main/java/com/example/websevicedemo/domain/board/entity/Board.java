package com.example.websevicedemo.domain.board.entity;


import com.example.websevicedemo.domain.comment.entity.Comment;
import com.example.websevicedemo.domain.file.entity.BoardFiles;
import com.example.websevicedemo.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String nickName;

    @Lob
    private String contents;

    private String userId;

    private String password;

    private final int viewCount = 0;

    private int likeCount = 0;

    private boolean declaration = false;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private final List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private final List<BoardFiles> files = new ArrayList<>();

    private String imageUrl;

    @Builder
    public Board(String title, String contents, String userId, String password, int likeCount, boolean declaration, String nickName, String imageUrl){ // 클래스에 @Builder 를 먹여서 처리하면 현재 서비스 로직에서 file을 먼저 저장하므로 board id 값이 null -> nullpoint
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.password = password;
        this.likeCount = likeCount;
        this.declaration = declaration;
        this.nickName = nickName;
        this.imageUrl = imageUrl;
    }

    // Board에서 파일 처리 위함.
    public void addFiles(BoardFiles boardFiles){
        this.files.add(boardFiles);

        // 게시글에 파일이 저장되어있지 않은 경우
        if(boardFiles.getBoard() != this){
            // 파일 저장
            boardFiles.setBoard(this);
        }
    }

}
