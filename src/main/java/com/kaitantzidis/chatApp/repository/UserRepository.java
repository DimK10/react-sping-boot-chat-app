package com.kaitantzidis.chatApp.repository;

import com.kaitantzidis.chatApp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
