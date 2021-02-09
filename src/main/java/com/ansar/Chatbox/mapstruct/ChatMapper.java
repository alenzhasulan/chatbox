package com.ansar.Chatbox.mapstruct;

import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.exception.ResourceNotFoundException;
import com.ansar.Chatbox.model.Chat;
import com.ansar.Chatbox.repository.ChatRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {CardMapper.class})
public abstract class ChatMapper {

    @Autowired
    private ChatRepository chatRepository;


    @Mapping(target="id", source="chat.id")
    @Mapping(target="name", source="chat.name")
    @Mapping(target = "cards",source = "chat.cards")
    public  abstract ChatDto toDto (Chat chat);


//    @Mapping(target="id", source="chatDto.id")
    @Mapping(target="name", source="chatDto.name")
    @Mapping(target ="cards",source = "chatDto.cards")

    public  abstract Chat toEntity (ChatDto chatDto);

    @AfterMapping
    public void after(ChatDto chatDto, @MappingTarget Chat chat) {
        if(chatDto.getId()!=0){
            chat.setId(chatDto.getId());
        }
    }

}
