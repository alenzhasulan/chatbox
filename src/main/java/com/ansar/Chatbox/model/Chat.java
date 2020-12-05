package com.ansar.Chatbox.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "chats")

public class Chat extends BaseEntity {

    @Column(name = "name")
    @NotNull(message = "Название не должно быть меньше 3 символов и больше 20  символов")
    @Size(min = 3,max = 20,message = "Название не должно быть меньше 3 символов и больше 20  символов")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false)
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL,orphanRemoval = true)
//    @Fetch(FetchMode.SELECT)
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
            this.cards.clear();
            if(cards!=null){
                this.cards.addAll(cards);
            }
//        this.cards = cards;
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
