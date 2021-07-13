package com.kaitantzidis.chatapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    @NonNull
    private String payload = "";

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation = new Conversation();

    @Basic(optional = false)
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreated = new Date();
}
