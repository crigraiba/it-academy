-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: m05t1_n2youtube
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
-- Table structure for table `canal`
--

DROP TABLE IF EXISTS `canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canal` (
  `canal_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcio` varchar(120) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `datahora_creacio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuari_id` int NOT NULL COMMENT 'Usuari al qual pertany.',
  PRIMARY KEY (`canal_id`),
  KEY `fk_canal_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_canal_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canal`
--

LOCK TABLES `canal` WRITE;
/*!40000 ALTER TABLE `canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentari`
--

DROP TABLE IF EXISTS `comentari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentari` (
  `comentari_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `contingut` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `datahora_publicacio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `video_id` int NOT NULL COMMENT 'Vídeo on ha estat escrit.',
  PRIMARY KEY (`comentari_id`),
  KEY `fk_comentari_video1_idx` (`video_id`),
  CONSTRAINT `fk_comentari_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentari`
--

LOCK TABLES `comentari` WRITE;
/*!40000 ALTER TABLE `comentari` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta`
--

DROP TABLE IF EXISTS `etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etiqueta` (
  `etiqueta_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`etiqueta_id`),
  UNIQUE KEY `nom_UNIQUE` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta`
--

LOCK TABLES `etiqueta` WRITE;
/*!40000 ALTER TABLE `etiqueta` DISABLE KEYS */;
/*!40000 ALTER TABLE `etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `estat` enum('PÚBLICA','PRIVADA') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: PÚBLICA o PRIVADA.',
  `datahora_creacio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
-- Table structure for table `playlist_conte_video`
--

DROP TABLE IF EXISTS `playlist_conte_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_conte_video` (
  `playlist_id` int NOT NULL,
  `video_id` int NOT NULL,
  PRIMARY KEY (`playlist_id`,`video_id`),
  KEY `fk_playlist_has_video_video1_idx` (`video_id`),
  KEY `fk_playlist_has_video_playlist1_idx` (`playlist_id`),
  CONSTRAINT `fk_playlist_has_video_playlist1` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_playlist_has_video_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_conte_video`
--

LOCK TABLES `playlist_conte_video` WRITE;
/*!40000 ALTER TABLE `playlist_conte_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `playlist_conte_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari`
--

DROP TABLE IF EXISTS `usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuari` (
  `usuari_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom_usuari` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `contrasenya` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `correu_electronic` varchar(320) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `data_naixement` date NOT NULL,
  `sexe` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `codi_postal` mediumint NOT NULL,
  `pais` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`usuari_id`),
  UNIQUE KEY `correu_electronic_UNIQUE` (`correu_electronic`),
  UNIQUE KEY `nom_usuari_UNIQUE` (`nom_usuari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari`
--

LOCK TABLES `usuari` WRITE;
/*!40000 ALTER TABLE `usuari` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari_reacciona_comentari`
--

DROP TABLE IF EXISTS `usuari_reacciona_comentari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuari_reacciona_comentari` (
  `usuari_id` int NOT NULL,
  `comentari_id` int NOT NULL,
  `tipus` enum('LIKE','DISLIKE') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: LIKE o DISLIKE.',
  PRIMARY KEY (`usuari_id`,`comentari_id`),
  KEY `fk_usuari_has_comentari_comentari1_idx` (`comentari_id`),
  KEY `fk_usuari_has_comentari_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_usuari_has_comentari_comentari1` FOREIGN KEY (`comentari_id`) REFERENCES `comentari` (`comentari_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_comentari_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari_reacciona_comentari`
--

LOCK TABLES `usuari_reacciona_comentari` WRITE;
/*!40000 ALTER TABLE `usuari_reacciona_comentari` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuari_reacciona_comentari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari_reacciona_video`
--

DROP TABLE IF EXISTS `usuari_reacciona_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuari_reacciona_video` (
  `usuari_id` int NOT NULL,
  `video_id` int NOT NULL,
  `tipus` enum('LIKE','DISLIKE') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: LIKE o DISLIKE.',
  PRIMARY KEY (`usuari_id`,`video_id`),
  KEY `fk_usuari_has_video_video1_idx` (`video_id`),
  KEY `fk_usuari_has_video_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_usuari_has_video_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_video_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari_reacciona_video`
--

LOCK TABLES `usuari_reacciona_video` WRITE;
/*!40000 ALTER TABLE `usuari_reacciona_video` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuari_reacciona_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari_subscriu_canal`
--

DROP TABLE IF EXISTS `usuari_subscriu_canal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuari_subscriu_canal` (
  `usuari_id` int NOT NULL,
  `canal_id` int NOT NULL,
  PRIMARY KEY (`usuari_id`,`canal_id`),
  KEY `fk_usuari_has_canal_canal1_idx` (`canal_id`),
  KEY `fk_usuari_has_canal_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_usuari_has_canal_canal1` FOREIGN KEY (`canal_id`) REFERENCES `canal` (`canal_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_canal_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari_subscriu_canal`
--

LOCK TABLES `usuari_subscriu_canal` WRITE;
/*!40000 ALTER TABLE `usuari_subscriu_canal` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuari_subscriu_canal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `video_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `titol` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcio` varchar(200) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `datahora_publicacio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nom_arxiu` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `durada_arxiu` time NOT NULL,
  `grandaria_arxiu` decimal(10,0) NOT NULL,
  `thumbnail` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `quantitat_reproduccions` int NOT NULL,
  `quantitat_likes` int NOT NULL,
  `quantitat_dislikes` int NOT NULL,
  `estat` enum('PÚBLIC','OCULT','PRIVAT') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: PÚBLIC, OCULT o PRIVAT.',
  `usuari_id` int NOT NULL COMMENT 'Usuari que l''ha publicat.',
  PRIMARY KEY (`video_id`),
  KEY `fk_video_usuari1_idx` (`usuari_id`),
  CONSTRAINT `fk_video_usuari1` FOREIGN KEY (`usuari_id`) REFERENCES `usuari` (`usuari_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_te_etiqueta`
--

DROP TABLE IF EXISTS `video_te_etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_te_etiqueta` (
  `video_id` int NOT NULL,
  `etiqueta_id` int NOT NULL,
  PRIMARY KEY (`video_id`,`etiqueta_id`),
  KEY `fk_video_has_etiqueta_etiqueta1_idx` (`etiqueta_id`),
  KEY `fk_video_has_etiqueta_video1_idx` (`video_id`),
  CONSTRAINT `fk_video_has_etiqueta_etiqueta1` FOREIGN KEY (`etiqueta_id`) REFERENCES `etiqueta` (`etiqueta_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_video_has_etiqueta_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_te_etiqueta`
--

LOCK TABLES `video_te_etiqueta` WRITE;
/*!40000 ALTER TABLE `video_te_etiqueta` DISABLE KEYS */;
/*!40000 ALTER TABLE `video_te_etiqueta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 16:10:40
