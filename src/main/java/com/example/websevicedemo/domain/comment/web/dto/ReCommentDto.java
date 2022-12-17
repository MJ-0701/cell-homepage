package com.example.websevicedemo.domain.comment.web.dto;

import com.example.websevicedemo.domain.comment.entity.ReplyUserInfo;
import com.example.websevicedemo.domain.comment.entity.ReComment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ReCommentDto {

    @JsonProperty("re_comment")
    private String reComment;

    @JsonProperty("reply_user_info")
    private ReplyUserInfo replyUserInfo;

    public ReCommentDto(ReComment entity) {
        this.reComment = entity.getReComment();
        this.replyUserInfo = entity.getReplyUserInfo();
    }
}
