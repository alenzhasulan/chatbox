package com.ansar.Chatbox.model;

import com.ansar.Chatbox.dto.ButtonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="messages")

public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer step;

    private MessageType messageType;

    private ContentType contentType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    @JsonIgnore
    private Card card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_id", referencedColumnName = "id")
    private Text text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;


    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ButtonContent> buttons=new ArrayList<ButtonContent>();


    public Message() {

    }

    public Message(Long id, Integer step, MessageType messageType, ContentType contentType, Card card, Text text, Image image, List<ButtonContent> buttons) {
        this.id = id;
        this.step = step;
        this.messageType = messageType;
        this.contentType = contentType;
        this.card = card;
        this.text = text;
        this.image = image;
        this.buttons = buttons;
    }


    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public List<ButtonContent> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonContent> buttons) {
        this.buttons = buttons;
    }
}
