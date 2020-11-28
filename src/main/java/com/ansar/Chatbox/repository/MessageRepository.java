package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
