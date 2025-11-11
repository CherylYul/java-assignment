package com.example.java_assignment.optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

public class OptionalTest {

    @Test
    void testBasicOptional() {
        String name = "Cheryl";
        Optional<String> opt = Optional.of(name);
        opt.ifPresentOrElse(System.out::println,
                () -> { System.out.println("unknown"); }
        );
    }

    @Test
    void testOfNullable() {
        String maybeNull = null;
        Optional<String> opt = Optional.ofNullable(maybeNull);
        opt.ifPresentOrElse(
                (val) -> {
                    System.out.println("Value is present");
                    },
                () -> {
                    System.out.println("Value is empty");
                }
        );
    }

    @Test
    void testMapAndFlatMap() {
        Optional<String> email = Optional.of("someone@example.com");
        Optional<String> mapResult = email.map(String::toUpperCase);
        Optional<String> flatMapResult = email.flatMap(
                e -> Optional.of(e.toUpperCase())
        );
        System.out.println(mapResult);
        System.out.println(flatMapResult);
    }

    @Test
    void testOrElseVariants() {
        Optional<String> opt = Optional.empty();
        assertEquals("A", opt.orElse("A"));
        assertEquals("B", opt.orElseGet(() -> "B"));
        assertThrows(NullPointerException.class, () ->
                opt.orElseThrow(() -> new NullPointerException("Throw Exception"))
        );
    }

    @Test
    void testUserLookup() {
        UserRepository repo = new UserRepository();
        repo.findUserById(1).ifPresent(System.out::println);
        assertEquals(
                "Not Found",
                repo.findUserById(5).orElseGet(() -> "Not Found"));
    }
}
