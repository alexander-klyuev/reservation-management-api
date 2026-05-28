INSERT INTO users (email, full_name)
VALUES ('alex@example.com', 'Alex Petrov'),
       ('ivan@example.com', 'Ivan Ivanov'),
       ('albert@example.com', 'Albert Smith'),
       ('sofia@example.com', 'Sofia Noreservations');

INSERT INTO rooms (name, capacity)
VALUES ('Alpha', 4),
       ('Beta', 5),
       ('Ocean', 10);

INSERT INTO reservations (user_id, room_id, start_time, end_time)
VALUES ((SELECT id FROM users WHERE email = 'ivan@example.com'),
        (SELECT id FROM rooms WHERE name = 'Alpha'),
        TIMESTAMP '2026-06-01 10:00:00',
        TIMESTAMP '2026-06-01 11:00:00'),
       ((SELECT id FROM users WHERE email = 'alex@example.com'),
        (SELECT id FROM rooms WHERE name = 'Alpha'),
        TIMESTAMP '2026-06-02 09:00:00',
        TIMESTAMP '2026-06-02 10:00:00'),
       ((SELECT id FROM users WHERE email = 'albert@example.com'),
        (SELECT id FROM rooms WHERE name = 'Alpha'),
        TIMESTAMP '2026-07-03 14:00:00',
        TIMESTAMP '2026-07-03 15:00:00'),

       ((SELECT id FROM users WHERE email = 'ivan@example.com'),
        (SELECT id FROM rooms WHERE name = 'Beta'),
        TIMESTAMP '2026-06-05 10:00:00',
        TIMESTAMP '2026-06-05 12:00:00'),
       ((SELECT id FROM users WHERE email = 'alex@example.com'),
        (SELECT id FROM rooms WHERE name = 'Beta'),
        TIMESTAMP '2026-06-10 13:00:00',
        TIMESTAMP '2026-06-10 14:00:00'),
       ((SELECT id FROM users WHERE email = 'albert@example.com'),
        (SELECT id FROM rooms WHERE name = 'Beta'),
        TIMESTAMP '2026-06-25 09:00:00',
        TIMESTAMP '2026-06-25 10:00:00'),

       ((SELECT id FROM users WHERE email = 'ivan@example.com'),
        (SELECT id FROM rooms WHERE name = 'Ocean'),
        TIMESTAMP '2026-06-15 15:00:00',
        TIMESTAMP '2026-06-15 16:00:00'),
       ((SELECT id FROM users WHERE email = 'alex@example.com'),
        (SELECT id FROM rooms WHERE name = 'Ocean'),
        TIMESTAMP '2026-06-20 10:00:00',
        TIMESTAMP '2026-06-20 11:00:00'),
       ((SELECT id FROM users WHERE email = 'albert@example.com'),
        (SELECT id FROM rooms WHERE name = 'Ocean'),
        TIMESTAMP '2026-06-30 16:00:00',
        TIMESTAMP '2026-06-30 17:00:00');