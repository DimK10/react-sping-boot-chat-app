package com.kaitantzidis.chatapp.repository;

import com.kaitantzidis.chatapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
