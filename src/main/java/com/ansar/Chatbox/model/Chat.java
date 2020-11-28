package com.ansar.Chatbox.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "chats")
@Data
public class Chat extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Название не должно быть меньше 3 символов и больше 20  символов")
    @Size(min = 3,max = 20,message = "Название не должно быть меньше 3 символов и больше 20  символов")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
