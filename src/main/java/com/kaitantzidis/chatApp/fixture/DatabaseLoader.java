package com.kaitantzidis.chatApp.fixture;

import com.kaitantzidis.chatApp.model.User;
import com.kaitantzidis.chatApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception { // <4>
        this.userRepository.save(new User("jDoe", "John", "Doe", "user0@gmail.com"));
    }
}
