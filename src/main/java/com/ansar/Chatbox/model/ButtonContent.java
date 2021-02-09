package com.ansar.Chatbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "buttons")
public class ButtonContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private Long to_id;

    private Float offsetTop;
    private Float offsetWidth;
    private Float offsetHeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    @JsonIgnore
    private Message message;

    public ButtonContent(){}
    public ButtonContent(Long id, String label, Long to_id, Float offsetTop, Float offsetWidth, Float offsetHeight) {
        this.id = id;
        this.label = label;
        this.to_id = to_id;
        this.offsetTop = offsetTop;
        this.offsetWidth = offsetWidth;
        this.offsetHeight = offsetHeight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getTo_id() {
        return to_id;
    }

    public void setTo_id(Long to_id) {
        this.to_id = to_id;
    }

    public Float getOffsetTop() {
        return offsetTop;
    }

    public void setOffsetTop(Float offsetTop) {
        this.offsetTop = offsetTop;
    }

    public Float getOffsetWidth() {
        return offsetWidth;
    }

    public void setOffsetWidth(Float offsetWidth) {
        this.offsetWidth = offsetWidth;
    }

    public Float getOffsetHeight() {
        return offsetHeight;
    }

    public void setOffsetHeight(Float offsetHeight) {
        this.offsetHeight = offsetHeight;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ButtonContent{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", to_id='" + to_id + '\'' +
                ", offsetTop=" + offsetTop +
                ", offsetWidth=" + offsetWidth +
                ", offsetHeight=" + offsetHeight +
                '}';
    }
}
