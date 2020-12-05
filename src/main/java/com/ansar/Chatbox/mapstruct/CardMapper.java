package com.ansar.Chatbox.mapstruct;

import com.ansar.Chatbox.dto.CardDto;
import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.exception.ResourceNotFoundException;
import com.ansar.Chatbox.model.Card;
import com.ansar.Chatbox.repository.CardRepository;
import com.ansar.Chatbox.service.CardService;
import javassist.NotFoundException;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceContext;
import java.util.List;


@Mapper(
        componentModel = "spring",
        uses = {
                ChatMapper.class,
//                MessageMapper.class
        },
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS

)

public abstract  class CardMapper {

    @Autowired
    private CardRepository cardRepository;


    @Mapping(target="id", source="card.id")
    @Mapping(target="step", source="card.step")
//    @Mapping(target="messages", source="card.messages")
    public  abstract CardDto toDto(Card card);
    public  abstract List<CardDto> toDto(List<CardDto> card);


    @Mapping(target="id", source="cardDto.id")
    @Mapping(target="step", source="cardDto.step")
//    @Mapping(target="messages", source="cardDto.messages")
    @Mapping(target="chat",ignore = true)
    public  abstract Card  toEntity(CardDto cardDto);
    public  abstract List<Card> toEntity(List<Card> card);


//    @AfterMapping
//    public void calledWithSourceAndTarget(CardDto cardDto, @MappingTarget Card card) {
//        System.out.println("OSISIISIISIISI");
//        System.out.println(chatDto);
//        Card result = this.cardRepository.findById(cardDto.getId())
////                .orElseGet(()->new Card());
//                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " ));
//        System.out.println(result);
//        card.setChat(result.getChat());
//    }



}
