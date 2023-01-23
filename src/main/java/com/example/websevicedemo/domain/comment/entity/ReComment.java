package com.example.websevicedemo.domain.comment.entity;

import com.example.websevicedemo.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "re_comment")
@Builder
public class ReComment extends BaseTimeEntity {

    private String reComment;

    private ReplyUserInfo replyUserInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
