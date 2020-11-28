package com.ansar.Chatbox.security.jwt;

import com.ansar.Chatbox.model.User;
import com.ansar.Chatbox.security.IAuthenticationFacade;
import com.ansar.Chatbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
class AuthenticationFacade implements IAuthenticationFacade {
    @Autowired
    private UserService userService;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public User getUser() {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(user!=null){
            return user;
        }
        return null;
    }


}
