-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: ecom
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activation`
--

DROP TABLE IF EXISTS `activation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activation` (
  `ACode` varchar(150) NOT NULL,
  `APeriod` int(11) NOT NULL,
  `AUID` varchar(20) DEFAULT NULL,
  `AStartDate` varchar(11) DEFAULT NULL,
  `AEndDate` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ACode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activation`
--

LOCK TABLES `activation` WRITE;
/*!40000 ALTER TABLE `activation` DISABLE KEYS */;
/*!40000 ALTER TABLE `activation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactinfo`
--

DROP TABLE IF EXISTS `contactinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contactinfo` (
  `CID` int(11) NOT NULL,
  `CName` varchar(45) DEFAULT NULL,
  `CAddress` varchar(80) DEFAULT NULL,
  `CEmail` varchar(80) DEFAULT NULL,
  `CMobPhone` int(11) DEFAULT NULL,
  `CLPhone` int(11) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactinfo`
--

LOCK TABLES `contactinfo` WRITE;
/*!40000 ALTER TABLE `contactinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `feedback` (
  `FID` int(5) unsigned zerofill NOT NULL,
  `FCusName` varchar(100) DEFAULT NULL,
  `FCusEmail` varchar(100) DEFAULT NULL,
  `FCusPhone` int(11) DEFAULT NULL,
  `FTitle` varchar(45) DEFAULT NULL,
  `FDescription` varchar(300) DEFAULT NULL,
  `FDate` varchar(11) DEFAULT NULL,
  `FViewStatus` binary(1) DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `material` (
  `MID` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `MName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (001,'Plastic -100%'),(002,'Plastic - Wood (60/40)');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `OID` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `OPID` int(5) DEFAULT NULL,
  `OCName` varchar(100) DEFAULT NULL,
  `OCNIC` varchar(20) DEFAULT NULL,
  `OCPhone` varchar(11) DEFAULT NULL,
  `OType` varchar(20) DEFAULT NULL,
  `ODescription` varchar(500) DEFAULT NULL,
  `OPrice` float DEFAULT NULL,
  `OAdAmount` float DEFAULT NULL,
  `OQuantity` int(11) DEFAULT NULL,
  `OStatus` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `PID` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `PName` varchar(50) DEFAULT NULL,
  `PDescription` varchar(300) DEFAULT NULL,
  `PDimention` varchar(20) DEFAULT NULL,
  `PWeight` varchar(20) DEFAULT NULL,
  `PColor` varchar(100) DEFAULT NULL,
  `PMaterial` varchar(100) DEFAULT NULL,
  `PAvailability` varchar(10) DEFAULT NULL,
  `PCustomize` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (00001,'Phone back Cover','Phone back Cover Description','100mm x 8mm x 50mm','20g','Black','Plastic - 100%',NULL,'Yes'),(00002,'Phone back Cover','Phone Back cover Description','110mm x 8mm x 50mm','25g','Black','Plastic - 100%','Available','No'),(00003,'Phone back Cover','Phone Back Cover Description','110mm x 8mm x 50mm','25g','Black','Plastic - 100%','Available','No');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rating` (
  `RID` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `RPID` int(5) unsigned zerofill DEFAULT NULL,
  `RCusName` varchar(100) DEFAULT NULL,
  `RNIC` varchar(20) DEFAULT NULL,
  `RTitle` varchar(45) DEFAULT NULL,
  `RDescription` varchar(200) DEFAULT NULL,
  `RRate` int(11) DEFAULT NULL,
  `RDate` varchar(11) DEFAULT NULL,
  `RStatus` binary(1) DEFAULT NULL,
  `RViewStatus` binary(1) DEFAULT NULL,
  PRIMARY KEY (`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackinfo`
--

DROP TABLE IF EXISTS `trackinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trackinfo` (
  `TID` int(7) unsigned zerofill NOT NULL DEFAULT '0000000',
  `TCode` varchar(80) DEFAULT NULL,
  `TOID` int(5) DEFAULT NULL,
  `TADPaySlip` blob,
  `TAdPayBank` varchar(45) DEFAULT NULL,
  `TAdPaySlipNo` varchar(40) DEFAULT NULL,
  `TAdPayAmount` float DEFAULT NULL,
  `TAdPayDate` varchar(11) DEFAULT NULL,
  `TAdPayStatus` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackinfo`
--

LOCK TABLES `trackinfo` WRITE;
/*!40000 ALTER TABLE `trackinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `trackinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `UID` varchar(20) NOT NULL,
  `UPassword` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `UID_UNIQUE` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ecom'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-12 17:59:03
