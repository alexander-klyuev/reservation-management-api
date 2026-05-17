package com.alexander.reservationmanagementapi.practice.generics;

import com.alexander.reservationmanagementapi.model.Room;
import com.alexander.reservationmanagementapi.model.User;
import org.apache.el.lang.ELArithmetic;

import java.util.ArrayList;
import java.util.List;

public class WildcardPracticeRunner {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "alex@example.com", "Alex"),
                new User(2L, "ivan@example.com", "Ivan")
        );

        List<Room> rooms = List.of(
                new Room(1L, "Alpha", 4),
                new Room(2L, "Ocean", 10)
        );

        printIds(users);
        printIds(rooms);

        List<Object> objects = new ArrayList<>();
        addDefaultUsers(objects);
        System.out.println(objects);
    }

    // producer extends
    private static void printIds(List<? extends Identifiable<Long>> entities) {
        for(Identifiable<Long> entity : entities) {
            System.out.println(entity.getId());
        }
    }

    // consumer super
    private static void addDefaultUsers(List<? super User> users) {
        users.add(new User(100L, "default@example.com", "Default User"));

        Object first = users.getFirst();
        System.out.println(first);
    }
}
