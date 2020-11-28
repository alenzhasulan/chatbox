package com.ansar.Chatbox.rest;

import com.ansar.Chatbox.model.User;
import com.ansar.Chatbox.repository.RoleRepository;
import com.ansar.Chatbox.repository.UserRepository;
import com.ansar.Chatbox.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users/")

public class UserRestControllerV1 {
    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @GetMapping("info")
    public ResponseEntity getInfo() {
        Authentication authentication =this.authenticationFacade.getAuthentication();
        User customUser = (User)authentication.getPrincipal();
        return ResponseEntity.ok(customUser);
    }
}
