package com.ansar.Chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="messages")

public class Message extends BaseEntity {

    private Integer step;

    private MessageType messageType;

    private ContentType contentType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    @JsonIgnore
    private Card card;


    public Message() {

    }

    public Message(Integer step, MessageType messageType, ContentType contentType) {
        this.step = step;
        this.messageType = messageType;
        this.contentType = contentType;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Message{" +
                "step=" + step +
                ", messageType=" + messageType +
                ", contentType=" + contentType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return step.equals(message.step) &&
                messageType == message.messageType &&
                contentType == message.contentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, messageType, contentType);
    }
}
