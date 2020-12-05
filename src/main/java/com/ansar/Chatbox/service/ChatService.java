package com.ansar.Chatbox.service;

import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.model.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    Chat create(String  chatName);
    List<Chat> getAll();
    Chat update(Long id,String name);

    ChatDto updateAll(ChatDto chatDto);
    ChatDto findById(Long id);
}
