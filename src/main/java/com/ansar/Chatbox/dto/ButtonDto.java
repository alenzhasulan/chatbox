package com.ansar.Chatbox.dto;

import com.ansar.Chatbox.model.Message;

public class ButtonDto {
    private Long id;
    private String label;
    private Long to_id;

    private Float offsetTop;
    private Float offsetWidth;
    private Float offsetHeight;

    private Message message;

    public ButtonDto(){}
    public ButtonDto(Long id, String label, Long to_id, Float offsetTop, Float offsetWidth, Float offsetHeight, Message message) {
        this.id = id;
        this.label = label;
        this.to_id = to_id;
        this.offsetTop = offsetTop;
        this.offsetWidth = offsetWidth;
        this.offsetHeight = offsetHeight;
        this.message = message;
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
}
