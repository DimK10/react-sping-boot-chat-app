package com.kaitantzidis.chatapp.fixture;

import com.kaitantzidis.chatapp.model.Conversation;
import com.kaitantzidis.chatapp.model.Message;
import com.kaitantzidis.chatapp.model.User;
import com.kaitantzidis.chatapp.repository.ConversationRepository;
import com.kaitantzidis.chatapp.repository.MessageRepository;
import com.kaitantzidis.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    private final MessageRepository messageRepository;

    private final ConversationRepository conversationRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository, MessageRepository messageRepository, ConversationRepository conversationRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        var jDoe = new User().toBuilder().build();
        jDoe.setUsername("jDoe");
        jDoe.setFirstname("John");
        jDoe.setLastname("Doe");
        jDoe.setEmail("user0@gmail.com");
        var fBar = new User().toBuilder().build();
        fBar.setUsername("fBar");
        fBar.setFirstname("Foo");
        fBar.setLastname("Bar");
        fBar.setEmail("user1@gmail.com");

        this.userRepository.save(jDoe);
        this.userRepository.save(fBar);

        var currentConverstation = new Conversation().toBuilder().build();
        currentConverstation.setDateTimeCreated(new Date());
        currentConverstation.setDateTimeUpdated(new Date());
        currentConverstation.addUser(jDoe);
        currentConverstation.addUser(fBar);

        // Add messages
        var messageFromJDoe = new Message().toBuilder().build();
        messageFromJDoe.setPayload("Hello Foo! How are you?");
        messageFromJDoe.setConversation(currentConverstation);
        messageFromJDoe.setSender(jDoe);

        var messageFromFooBar = new Message();
        messageFromFooBar.setPayload("Hello Joe! Im good, you?");
        messageFromFooBar.setConversation(currentConverstation);
        messageFromFooBar.setSender(fBar);


        currentConverstation.addMessage(messageFromJDoe);
        currentConverstation.addMessage(messageFromFooBar);

        // Engage in conversation
        this.conversationRepository.save(currentConverstation);

        messageRepository.save(messageFromJDoe);
        messageRepository.save(messageFromFooBar);



    }
}
