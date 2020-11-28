package com.ansar.Chatbox.service;

import com.ansar.Chatbox.model.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    Chat create(String  chatName);

    List<Chat> getAll();

    Chat findById(Long id);

    Chat update(Long id,String name);
}
