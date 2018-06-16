-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: 学生学籍管理
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
-- Temporary view structure for view `学生信息_视图`
--

DROP TABLE IF EXISTS `学生信息_视图`;
/*!50001 DROP VIEW IF EXISTS `学生信息_视图`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `学生信息_视图` AS SELECT 
 1 AS `学号`,
 1 AS `姓名`,
 1 AS `性别`,
 1 AS `班级`,
 1 AS `系别`,
 1 AS `出生年月`,
 1 AS `入学时间`,
 1 AS `籍贯`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `学生信息表`
--

DROP TABLE IF EXISTS `学生信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `学生信息表` (
  `学号` char(12) NOT NULL,
  `姓名` char(20) DEFAULT NULL,
  `性别` char(2) DEFAULT NULL,
  `班级` char(20) DEFAULT NULL,
  `系别` char(20) DEFAULT NULL,
  `出生年月` date DEFAULT NULL,
  `入学时间` date DEFAULT NULL,
  `籍贯` char(5) DEFAULT NULL,
  PRIMARY KEY (`学号`),
  UNIQUE KEY `PK__学生信息表__300424B4` (`学号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `学生信息表`
--

LOCK TABLES `学生信息表` WRITE;
/*!40000 ALTER TABLE `学生信息表` DISABLE KEYS */;
INSERT INTO `学生信息表` VALUES ('01','程杨','男','0711','金融','1988-12-17','2007-09-01','陕西'),('02','乔丁宁','女','0702','会计','1988-10-24','2007-09-01','陕西'),('03','王佩琴','女','0706','计本','1988-05-23','2007-09-01','陕西'),('08','乔丁宁','女','0702','数字媒体与技术','1988-10-24',NULL,'陕j');
/*!40000 ALTER TABLE `学生信息表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `学生成绩表`
--

DROP TABLE IF EXISTS `学生成绩表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `学生成绩表` (
  `课程号` char(8) NOT NULL,
  `学号` char(12) DEFAULT NULL,
  `课程名` char(20) DEFAULT NULL,
  `成绩` char(4) DEFAULT NULL,
  PRIMARY KEY (`课程号`),
  UNIQUE KEY `课程名` (`课程名`),
  KEY `学号` (`学号`),
  CONSTRAINT `学生成绩表_ibfk_1` FOREIGN KEY (`学号`) REFERENCES `学生信息表` (`学号`),
  CONSTRAINT `学生成绩表_ibfk_2` FOREIGN KEY (`课程号`) REFERENCES `课程信息表` (`课程号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `学生成绩表`
--

LOCK TABLES `学生成绩表` WRITE;
/*!40000 ALTER TABLE `学生成绩表` DISABLE KEYS */;
INSERT INTO `学生成绩表` VALUES ('001','01','西方经济学','91'),('008','03','运筹学','89'),('010','03','数据结构','99'),('012','02','高等数学','80');
/*!40000 ALTER TABLE `学生成绩表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `用户表`
--

DROP TABLE IF EXISTS `用户表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `用户表` (
  `用户名` varchar(20) NOT NULL,
  `用户类型` char(20) NOT NULL,
  `密码` varchar(45) NOT NULL,
  PRIMARY KEY (`用户名`,`用户类型`,`密码`),
  UNIQUE KEY `用户名_UNIQUE` (`用户名`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `用户表`
--

LOCK TABLES `用户表` WRITE;
/*!40000 ALTER TABLE `用户表` DISABLE KEYS */;
INSERT INTO `用户表` VALUES ('admin','老师','256'),('std','学生','123'),('teacher','老师','123');
/*!40000 ALTER TABLE `用户表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `用户表_视图`
--

DROP TABLE IF EXISTS `用户表_视图`;
/*!50001 DROP VIEW IF EXISTS `用户表_视图`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `用户表_视图` AS SELECT 
 1 AS `用户名`,
 1 AS `用户类型`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `课程信息_视图`
--

DROP TABLE IF EXISTS `课程信息_视图`;
/*!50001 DROP VIEW IF EXISTS `课程信息_视图`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `课程信息_视图` AS SELECT 
 1 AS `课程号`,
 1 AS `课程名`,
 1 AS `授课老师`,
 1 AS `课时`,
 1 AS `学分`,
 1 AS `课程类型`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `课程信息表`
--

DROP TABLE IF EXISTS `课程信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `课程信息表` (
  `课程号` char(8) NOT NULL,
  `课程名` char(20) DEFAULT NULL,
  `授课老师` char(10) DEFAULT NULL,
  `课时` smallint(6) DEFAULT NULL,
  `学分` smallint(6) DEFAULT NULL,
  `课程类型` char(20) DEFAULT NULL,
  PRIMARY KEY (`课程号`),
  UNIQUE KEY `学生课程index` (`课程号`),
  UNIQUE KEY `课程名` (`课程名`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `课程信息表`
--

LOCK TABLES `课程信息表` WRITE;
/*!40000 ALTER TABLE `课程信息表` DISABLE KEYS */;
INSERT INTO `课程信息表` VALUES ('001','西方经济学','王瑞',54,3,'必修'),('002','西方经济学2','王瑞',54,3,'必修'),('008','运筹学','李俊辑',54,2,'必修'),('010','数据结构','刘通',54,4,'必修'),('012','高等数学','王义',74,3,'必修');
/*!40000 ALTER TABLE `课程信息表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database '学生学籍管理'
--

--
-- Dumping routines for database '学生学籍管理'
--

--
-- Final view structure for view `学生信息_视图`
--

/*!50001 DROP VIEW IF EXISTS `学生信息_视图`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `学生信息_视图` AS select `学生信息表`.`学号` AS `学号`,`学生信息表`.`姓名` AS `姓名`,`学生信息表`.`性别` AS `性别`,`学生信息表`.`班级` AS `班级`,`学生信息表`.`系别` AS `系别`,`学生信息表`.`出生年月` AS `出生年月`,`学生信息表`.`入学时间` AS `入学时间`,`学生信息表`.`籍贯` AS `籍贯` from `学生信息表` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `用户表_视图`
--

/*!50001 DROP VIEW IF EXISTS `用户表_视图`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `用户表_视图` AS select `用户表`.`用户名` AS `用户名`,`用户表`.`用户类型` AS `用户类型` from `用户表` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `课程信息_视图`
--

/*!50001 DROP VIEW IF EXISTS `课程信息_视图`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `课程信息_视图` AS select `课程信息表`.`课程号` AS `课程号`,`课程信息表`.`课程名` AS `课程名`,`课程信息表`.`授课老师` AS `授课老师`,`课程信息表`.`课时` AS `课时`,`课程信息表`.`学分` AS `学分`,`课程信息表`.`课程类型` AS `课程类型` from `课程信息表` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-28  9:27:14
