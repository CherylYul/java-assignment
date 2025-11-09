package com.example.java_assignment.hashmap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBroken {
    private int id;
    private String name;

    public UserBroken(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBroken)) return false;
        UserBroken castedUser = (UserBroken) o;
        return id == castedUser.id;
    }

    // forget to write hashcode
}
