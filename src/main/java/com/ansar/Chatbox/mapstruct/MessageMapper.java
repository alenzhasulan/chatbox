package com.ansar.Chatbox.mapstruct;

import com.ansar.Chatbox.dto.ButtonDto;
import com.ansar.Chatbox.dto.MessageDto;
import com.ansar.Chatbox.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",uses = {CardMapper.class})
public  abstract  class MessageMapper {

    @Mapping(target="id", source="message.id")
    @Mapping(target="step", source="message.step")
    public abstract MessageDto toDto(Message message);

//    @Mapping(target="id", source="messageDto.id")
    @Mapping(target="step", source="messageDto.step")
    public abstract Message toEntity(MessageDto messageDto);

    @AfterMapping
    public void afterMessageDto(@MappingTarget MessageDto messageDto, Message message) {
        System.out.println(message);
        if(message.getMessageType()== MessageType.TEXT){
            messageDto.setData(message.getText().getField());
            messageDto.setChild_id(message.getText().getId());
            messageDto.setType_message("text");
        }
        if(message.getMessageType()==MessageType.IMAGE){
            messageDto.setUrl(message.getImage().getUrl());
            messageDto.setChild_id(message.getImage().getId());
            messageDto.setType_message("image");
        }
        if(message.getMessageType()==MessageType.BUTTON){
            messageDto.setType_message("button");
            messageDto.setChild_id((long) 0);
            System.out.println(message.getButtons());
            List <ButtonDto> buttons=new ArrayList<>();
            message.getButtons().forEach(bnt->{
                ButtonDto buttonDto=new ButtonDto();
                buttonDto.setId(bnt.getId());
                buttonDto.setLabel(bnt.getLabel());
                buttonDto.setOffsetHeight(bnt.getOffsetHeight());
                buttonDto.setOffsetTop(bnt.getOffsetTop());
                buttonDto.setOffsetWidth(bnt.getOffsetWidth());
                buttonDto.setTo_id(bnt.getTo_id());
                buttons.add(buttonDto);
            });
            messageDto.setContentButton(buttons);
        }
        if(message.getContentType()==ContentType.ANSWER){
            messageDto.setType_content("answer");
        }
        if(message.getContentType()==ContentType.QUESTION){
            messageDto.setType_content("question");
        }
    }

    @AfterMapping
    public void afterMessage( MessageDto messageDto, @MappingTarget Message message) {
        System.out.println("SET SET");

        if(messageDto.getId()!=0){
            message.setId(messageDto.getId());
        }
//        SET MESSAGE
        if(messageDto.getType_message().equals("text")){
            message.setMessageType(MessageType.TEXT);
            Text text=new Text();
            text.setField(messageDto.getData());
            if(messageDto.getChild_id()!=0) {
                text.setId(messageDto.getChild_id());
            }else {
                text.setField("");
            }
            message.setText(text);
        }
        if(messageDto.getType_message().equals("image")){
            message.setMessageType(MessageType.IMAGE);
            Image image=new Image();
            image.setUrl(messageDto.getUrl());
            if(messageDto.getChild_id()!=0) {
                image.setId(messageDto.getChild_id());
            }
            message.setImage(image);
        }

        if(messageDto.getType_message().equals("button")){
            message.setMessageType(MessageType.BUTTON);
            List<ButtonContent> buttons=new ArrayList<>();
            messageDto.getContentButton().forEach(bnt->{
                ButtonContent button=new ButtonContent();
                button.setId(bnt.getId());
                button.setLabel(bnt.getLabel());
                button.setOffsetHeight(bnt.getOffsetHeight());
                button.setOffsetTop(bnt.getOffsetTop());
                button.setOffsetWidth(bnt.getOffsetWidth());
                button.setTo_id(bnt.getTo_id());
                button.setMessage(message);
                buttons.add(button);
            });
            message.setButtons(buttons);
        }

//        SET CONTENT TYPE
        if(messageDto.getType_content().equals("question")){
            message.setContentType(ContentType.QUESTION);
        }
        if(messageDto.getType_content().equals("answer")){
            message.setContentType(ContentType.ANSWER);
        }



    }

}
