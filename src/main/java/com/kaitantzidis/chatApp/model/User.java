package com.kaitantzidis.chatApp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
}
