-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.33-community-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bd_quierescomprar_ws
--

CREATE DATABASE IF NOT EXISTS bd_quierescomprar_ws;
USE bd_quierescomprar_ws;

--
-- Definition of table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
CREATE TABLE `oferta` (
  `codOfe` int(11) NOT NULL AUTO_INCREMENT,
  `fecIniOfe` date DEFAULT NULL,
  `fecFinOfe` date DEFAULT NULL,
  `porOfe` double DEFAULT NULL,
  `codPro` int(11) NOT NULL,
  `flgAct` varchar(1) NOT NULL,
  PRIMARY KEY (`codOfe`),
  KEY `fk_Oferta_Producto` (`codPro`),
  CONSTRAINT `fk_Oferta_Producto` FOREIGN KEY (`codPro`) REFERENCES `producto` (`codPro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `oferta`
--

/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` (`codOfe`,`fecIniOfe`,`fecFinOfe`,`porOfe`,`codPro`,`flgAct`) VALUES 
 (1,'2012-07-08','2012-08-08',0.5,1,'A'),
 (2,'2012-07-07','2012-08-08',0.8,2,'A');
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;


--
-- Definition of table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `codPro` int(11) NOT NULL AUTO_INCREMENT,
  `desPro` varchar(45) DEFAULT NULL,
  `prePro` double DEFAULT NULL,
  PRIMARY KEY (`codPro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`codPro`,`desPro`,`prePro`) VALUES 
 (1,'Lavado de prendas 20 KG',50),
 (2,'Tapiz rojo',20);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
