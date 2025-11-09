package com.example.java_assignment.hashmap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadKey {
    private String value;

    public BadKey(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadKey)) return false;
        BadKey other = (BadKey) o;
        return value.equals(other.value);
    }
}
