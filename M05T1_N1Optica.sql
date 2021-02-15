-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: m05t1_n1optica
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
-- Table structure for table `adreça`
--

DROP TABLE IF EXISTS `adreça`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adreça` (
  `adreça_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `carrer` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `numero` smallint NOT NULL,
  `pis` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `porta` tinyint DEFAULT NULL,
  `ciutat` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `codi_postal` mediumint NOT NULL,
  `pais` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`adreça_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adreça`
--

LOCK TABLES `adreça` WRITE;
/*!40000 ALTER TABLE `adreça` DISABLE KEYS */;
/*!40000 ALTER TABLE `adreça` ENABLE KEYS */;
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
  `telefon` int NOT NULL,
  `correu_electronic` varchar(320) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `adreça_id` int NOT NULL COMMENT 'Adreça on viu.',
  `datahora_registre` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`client_id`),
  KEY `fk_client_address_idx` (`adreça_id`),
  CONSTRAINT `fk_client_address` FOREIGN KEY (`adreça_id`) REFERENCES `adreça` (`adreça_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `client_compra_ullera`
--

DROP TABLE IF EXISTS `client_compra_ullera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_compra_ullera` (
  `client_id` int NOT NULL,
  `ullera_id` int NOT NULL,
  `empleat_id` int NOT NULL,
  `quantitat` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`client_id`,`ullera_id`,`empleat_id`),
  KEY `fk_client_has_glasses_glasses1_idx` (`ullera_id`),
  KEY `fk_client_has_glasses_client1_idx` (`client_id`),
  KEY `fk_client_buys_glasses_seller1_idx` (`empleat_id`),
  CONSTRAINT `fk_client_buys_glasses_seller1` FOREIGN KEY (`empleat_id`) REFERENCES `empleat` (`empleat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_client_has_glasses_client1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_client_has_glasses_glasses1` FOREIGN KEY (`ullera_id`) REFERENCES `ullera` (`ullera_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_compra_ullera`
--

LOCK TABLES `client_compra_ullera` WRITE;
/*!40000 ALTER TABLE `client_compra_ullera` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_compra_ullera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_recomanador`
--

DROP TABLE IF EXISTS `client_recomanador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_recomanador` (
  `client_id` int NOT NULL COMMENT 'Client recomanat. Pot haver estat recomanat per més d''un client.',
  `client_id1` int NOT NULL COMMENT 'Client recomanador.',
  PRIMARY KEY (`client_id`,`client_id1`),
  KEY `fk_client_has_client_client2_idx` (`client_id1`),
  KEY `fk_client_has_client_client1_idx` (`client_id`),
  CONSTRAINT `fk_client_has_client_client1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_client_has_client_client2` FOREIGN KEY (`client_id1`) REFERENCES `client` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_recomanador`
--

LOCK TABLES `client_recomanador` WRITE;
/*!40000 ALTER TABLE `client_recomanador` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_recomanador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleat`
--

DROP TABLE IF EXISTS `empleat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleat` (
  `empleat_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Nom.',
  PRIMARY KEY (`empleat_id`)
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
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `marca_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `proveidor_id` int NOT NULL COMMENT 'Proveïdor al qual s''ha comprat.',
  PRIMARY KEY (`marca_id`),
  KEY `fk_brand_supplier1_idx` (`proveidor_id`),
  CONSTRAINT `fk_brand_supplier1` FOREIGN KEY (`proveidor_id`) REFERENCES `proveidor` (`proveidor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveidor`
--

DROP TABLE IF EXISTS `proveidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveidor` (
  `proveidor_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `nom` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nif` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefon` int NOT NULL,
  `fax` int DEFAULT NULL,
  `adreça_id` int NOT NULL COMMENT 'Adreça on es troba localitzat.',
  PRIMARY KEY (`proveidor_id`),
  UNIQUE KEY `nif_UNIQUE` (`nif`),
  KEY `fk_supplier_address1_idx` (`adreça_id`),
  CONSTRAINT `fk_supplier_address1` FOREIGN KEY (`adreça_id`) REFERENCES `adreça` (`adreça_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveidor`
--

LOCK TABLES `proveidor` WRITE;
/*!40000 ALTER TABLE `proveidor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ullera`
--

DROP TABLE IF EXISTS `ullera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ullera` (
  `ullera_id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador únic.',
  `muntura_tipus` enum('FLOTANT','DE PASTA','METÀL·LICA') COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Pot ser: FLOTANT, DE PASTA o METÀL·LICA.',
  `muntura_color` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Color de la muntura.',
  `vidre_graduacio1` decimal(10,0) NOT NULL COMMENT 'Graduació del vidre esquerre.',
  `vidre_graduacio2` decimal(10,0) NOT NULL COMMENT 'Graduació del vidre dret.',
  `vidre_color1` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Color del vidre esquerre.',
  `vidre_color2` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Color del vidre dret.',
  `preu` decimal(10,0) NOT NULL COMMENT 'Preu.',
  `marca_id` int NOT NULL COMMENT 'Marca a la qual pertany.',
  PRIMARY KEY (`ullera_id`),
  KEY `fk_glasses_brand1_idx` (`marca_id`),
  CONSTRAINT `fk_glasses_brand1` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`marca_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ullera`
--

LOCK TABLES `ullera` WRITE;
/*!40000 ALTER TABLE `ullera` DISABLE KEYS */;
/*!40000 ALTER TABLE `ullera` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-15 16:10:11
