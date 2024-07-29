-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: productosdb
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `cedula` varchar(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Ana Gómez','1000000001','Avenida Siempre Viva 742','555-1234'),(2,'Luis Rodríguez','1000000002','Calle Otoño 23','555-5678'),(3,'Marta Fernández','1000000003','Plaza Primavera 456','555-8765'),(4,'Carlos Sánchez','1000000004','Camino del Sol 12','555-4321'),(5,'Elena Martínez','1000000005','Paseo de la Luna 34','555-6789'),(6,'Jorge López','1000000006','Boulevard del Bosque 789','555-9876'),(7,'Patricia Jiménez','1000000007','Ruta del Viento 101','555-5432'),(8,'Andrés Pérez','1000000008','Avenida del Río 202','555-2109'),(9,'Isabel Ramírez','1000000009','Calle de las Flores 303','555-6543'),(10,'Gabriel Torres','1000000010','Camino Real 404','555-7890');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `precio` double DEFAULT '0',
  `cantidad` int(11) DEFAULT '0',
  `categoria` varchar(50) NOT NULL,
  `caducidad` varchar(10) NOT NULL,
  `descuento` double DEFAULT '0',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (7,'PAPAS',0.7,15,'Alimentación','10/08/2025',0),(8,'Mani',20,109,'Alimentacion','20/6/2027',0),(9,'Atun',25,106,'Alimentacion','20/6/2027',0),(10,'Queso',30,73,'Alimentacion','20/6/2025',0),(11,'Galletas',40,93,'Alimentacion','20/6/2025',0),(12,'Cerveza',50,83,'Alimentacion','20/6/2024',0),(13,'Jugo',60,78,'Alimentacion','20/6/2024',0),(14,'Pan',70,122,'Alimentacion','3/10/2024',0),(15,'Sopa de Tomate',80,90,'Alimentacion','3/10/2026',0),(16,'Pescado',90,95,'Alimentacion','3/10/2026',0),(17,'Gelatina',120,106,'Alimentacion','3/10/2026',0),(18,'Aceite',110,117,'Alimentacion','3/10/2026',0),(19,'Papas',120,104,'Alimentacion','3/10/2026',0),(20,'Pollo',130,98,'Alimentacion','17/3/2026',0),(21,'Zanahorias',140,131,'Alimentacion','17/3/2027',0),(22,'Carne',150,77,'Alimentacion','17/3/2027',0),(23,'Ensalada',160,144,'Alimentacion','17/3/2027',0),(24,'Tomates',170,96,'Alimentacion','17/3/2027',0),(25,'Fideos',180,75,'Alimentacion','13/5/2024',0),(26,'Yogur',190,135,'Alimentacion','13/5/2024',0),(27,'Mermelada',200,98,'Alimentacion','13/5/2024',0),(28,'Lamina magnetica',5,130,'Educacion','20/6/2027',0),(29,'Resorte flexifilo',6,108,'Educacion','20/6/2027',0),(30,'Mesa de manipulacion',7,121,'Educacion','20/6/2025',0),(31,'Fondo de colores para bolsa',8,36,'Educacion','20/6/2025',0),(32,'Pinzas para recortar papel',9,125,'Educacion','20/6/2024',0),(33,'Escobilla de acero inoxidable',10,102,'Educacion','20/6/2024',0),(34,'Bolsa de plastico',11,117,'Educacion','3/10/2024',0),(35,'Sobre para proteger cosas pequeñas',12,99,'Educacion','3/10/2026',0),(36,'Marcador',13,101,'Educacion','3/10/2026',0),(37,'Boligrafo',14,76,'Educacion','3/10/2026',0),(38,'Lapiz',15,123,'Educacion','3/10/2026',0),(39,'Panel de aluminio para cubierta',16,0,'Educacion','3/10/2026',0),(40,'Paleta para colorear',17,9,'Educacion','17/3/2026',0),(41,'Juego de maletas plasticas',18,5,'Educacion','17/3/2027',0),(42,'Tiras adhesivas para coser',19,28,'Educacion','17/3/2027',0),(43,'Kit de reposteria basica',20,11,'Educacion','17/3/2027',0),(44,'Puzzle',21,0,'Educacion','17/3/2027',0),(45,'Set de accesorios para bolsa',22,9,'Educacion','13/5/2024',0),(46,'Bolsa para zapatos',23,29,'Educacion','13/5/2024',0),(47,'Guantes de cocina',24,17,'Educacion','13/5/2024',0),(48,'Cama para mascotas',99.62,84,'Hogar','20/6/2027',0),(49,'Recortador de barba',8.86,74,'Hogar','20/6/2027',0),(50,'Accesorios para dispositivos moviles',15.45,111,'Hogar','20/6/2025',0),(51,'Gel hidroalcoholico',199.77,62,'Hogar','20/6/2025',0),(52,'Ropa deportiva',183.54,77,'Hogar','20/6/2024',0),(53,'Fajas para el cuerpo',156.68,116,'Hogar','20/6/2024',0),(54,'Mascara o mascarilla',184.54,61,'Hogar','3/10/2024',0),(55,'Guantes de nitrilo',120.71,113,'Hogar','3/10/2026',0),(56,'Dispositivos de ahorro de energia',256.88,121,'Hogar','3/10/2026',0),(57,'Productos de depilacion',134.7,64,'Hogar','3/10/2026',0),(58,'Productos para bebes',82.95,114,'Hogar','3/10/2026',0),(59,'Gadgets',252.59,74,'Hogar','3/10/2026',0),(60,'Botellas re utilizables',0.15,93,'Hogar','17/3/2026',0),(61,'Vaporizador de leche electrico',234.05,62,'Hogar','17/3/2027',0),(62,'Repetidor de Red Wifi',265.92,92,'Hogar','17/3/2027',0),(63,'Decoracion tematica espacial',148.98,99,'Hogar','17/3/2027',0),(64,'Mini proyector para telefono movil',85.84,98,'Hogar','17/3/2027',0),(65,'Libros',156.39,19,'Hogar','13/5/2024',0),(66,'Controlador de porciones de comida',86.13,54,'Hogar','13/5/2024',0),(67,'Dispositivos Amazon',73.79,37,'Hogar','13/5/2024',0),(68,'Traje ejecutivo en algodon y seda',184.11,16,'Vestimenta','20/6/2027',0),(69,'Chaleco ejecutivo en seda',234.23,48,'Vestimenta','20/6/2027',0),(70,'Blazer ejecutivo en gabardina o algodon mezclado',106.84,44,'Vestimenta','20/6/2025',0),(71,'Traje de lujo en fibra sintetica y lana',103.25,30,'Vestimenta','20/6/2025',0),(72,'Traje de baile en algodon',24.45,12,'Vestimenta','20/6/2024',0),(73,'Camisa blanca en algodon y seda',12.02,17,'Vestimenta','20/6/2024',0),(74,'Camisa cuadriculada en algodon',94.26,1,'Vestimenta','3/10/2024',0),(75,'Camisa sport en algodon',148.88,86,'Vestimenta','3/10/2026',0),(76,'Pantalon deportivo en algodon',103.79,91,'Vestimenta','3/10/2026',0),(77,'Pantalon chino en seda y algodon',3.01,102,'Vestimenta','3/10/2026',0),(78,'Frac de smoking en algodon',255.53,102,'Vestimenta','3/10/2026',0),(79,'Cami acolchado en fibra sintetica y algodon',46.7,88,'Vestimenta','3/10/2026',0),(80,'Chaqueta acolchada en gabardina',160.4,64,'Vestimenta','17/3/2026',0),(81,'Prenda de abrigo en fibra sintetica',160.6,93,'Vestimenta','17/3/2027',0),(82,'Vestido largo en seda',235.06,0,'Vestimenta','17/3/2027',0),(83,'Vestido casual en algodon y fibra sintetica',228.8,0,'Vestimenta','17/3/2027',0),(84,'Bolsa de mano en cuero de cabra',29.98,0,'Vestimenta','17/3/2027',0),(85,'Bolso de lujo en cuero y seda',144.69,0,'Vestimenta','13/5/2024',0),(86,'Zapatillas casuales en tela sintetica',209.48,0,'Vestimenta','13/5/2024',0),(87,'Zapatos de vestir en cuero y acero',227.25,0,'Vestimenta','13/5/2024',0),(88,'Pinzas dentales',21.94,106,'Salud','20/6/2027',0),(89,'Bisturi',14.63,118,'Salud','20/6/2027',0),(90,'Escalpel',37.03,103,'Salud','20/6/2025',0),(91,'Forceps',31.69,122,'Salud','20/6/2025',0),(92,'Tijeras quirurgicas',14.46,106,'Salud','20/6/2024',0),(93,'Tenacillas de pellizcar',11.57,107,'Salud','20/6/2024',0),(94,'Aguja de hilo dental',3.68,106,'Salud','3/10/2024',0),(95,'Espatula',9.88,108,'Salud','3/10/2026',0),(96,'Vaso de Kidd',31.3,92,'Salud','3/10/2026',0),(97,'Sifon de borbotones',2.12,106,'Salud','3/10/2026',0),(98,'Bolsa de esponja',6.97,108,'Salud','3/10/2026',0),(99,'Tapabocas quirurgico',35.52,96,'Salud','3/10/2026',0),(100,'Guantes esteriles',40.31,59,'Salud','17/3/2026',0),(101,'Bota de piel de cordero',1.25,141,'Salud','17/3/2027',0),(102,'Gasa',19.73,109,'Salud','17/3/2027',0),(103,'Algodon de lienzo',7.41,98,'Salud','17/3/2027',0),(104,'Colirios',30.08,93,'Salud','17/3/2027',0),(105,'Agujero de alfiler',33.61,106,'Salud','13/5/2024',0),(106,'Eyedropper',14.58,94,'Salud','13/5/2024',0),(107,'Compresa',14.07,82,'Salud','13/5/2024',0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-28 17:29:27
