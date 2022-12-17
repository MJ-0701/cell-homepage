package com.example.websevicedemo.domain.comment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;

@Embeddable
public class ReplyUserInfo {

    @JsonProperty("reply_id")
    private String replyId;

    @JsonProperty("reply_pwd")
    private String replyPwd;
}
