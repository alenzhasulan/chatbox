package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {
    Optional<Card> findById(Long id);
}