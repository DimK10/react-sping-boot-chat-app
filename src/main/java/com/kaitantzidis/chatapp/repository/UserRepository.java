package com.kaitantzidis.chatapp.repository;

import com.kaitantzidis.chatapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsernameEquals(@Param("username") String username);
}
