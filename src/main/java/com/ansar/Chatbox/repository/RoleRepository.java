package com.ansar.Chatbox.repository;

import com.ansar.Chatbox.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
