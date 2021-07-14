package com.kaitantzidis.chatapp.config;

import com.kaitantzidis.chatapp.model.Message;
import com.kaitantzidis.chatapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * WebSocket Listener class
 */
@Component
public class WebSocketChatEventListener {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        Logger logger = LoggerFactory.getLogger(WebSocketChatEventListener.class);
        logger.info("==========================================================");
        logger.info("Received a new web socket connection");
        logger.info("==========================================================");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        User sender = (User) headerAccessor.getSessionAttributes().get("user");
        if(sender != null) {
            var chatMessage = new Message();
            chatMessage.setType("Leave");
            chatMessage.setSender(sender);
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
