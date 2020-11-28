package com.ansar.Chatbox.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")

public class  Role extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<User> users;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
