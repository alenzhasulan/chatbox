package com.ansar.Chatbox.dto;

import com.ansar.Chatbox.model.ContentType;
import com.ansar.Chatbox.model.MessageType;

public class MessageDto {
    private Long id;

    private Integer step;

    private String type_message;

    private String type_content;

    private String data;

    private String url;

    private Long child_id;

    public MessageDto(Long id, Integer step, String type_message, String type_content, String data, String url, Long child_id) {
        this.id = id;
        this.step = step;
        this.type_message = type_message;
        this.type_content = type_content;
        this.data = data;
        this.url = url;
        this.child_id = child_id;
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

    public String getType_message() {
        return type_message;
    }

    public void setType_message(String type_message) {
        this.type_message = type_message;
    }

    public String getType_content() {
        return type_content;
    }

    public void setType_content(String type_content) {
        this.type_content = type_content;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", step=" + step +
                ", type_message='" + type_message + '\'' +
                ", type_content='" + type_content + '\'' +
                '}';
    }

    public Long getChild_id() {
        return child_id;
    }

    public void setChild_id(Long child_id) {
        this.child_id = child_id;
    }
}
