DROP TABLE IF EXISTS reservations, rooms, users;

CREATE TABLE users
(
    id        BIGSERIAL PRIMARY KEY,
    email     VARCHAR(255) NOT NULL UNIQUE,
    full_name VARCHAR(255) NOT NULL
);

CREATE TABLE rooms
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL UNIQUE,
    capacity INTEGER      NOT NULL

        CONSTRAINT chk_room_capacity
            CHECK (capacity > 0)
);

CREATE TABLE reservations
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT    NOT NULL,
    room_id    BIGINT    NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time   TIMESTAMP NOT NULL,

    CONSTRAINT fk_reservations_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),

    CONSTRAINT fk_reservations_room
        FOREIGN KEY (room_id)
            REFERENCES rooms (id),

    CONSTRAINT chk_reservation_time
        CHECK (end_time > start_time)
);

