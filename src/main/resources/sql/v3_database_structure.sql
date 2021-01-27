-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table pharma_connect.admin
CREATE TABLE IF NOT EXISTS `admin` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                       `last_name` varchar(200) NOT NULL,
                                       `first_name` varchar(200) NOT NULL,
                                       `username` varchar(200) NOT NULL,
                                       `password` varchar(200) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.admin: ~0 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.chat
CREATE TABLE IF NOT EXISTS `chat` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `message` varchar(500) NOT NULL,
                                      `created_at` datetime NOT NULL DEFAULT current_timestamp(),
                                      `client_id` int(11) NOT NULL,
                                      `delivery_id` int(11) NOT NULL,
                                      `order_id` int(11) NOT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `client_chat_fk` (`client_id`),
                                      KEY `delivery_man_chat_fk` (`delivery_id`),
                                      KEY `order_chat_fk` (`order_id`),
                                      CONSTRAINT `client_chat_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                      CONSTRAINT `delivery_man_chat_fk` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                      CONSTRAINT `order_chat_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.chat: ~0 rows (approximately)
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.client
CREATE TABLE IF NOT EXISTS `client` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `first_name` varchar(200) DEFAULT NULL,
                                        `last_name` varchar(200) DEFAULT NULL,
                                        `phone` varchar(200) DEFAULT NULL,
                                        `username` varchar(200) DEFAULT NULL,
                                        `password` varchar(200) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `username_uk` (`username`) USING BTREE,
                                        UNIQUE KEY `phone_uk` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.client: ~0 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.delivery_man
CREATE TABLE IF NOT EXISTS `delivery_man` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `first_name` varchar(200) DEFAULT NULL,
                                              `last_name` varchar(200) DEFAULT NULL,
                                              `phone` varchar(200) DEFAULT NULL,
                                              `username` varchar(200) DEFAULT NULL,
                                              `password` varchar(200) DEFAULT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE KEY `username` (`username`),
                                              UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.delivery_man: ~0 rows (approximately)
