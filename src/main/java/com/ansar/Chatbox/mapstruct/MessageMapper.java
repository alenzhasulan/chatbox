package com.ansar.Chatbox.mapstruct;

import com.ansar.Chatbox.dto.MessageDto;
import com.ansar.Chatbox.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public  abstract  class MessageMapper {

    @Mapping(target="id", source="message.id")
    @Mapping(target="step", source="message.step")
    @Mapping(target="type_message", source="message.messageType")
    @Mapping(target="type_content", source="message.contentType")
    public abstract MessageDto toDto(Message message);

    @Mapping(target="id", source="messageDto.id")
    @Mapping(target="step", source="messageDto.step")
    public abstract Message toEntity(MessageDto messageDto);

    @AfterMapping
    public void afterMessageDto(@MappingTarget MessageDto messageDto, Message message) {
        if(message.getMessageType()== MessageType.TEXT){
            messageDto.setData(message.getText().getField());
            messageDto.setChild_id(message.getText().getId());
        }
        if(message.getMessageType()==MessageType.IMAGE){
            System.out.println(message.getImage());
            messageDto.setUrl(message.getImage().getUrl());
            messageDto.setChild_id(message.getImage().getId());
        }
    }

    @AfterMapping
    public void afterMessage( MessageDto messageDto, @MappingTarget Message message) {
//        SET MESSAGE
        if(messageDto.getType_message().equals("text")){
            message.setMessageType(MessageType.TEXT);
            Text text=new Text();
            text.setField(messageDto.getData());
            text.setId(messageDto.getChild_id());
        }
        if(messageDto.getType_message().equals("image")){
            message.setMessageType(MessageType.IMAGE);
            Image image=new Image();
            image.setUrl(messageDto.getUrl());
            image.setId(messageDto.getChild_id());
        }

//        SET CONTENT TYPE
        if(messageDto.getType_content().equals("question")){
            message.setContentType(ContentType.ANSWER);
        }
        if(messageDto.getType_content().equals("answer")){
            message.setContentType(ContentType.QUESTION);
        }


    }

}
