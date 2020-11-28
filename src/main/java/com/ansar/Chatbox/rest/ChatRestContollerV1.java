package com.ansar.Chatbox.rest;

import com.ansar.Chatbox.dto.ChatDto;
import com.ansar.Chatbox.model.Chat;
import com.ansar.Chatbox.security.IAuthenticationFacade;
import com.ansar.Chatbox.service.ChatService;
import com.ansar.Chatbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/chats")
@Validated

public class ChatRestContollerV1 {

    private final ChatService chatService;
    private final UserService userService;
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    public ChatRestContollerV1(ChatService chatService, UserService userService, IAuthenticationFacade authenticationFacade) {
        this.chatService = chatService;
        this.userService = userService;
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getChats (){
        List<Chat> chats=chatService.getAll();
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getById ( @PathVariable Long id){
        Chat chats=chatService.findById(id);
        return ResponseEntity.ok(chats);
    }

    @PostMapping("/add")
    public ResponseEntity<Chat> add (@Valid @RequestBody ChatDto chatDto){
        String chatName=chatDto.getName();
        Chat chat=chatService.create(chatName);
        return ResponseEntity.ok(chat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> update (@PathVariable("id") long id,@Valid @RequestBody ChatDto chatDto){
        String chatName=chatDto.getName();
        Chat chat=chatService.update(id,chatName);
        return ResponseEntity.ok(chat);
    }
}
