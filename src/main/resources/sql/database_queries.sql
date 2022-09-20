-- Create a database
    CREATE DATABASE IF NOT EXISTS `jukebox`;

-- Use database
    USE `jukebox`;

-- create a table in the database
-- add song_number, song_name, artist, genre, duration, song_url
    CREATE TABLE IF NOT EXISTS `songs`
    (
	`song_number` int not null primary key,
    `song_name` varchar(50) not null,
    `artist` varchar(50) not null,
    `genre` varchar(50) not null,
    `duration` varchar(50) not null,
    `song_url` varchar(150) not null,
    );