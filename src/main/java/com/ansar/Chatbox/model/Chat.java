package com.ansar.Chatbox.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "chats")

public class Chat extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Название не должно быть меньше 3 символов и больше 20  символов")
    @Size(min = 3,max = 20,message = "Название не должно быть меньше 3 символов и больше 20  символов")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Card> cards=new ArrayList<Card>();

    public Chat() {
    }

    public Chat(@NotNull(message = "Название не должно быть меньше 3 символов и больше 20  символов") @Size(min = 3, max = 20, message = "Название не должно быть меньше 3 символов и больше 20  символов") String name, User user, List<Card> cards) {
        this.name = name;
        this.user = user;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chat chat = (Chat) o;
        return name.equals(chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
