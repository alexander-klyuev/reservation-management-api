SELECT r.id,
       u.email,
       u.full_name,
       rooms.name AS room_name,
       r.start_time,
       r.end_time
FROM reservations r
         JOIN users u ON r.user_id = u.id
         JOIN rooms ON r.room_id = rooms.id
WHERE u.email = 'ivan@example.com'
ORDER BY r.start_time;

SELECT id,
       name,
       capacity
FROM rooms
WHERE capacity >= 5
ORDER BY capacity;

SELECT rooms.name  AS room_name,
       COUNT(r.id) AS reservations_count
FROM rooms
         LEFT JOIN reservations r ON r.room_id = rooms.id
GROUP BY rooms.id, rooms.name
ORDER BY rooms.name;

SELECT u.id,
       u.email,
       u.full_name
FROM users u
         LEFT JOIN reservations r ON r.user_id = u.id
WHERE r.id IS NULL;

SELECT r.id,
       u.email,
       rooms.name AS room_name,
       r.start_time,
       r.end_time
FROM reservations r
         JOIN users u on r.user_id = u.id
         JOIN rooms ON r.room_id = rooms.id
WHERE r.start_time < TIMESTAMP '2026-07-01 00:00:00'
  AND r.end_time > TIMESTAMP '2026-06-01 00:00:00'
ORDER BY r.start_time;