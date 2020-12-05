package com.ansar.Chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "texts")

public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String field;


    @JsonIgnore
    @OneToOne(mappedBy = "text",cascade =  CascadeType.ALL,fetch = FetchType.LAZY)
    private Message message;

    public Text() {
    }

    public Text(String field, Message message) {
        this.field = field;
        this.message = message;
    }

    public Text(Long id, String field, Message message) {
        this.id = id;
        this.field = field;
        this.message = message;
    }


    @Override
    public String toString() {
        return "Text{" +
                "message='" + field + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
