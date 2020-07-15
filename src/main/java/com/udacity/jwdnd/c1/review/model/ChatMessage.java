package com.udacity.jwdnd.c1.review.model;

public class ChatMessage {

  private Integer messageid;
  private String username;
  private String messagetext;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMessageText() {
    return messagetext;
  }

  public void setMessageText(String messagetext) {
    this.messagetext = messagetext;
  }

  public Integer getMessageid() {
    return messageid;
  }

  public void setMessageid(Integer messageid) {
    this.messageid = messageid;
  }
}
