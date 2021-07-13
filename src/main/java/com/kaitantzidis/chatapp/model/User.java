package com.kaitantzidis.chatapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@EqualsAndHashCode(exclude = "messagesSent")
@Builder(toBuilder = true)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String username = "";
    @NonNull
    private String firstname = "";
    @NonNull
    private String lastname = "";
    @NonNull
    private String email = "";

    @ManyToMany
    private Set<Conversation> conversations = new HashSet<>();

    public void addConversation(Conversation aConversation) {
        conversations.add(aConversation);
    }

    public void removeConversation(Conversation aConversation) {
        conversations.remove(aConversation);
    }
}
