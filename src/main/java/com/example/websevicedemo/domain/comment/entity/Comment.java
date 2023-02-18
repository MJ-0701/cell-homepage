package com.example.websevicedemo.domain.comment.entity;

import com.example.websevicedemo.domain.board.entity.Board;
import com.example.websevicedemo.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "comment")
@Builder
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "replyId", column = @Column(name = "reply_id")),
            @AttributeOverride(name = "replyPwd", column = @Column(name = "reply_pwd"))
    })
    private ReplyUserInfo replyUserInfo;

    @OneToMany(mappedBy = "comment", orphanRemoval = true, cascade = {CascadeType.ALL})
    private final List<ReComment> reCommentList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


}
