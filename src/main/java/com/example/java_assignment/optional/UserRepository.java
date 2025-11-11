package com.example.java_assignment.optional;

import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<Integer, String> db = Map.of(
            1, "Dilys",
            2, "Andrew",
            3, "Howard",
            4, "Cheryl"
    );

    Optional<String> findUserById(int id) {
        return Optional.ofNullable(db.get(id));
    }
}
