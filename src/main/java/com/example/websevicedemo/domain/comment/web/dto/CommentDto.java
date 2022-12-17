package com.example.websevicedemo.domain.comment.web.dto;

import com.example.websevicedemo.domain.comment.entity.Comment;
import com.example.websevicedemo.domain.comment.entity.ReplyUserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CommentDto {

    private String comment;

    @JsonProperty("reply_user_info")
    private ReplyUserInfo replyUserInfo;


    public CommentDto(Comment entity) {
        this.comment = entity.getComment();
        this.replyUserInfo = entity.getReplyUserInfo();
    }
}
