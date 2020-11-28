package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String name);
}
