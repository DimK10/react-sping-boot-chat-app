package com.kaitantzidis.chatapp.repository;

import com.kaitantzidis.chatapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
