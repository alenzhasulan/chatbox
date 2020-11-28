package com.ansar.Chatbox.service.impl;

import com.ansar.Chatbox.model.Role;
import com.ansar.Chatbox.model.Status;
import com.ansar.Chatbox.model.User;
import com.ansar.Chatbox.repository.RoleRepository;
import com.ansar.Chatbox.repository.UserRepository;
import com.ansar.Chatbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser=roleRepository.findByName("ROLE_USER");
        List<Role> userRoles=new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser=userRepository.save(user);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = (List<User>) userRepository.findAll();
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result=userRepository.findByUsername(username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result=userRepository.findById(id).orElse(null);
        if(result==null){
            return null;
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