/*!40000 ALTER TABLE `delivery_man` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_man` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.detail_order
CREATE TABLE IF NOT EXISTS `detail_order` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `product_code` varchar(200) NOT NULL,
                                              `order_id` int(11) NOT NULL,
                                              PRIMARY KEY (`id`),
                                              KEY `product_detail_order_fk` (`product_code`),
                                              KEY `order_detail_order_fk` (`order_id`),
                                              CONSTRAINT `order_detail_order_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                              CONSTRAINT `product_detail_order_fk` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.detail_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `detail_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_order` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.historical_address
CREATE TABLE IF NOT EXISTS `historical_address` (
                                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                                    `address` varchar(200) NOT NULL,
                                                    `last_modified_date` datetime NOT NULL,
                                                    `client_id` int(11) NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    KEY `client_historical_adress_fk` (`client_id`),
                                                    CONSTRAINT `client_historical_adress_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.historical_address: ~0 rows (approximately)
/*!40000 ALTER TABLE `historical_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `historical_address` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.lk_pharmacy_permanent
CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent` (
                                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                                       `pharmacy_id` int(11) NOT NULL,
                                                       `permanent_id` int(11) NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       KEY `pharmacie_Ik_pharmacy_permanent_fk` (`pharmacy_id`) USING BTREE,
                                                       KEY `permanent_Ik_pharmacy_permanent_fk` (`permanent_id`),
                                                       CONSTRAINT `permanent_Ik_pharmacy_permanent_fk` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                                       CONSTRAINT `pharmacie_Ik_pharmacy_permanent_fk` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.lk_pharmacy_permanent: ~3 rows (approximately)
/*!40000 ALTER TABLE `lk_pharmacy_permanent` DISABLE KEYS */;
INSERT INTO `lk_pharmacy_permanent` (`id`, `pharmacy_id`, `permanent_id`) VALUES
(1, 2, 1),
(2, 1, 1),
(3, 2, 3);
/*!40000 ALTER TABLE `lk_pharmacy_permanent` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.orders
CREATE TABLE IF NOT EXISTS `orders` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `nbr_product` int(11) NOT NULL,
                                        `price` double NOT NULL,
                                        `client_id` int(11) NOT NULL,
                                        `delivery_id` int(11) NOT NULL,
                                        `product_id` int(11) NOT NULL,
                                        `payment_id` int(11) NOT NULL,
                                        `pharmacy_id` int(11) NOT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `client_ordered_fk` (`client_id`),
                                        KEY `delivery_man_ordered_fk` (`delivery_id`),
                                        KEY `product_ordered_fk` (`product_id`),
                                        KEY `pharmacy_ordered_fk` (`pharmacy_id`),
                                        KEY `payment_ordered_fk` (`payment_id`),
                                        CONSTRAINT `client_ordered_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `delivery_man_ordered_fk` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `payment_ordered_fk` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `pharmacy_ordered_fk` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `product_ordered_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.payment
CREATE TABLE IF NOT EXISTS `payment` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `status` varchar(200) NOT NULL,
                                         `method` varchar(200) NOT NULL,
                                         `client_id` int(11) NOT NULL,
                                         `order_id` int(11) NOT NULL,
                                         PRIMARY KEY (`id`),
                                         KEY `client_payment_fk` (`client_id`),
                                         KEY `order_payment_fk` (`order_id`),
                                         CONSTRAINT `client_payment_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                         CONSTRAINT `order_payment_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.payment: ~0 rows (approximately)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.permanent
CREATE TABLE IF NOT EXISTS `permanent` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT,
                                           `start_date` datetime NOT NULL,
                                           `end_date` datetime NOT NULL,
                                           `type` varchar(200) NOT NULL,
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.permanent: ~3 rows (approximately)
/*!40000 ALTER TABLE `permanent` DISABLE KEYS */;
INSERT INTO `permanent` (`id`, `start_date`, `end_date`, `type`) VALUES
(1, '2022-01-23 20:00:00', '2021-01-29 18:00:00', 'NIGHT'),
(2, '2022-02-23 20:00:00', '2021-02-27 18:00:00', 'DAY'),
(3, '2021-01-20 00:00:03', '2021-01-29 00:00:00', 'DAY');
/*!40000 ALTER TABLE `permanent` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
                                          `name` varchar(200) NOT NULL,
                                          `address` varchar(200) NOT NULL,
                                          `pharmacist` varchar(200) NOT NULL,
                                          `lat` double DEFAULT NULL,
                                          `lng` double DEFAULT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.pharmacy: ~2 rows (approximately)
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` (`id`, `name`, `address`, `pharmacist`, `lat`, `lng`) VALUES
(1, 'Ezzehour', '35 rue ezzhour Errachidia', 'YoNajeh', 7.36, 2.58),
(2, 'Ibn Tachefin', '25 rue Ibn Tachefin Lissasfa', 'YoNajeh', 10.36, -5.55);
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.product
CREATE TABLE IF NOT EXISTS `product` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `name` varchar(200) NOT NULL,
                                         `price` double NOT NULL,
                                         `code` varchar(50) NOT NULL,
                                         `prescription` tinyint(1) NOT NULL,
                                         `pharmacy_id` int(11) NOT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `coded` (`code`) USING BTREE,
                                         KEY `pharmacie_product_fk` (`pharmacy_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.review
CREATE TABLE IF NOT EXISTS `review` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `review` varchar(200) NOT NULL,
                                        `rate` int(11) DEFAULT NULL,
                                        `client_id` int(11) NOT NULL,
                                        `delivery_id` int(11) NOT NULL,
                                        `order_id` int(11) NOT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `client_review_fk` (`client_id`),
                                        KEY `delivery_man_review_fk` (`delivery_id`),
                                        KEY `ordered_review_fk` (`order_id`) USING BTREE,
                                        CONSTRAINT `client_review_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `delivery_man_review_fk` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `order_review_fk` FOREIGN KEY (`order_id`) REFERENCES `review` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.review: ~0 rows (approximately)
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
