package com.kaitantzidis.chatapp.repository;

import com.kaitantzidis.chatapp.model.Conversation;
import org.springframework.data.repository.CrudRepository;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
}
