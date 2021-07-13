package com.kaitantzidis.chatapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"usersInvolved", "messages"})
@Builder(toBuilder = true)
public class Conversation {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreated = new Date();

    @Basic
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeUpdated = new Date();

    @ManyToMany
    @NonNull
    private Set<User> usersInvolved = new HashSet<>();

    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages = new HashSet<>();

    public void addUser(User aUser) {
        usersInvolved.add(aUser);
        aUser.addConversation(this);
    }

    public void removeUser(User aUser) {
        usersInvolved.remove(aUser);
        aUser.removeConversation(this);
    }

    public void addMessage(Message aMessage) {
        messages.add(aMessage);
    }
}
