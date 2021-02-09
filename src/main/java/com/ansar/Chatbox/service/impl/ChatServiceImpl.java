package com.ansar.Chatbox.service.impl;


import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.exception.ResourceNotFoundException;
import com.ansar.Chatbox.mapstruct.CardMapper;
import com.ansar.Chatbox.mapstruct.ChatMapper;
import com.ansar.Chatbox.mapstruct.MessageMapper;
import com.ansar.Chatbox.model.*;
import com.ansar.Chatbox.repository.CardRepository;
import com.ansar.Chatbox.repository.ChatRepository;
import com.ansar.Chatbox.security.IAuthenticationFacade;
import com.ansar.Chatbox.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ChatServiceImpl implements ChatService {
    @Autowired
    private final ChatMapper chatMapper;
    @Autowired
    private final CardMapper cardMapper;
    @Autowired
    private final MessageMapper messageMapper;

    private ChatRepository chatRepository;
    private CardRepository cardRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @Autowired
    public ChatServiceImpl(ChatMapper chatMapper, CardMapper cardMapper, ChatRepository chatRepository, CardRepository cardRepository, IAuthenticationFacade authenticationFacade,MessageMapper messageMapper) {
        this.chatMapper = chatMapper;
        this.cardMapper = cardMapper;
        this.messageMapper=messageMapper;
        this.chatRepository = chatRepository;
        this.cardRepository = cardRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public Chat create(String chatName) {
        User user = authenticationFacade.getUser();
        Chat chat=new Chat();
        chat.setUser(user);
        chat.setCreated(new Date());
        chat.setUpdated(new Date());
        chat.setStatus(Status.ACTIVE);
        chat.setName(chatName);
        Chat newChat=chatRepository.save(chat);
        return newChat;
    }

    @Override
    public List<Chat> getAll() {
        User user = authenticationFacade.getUser();
        List <Chat> chats= chatRepository.findAllByUser(user);
        return chats;
    }


    @Override
    public ChatDto findById(Long id) {
        User user = authenticationFacade.getUser();
        Chat chat= chatRepository.findAllByUserAndId(user,id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " + id));

        return  chatMapper.toDto(chat);
    }

    @Override
    public Chat update(Long id, String name) {
        User user = authenticationFacade.getUser();
        Chat chat = chatRepository.findAllByUserAndId(user,id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " + id));
        chat.setName(name);
        chatRepository.save(chat);
        return chat;
    }

    @Override
    @Transactional
    public ChatDto updateAll(ChatDto chatDto){
        User user = authenticationFacade.getUser();
        Chat parentChat=chatRepository.findById(chatDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = "+chatDto.getId()));

        List<Card> newCards = new ArrayList<>();
        chatDto.getCards().forEach(cardDto -> {
            Card card=cardMapper.toEntity(cardDto);
            card.setChat(parentChat);

            List<Message> newMessages = new ArrayList<>();
            cardDto.getMessages().forEach(messageDto -> {
                Message message=messageMapper.toEntity(messageDto);
                message.setCard(card);
                newMessages.add(message);
            });
            card.getMessages().clear();
            card.setMessages(newMessages);

            newCards.add(card);
        });

        parentChat.getCards().clear();
        parentChat.setCards(newCards);

        chatRepository.save(parentChat);
        return chatMapper.toDto(parentChat);
    }

    public <T> List<T> difference(List<T> first, List<T> second) {
        List<T> toReturn = new ArrayList<>(first);
        toReturn.removeAll(second);
        return toReturn;
    }
}
