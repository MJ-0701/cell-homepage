package com.example.websevicedemo.domain.board.entity;


import com.example.websevicedemo.domain.comment.entity.Comment;
import com.example.websevicedemo.domain.file.entity.Files;
import com.example.websevicedemo.global.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Builder
public class Board extends BaseEntity {

    private String title;

    @Lob
    private String contents;

    private String userId;

    private String password;

    private int viewCount = 0;

    private int likeCount = 0;

    private boolean declaration = false;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Files> files = new ArrayList<>();

    @Builder
    public Board(String title, String contents, String userId, String password, int likeCount, boolean declaration){ // 클래스에 @Builder 를 먹여서 처리하면 현재 서비스 로직에서 file을 먼저 저장하므로 board id 값이 null -> nullpoint
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.password = password;
        this.likeCount = likeCount;
        this.declaration = declaration;
    }

}
