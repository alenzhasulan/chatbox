package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.Chat;
import com.ansar.Chatbox.model.Message;
import com.ansar.Chatbox.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MessageRepository extends CrudRepository<Message,Long> {

}
