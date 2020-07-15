package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  private String message;
  private List<String> ignoreList;
  private UserService userService;
  private MessageMapper messageMapper;

  //ArrayList<ChatMessage> chatHistory;


  public MessageService(String message,
      UserService userService,
      MessageMapper messageMapper) {
    this.message = message;
    this.userService = userService;
    this.messageMapper = messageMapper;
  }

  public String uppercase() {
    return this.message.toUpperCase();
  }

  public String lowercase() {
    return this.message.toLowerCase();
  }

  public void addMessage(ChatForm chatForm) {
    ChatMessage tempChat = new ChatMessage();

    if (ignoreList.stream().anyMatch(x -> x.equalsIgnoreCase(chatForm.getMessageText())) == false ) {
      if (chatForm.getMessageType().equals("Whisper")) {
        chatForm.setMessageText(chatForm.getMessageText().toLowerCase());
      } else if (chatForm.getMessageType().equals("Shout")) {
        chatForm.setMessageText(chatForm.getMessageText().toUpperCase());
      }
      tempChat.setMessageText(chatForm.getMessageText());
      tempChat.setUsername(chatForm.getUserName());
      //chatHistory.add(tempChat);
      messageMapper.insert(tempChat);
    }

  }

  public ArrayList<ChatMessage> getMessage() {
    return messageMapper.getMessages();
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("MessageService bean created");
    //chatHistory = new ArrayList<ChatMessage>();
    ignoreList = new ArrayList<String>();
    ignoreList.add("Bad");
    ignoreList.add("Worse");
    ignoreList.add("Mean");
  }


}
