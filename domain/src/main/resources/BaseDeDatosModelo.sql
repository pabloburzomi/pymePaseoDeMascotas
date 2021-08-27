-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.25 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para paseoperros
CREATE DATABASE IF NOT EXISTS `paseoperros` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `paseoperros`;

-- Volcando estructura para tabla paseoperros.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombreyapellidos` varchar(50) NOT NULL,
  `dni` varchar(50) DEFAULT NULL,
  `domicilio` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`idcliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla paseoperros.mascotas
CREATE TABLE IF NOT EXISTS `mascotas` (
  `idmascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `raza` varchar(50) NOT NULL DEFAULT '',
  `caracteristicas` varchar(50) NOT NULL DEFAULT '',
  `cantpaseosdiarios` varchar(50) NOT NULL DEFAULT '',
  `idcliente` int NOT NULL,
  PRIMARY KEY (`idmascota`),
  KEY `FK_mascotas_dueños` (`idcliente`) USING BTREE,
  CONSTRAINT `FK_mascotas_dueños` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla paseoperros.paseadores
CREATE TABLE IF NOT EXISTS `paseadores` (
  `idpaseador` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(50) NOT NULL DEFAULT '',
  `nombreyapellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`idpaseador`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla paseoperros.paseos
CREATE TABLE IF NOT EXISTS `paseos` (
  `idpaseo` int NOT NULL AUTO_INCREMENT,
  `idmascota` int NOT NULL,
  `idpaseador` int NOT NULL,
  `fechapaseo` varchar(50) NOT NULL DEFAULT '',
  `horapaseo` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`idpaseo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla paseoperros.valores
CREATE TABLE IF NOT EXISTS `valores` (
  `idvalor` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `importepaseo` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`idvalor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
