package com.alexander.reservationmanagementapi.practice;

import com.alexander.reservationmanagementapi.model.Room;
import com.alexander.reservationmanagementapi.model.User;

import java.util.*;

public class CollectionsPracticeRunner {
    public static void main(String[] args) {
        practiceHashSet();
        practiceHashMap();
        practiceTreeMap();
    }

    private static void practiceHashSet() {
        Set<User> users = new HashSet<>();

        users.add(new User(1L, "alex@example.com", "Alex"));
        users.add(new User(2L, "alex@example.com", "Alexander"));
        users.add(new User(3L, "ivan@example.com", "Ivan"));

        System.out.println("HashSet users:");
        users.forEach(System.out::println);
        System.out.println("Size: " + users.size());
        System.out.println();
    }

    private static void practiceHashMap() {
        Map<User, Integer> reservationCountByUser = new HashMap<>();

        User alex1 = new User(1L, "alex@example.com", "Alex");
        User alex2 = new User(2L, "alex@example.com", "Alexander");

        reservationCountByUser.put(alex1, 3);
        reservationCountByUser.put(alex2, 5);

        System.out.println("HashMap reservations count:");
        reservationCountByUser.forEach((user, count) ->
                System.out.println(user + " -> " + count)
        );
        System.out.println("Size: " + reservationCountByUser.size());
        System.out.println();
    }

    private static void practiceTreeMap() {
        Map<String, Room> roomsByName = new TreeMap<>();

        roomsByName.put("Ocean", new Room(1L, "Ocean", 10));
        roomsByName.put("Alpha", new Room(2L, "Alpha", 6));
        roomsByName.put("Beta", new Room(3L, "Beta", 4));

        System.out.println("TreeMap rooms by name:");
        roomsByName.forEach((name, room) ->
                System.out.println(name + " -> " + room)
        );
    }
}
