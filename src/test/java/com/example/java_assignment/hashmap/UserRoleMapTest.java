package com.example.java_assignment.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserRoleMapTest {
    private UserRoleMapTest() {}

    @Test
    void testEqualsAndHashCodeWorks() {
        User firstUser = new User(1, "Cheryl");
        User secondUser = new User(1, "Cheryl Duplicate");
        Map<User, String> roleMap = new HashMap<>();
        roleMap.put(firstUser, "ADMIN");
        assertEquals("ADMIN", roleMap.get(secondUser));
    }

    @Test
    void testMissingHashCodeCausesBug() {
        UserBroken firstUser = new UserBroken(1, "Howard");
        UserBroken secondUser = new UserBroken(1, "Howard Duplicate");
        Map<UserBroken, String> roleMap = new HashMap<>();
        roleMap.put(firstUser, "ADMIN");
        assertNotEquals("ADMIN", roleMap.get(secondUser));
    }

    // collision simulation
    @Test
    void testHashCollision() {
        BadKey firstKey = new BadKey("password");
        BadKey secondKey = new BadKey("123456");
        Map<BadKey, String> map = new HashMap<>();
        map.put(firstKey, "Value A");
        map.put(secondKey, "Value B");
        assertEquals("Value A", map.get(firstKey));
        assertEquals("Value B", map.get(secondKey));
    }

    // multiple key bug
    @Test
    void TestMutableKeyBug() {
        User user = new User(2, "Andrew");
        Map<User, String> roleMap = new HashMap<>();
        roleMap.put(user, "GUEST");
        user.setId(9);
        // mutated key make hashCode changed; map cannot find it anymore
        assertNull(roleMap.get(user));
    }

    @Test
    void testArrayListVsHashMapPerformance() {
        int size = 10_000;

        List<User> userList = new ArrayList<>();
        for (int i = 0 ; i < size; i++) {
            userList.add(new User(i, "User" + i));
        }

        Map<Integer, User> userMap = new HashMap<>();
        for (User u : userList) {
            userMap.put(u.getId(), u);
        }

        int targetId = size - 1;
        long startList = System.nanoTime();
        userList.stream().filter(u -> u.getId() == targetId).findFirst();
        long durationList = System.nanoTime() - startList;

        long startMap = System.nanoTime();
        userMap.get(targetId);
        long durationMap = System.nanoTime() - startMap;

        System.out.println("List: " + durationList);
        System.out.println("Map: " + durationMap);

        assertTrue(durationMap < durationList);
    }
}
