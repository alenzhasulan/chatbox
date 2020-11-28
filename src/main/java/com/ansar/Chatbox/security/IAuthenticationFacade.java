package com.ansar.Chatbox.security;


import com.ansar.Chatbox.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

public interface IAuthenticationFacade {
    Authentication getAuthentication();
    User getUser();
}


