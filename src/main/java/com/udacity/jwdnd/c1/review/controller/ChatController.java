package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

  private MessageService messageService;

  public ChatController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping
  public String getChatHome(ChatForm chatForm, Model model) {
    model.addAttribute("chatMessage", this.messageService.getMessage());
    return "chat";
  }

  @PostMapping
  public String postChatHome(ChatForm chatForm, Model model) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    System.out.println("username: " + username);
    chatForm.setUserName(username);
    messageService.addMessage(chatForm);
    System.out.println("chat form " + chatForm.toString());
    model.addAttribute("chatMessage", this.messageService.getMessage());
    chatForm.setMessageText("");
    chatForm.setUserName("");
    return "chat";
  }

  @ModelAttribute("allMessageTypes")
  public String[] allMessageTypes () {
    return new String[] {"Say", "Shout", "Whisper"};
  }

}
