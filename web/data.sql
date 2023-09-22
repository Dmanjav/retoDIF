-- MySQL dump 10.16  Distrib 10.1.48-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	10.1.48-MariaDB-0+deb9u2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dbo.Admins`
--

DROP TABLE IF EXISTS `dbo.Admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Admins` (
  `usuario` varchar(0) DEFAULT NULL,
  `contrasena` varchar(0) DEFAULT NULL, 
  `salt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Admins`
--

LOCK TABLES `dbo.Admins` WRITE;
/*!40000 ALTER TABLE `dbo.Admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Anuncios`
--

DROP TABLE IF EXISTS `dbo.Anuncios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Anuncios` (
  `IdAnuncio` varchar(0) DEFAULT NULL,
  `IdComedor` varchar(0) DEFAULT NULL,
  `contenido` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Anuncios`
--

LOCK TABLES `dbo.Anuncios` WRITE;
/*!40000 ALTER TABLE `dbo.Anuncios` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Anuncios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Cliente`
--

DROP TABLE IF EXISTS `dbo.Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Cliente` (
  `curp` varchar(0) DEFAULT NULL,
  `nombre` varchar(0) DEFAULT NULL,
  `apellidoP` varchar(0) DEFAULT NULL,
  `apellidoM` varchar(0) DEFAULT NULL,
  `sexo` varchar(0) DEFAULT NULL,
  `fechaNacimiento` varchar(0) DEFAULT NULL,
  `condicion` varchar(0) DEFAULT NULL,
  `contrasena` varchar(0) DEFAULT NULL,
  `salt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Cliente`
--

LOCK TABLES `dbo.Cliente` WRITE;
/*!40000 ALTER TABLE `dbo.Cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Comedor`
--

DROP TABLE IF EXISTS `dbo.Comedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Comedor` (
  `IdComedor` varchar(0) DEFAULT NULL,
  `nombre` varchar(0) DEFAULT NULL,
  `calle` varchar(0) DEFAULT NULL,
  `numero` varchar(0) DEFAULT NULL,
  `colonia` varchar(0) DEFAULT NULL,
  `contrasena` varchar(0) DEFAULT NULL,
  `salt` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Comedor`
--

LOCK TABLES `dbo.Comedor` WRITE;
/*!40000 ALTER TABLE `dbo.Comedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Comedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Comida`
--

DROP TABLE IF EXISTS `dbo.Comida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Comida` (
  `IdComida` varchar(0) DEFAULT NULL,
  `entrada` varchar(0) DEFAULT NULL,
  `plato` varchar(0) DEFAULT NULL,
  `postre` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Comida`
--

LOCK TABLES `dbo.Comida` WRITE;
/*!40000 ALTER TABLE `dbo.Comida` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Comida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Dependencia`
--

DROP TABLE IF EXISTS `dbo.Dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Dependencia` (
  `IdResponsable` varchar(0) DEFAULT NULL,
  `IdDependiente` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Dependencia`
--

LOCK TABLES `dbo.Dependencia` WRITE;
/*!40000 ALTER TABLE `dbo.Dependencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Dependencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbo.Pedido`
--

DROP TABLE IF EXISTS `dbo.Pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbo.Pedido` (
  `IdPedido` varchar(0) DEFAULT NULL,
  `fecha` varchar(0) DEFAULT NULL,
  `donacion` varchar(0) DEFAULT NULL,
  `responsable` varchar(0) DEFAULT NULL,
  `dependiente` varchar(0) DEFAULT NULL,
  `IdComedor` varchar(0) DEFAULT NULL,
  `IdComida` varchar(0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbo.Pedido`
--

LOCK TABLES `dbo.Pedido` WRITE;
/*!40000 ALTER TABLE `dbo.Pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `dbo.Pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-18 10:46:27
