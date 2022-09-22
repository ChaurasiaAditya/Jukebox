-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `songs_list` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES (1,'My Favourite','1,2,3');
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `songs` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `artist` varchar(50) NOT NULL,
  `duration` varchar(10) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `url` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'Alone Alan','Alan Walker','02:43','EDM','src/main/resources/songs/Alone.wav'),(2,'Faded Alan','Alan Walker','04:43','EDM','src/main/resources/songs/Fade.wav'),(3,'Cartoon ','Daniel Levi','03:27','POP','src/main/resources/songs/Cartoon.wav'),(4,'Heaven Fly','Ehide Levi ','04:27','POP','src/main/resources/songs/Heaven.wav'),(5,'Lighting','Diana King ','04:51','EDM','src/main/resources/songs/Light.wav'),(6,'Electro ','Erick Mori','03:58','POP','src/main/resources/songs/Elektronomia.wav'),(7,'Janji    ','Johnning P ','03:28','EDM','src/main/resources/songs/Janji.wav'),(8,'Heaven Map','Asher Furo ','01:55','JAZ','src/main/resources/songs/Kiss Heavens.wav'),(9,'Lost Sky','Chris Lint','03:14','EDM','src/main/resources/songs/Lost Sky.wav'),(10,'Snowfall','Asher Furo ','02:36','JAZ','src/main/resources/songs/Snowfall.wav'),(11,'Superhero','Chris Furo','03:01','EDM','src/main/resources/songs/Superhero.wav');
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-23  0:27:27
