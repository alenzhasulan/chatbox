package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.Chat;
import com.ansar.Chatbox.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ChatRepository extends CrudRepository<Chat,Long> {
    List<Chat> findAllByUser(User user);
    Optional<Chat>  findAllByUserAndId(User user, Long id);


}
