-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: m05t1_n3spotify
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `album_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `titol` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `any_publicacio` date NOT NULL,
  `portada` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `artista_id` int NOT NULL COMMENT 'Artista que l''ha publicat.',
  PRIMARY KEY (`album_id`),
  KEY `fk_album_artista1_idx` (`artista_id`),
  CONSTRAINT `fk_album_artista1` FOREIGN KEY (`artista_id`) REFERENCES `artista` (`artista_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista` (
  `artista_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `imatge` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`artista_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista_relacionat`
--

DROP TABLE IF EXISTS `artista_relacionat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artista_relacionat` (
  `artista_id` int NOT NULL,
  `artista_id1` int NOT NULL,
  PRIMARY KEY (`artista_id`,`artista_id1`),
  KEY `fk_artista_has_artista_artista2_idx` (`artista_id1`),
  KEY `fk_artista_has_artista_artista1_idx` (`artista_id`),
  CONSTRAINT `fk_artista_has_artista_artista1` FOREIGN KEY (`artista_id`) REFERENCES `artista` (`artista_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_artista_has_artista_artista2` FOREIGN KEY (`artista_id1`) REFERENCES `artista` (`artista_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista_relacionat`
--

LOCK TABLES `artista_relacionat` WRITE;
/*!40000 ALTER TABLE `artista_relacionat` DISABLE KEYS */;
/*!40000 ALTER TABLE `artista_relacionat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canço`
--

DROP TABLE IF EXISTS `canço`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canço` (
  `canço_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `titol` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `durada` time NOT NULL,
  `quantitat_reproduccions` int NOT NULL,
  `album_id` int NOT NULL COMMENT 'Àlbum al qual pertany.',
  PRIMARY KEY (`canço_id`),
  KEY `fk_canço_album1_idx` (`album_id`),
  CONSTRAINT `fk_canço_album1` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canço`
--

LOCK TABLES `canço` WRITE;
/*!40000 ALTER TABLE `canço` DISABLE KEYS */;
/*!40000 ALTER TABLE `canço` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorit`
--

DROP TABLE IF EXISTS `favorit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorit` (
  `usuari_id` int NOT NULL,
  `canço_id` int NOT NULL,
  `album_id` int NOT NULL,
  PRIMARY KEY (`usuari_id`,`canço_id`,`album_id`),
  KEY `fk_usuari_has_canço_canço1_idx` (`canço_id`),
  KEY `fk_usuari_has_canço_usuari1_idx` (`usuari_id`),
  KEY `fk_usuari_has_canço_album1_idx` (`album_id`),
  CONSTRAINT `fk_usuari_has_canço_album1` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_canço_canço1` FOREIGN KEY (`canço_id`) REFERENCES `canço` (`canço_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_canço_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorit`
--

LOCK TABLES `favorit` WRITE;
/*!40000 ALTER TABLE `favorit` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metode_pagament`
--

DROP TABLE IF EXISTS `metode_pagament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metode_pagament` (
  `metode_pagament_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `tipus` enum('TARGETA DE CRÈDIT','PAYPAL') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: TARGETA DE CRÈDIT o PAYPAL.',
  `numero_targeta` int DEFAULT NULL COMMENT 'Número de la targeta de crèdit.',
  `caducitat_targeta` date DEFAULT NULL COMMENT 'Mes i any de caducitat de la targeta de crèdit.',
  `codi_seguretat_targeta` smallint DEFAULT NULL COMMENT 'Codi de seguretat de la targeta de crèdit.',
  `nom_usuari_paypal` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL COMMENT 'Nom d''usuari de PayPal.',
  PRIMARY KEY (`metode_pagament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metode_pagament`
--

LOCK TABLES `metode_pagament` WRITE;
/*!40000 ALTER TABLE `metode_pagament` DISABLE KEYS */;
/*!40000 ALTER TABLE `metode_pagament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagament`
--

DROP TABLE IF EXISTS `pagament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagament` (
  `pagament_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `data` date NOT NULL,
  `quantitat` decimal(10,0) NOT NULL,
  `subscripcio_id` int NOT NULL COMMENT 'Subscripció a la qual pertany.',
  PRIMARY KEY (`pagament_id`),
  KEY `fk_pagament_subscripcio1_idx` (`subscripcio_id`),
  CONSTRAINT `fk_pagament_subscripcio1` FOREIGN KEY (`subscripcio_id`) REFERENCES `subscripcio` (`subscripcio_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagament`
--

LOCK TABLES `pagament` WRITE;
/*!40000 ALTER TABLE `pagament` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `titol` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `quantitat_cançons` int NOT NULL,
  `data_creacio` datetime NOT NULL,
  `estat` enum('ACTIVA','ELIMINADA') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: ACTIVA o ELIMINADA.',
  `data_eliminacio` datetime DEFAULT NULL,
  `usuari_id` int NOT NULL COMMENT 'Usuari que l''ha creat.',
  PRIMARY KEY (`playlist_id`),
  KEY `fk_playlist_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_playlist_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_conte_canço`
--

DROP TABLE IF EXISTS `playlist_conte_canço`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_conte_canço` (
  `playlist_id` int NOT NULL,
  `canço_id` int NOT NULL,
  `usuari_id` int DEFAULT NULL COMMENT 'Usuari que l''ha afegit.',
  PRIMARY KEY (`playlist_id`,`canço_id`),
  KEY `fk_playlist_has_canço_canço1_idx` (`canço_id`),
  KEY `fk_playlist_has_canço_playlist1_idx` (`playlist_id`),
  KEY `fk_playlist_conte_canço_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_playlist_conte_canço_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_playlist_has_canço_canço1` FOREIGN KEY (`canço_id`) REFERENCES `canço` (`canço_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_playlist_has_canço_playlist1` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_conte_canço`
--

LOCK TABLES `playlist_conte_canço` WRITE;
/*!40000 ALTER TABLE `playlist_conte_canço` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_conte_canço` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscripcio`
--

DROP TABLE IF EXISTS `subscripcio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscripcio` (
  `subscripcio_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `data_inici` date NOT NULL,
  `data_renovacio` date NOT NULL,
  `usuari_id` int NOT NULL COMMENT 'Usuari que l''ha realitzat.',
  `metode_pagament_id` int NOT NULL COMMENT 'Mètode de pagament que s''ha utilitzat.',
  PRIMARY KEY (`subscripcio_id`),
  KEY `fk_subscripcio_usuari_idx` (`usuari_id`),
  KEY `fk_subscripcio_metode_pagament1_idx` (`metode_pagament_id`),
  CONSTRAINT `fk_subscripcio_metode_pagament1` FOREIGN KEY (`metode_pagament_id`) REFERENCES `metode_pagament` (`metode_pagament_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_subscripcio_usuari` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscripcio`
--

LOCK TABLES `subscripcio` WRITE;
/*!40000 ALTER TABLE `subscripcio` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscripcio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari`
--

DROP TABLE IF EXISTS `usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuari` (
  `usuari_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `tipus` enum('FREE','PREMIUM') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: FREE o PREMIUM.',
  `nom_usuari` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `contrasenya` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `correu_electronic` varchar(320) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `data_naixement` date NOT NULL,
  `sexe` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `codi_postal` mediumint NOT NULL,
  `pais` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`usuari_id`),
  UNIQUE KEY `nom_usuari_UNIQUE` (`nom_usuari`),
  UNIQUE KEY `correu_electronic_UNIQUE` (`correu_electronic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari`
--

LOCK TABLES `usuari` WRITE;
/*!40000 ALTER TABLE `usuari` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuari` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 16:10:54
