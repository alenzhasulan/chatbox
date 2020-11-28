package com.ansar.Chatbox.service.impl;


import com.ansar.Chatbox.exception.ResourceNotFoundException;
import com.ansar.Chatbox.model.Chat;
import com.ansar.Chatbox.model.Status;
import com.ansar.Chatbox.model.User;
import com.ansar.Chatbox.repository.ChatRepository;
import com.ansar.Chatbox.security.IAuthenticationFacade;
import com.ansar.Chatbox.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class ChatServiceImpl implements ChatService {
    private  ChatRepository chatRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
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
    public Chat findById(Long id) {
        User user = authenticationFacade.getUser();
        Chat chat= chatRepository.findAllByUserAndId(user,id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found chat with id = " + id));
        return  chat;
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
}
