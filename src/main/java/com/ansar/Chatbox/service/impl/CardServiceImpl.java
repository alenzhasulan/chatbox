package com.ansar.Chatbox.service.impl;

import com.ansar.Chatbox.exception.ResourceNotFoundException;
import com.ansar.Chatbox.model.Card;
import com.ansar.Chatbox.repository.CardRepository;

import com.ansar.Chatbox.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Slf4j
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Named("findById")
    @Override
    public Card findById(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " + id));
        return card;
    }
}
