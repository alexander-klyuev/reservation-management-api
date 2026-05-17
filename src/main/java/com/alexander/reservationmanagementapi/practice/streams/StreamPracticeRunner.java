package com.alexander.reservationmanagementapi.practice.streams;

import com.alexander.reservationmanagementapi.model.Reservation;
import com.alexander.reservationmanagementapi.model.Room;
import com.alexander.reservationmanagementapi.model.User;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPracticeRunner {
    public static void main(String[] args) {
        User user1 = new User(1L, "alex@example.com", "Alex");
        User user2 = new User(2L, "ivan@example.com", "Ivan");
        User user3 = new User(3L, "albert@example.com", "Albert");

        Room room1 = new Room(1L, "Alpha", 6);
        Room room2 = new Room(2L, "Beta", 4);
        Room room3 = new Room(3L, "Ocean", 10);

        Reservation reservation1 = new Reservation(
                1L,
                user1,
                room1,
                LocalDateTime.of(2026, 6, 3, 15, 30),
                LocalDateTime.of(2026, 6, 10, 15, 30)
        );
        Reservation reservation2 = new Reservation(
                2L,
                user2,
                room1,
                LocalDateTime.of(2026, 6, 4, 15, 30),
                LocalDateTime.of(2026, 6, 14, 15, 30)
        );
        Reservation reservation3 = new Reservation(
                3L,
                user3,
                room1,
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 6, 1, 11, 30)
        );
        Reservation reservation4 = new Reservation(
                4L,
                user1,
                room2,
                LocalDateTime.of(2026, 6, 3, 15, 30),
                LocalDateTime.of(2026, 6, 10, 15, 30)
        );
        Reservation reservation5 = new Reservation(
                5L,
                user2,
                room2,
                LocalDateTime.of(2026, 6, 4, 15, 30),
                LocalDateTime.of(2026, 6, 14, 15, 30)
        );
        Reservation reservation6 = new Reservation(
                6L,
                user3,
                room2,
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 6, 1, 11, 30)
        );
        Reservation reservation7 = new Reservation(
                7L,
                user1,
                room3,
                LocalDateTime.of(2026, 6, 3, 15, 30),
                LocalDateTime.of(2026, 6, 10, 15, 30)
        );
        Reservation reservation8 = new Reservation(
                8L,
                user2,
                room3,
                LocalDateTime.of(2026, 6, 4, 15, 30),
                LocalDateTime.of(2026, 6, 14, 15, 30)
        );
        Reservation reservation9 = new Reservation(
                9L,
                user3,
                room3,
                LocalDateTime.of(2026, 5, 20, 10, 30),
                LocalDateTime.of(2026, 6, 1, 11, 30)
        );

        List<Room> rooms = List.of(room1, room2, room3);
        List<Reservation> reservations = List.of(
                reservation1, reservation2, reservation3,
                reservation4, reservation5, reservation6,
                reservation7, reservation8, reservation9
        );

        findReservationsByUserEmail(reservations, "ivan@example.com").forEach(System.out::println);
        System.out.println();

        (groupReservationsByRoom(reservations)).forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(System.out::println);
        });
        System.out.println();

        countReservationsByUser(reservations).forEach((key, value) ->
            System.out.println(key + ": " + value)
        );
        System.out.println();

        System.out.println("minCapacity: 5");
        findRoomsWithCapacityAtLeast(rooms, 5).forEach(System.out::println);
        System.out.println("minCapacity: 7");
        findRoomsWithCapacityAtLeast(rooms, 7).forEach(System.out::println);
        System.out.println();

        System.out.println("findFirstReservationForRoom 'Alpha':");
        System.out.println(findFirstReservationForRoom(reservations, "Alpha"));
        System.out.println("findFirstReservationForRoom 'Gamma':");
        System.out.println(findFirstReservationForRoom(reservations, "Gamma"));
        System.out.println();

        System.out.println("Reservations sorted by start time:");
        sortReservationsByStartTime(reservations).forEach(System.out::println);
    }

    private static List<Reservation> findReservationsByUserEmail(
            List<Reservation> reservations,
            String email
    ) {
        return reservations.stream()
                .filter(reservation -> reservation.getUser().getEmail().equals(email))
                .toList();
    }

    private static Map<Room, List<Reservation>> groupReservationsByRoom(
            List<Reservation> reservations
    ) {
        return reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getRoom));
    }

    private static Map<User, Long> countReservationsByUser(
            List<Reservation> reservations
    ) {
        return reservations.stream()
                .collect(Collectors.groupingBy(
                        Reservation::getUser,
                        Collectors.counting()
                ));
    }

    private static List<Room> findRoomsWithCapacityAtLeast(
            List<Room> rooms,
            int minCapacity
    ) {
        return rooms.stream()
                .filter(room -> room.getCapacity() >= minCapacity)
                .toList();
    }

    private static Optional<Reservation> findFirstReservationForRoom(
            List<Reservation> reservations,
            String roomName
    ) {
        return reservations.stream()
                .filter(reservation -> reservation.getRoom().getName().equals(roomName))
                .findFirst();
    }

    private static List<Reservation> sortReservationsByStartTime(
            List<Reservation> reservations
    ) {
        return reservations.stream()
                .sorted(Comparator.comparing(Reservation::getStartTime))
                .toList();
    }
}
