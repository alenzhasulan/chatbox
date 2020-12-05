package com.ansar.Chatbox.dto;

import com.ansar.Chatbox.model.Card;
import com.ansar.Chatbox.model.Chat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CardDto {
    private Long id;
    private Integer step;
//    private List<MessageDto> messages;

    public CardDto() {

    }

    public CardDto(Long id, Integer step, List<MessageDto> messages) {
        this.id = id;
        this.step = step;
//        this.messages = messages;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "id=" + id +
                ", step=" + step +
                '}';
    }

//    public List<MessageDto> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<MessageDto> messages) {
//        this.messages = messages;
//    }
}
