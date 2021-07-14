package com.kaitantzidis.chatapp.controller;

import com.kaitantzidis.chatapp.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/conversation")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/conversation")
    public Message newUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("user", message.getSender() == null ? "" : message.getSender());
        return message;
    }
}
