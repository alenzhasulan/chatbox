package com.ansar.Chatbox.mapstruct;

import com.ansar.Chatbox.dto.CardDto;
import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.dto.PositionDto;
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
                MessageMapper.class
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
    @Mapping(target="messages", source="card.messages")
    public  abstract CardDto toDto(Card card);
    public  abstract List<CardDto> toDto(List<CardDto> card);


    @Mapping(target="id", source="cardDto.id")
    @Mapping(target="step", source="cardDto.step")
    @Mapping(target="messages", source="cardDto.messages")
    @Mapping(target="chat",ignore = true)
    @Mapping(target="position_x", source="cardDto.position.x")
    @Mapping(target="position_y", source="cardDto.position.y")
    public  abstract Card  toEntity(CardDto cardDto);
    public  abstract List<Card> toEntity(List<Card> card);


    @AfterMapping
    public void after(@MappingTarget CardDto cardDto,  Card card) {
        PositionDto positionDto=new PositionDto();
        positionDto.setX(card.getPosition_x());
        positionDto.setY(card.getPosition_y());
        cardDto.setPosition(positionDto);
    }



}
