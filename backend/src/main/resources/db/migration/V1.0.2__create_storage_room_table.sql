CREATE TABLE storage_room
(
    id IDENTITY PRIMARY KEY,
    name            VARCHAR(50) NOT NULL,
    location        VARCHAR(20) NOT NULL,
    create_date DATE
);