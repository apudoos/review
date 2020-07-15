package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {

  @Select("SELECT * FROM MESSAGES") // WHERE USERNAME=#{username}")
  ArrayList<ChatMessage> getMessages();

  @Insert("INSERT INTO MESSAGES (USERNAME, MESSAGETEXT) VALUES(#{username"
      + "}, #{messagetext})" )
  @Options(useGeneratedKeys = true, keyProperty = "messageid")
  int insert(ChatMessage chatMessage
  );

}
