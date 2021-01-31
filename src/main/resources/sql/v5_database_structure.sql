-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           10.4.17-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Listage de la structure de la table pharma_connect. admin
CREATE TABLE IF NOT EXISTS `admin` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_gfn44sntic2k93auag97juyij` (`username`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. chat
CREATE TABLE IF NOT EXISTS `chat` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime NOT NULL,
    `message` varchar(255) NOT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKrrnwynvawopofurxfkbgtrame` (`client_id`),
    KEY `FKsahshgfgf40qvn9u0w5dq4j86` (`delivery_id`),
    KEY `FK3034d4gqj9h171m81ebdqjroh` (`order_id`),
    CONSTRAINT `FK3034d4gqj9h171m81ebdqjroh` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
    CONSTRAINT `FKrrnwynvawopofurxfkbgtrame` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKsahshgfgf40qvn9u0w5dq4j86` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. client
CREATE TABLE IF NOT EXISTS `client` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `phone` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_qe9dtj732yl9u3oqhhsee4lps` (`phone`),
    UNIQUE KEY `UK_ah5c1ribskm746956okm9283n` (`username`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. delivery_man
CREATE TABLE IF NOT EXISTS `delivery_man` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) NOT NULL,
    `last_name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `phone` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_j6a8sbhehsoi45sba3frraeo5` (`phone`),
    UNIQUE KEY `UK_myvni74mf8r3po1y2xvy35o8r` (`username`)
    ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. detail_order
CREATE TABLE IF NOT EXISTS `detail_order` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `product_code` varchar(255) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKjdf2te6dqo3a74nru9wknvcp8` (`order_id`),
    CONSTRAINT `FKjdf2te6dqo3a74nru9wknvcp8` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. historical_address
CREATE TABLE IF NOT EXISTS `historical_address` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `last_modified_date` datetime DEFAULT NULL,
    `client_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK6dvcxo3ejhvvag2s0sidj13m1` (`client_id`),
    CONSTRAINT `FK6dvcxo3ejhvvag2s0sidj13m1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. lk_pharmacy_permanent
CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent` (
    `pharmacy_id` int(11) NOT NULL,
    `permanent_id` int(11) NOT NULL,
    KEY `FKswg008p0q7l738tuxsfm8rdba` (`permanent_id`),
    KEY `FK80rdw8mib5wb3vde65wfhqtw4` (`pharmacy_id`),
    CONSTRAINT `FK80rdw8mib5wb3vde65wfhqtw4` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`),
    CONSTRAINT `FKswg008p0q7l738tuxsfm8rdba` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. orders
CREATE TABLE IF NOT EXISTS `orders` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nbr_product` int(11) NOT NULL,
    `price` double NOT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) DEFAULT NULL,
    `payment_id` int(11) NOT NULL,
    `pharmacy_id` int(11) DEFAULT NULL,
    `product_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK17yo6gry2nuwg2erwhbaxqbs9` (`client_id`),
    KEY `FKottfdcheyhpx5d6petq7v7u97` (`delivery_id`),
    KEY `FKag8ppnkjvx255gj7lm3m18wkj` (`payment_id`),
    KEY `FKttmxvmgcfr0cf63sb6w2vd9b` (`pharmacy_id`),
    KEY `FK787ibr3guwp6xobrpbofnv7le` (`product_id`),
    CONSTRAINT `FK17yo6gry2nuwg2erwhbaxqbs9` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FK787ibr3guwp6xobrpbofnv7le` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
    CONSTRAINT `FKag8ppnkjvx255gj7lm3m18wkj` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
    CONSTRAINT `FKottfdcheyhpx5d6petq7v7u97` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`),
    CONSTRAINT `FKttmxvmgcfr0cf63sb6w2vd9b` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. payment
CREATE TABLE IF NOT EXISTS `payment` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `method` varchar(20) NOT NULL,
    `status` varchar(20) NOT NULL,
    `client_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK3fpanu7q9tijfio491vu0fd0r` (`client_id`),
    KEY `FKlouu98csyullos9k25tbpk4va` (`order_id`),
    CONSTRAINT `FK3fpanu7q9tijfio491vu0fd0r` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKlouu98csyullos9k25tbpk4va` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. permanent
CREATE TABLE IF NOT EXISTS `permanent` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `end_date` datetime NOT NULL,
    `start_date` datetime NOT NULL,
    `type` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `lat` double DEFAULT NULL,
    `lng` double DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `pharmacist` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. product
CREATE TABLE IF NOT EXISTS `product` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `prescription` bit(1) NOT NULL,
    `price` double NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table pharma_connect. review
CREATE TABLE IF NOT EXISTS `review` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `rate` int(11) DEFAULT NULL,
    `review` varchar(255) DEFAULT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKhr2oxqr7hu3upmi4hvg9g0ghp` (`client_id`),
    KEY `FKr69bg2vtklebe6dx9novxs9nc` (`delivery_id`),
    KEY `FKnkc5s3da46cbx8oeqrfhnm7es` (`order_id`),
    CONSTRAINT `FKhr2oxqr7hu3upmi4hvg9g0ghp` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKnkc5s3da46cbx8oeqrfhnm7es` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
    CONSTRAINT `FKr69bg2vtklebe6dx9novxs9nc` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Les données exportées n'étaient pas sélectionnées.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
