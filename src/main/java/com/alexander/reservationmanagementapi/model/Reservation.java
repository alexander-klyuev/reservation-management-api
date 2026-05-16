package com.alexander.reservationmanagementapi.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {
    private final Long id;
    private final User user;
    private final Room room;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Reservation(Long id, User user, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation reservation)) return false;
        return Objects.equals(room, reservation.room)
                && Objects.equals(startTime, reservation.startTime)
                && Objects.equals(endTime, reservation.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
