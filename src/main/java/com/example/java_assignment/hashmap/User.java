package com.example.java_assignment.hashmap;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User castedUser = (User) o;
        return id == castedUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
