CREATE TABLE users
(
    id IDENTITY PRIMARY KEY,
    username            VARCHAR(50) NOT NULL,
    password        VARCHAR(68) NOT NULL,
    enabled BOOLEAN NOT NULL
);