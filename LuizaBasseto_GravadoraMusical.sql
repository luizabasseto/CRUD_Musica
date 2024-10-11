CREATE DATABASE  IF NOT EXISTS `gravadora_luizabasseto` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gravadora_luizabasseto`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gravadora_luizabasseto
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cantores`
--

DROP TABLE IF EXISTS `cantores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cantores` (
  `id_cantores` int NOT NULL,
  `nome_cantores` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cantores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cantores`
--

LOCK TABLES `cantores` WRITE;
/*!40000 ALTER TABLE `cantores` DISABLE KEYS */;
INSERT INTO `cantores` VALUES (1,'Arctic Monkeys'),(2,'Gun\'s Roses'),(3,'Shawn Mendes'),(4,'Camila Cabello'),(5,'Zayn'),(6,'Taylor Swift'),(7,'Rihanna'),(8,'Beyonce'),(9,'Lauren Jauregui'),(10,'Normani'),(11,'Dinah Jane'),(12,'Harry Styles'),(13,'Louis Tomlinson'),(14,'The Neighbourhood'),(15,'The 1975'),(16,'Paramore'),(17,'One Direction'),(18,'Demi Lovato'),(19,'Justin Bieber'),(20,'Jão'),(21,'Chance the Rapper'),(22,'Henrique e Juliano'),(23,'Luan Santana'),(24,'Marília Mendonça'),(25,'Halsey'),(26,'Troye Sivan'),(27,'Kamaitachi'),(28,'Red Hot Chili Peppers'),(29,'Oasis'),(30,'Pink Floyd'),(31,'Queen'),(32,'AC/DC'),(33,'Green Day'),(34,'Johnny Cash'),(35,'Fifth Harmony'),(36,'Katy Perry'),(37,'The Chainsmokers'),(38,'Dua Lipa'),(39,'Martin Garrix'),(40,'Lana Del Rey'),(41,'Ed Sheeran'),(42,'Adele'),(43,'Coldplay'),(44,'Nando reis'),(45,'Legião Urbana'),(46,'Cássia Eller'),(47,'Maria Gadu'),(48,'Cazuza'),(49,'Natiruts'),(50,'Cidade negra'),(51,'Lagum'),(52,'ANAVITÓRIA'),(53,'Alceu Valença'),(54,'Raimundos'),(55,'Ira!'),(56,'Engenheiros do Hawaii'),(57,'Bob Dylan'),(58,'Khalid'),(59,'Seu Jorge'),(60,'Anitta'),(61,'Matheus e Kauan'),(62,'Jorge e Mateus'),(64,'Shakira'),(240,'The Beatles');
/*!40000 ALTER TABLE `cantores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id_genero` int NOT NULL,
  `nome_genero` varchar(45) NOT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Rock'),(2,'Reggae'),(3,'Pop'),(4,'Rap'),(5,'Sertanejo'),(6,'Indie'),(7,'MPB'),(8,'Samba'),(9,'Pagode'),(10,'Jazz'),(11,'Blues'),(12,'Eletrônica'),(13,'AAAAAAAAAAA');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrumentos`
--

DROP TABLE IF EXISTS `instrumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrumentos` (
  `id_instrumentos` int NOT NULL,
  `nome_instrumentos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_instrumentos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrumentos`
--

LOCK TABLES `instrumentos` WRITE;
/*!40000 ALTER TABLE `instrumentos` DISABLE KEYS */;
INSERT INTO `instrumentos` VALUES (1,'Baixo'),(2,'Violão'),(3,'Guitarra'),(4,'Flauta'),(5,'Gaita'),(6,'Bateria'),(7,'Saxofone'),(8,'Sanfona'),(9,'Acordeão'),(10,'Clarinete'),(11,'Triângulo'),(14,'Piano'),(48,'Guitarra');
/*!40000 ALTER TABLE `instrumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica` (
  `id_musica` int NOT NULL,
  `nome_musica` varchar(45) NOT NULL,
  `paises_id_paises` int NOT NULL,
  PRIMARY KEY (`id_musica`),
  KEY `fk_musica_paises1_idx` (`paises_id_paises`),
  CONSTRAINT `fk_musica_paises1` FOREIGN KEY (`paises_id_paises`) REFERENCES `paises` (`id_paises`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
INSERT INTO `musica` VALUES (1,'There\'s Nothing Holding Me Back',11),(2,'Night Changes',3),(3,'Youth',2),(4,'Youth',2),(5,'Mercy',11),(6,'IDGAF',3),(7,'Drag Me Down',2),(8,'My My My!',3),(9,'Chocolate',3),(10,'Happier',3),(11,'Boyfriend',11),(12,'Beauty And A Beat',2),(13,'As Long As You Love',11),(14,'I Don\'t Care',7),(15,'Perfect',3),(16,'I Don\'t Wanna Live Forever',3),(17,'Live While We\'re Young',3),(18,'Why\'d You Only Call Me When You Are High? ',3),(19,'R.I.P. 2 My Youth',2),(20,'Sweater Weather',2),(21,'Lanaaa',1),(22,'Julieta',1),(23,'As It Wasfff',3),(24,'Burguesinha',1),(25,'Amiga da Minha Mulher',1),(26,'Summertime Sadness',2),(27,'Diet Mountain Dew',2),(28,'Confident',11),(29,'On Guard',2),(30,'Scattered',2),(31,'Expectations',2),(32,'Recovery',11),(33,'Don\'t Wanna Say',2),(34,'No Lie',3),(35,'Easy',12),(36,'Taxi',12),(37,'Write On Me',2),(38,'Colors',2),(39,'Shameless',12),(40,'Bam Bam',3),(41,'Cool for the Summer',2),(42,'Golden',3),(43,'Adore You',3),(44,'Idiota',1),(45,'The Beach',2),(46,'Best Song Ever',3),(47,'Girls',3),(48,'Hard Times',2),(49,'Exagerado',1),(50,'Fica',1),(51,'Por Andei',1),(52,'New Rules',3),(53,'Ao Vivo e A Cores',1),(54,'Stay',2),(55,'Umbrella',2),(56,'Do I Wanna Know?',3),(57,'Rolling in the Deep',3),(58,'Don\'t Start Now',3),(59,'Halo',2),(60,'Nessas Horas',1),(61,'Paredes',1),(62,'I Kissed a Girl',2),(63,'Love Story',12),(64,'Yellow',3),(90,'Red (Taylor\'s Version)',2);
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_has_cantores`
--

DROP TABLE IF EXISTS `musica_has_cantores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_has_cantores` (
  `musica_id_musica` int NOT NULL,
  `cantores_id_cantores` int NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`musica_id_musica`,`cantores_id_cantores`),
  KEY `fk_musica_has_cantores_cantores1_idx` (`cantores_id_cantores`),
  KEY `fk_musica_has_cantores_musica1_idx` (`musica_id_musica`),
  CONSTRAINT `fk_musica_has_cantores_cantores1` FOREIGN KEY (`cantores_id_cantores`) REFERENCES `cantores` (`id_cantores`),
  CONSTRAINT `fk_musica_has_cantores_musica1` FOREIGN KEY (`musica_id_musica`) REFERENCES `musica` (`id_musica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_has_cantores`
--

LOCK TABLES `musica_has_cantores` WRITE;
/*!40000 ALTER TABLE `musica_has_cantores` DISABLE KEYS */;
INSERT INTO `musica_has_cantores` VALUES (1,3,NULL),(2,17,NULL),(3,3,NULL),(3,58,NULL),(4,26,NULL),(5,3,NULL),(6,38,NULL),(7,17,NULL),(8,26,NULL),(9,15,NULL),(10,41,NULL),(11,19,NULL),(12,19,NULL),(13,19,NULL),(14,19,NULL),(14,41,NULL),(15,41,NULL),(16,5,NULL),(16,6,NULL),(17,17,NULL),(18,17,NULL),(19,14,NULL),(20,14,NULL),(21,27,NULL),(22,27,NULL),(23,12,NULL),(24,59,NULL),(25,59,NULL),(26,40,NULL),(27,40,NULL),(28,19,NULL),(28,21,NULL),(29,9,NULL),(30,9,NULL),(31,9,NULL),(32,19,NULL),(33,9,NULL),(34,38,NULL),(35,4,NULL),(36,4,NULL),(37,35,NULL),(38,25,NULL),(39,4,NULL),(40,4,NULL),(40,41,NULL),(41,18,NULL),(42,12,NULL),(43,12,NULL),(44,20,NULL),(45,14,NULL),(46,17,NULL),(47,15,NULL),(48,16,NULL),(49,48,NULL),(50,52,NULL),(50,61,NULL),(51,44,NULL),(52,38,NULL),(53,61,NULL),(53,62,NULL),(54,7,NULL),(55,7,NULL),(56,1,NULL),(57,42,NULL),(58,38,NULL),(59,8,NULL),(60,61,NULL),(61,62,NULL),(62,36,NULL),(63,3,NULL),(63,6,NULL),(64,43,NULL);
/*!40000 ALTER TABLE `musica_has_cantores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_has_genero`
--

DROP TABLE IF EXISTS `musica_has_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_has_genero` (
  `musica_id_musica` int NOT NULL,
  `genero_id_genero` int NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`musica_id_musica`,`genero_id_genero`),
  KEY `fk_musica_has_genero_genero1_idx` (`genero_id_genero`),
  KEY `fk_musica_has_genero_musica1_idx` (`musica_id_musica`),
  CONSTRAINT `fk_musica_has_genero_genero1` FOREIGN KEY (`genero_id_genero`) REFERENCES `genero` (`id_genero`),
  CONSTRAINT `fk_musica_has_genero_musica1` FOREIGN KEY (`musica_id_musica`) REFERENCES `musica` (`id_musica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_has_genero`
--

LOCK TABLES `musica_has_genero` WRITE;
/*!40000 ALTER TABLE `musica_has_genero` DISABLE KEYS */;
INSERT INTO `musica_has_genero` VALUES (1,3,NULL),(2,3,NULL),(3,3,NULL),(4,3,NULL),(5,3,NULL),(6,3,NULL),(7,3,NULL),(8,3,NULL),(9,6,NULL),(10,3,NULL),(11,3,NULL),(12,3,NULL),(13,3,NULL),(14,3,NULL),(15,3,NULL),(16,3,NULL);
/*!40000 ALTER TABLE `musica_has_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_has_instrumentos`
--

DROP TABLE IF EXISTS `musica_has_instrumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_has_instrumentos` (
  `musica_id_musica` int NOT NULL,
  `instrumentos_id_instrumentos` int NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`musica_id_musica`,`instrumentos_id_instrumentos`),
  KEY `fk_musica_has_instrumentos_musica1_idx` (`musica_id_musica`),
  KEY `fk_musica_has_instrumentos_instrumentos1_idx` (`instrumentos_id_instrumentos`),
  CONSTRAINT `fk_musica_has_instrumentos_instrumentos1` FOREIGN KEY (`instrumentos_id_instrumentos`) REFERENCES `instrumentos` (`id_instrumentos`),
  CONSTRAINT `fk_musica_has_instrumentos_musica1` FOREIGN KEY (`musica_id_musica`) REFERENCES `musica` (`id_musica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_has_instrumentos`
--

LOCK TABLES `musica_has_instrumentos` WRITE;
/*!40000 ALTER TABLE `musica_has_instrumentos` DISABLE KEYS */;
INSERT INTO `musica_has_instrumentos` VALUES (1,3,NULL),(1,5,NULL),(1,11,NULL),(2,5,NULL),(2,9,NULL),(3,4,NULL),(3,8,NULL),(7,8,NULL),(7,9,NULL);
/*!40000 ALTER TABLE `musica_has_instrumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_has_plataformas`
--

DROP TABLE IF EXISTS `musica_has_plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_has_plataformas` (
  `musica_id_musica` int NOT NULL,
  `plataformas_id_plataformas` int NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`musica_id_musica`,`plataformas_id_plataformas`),
  KEY `fk_musica_has_plataformas_plataformas1_idx` (`plataformas_id_plataformas`),
  KEY `fk_musica_has_plataformas_musica1_idx` (`musica_id_musica`),
  CONSTRAINT `fk_musica_has_plataformas_musica1` FOREIGN KEY (`musica_id_musica`) REFERENCES `musica` (`id_musica`),
  CONSTRAINT `fk_musica_has_plataformas_plataformas1` FOREIGN KEY (`plataformas_id_plataformas`) REFERENCES `plataformas` (`id_plataformas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_has_plataformas`
--

LOCK TABLES `musica_has_plataformas` WRITE;
/*!40000 ALTER TABLE `musica_has_plataformas` DISABLE KEYS */;
INSERT INTO `musica_has_plataformas` VALUES (1,1,NULL),(1,2,NULL),(1,3,NULL),(1,5,NULL),(2,1,NULL),(2,2,NULL),(2,4,NULL),(3,1,NULL),(4,5,NULL),(5,3,NULL),(5,4,NULL),(6,1,NULL),(6,2,NULL),(6,4,NULL);
/*!40000 ALTER TABLE `musica_has_plataformas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_has_tom_musica`
--

DROP TABLE IF EXISTS `musica_has_tom_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_has_tom_musica` (
  `musica_id_musica` int NOT NULL,
  `tom_musica_id_tom_musica` int NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`musica_id_musica`,`tom_musica_id_tom_musica`),
  KEY `fk_musica_has_tom_musica_tom_musica1_idx` (`tom_musica_id_tom_musica`),
  KEY `fk_musica_has_tom_musica_musica1_idx` (`musica_id_musica`),
  CONSTRAINT `fk_musica_has_tom_musica_musica1` FOREIGN KEY (`musica_id_musica`) REFERENCES `musica` (`id_musica`),
  CONSTRAINT `fk_musica_has_tom_musica_tom_musica1` FOREIGN KEY (`tom_musica_id_tom_musica`) REFERENCES `tom_musica` (`id_tom_musica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_has_tom_musica`
--

LOCK TABLES `musica_has_tom_musica` WRITE;
/*!40000 ALTER TABLE `musica_has_tom_musica` DISABLE KEYS */;
INSERT INTO `musica_has_tom_musica` VALUES (1,1,NULL),(1,2,NULL),(2,2,NULL),(2,12,NULL),(3,2,NULL),(3,11,NULL),(4,3,NULL),(5,6,NULL),(6,9,NULL),(7,6,NULL);
/*!40000 ALTER TABLE `musica_has_tom_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `id_paises` int NOT NULL,
  `nome_paises` varchar(45) NOT NULL,
  PRIMARY KEY (`id_paises`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Brasil'),(2,'EUA'),(3,'Inglaterra'),(4,'Alemanha'),(5,'Itália'),(6,'Espanha'),(7,'Argentina'),(8,'Chile'),(9,'Japão'),(10,'China'),(11,'Canadá'),(12,'Cuba'),(15,'Paraguai');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformas`
--

DROP TABLE IF EXISTS `plataformas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataformas` (
  `id_plataformas` int NOT NULL,
  `nome_plataformas` varchar(45) NOT NULL,
  PRIMARY KEY (`id_plataformas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformas`
--

LOCK TABLES `plataformas` WRITE;
/*!40000 ALTER TABLE `plataformas` DISABLE KEYS */;
INSERT INTO `plataformas` VALUES (1,'Spotify'),(2,'Apple Music'),(3,'Deezer'),(4,'Tidal'),(5,'Youtube'),(6,'Teste'),(7,'bbbbbbbbbb');
/*!40000 ALTER TABLE `plataformas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tom_musica`
--

DROP TABLE IF EXISTS `tom_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tom_musica` (
  `id_tom_musica` int NOT NULL,
  `nome_tom` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tom_musica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tom_musica`
--

LOCK TABLES `tom_musica` WRITE;
/*!40000 ALTER TABLE `tom_musica` DISABLE KEYS */;
INSERT INTO `tom_musica` VALUES (1,'A'),(2,'A#'),(3,'B'),(4,'C'),(5,'C#'),(6,'D'),(7,'D#'),(8,'E'),(9,'F'),(10,'F#'),(11,'G'),(12,'G#');
/*!40000 ALTER TABLE `tom_musica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-19 16:35:50
