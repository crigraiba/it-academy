-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: m05t1_n1pizzeria
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
-- Table structure for table `botiga`
--

DROP TABLE IF EXISTS `botiga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `botiga` (
  `botiga_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `adreça` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `codi_postal` mediumint NOT NULL,
  `localitat_id` int NOT NULL COMMENT 'Localitat on es troba localitzada.',
  PRIMARY KEY (`botiga_id`),
  KEY `fk_botiga_localitat1_idx` (`localitat_id`),
  CONSTRAINT `fk_botiga_localitat1` FOREIGN KEY (`localitat_id`) REFERENCES `localitat` (`localitat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `botiga`
--

LOCK TABLES `botiga` WRITE;
/*!40000 ALTER TABLE `botiga` DISABLE KEYS */;
/*!40000 ALTER TABLE `botiga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cognoms` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefon` int NOT NULL,
  `adreça` varchar(100) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `codi_postal` mediumint DEFAULT NULL,
  `localitat_id` int DEFAULT NULL COMMENT 'Localitat on viu. ',
  PRIMARY KEY (`client_id`),
  KEY `fk_client_localitat1_idx` (`localitat_id`),
  CONSTRAINT `fk_client_localitat1` FOREIGN KEY (`localitat_id`) REFERENCES `localitat` (`localitat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comanda` (
  `comanda_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `client_id` int NOT NULL COMMENT 'Client que l''ha realitzat.',
  `datahora` datetime NOT NULL,
  `quantitat_pizzes` tinyint NOT NULL DEFAULT '0',
  `quantitat_hamburgueses` tinyint NOT NULL DEFAULT '0',
  `quantitat_begudes` tinyint NOT NULL DEFAULT '0',
  `preu_total` decimal(10,0) NOT NULL,
  `tipus` enum('A DOMICILI','PER RECOLLIR') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: A DOMICILI o PER RECOLLIR.',
  `botiga_id` int NOT NULL COMMENT 'Botiga que l''ha gestionat.',
  `empleat_id` int DEFAULT NULL COMMENT 'Repartidor.',
  `datahora_lliurament` datetime DEFAULT NULL,
  PRIMARY KEY (`comanda_id`),
  KEY `fk_comanda_empleat1_idx` (`empleat_id`),
  KEY `fk_comanda_botiga1_idx` (`botiga_id`),
  KEY `fk_comanda_client1_idx` (`client_id`),
  CONSTRAINT `fk_comanda_botiga1` FOREIGN KEY (`botiga_id`) REFERENCES `botiga` (`botiga_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comanda_client1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comanda_empleat1` FOREIGN KEY (`empleat_id`) REFERENCES `empleat` (`empleat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda_conte_producte`
--

DROP TABLE IF EXISTS `comanda_conte_producte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comanda_conte_producte` (
  `comanda_id` int NOT NULL,
  `producte_id` int NOT NULL,
  `quantitat` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`comanda_id`,`producte_id`),
  KEY `fk_comanda_has_producte_producte1_idx` (`producte_id`),
  KEY `fk_comanda_has_producte_comanda1_idx` (`comanda_id`),
  CONSTRAINT `fk_comanda_has_producte_comanda1` FOREIGN KEY (`comanda_id`) REFERENCES `comanda` (`comanda_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comanda_has_producte_producte1` FOREIGN KEY (`producte_id`) REFERENCES `producte` (`producte_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda_conte_producte`
--

LOCK TABLES `comanda_conte_producte` WRITE;
/*!40000 ALTER TABLE `comanda_conte_producte` DISABLE KEYS */;
/*!40000 ALTER TABLE `comanda_conte_producte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleat`
--

DROP TABLE IF EXISTS `empleat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleat` (
  `empleat_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cognoms` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nif` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefon` int NOT NULL COMMENT 'Número de telèfon.',
  `tipus` enum('CUINER','REPARTIDOR') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: CUINER o REPARTIDOR.',
  `botiga_id` int NOT NULL COMMENT 'Botiga on treballa.',
  PRIMARY KEY (`empleat_id`),
  KEY `fk_empleat_botiga1_idx` (`botiga_id`),
  CONSTRAINT `fk_empleat_botiga1` FOREIGN KEY (`botiga_id`) REFERENCES `botiga` (`botiga_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleat`
--

LOCK TABLES `empleat` WRITE;
/*!40000 ALTER TABLE `empleat` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localitat`
--

DROP TABLE IF EXISTS `localitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localitat` (
  `localitat_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Nom.',
  `provincia_id` int NOT NULL COMMENT 'Província a la qual pertany.',
  PRIMARY KEY (`localitat_id`),
  KEY `fk_localitat_provincia_idx` (`provincia_id`),
  CONSTRAINT `fk_localitat_provincia` FOREIGN KEY (`provincia_id`) REFERENCES `provincia` (`provincia_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localitat`
--

LOCK TABLES `localitat` WRITE;
/*!40000 ALTER TABLE `localitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `localitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producte`
--

DROP TABLE IF EXISTS `producte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producte` (
  `producte_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcio` varchar(150) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `imatge` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `preu` decimal(10,0) NOT NULL,
  `tipus` enum('PIZZA','HAMBURGUESA','BEGUDA') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: PIZZA, HAMBURGUESA o BEGUDA.',
  `subtipus_id` int DEFAULT NULL COMMENT 'Categoria de pizza.',
  PRIMARY KEY (`producte_id`),
  KEY `fk_producte_categoria_pizza1_idx` (`subtipus_id`),
  CONSTRAINT `fk_producte_categoria_pizza1` FOREIGN KEY (`subtipus_id`) REFERENCES `subtipus` (`subtipus_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producte`
--

LOCK TABLES `producte` WRITE;
/*!40000 ALTER TABLE `producte` DISABLE KEYS */;
/*!40000 ALTER TABLE `producte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `provincia_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`provincia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtipus`
--

DROP TABLE IF EXISTS `subtipus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtipus` (
  `subtipus_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`subtipus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtipus`
--

LOCK TABLES `subtipus` WRITE;
/*!40000 ALTER TABLE `subtipus` DISABLE KEYS */;
/*!40000 ALTER TABLE `subtipus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 16:10:24
