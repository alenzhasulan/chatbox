package com.ansar.Chatbox.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class ChatDto {
    @NotNull(message = "Название не должно быть меньше 3 символов и больше 20  символов")
    @Size(min = 3,max = 20,message = "Название не должно быть меньше 3 символов и больше 20  символов")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
