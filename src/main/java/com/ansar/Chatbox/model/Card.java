package com.ansar.Chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Table(name = "cards")
@Entity

public class Card extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer step;

    private Float position_x;
    private Float position_y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    @JsonIgnore
    private Chat chat;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Message> messages=new ArrayList<Message>();

    public Card() {
    }

    public Card(Long id, Integer step, Float position_x, Float position_y, Chat chat, List<Message> messages) {
        this.id = id;
        this.step = step;
        this.position_x = position_x;
        this.position_y = position_y;
        this.chat = chat;
        this.messages = messages;
    }


    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return step.equals(card.step) &&
                chat.equals(card.chat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, chat);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", step=" + step +
                ", chat=" + chat +
                '}';
    }

    public Float getPosition_x() {
        return position_x;
    }

    public void setPosition_x(Float position_x) {
        this.position_x = position_x;
    }

    public Float getPosition_y() {
        return position_y;
    }

    public void setPosition_y(Float position_y) {
        this.position_y = position_y;
    }
}
