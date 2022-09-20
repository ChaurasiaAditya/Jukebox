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

-- Add the songs details in Database
-- Alone- Alan walker
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('1', 'Alone', 'Alan Walker', '02:43', 'EDM', 'src/main/resources/songs/Alone.wav');

-- Fade- Alan walker
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('3', 'Fade', 'Alan Walker', '04:43', 'EDM', 'src/main/resources/songs/Fade.wav');

-- Cartoon - Daniel Levi
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('3', 'Cartoon', 'Daniel Levi', '03:27', 'POP', 'src/main/resources/songs/Cartoon.wav');

-- Heaven - Ehide
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('4', 'Heaven', 'Ehide ', '04:27', 'POP', 'src/main/resources/songs/Heaven.wav');

-- Light - Sybolism
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('5', 'Light', 'Sybolism', '04:51', 'EDM', 'src/main/resources/songs/Light.wav');

-- Electronomia - Sky High
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('6', 'Electronomia', 'Sky High', '03:58', 'POP', 'src/main/resources/songs/Elektronomia.wav');

-- Janji - Johnning
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('7', 'Janji', 'Johnning', '03:28', 'EDM', 'src/main/resources/songs/Janji.wav');

-- Kiss Heaven - Asher Fulero
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('8', 'Kiss Heaven', 'Asher Fulero', '01:56', 'Classical', 'src/main/resources/songs/Kiss Heavens.wav');

-- Lost Sky - Chris Linton
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('9', 'Lost Sky', 'Chris Linton', '03:14', 'EDM', 'src/main/resources/songs/Lost Sky.wav');

-- Snowfall - Asher Fulero
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('10', 'Snowfall', 'Asher Fulero', '02:37', 'Classical', 'src/main/resources/songs/Snowfall.wav');

-- Superhero - Chris Linton
INSERT INTO `jukebox`.`songs` (`song_number`, `song_name`, `artist`, `duration`, `genre`, `song_url`) VALUES ('11', 'Superhero', 'Chris Linton', '03:01', 'EDM', 'src/main/resources/songs/Superhero.wav');