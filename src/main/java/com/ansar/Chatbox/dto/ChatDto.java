package com.ansar.Chatbox.dto;

import com.ansar.Chatbox.model.Card;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class ChatDto {
    private Long id;
    private String name;
    private List<CardDto> cards;

    public ChatDto() {

    }

    public ChatDto(Long id, String name, List<CardDto> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public void setCards(List<CardDto> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
