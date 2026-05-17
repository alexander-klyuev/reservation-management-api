package com.alexander.reservationmanagementapi.practice.generics;

import com.alexander.reservationmanagementapi.model.Room;
import com.alexander.reservationmanagementapi.model.User;

public class GenericsPracticeRunner {
    public static void main(String[] args) {
        InMemoryRepository<User, Long> userRepository = new UserInMemoryRepository();
        InMemoryRepository<Room, Long> roomRepository = new RoomInMemoryRepository();

        userRepository.save(new User(1L, "alex@example.com", "Alex"));
        userRepository.save(new User(2L, "ivan@example.com", "Ivan"));

        roomRepository.save(new Room(1L, "Alpha", 4));
        roomRepository.save(new Room(2L, "Ocean", 10));

        System.out.println(userRepository.findById(1L));
        System.out.println(roomRepository.findAll());
        System.out.println("Deleting room by id: " + 1L);
        roomRepository.deleteById(1L);
        System.out.println(roomRepository.findAll());
    }
}
