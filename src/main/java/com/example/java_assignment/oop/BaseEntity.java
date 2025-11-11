package com.example.java_assignment.oop;

import lombok.Getter;

@Getter
public abstract class BaseEntity {
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public abstract void printInfo();
}
