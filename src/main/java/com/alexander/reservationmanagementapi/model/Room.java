package com.alexander.reservationmanagementapi.model;

import com.alexander.reservationmanagementapi.practice.generics.Identifiable;

import java.util.Objects;

public class Room implements Identifiable<Long> {
    private final Long id;
    private final String name;
    private final int capacity;

    public Room(Long id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
