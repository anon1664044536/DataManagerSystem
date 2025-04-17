-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: collage
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CosNO` varchar(20) NOT NULL,
  `CosName` varchar(20) NOT NULL,
  `TchNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CosNO`),
  KEY `TchNo` (`TchNo`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`TchNo`) REFERENCES `teacher` (`TchNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('C001','数据库原理','T001'),('C002','高等数学','T002'),('C003','大学物理','T003'),('C004','有机化学','T004'),('C005','数据结构','T005'),('C006','电路分析','T006'),('C007','概率统计','T007'),('C008','量子力学','T008');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu_course`
--

DROP TABLE IF EXISTS `stu_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu_course` (
  `CosNo` varchar(20) NOT NULL,
  `StuNo` varchar(20) NOT NULL,
  `Grade` double DEFAULT NULL,
  PRIMARY KEY (`CosNo`,`StuNo`),
  KEY `StuNo` (`StuNo`),
  CONSTRAINT `stu_course_ibfk_1` FOREIGN KEY (`CosNo`) REFERENCES `course` (`CosNO`),
  CONSTRAINT `stu_course_ibfk_2` FOREIGN KEY (`StuNo`) REFERENCES `student` (`StuNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu_course`
--

LOCK TABLES `stu_course` WRITE;
/*!40000 ALTER TABLE `stu_course` DISABLE KEYS */;
INSERT INTO `stu_course` VALUES ('C001','S001',85.5),('C001','S004',92),('C001','S007',88),('C001','S010',76.5),('C001','S016',81),('C002','S002',78),('C002','S005',89.5),('C002','S008',88.5),('C002','S011',91),('C002','S014',65),('C002','S017',83.5),('C002','S020',72),('C003','S003',76),('C003','S009',82.5),('C003','S015',68),('C003','S020',74.5),('C004','S005',89.5),('C004','S011',77),('C004','S017',85),('C004','S019',92.5),('C005','S001',91),('C005','S004',87.5),('C005','S007',79),('C005','S010',84.5),('C005','S013',76),('C005','S016',89),('C006','S003',85.5),('C006','S006',82),('C006','S009',77),('C006','S012',73.5),('C006','S018',68),('C007','S002',88),('C007','S008',94.5),('C007','S013',79),('C007','S014',71),('C007','S020',83.5),('C008','S003',75),('C008','S009',81.5),('C008','S015',87),('C008','S018',72.5);
/*!40000 ALTER TABLE `stu_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `StuNo` varchar(20) NOT NULL,
  `StuName` varchar(20) NOT NULL,
  `StuSex` varchar(5) DEFAULT NULL,
  `StuAge` int DEFAULT NULL,
  `StuDept` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`StuNo`),
  CONSTRAINT `student_chk_1` CHECK ((`StuSex` in (_utf8mb4'男',_utf8mb4'女'))),
  CONSTRAINT `student_chk_2` CHECK (((`StuAge` >= 0) and (`StuAge` <= 150)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S001','张伟','男',20,'计算机系'),('S002','王芳','女',19,'数学系'),('S003','李娜','女',21,'物理系'),('S004','刘洋','男',22,'计算机系'),('S005','陈静','女',20,'化学系'),('S006','杨光','男',19,'电子系'),('S007','赵敏','女',21,'计算机系'),('S008','周杰','男',20,'数学系'),('S009','吴晓','女',19,'物理系'),('S010','黄磊','男',22,'计算机系'),('S011','徐丽','女',20,'化学系'),('S012','孙浩','男',21,'电子系'),('S013','马英','女',19,'计算机系'),('S014','朱强','男',20,'数学系'),('S015','胡雪','女',21,'物理系'),('S016','林涛','男',22,'计算机系'),('S017','梁冰','女',20,'化学系'),('S018','郑凯','男',19,'电子系'),('S019','谢芳','女',21,'计算机系'),('S020','韩梅','女',20,'数学系');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `OnInsertStu` BEFORE INSERT ON `student` FOR EACH ROW begin
    insert into user_psw(username, password, role) values
    (StuNo, StuNo, 'stu');
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `OnDeleteStu` AFTER DELETE ON `student` FOR EACH ROW begin
    delete from user_psw
    where UserName = old.StuNo;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `TchNO` varchar(20) NOT NULL,
  `TchName` varchar(20) NOT NULL,
  `TchSex` varchar(5) DEFAULT NULL,
  `TchOffice` varchar(20) DEFAULT NULL,
  `TchAge` int DEFAULT NULL,
  `TchSalary` int DEFAULT NULL,
  PRIMARY KEY (`TchNO`),
  CONSTRAINT `teacher_chk_1` CHECK ((`TchSex` in (_utf8mb4'男',_utf8mb4'女'))),
  CONSTRAINT `teacher_chk_2` CHECK (((`TchAge` >= 0) and (`TchAge` <= 150))),
  CONSTRAINT `teacher_chk_3` CHECK ((`TchSalary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('T001','王建国','男','计算机楼101',45,15000),('T002','李淑华','女','数学楼205',50,18000),('T003','张卫国','男','物理楼310',38,12000),('T004','刘芳','女','化学楼112',42,16000),('T005','陈志强','男','计算机楼203',55,20000),('T006','杨雪','女','电子楼305',40,14000),('T007','周文斌','男','数学楼208',48,17000),('T008','赵丽','女','物理楼215',36,13000);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `OnInsertTch` BEFORE INSERT ON `teacher` FOR EACH ROW begin
    if new.TchSalary < 8000 then
        set new.TchSalary = 8000;
    end if;
    
    insert into user_psw(username, password, role) values
        (TchNO, TchNO, 'tch');
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `OnDeleteTch` AFTER DELETE ON `teacher` FOR EACH ROW begin
    delete from user_psw
    where UserName = old.TchNO;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user_psw`
--

DROP TABLE IF EXISTS `user_psw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_psw` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `user_psw_chk_1` CHECK ((`Role` in (_utf8mb4'stu',_utf8mb4'tch',_utf8mb4'admin')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_psw`
--

LOCK TABLES `user_psw` WRITE;
/*!40000 ALTER TABLE `user_psw` DISABLE KEYS */;
INSERT INTO `user_psw` VALUES ('admin1','admin1','admin'),('admin2','admin2','admin'),('S001','S001','stu'),('S002','S002','stu'),('S003','S003','stu'),('S004','S004','stu'),('S005','S005','stu'),('S006','S006','stu'),('S007','S007','stu'),('S008','S008','stu'),('S009','S009','stu'),('S010','S010','stu'),('S011','S011','stu'),('S012','S012','stu'),('S013','S013','stu'),('S014','S014','stu'),('S015','S015','stu'),('S016','S016','stu'),('S017','S017','stu'),('S018','S018','stu'),('S019','S019','stu'),('S020','S020','stu'),('T001','T001','stu'),('T002','T002','stu'),('T003','T003','stu'),('T004','T004','stu'),('T005','T005','stu'),('T006','T006','stu'),('T007','T007','stu'),('T008','T008','stu');
/*!40000 ALTER TABLE `user_psw` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-17 18:40:31
