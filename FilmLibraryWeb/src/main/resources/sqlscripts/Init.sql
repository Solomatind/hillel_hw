CREATE DATABASE  IF NOT EXISTS `films_library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `films_library`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: films_library
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `idactors` int NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(45) NOT NULL,
  `actor_birthday` date NOT NULL,
  PRIMARY KEY (`idactors`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` VALUES (1,'Leonardo Dicaprio','1974-11-11'),(2,'Tom Hardy','1977-09-15'),(3,'Joseph Gordon-Levitt','1981-02-17'),(4,'Brad Pitt','1963-12-18'),(5,'Margot Robbie','1990-07-02'),(6,'Josh Brolin','1968-02-12'),(7,'Robert Downey Jr','1965-04-04'),(8,'Mark Ruffalo','1967-11-22'),(9,'Jon Favreau','1966-10-19'),(10,'Gwyneth Paltrow','1972-09-27'),(11,'Quentin Tarantino','1963-03-27'),(12,'Tim Roth','1961-05-14'),(13,'Harvey Keitel','1939-05-13'),(14,'Steven Buscemi','1957-12-13'),(15,'Ben Affleck','1972-08-15'),(16,'Bryan Cranston','1956-03-07'),(17,'John Goodman','1952-06-20'),(18,'John David Washington','1984-07-28'),(19,'Robert Pattinson','1986-05-13'),(20,'Michael Caine','1933-03-14');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `iddirectors` int NOT NULL AUTO_INCREMENT,
  `director_name` varchar(45) NOT NULL,
  `director_birthday` date NOT NULL,
  PRIMARY KEY (`iddirectors`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES (1,'Christopher Nolan','1970-06-30'),(2,'Quentin Tarantino','1963-03-27'),(3,'Joe Russo','1971-07-18'),(4,'Jon Favreau','1966-10-19'),(5,'Ben Affleck','1972-08-15');
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `films` (
  `idfilms` int NOT NULL AUTO_INCREMENT,
  `film_name` varchar(45) NOT NULL,
  `director_id` int NOT NULL,
  `release_date` year NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`idfilms`),
  UNIQUE KEY `idfilms_UNIQUE` (`idfilms`) /*!80000 INVISIBLE */,
  KEY `director_id_idx` (`director_id`),
  CONSTRAINT `director_id` FOREIGN KEY (`director_id`) REFERENCES `directors` (`iddirectors`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films`
--

LOCK TABLES `films` WRITE;
/*!40000 ALTER TABLE `films` DISABLE KEYS */;
INSERT INTO `films` VALUES (1,'Inception',1,2010,'USA/UK'),(2,'Once Upon A Time In Hollywood',2,2019,'USA/UK'),(3,'Avengers: Endgame',3,2019,'USA'),(4,'Reservoir Dogs',2,1992,'USA'),(5,'Iron Man',4,2008,'USA'),(6,'Argo',5,2012,'USA'),(7,'Tenet',1,2020,'USA/UK');
/*!40000 ALTER TABLE `films` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `films_actors`
--

DROP TABLE IF EXISTS `films_actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `films_actors` (
  `idfilms_actors` int NOT NULL AUTO_INCREMENT,
  `idfilms` int NOT NULL,
  `idactors` int NOT NULL,
  PRIMARY KEY (`idfilms_actors`),
  UNIQUE KEY `idfilms_actors_UNIQUE` (`idfilms_actors`),
  KEY `film_id_idx` (`idfilms`),
  KEY `actor_id_idx` (`idactors`),
  CONSTRAINT `actor_id` FOREIGN KEY (`idactors`) REFERENCES `actors` (`idactors`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `film_id` FOREIGN KEY (`idfilms`) REFERENCES `films` (`idfilms`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `films_actors`
--

LOCK TABLES `films_actors` WRITE;
/*!40000 ALTER TABLE `films_actors` DISABLE KEYS */;
INSERT INTO `films_actors` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,20),(5,2,1),(6,2,4),(7,2,5),(8,3,6),(9,3,7),(10,3,8),(11,3,9),(12,3,10),(13,4,11),(14,4,12),(15,4,13),(16,4,14),(17,5,7),(18,5,9),(19,5,10),(20,6,15),(21,6,16),(22,6,17),(23,7,18),(24,7,19),(25,7,20);
/*!40000 ALTER TABLE `films_actors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','root'),(2,'den','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-15 13:28:18
