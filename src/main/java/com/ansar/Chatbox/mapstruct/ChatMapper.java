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


    @Mapping(target="id", source="chatDto.id")
    @Mapping(target="name", source="chatDto.name")
    @Mapping(target ="cards",source = "chatDto.cards")

    public  abstract Chat toEntity (ChatDto chatDto);

//    @AfterMapping
//    public void after(ChatDto chatDto, @MappingTarget Chat chat) {
//        System.out.println("Begin chat");
//        if(chatDto.getCards().size()!=0){
//            Chat parent=chatRepository.findById(chatDto.getId())
//                    .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " ));
//            System.out.println(parent);
//            chat.getCards().forEach(card -> {
//                card.setChat(parent);
//            });
//            System.out.println(chat);
//            System.out.println("bir");
//        }
//    }

}
