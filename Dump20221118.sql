-- MySQL dump 10.13  Distrib 5.7.40, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.40-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info` (
  `Pro_Id` int(11) NOT NULL,
  `Pro_Name` varchar(255) DEFAULT NULL,
  `Pro_Description` varchar(500) DEFAULT NULL,
  `Pro_Price` int(11) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`Pro_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (101,'APPLE iPhone 12 (Black, 128 GB)','128 GB ROM , 15.49 cm (6.1 inch) Super Retina XDR Display, 12MP + 12MP | 12MP Front Camera',56000,20),(102,'The Case-Book of Sherlock Holmes','Language: English, Publisher: Fingerprint! Publishing, Edition: 2018, Pages: 320',115,45),(103,'Solid Men Round Neck Multicolor T-Shirt','Type:Round Neck, Sleeve:Short Sleeve, Fit:Regular, Fabric:Cotton Blend',500,10),(104,'Mens Stylish Sports Running Shoes','Color:Navy, Outer material:Synthetic, Textile, Model name:Adistound M',750,38),(105,'OnePlus Bullets Wireless Z2 Bluetooth Headset','Model Name:Bullets Wireless Z2, Color:Beam Blue, Headphone Type:In the Ear',2000,560),(106,'Talking Tom Cat Toy for Kids Speaking Repeats What You Say','Material: Plastic, Battery Operated, 3 Battteries, Non-rechargeable Batteries',380,130),(107,'512 Regular Men Blue Jeans','Brand: LEVIS, Ideal For: Men, Suitable For:Western Wear',1500,60),(108,'FOSSIL - Jacqline Analog Watch - For Women','Water Resistant:Yes, Display Type:Analog, Occasion:Casual',6900,18),(109,'Mi 5A 80 cm (32 inch) HD Ready LED Smart Android TV with Dolby Audio','Resolution: HD Ready 1366 x 768 Pixels, Sound Output: 20 W, Refresh Rate: 60 Hz',13000,12),(110,'Medium 21 L Backpack Stark  (Blue)','Type:Backpack, Ideal For:Men & Women, Laptop Sleeve:No, Color Code:Blue',650,92);
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserName` varchar(255) NOT NULL,
  `Passward` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('jyoti','jyoti@123'),('nitin','nitin@123'),('ram','ram123'),('shivani','mane'),('shrikant','shrikant@123'),('shyam','ghanshyam'),('vishwajit','ingale');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_history`
--

DROP TABLE IF EXISTS `user_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_history` (
  `UserName` varchar(255) DEFAULT NULL,
  `Products` varchar(255) DEFAULT NULL,
  `TotalPrice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_history`
--

LOCK TABLES `user_history` WRITE;
/*!40000 ALTER TABLE `user_history` DISABLE KEYS */;
INSERT INTO `user_history` VALUES ('shivani','Mens Stylish Sports Running Shoes','750'),('shivani','Mi 5A 80 cm (32 inch) HD Ready LED Smart Android TV with Dolby Audio','13000'),('vishwajit','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('vishwajit','512 Regular Men Blue Jeans','1500'),('vishwajit','Solid Men Round Neck Multicolor T-Shirt','500'),('jyoti','APPLE iPhone 12 (Black, 128 GB)','56000'),('jyoti','FOSSIL - Jacqline Analog Watch - For Women','6900'),('jyoti','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('shyam','FOSSIL - Jacqline Analog Watch - For Women','6900'),('shyam','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('shyam','Medium 21 L Backpack Stark  (Blue)','650'),('nitin','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('nitin','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('nitin','The Case-Book of Sherlock Holmes','115'),('nitin','The Case-Book of Sherlock Holmes','115'),('shrikant','Solid Men Round Neck Multicolor T-Shirt','500'),('shrikant','FOSSIL - Jacqline Analog Watch - For Women','6900'),('shrikant','OnePlus Bullets Wireless Z2 Bluetooth Headset','2000'),('shrikant','Mens Stylish Sports Running Shoes','750'),('shrikant','The Case-Book of Sherlock Holmes','115'),('ram','Mens Stylish Sports Running Shoes','750'),('ram','Medium 21 L Backpack Stark  (Blue)','650');
/*!40000 ALTER TABLE `user_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-18 10:28:24
