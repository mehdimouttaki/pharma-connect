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
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.admin : ~2 rows (environ)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`) VALUES
(6),
(18);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. chat
CREATE TABLE IF NOT EXISTS `chat` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `created_at` datetime NOT NULL,
    `message` varchar(255) NOT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_chat_client` (`client_id`) USING BTREE,
    KEY `pk_chat_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_chat_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_chat_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `fk_chat_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`),
    CONSTRAINT `fk_chat_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.chat : ~5 rows (environ)
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` (`id`, `created_at`, `message`, `client_id`, `delivery_id`, `order_id`) VALUES
(3, '2021-02-08 14:53:11', 'Merci', 12, 15, 6),
(4, '2021-02-11 14:53:35', 'Accepte', 52, 14, 11),
(5, '2020-10-08 14:54:08', 'thanks', 43, 61, 10),
(6, '2019-09-08 14:55:30', 'bizarre', 50, 58, 7),
(7, '2020-11-08 14:56:49', 'good man ', 48, 58, 9);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. client
CREATE TABLE IF NOT EXISTS `client` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_client_phone` (`phone`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.client : ~12 rows (environ)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `phone`) VALUES
(12, '0603060804'),
(52, '06101010110'),
(43, '061111111'),
(53, '0612121212'),
(44, '0622222222'),
(45, '06333333333'),
(46, '06444444444'),
(47, '06555555555'),
(48, '0666666666'),
(49, '067777777'),
(50, '068888888'),
(51, '069999999');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. delivery_man
CREATE TABLE IF NOT EXISTS `delivery_man` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_delivery_man_phone` (`phone`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.delivery_man : ~10 rows (environ)
/*!40000 ALTER TABLE `delivery_man` DISABLE KEYS */;
INSERT INTO `delivery_man` (`id`, `phone`) VALUES
(15, '0000000000000'),
(61, '0001090208'),
(62, '0102060805'),
(60, '010900706'),
(14, '0111111111111'),
(59, '0309080706'),
(58, '0609080705'),
(57, '0709080605'),
(56, '08090706050403'),
(55, '0908070605');
/*!40000 ALTER TABLE `delivery_man` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. detail_order
CREATE TABLE IF NOT EXISTS `detail_order` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `product_code` varchar(255) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_detail_order_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_detail_order_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.detail_order : ~0 rows (environ)
/*!40000 ALTER TABLE `detail_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_order` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. historical_address
CREATE TABLE IF NOT EXISTS `historical_address` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `last_modified_date` datetime DEFAULT NULL,
    `client_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_historical_address_client` (`client_id`) USING BTREE,
    CONSTRAINT `fk_historical_adress_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.historical_address : ~0 rows (environ)
/*!40000 ALTER TABLE `historical_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `historical_address` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. lk_pharmacy_permanent
CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent` (
    `pharmacy_id` int(11) NOT NULL,
    `permanent_id` int(11) NOT NULL,
    KEY `pk_pharmacy_permanent_permanent` (`permanent_id`) USING BTREE,
    KEY `pk_pharmacy_permanent_pharmacy` (`pharmacy_id`) USING BTREE,
    CONSTRAINT `fk_pharmacy_permanent_permanent` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`),
    CONSTRAINT `fk_pharmacy_permanent_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.lk_pharmacy_permanent : ~0 rows (environ)
/*!40000 ALTER TABLE `lk_pharmacy_permanent` DISABLE KEYS */;
/*!40000 ALTER TABLE `lk_pharmacy_permanent` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. orders
CREATE TABLE IF NOT EXISTS `orders` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nbr_product` int(11) NOT NULL,
    `price` double NOT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) DEFAULT NULL,
    `pharmacy_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_orders_client` (`client_id`) USING BTREE,
    KEY `pk_orders_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_orders_pharmacy` (`pharmacy_id`) USING BTREE,
    CONSTRAINT `fk_orders_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `fk_orders_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`),
    CONSTRAINT `fk_orders_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.orders : ~7 rows (environ)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `nbr_product`, `price`, `client_id`, `delivery_id`, `pharmacy_id`) VALUES
(6, 2, 99.89, 44, 14, 6),
(7, 8, 390.76, 12, 15, 6),
(8, 1, 34.87, 52, 60, 13),
(9, 5, 156.84, 45, 14, 9),
(10, 7, 245, 47, 59, 8),
(11, 3, 88.67, 51, 60, 11),
(12, 8, 56.78, 49, 14, 10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. payment
CREATE TABLE IF NOT EXISTS `payment` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `method` varchar(20) NOT NULL,
    `status` varchar(20) NOT NULL,
    `client_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_payment_client` (`client_id`) USING BTREE,
    KEY `pk_payment_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_payment_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `fk_payment_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.payment : ~0 rows (environ)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. permanent
CREATE TABLE IF NOT EXISTS `permanent` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `end_date` datetime NOT NULL,
    `start_date` datetime NOT NULL,
    `type` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.permanent : ~3 rows (environ)
/*!40000 ALTER TABLE `permanent` DISABLE KEYS */;
INSERT INTO `permanent` (`id`, `end_date`, `start_date`, `type`) VALUES
(3, '2021-02-08 14:57:53', '2021-02-24 14:57:56', 'DAY'),
(4, '2021-03-08 14:58:18', '2021-04-08 14:58:26', 'NIGHT'),
(5, '2020-02-08 14:58:43', '2020-02-16 14:58:49', 'DAY');
/*!40000 ALTER TABLE `permanent` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `lat` double DEFAULT NULL,
    `lng` double DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `pharmacist` varchar(255) DEFAULT NULL,
    `ville_id` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.pharmacy : ~8 rows (environ)
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` (`id`, `address`, `lat`, `lng`, `name`, `pharmacist`, `ville_id`) VALUES
(6, 'lissasfa', 9.77, -7.092, 'othman', 'abdo', ''),
(7, 'oulfa', 17, -89, 'naha', 'rida', ''),
(8, 'zoubir', 16.788, -12.77, 'alakhwayn', 'fatiha', ''),
(9, 'anfa', 5.98, -78.99, 'Habiba', 'hassan', ''),
(10, 'Dar 16', NULL, NULL, 'Falah', 'khadija', ''),
(11, 'sidi rihal', NULL, NULL, 'zraktouni', 'mohamed', ''),
(12, 'bouskoura', 7.988, -34.88, 'boustan', 'moughit', ''),
(13, 'sidi Maroof', 67.84, -56.78, 'warda', 'youssef', '');
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. product
CREATE TABLE IF NOT EXISTS `product` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `prescription` bit(1) NOT NULL,
    `price` double NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.product : ~8 rows (environ)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `code`, `name`, `prescription`, `price`) VALUES
(14, 'Hjuuu', 'Efferalgan\r\n', b'0', 53),
(15, 'HJKL', 'Doliprane', b'0', 44.77),
(16, 'KJJJJ', 'Spassirex Gé', b'1', 90),
(17, 'ki-HH', 'Spasfon', b'1', 90.77),
(18, 'SDFF', 'Héxomédine', b'1', 89.77),
(19, 'CARH', 'Cardiosolupsan', b'1', 120.88),
(20, 'PHLM', 'Humex Pholcodine', b'0', 66.87),
(21, 'DIM', 'Dimétane', b'1', 12.77),
(22, 'HGTY', 'Aspigic', b'1', 48.98);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. review
CREATE TABLE IF NOT EXISTS `review` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `rate` int(5) DEFAULT NULL,
    `review` varchar(100) DEFAULT NULL,
    `client_id` int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_review_client` (`client_id`) USING BTREE,
    KEY `pk_review_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_review_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_review_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `fk_review_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`),
    CONSTRAINT `fk_review_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.review : ~5 rows (environ)
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` (`id`, `rate`, `review`, `client_id`, `delivery_id`, `order_id`) VALUES
(8, 0, '5', 12, 15, 6),
(9, 0, '3', 52, 61, 7),
(10, NULL, NULL, 43, 14, 8),
(12, 0, '1', 53, 60, 11),
(14, 0, '5', 51, 56, 9);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. user
CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(200) NOT NULL,
    `password` varchar(255) NOT NULL,
    `role` varchar(20) NOT NULL DEFAULT 'CLIENT',
    `first_name` varchar(200) NOT NULL,
    `last_name` varchar(200) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
    ) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.user : ~20 rows (environ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `first_name`, `last_name`) VALUES
(18, 'admin', '$2a$10$.tRRcd7IPTbKvO.KRwb0.Ot1Yg3gSUfm3RdPVEHJeCNv2tsFRghuy', 'ADMIN', 'Mehdi', 'Mouttaki'),
(43, 'mehdimouttaki99@gmail.com', '$2a$10$l9Npvq1ENjpIpyH5XM7KI.XR6ogtkzBApy.uZ.dB3X1jgvO.G0cLW', 'CLIENT', 'mehdi', 'mouttaki'),
(44, 'ridahsika@gmail.com', '$2a$10$ofM8Zn5DwqU9xA/0F0v7dOOlx9Nxnxme.M8KzugK733XLy9Hn8i/q', 'CLIENT', 'rida ', 'hsika'),
(45, 'moughitmoustain@gmail.com', '$2a$10$wXMiagEA.6JAraWdrFCuZOszzJFJ3w6TYje.4fJGvBrr6am0n2HYq', 'CLIENT', 'moughit', 'mostain'),
(46, 'youssefnajeh@gmail.com', '$2a$10$6Wb0Lq6sVjfbCUmXWFt5x.FaOipQGFBdRxTQmptbXFhRxcXbvnu6.', 'CLIENT', 'youssef', 'najeh'),
(47, 'abdomostain@gmail.com', '$2a$10$yot121GaXDlN1KjqljyJt.85wEhF4GneeRARIXaj3jdKPB8aVknGm', 'CLIENT', 'abdejlil', 'moustain'),
(48, 'youssefelkaoumi@gmail.com', '$2a$10$Fp6F/tCQg7HjtmT9g3zILegHlwYxMaz5QxNGscCVhEM37CmmNlj.e', 'CLIENT', 'youssef', 'elkaoumi'),
(49, 'omarelkaoumi@gmail.com', '$2a$10$1CQPsKzvaJ8kezk1xR/2L.6ZgpCYFtPMHKGBf6TXYV/NJn0I/ByMe', 'CLIENT', 'omar', 'elkaoumi'),
(50, 'saidelgarch@gmail.com', '$2a$10$WjHcmvdgdC80BubSwmAR5uoFrHQvYCiH1Mjp1EY/fe4TC.KFoXh3u', 'CLIENT', 'said', 'elgerch'),
(51, 'mouadbaso@gmail.com', '$2a$10$wp6QKntLUzA1.qMeY36f6.IDgRgtDx5KAG5rSeoorX0CM82T0XC3G', 'CLIENT', 'mouad', 'baso'),
(52, 'kabilmohamed@gmail.com', '$2a$10$nWGSmAZBOYN16xDVC6CQweqzp9SqkpUjfLcVAZoBUpZtqWT7TTfZu', 'CLIENT', 'mohamed', 'kabil'),
(53, 'saadnajeh@gmail.com', '$2a$10$fUr9B95qg/CNROf3mzfWaeIbDOIXb3MIdbsj4od7AVCocJpz0VztG', 'CLIENT', 'saad', 'najeh'),
(55, 'ahmedmoustain@gmail.com', '$2a$10$T5h4EWlhKWyyaye6sfc/U.nZYVH1DolAMoJSiaAj1ZxOe5k3OW3cq', 'DELIVERY', 'ahmed', 'moustain'),
(56, 'oussamachahet@gmail.com', '$2a$10$8N6gyawT0Wr/tfXkySnlzOUo0Lzjmb7TiihocqRHsfxGsaD0z7YgW', 'DELIVERY', 'oussama', 'chahet'),
(57, 'imadbouchala@gmail.com', '$2a$10$2jESfI4ZUEa2yhnpYFAhDe.p7E54wk9enrUrV9e8scHfNxD1xf1re', 'DELIVERY', 'imad', 'bouchalaa'),
(58, 'zakariabouchala@gmail.com', '$2a$10$8e1MvX7d39qmVQ7Z9sqDNO1ginOF8soCqxPPcsesKmWy.TLIl015W', 'DELIVERY', 'zakaria', 'bouchala'),
(59, 'walidhsika@gmail.com', '$2a$10$hcpN2WrYHcbifi6aHGA61.KyDvu6fZfJwCRN0.P3kP/EaAUETEbnq', 'DELIVERY', 'walid', 'hsika'),
(60, 'omaranjar@gmail.com', '$2a$10$uHOi4ni57ZOBj2NCNQyj0.YeY292081wZAJVQ/s47yCEfzqvt.jJG', 'DELIVERY', 'omar', 'anjar'),
(61, 'azizchajiaa@gmail.com', '$2a$10$CtNHHs4LR.oYXMt4tCrPDuqOX2OZ7.JPKHwaKuT4TMSGUnW2fQHAC', 'DELIVERY', 'aziz', 'chajiaa'),
(62, 'najibroby@gmail.com', '$2a$10$cEOjd9MAxc/SNOGGbO/3Nu7z4/s3nTIT3pZeCydL8.zekXgJVckHq', 'DELIVERY', 'najib', 'roby');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. ville
CREATE TABLE IF NOT EXISTS `ville` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `ville` varchar(500) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.ville : ~394 rows (environ)
/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
INSERT INTO `ville` (`id`, `ville`) VALUES
(1, 'Aïn Harrouda'),
(2, 'Ben Yakhlef'),
(3, 'Bouskoura'),
(4, 'Casablanca'),
(5, 'Médiouna'),
(6, 'Mohammadia'),
(7, 'Tit Mellil'),
(8, 'Ben Yakhlef'),
(9, 'Bejaâd'),
(10, 'Ben Ahmed'),
(11, 'Benslimane'),
(12, 'Berrechid'),
(13, 'Boujniba'),
(14, 'Boulanouare'),
(15, 'Bouznika'),
(16, 'Deroua'),
(17, 'El Borouj'),
(18, 'El Gara'),
(19, 'Guisser'),
(20, 'Hattane'),
(21, 'Khouribga'),
(22, 'Loulad'),
(23, 'Oued Zem'),
(24, 'Oulad Abbou'),
(25, 'Oulad HRiz Sahel'),
(26, 'Oulad M\rah'),
(27, 'Oulad Saïd'),
(28, 'Oulad Sidi Ben Daoud'),
(29, 'Ras El Aïn'),
(30, 'Settat'),
(31, 'Sidi Rahhal Chataï'),
(32, 'Soualem'),
(33, 'Azemmour'),
(34, 'Bir Jdid'),
(35, 'Bouguedra'),
(36, 'Echemmaia'),
(37, 'El Jadida'),
(38, 'Hrara'),
(39, 'Ighoud'),
(40, 'Jamâat Shaim'),
(41, 'Jorf Lasfar'),
(42, 'Khemis Zemamra'),
(43, 'Laaounate'),
(44, 'Moulay Abdallah'),
(45, 'Oualidia'),
(46, 'Oulad Amrane'),
(47, 'Oulad Frej'),
(48, 'Oulad Ghadbane'),
(49, 'Safi'),
(50, 'Sebt El Maârif'),
(51, 'Sebt Gzoula'),
(52, 'Sidi Ahmed'),
(53, 'Sidi Ali Ban Hamdouche'),
(54, 'Sidi Bennour'),
(55, 'Sidi Bouzid'),
(56, 'Sidi Smaïl'),
(57, 'Youssoufia'),
(58, 'Fès'),
(59, 'Aïn Cheggag'),
(60, 'Bhalil'),
(61, 'Boulemane'),
(62, 'El Menzel'),
(63, 'Guigou'),
(64, 'Imouzzer Kandar'),
(65, 'Imouzzer Marmoucha'),
(66, 'Missour'),
(67, 'Moulay Yaâcoub'),
(68, 'Ouled Tayeb'),
(69, 'Outat El Haj'),
(70, 'Ribate El Kheir'),
(71, 'Séfrou'),
(72, 'Skhinate'),
(73, 'Tafajight'),
(74, 'Arbaoua'),
(75, 'Aïn Dorij'),
(76, 'Dar Gueddari'),
(77, 'Had Kourt'),
(78, 'Jorf El Melha'),
(79, 'Kénitra'),
(80, 'Khenichet'),
(81, 'Lalla Mimouna'),
(82, 'Mechra Bel Ksiri'),
(83, 'Mehdia'),
(84, 'Moulay Bousselham'),
(85, 'Sidi Allal Tazi'),
(86, 'Sidi Kacem'),
(87, 'Sidi Slimane'),
(88, 'Sidi Taibi'),
(89, 'Sidi Yahya El Gharb'),
(90, 'Souk El Arbaa'),
(91, 'Akka'),
(92, 'Assa'),
(93, 'Bouizakarne'),
(94, 'El Ouatia'),
(95, 'Es-Semara'),
(96, 'Fam El Hisn'),
(97, 'Foum Zguid'),
(98, 'Guelmim'),
(99, 'Taghjijt'),
(100, 'Tan-Tan'),
(101, 'Tata'),
(102, 'Zag'),
(103, 'Marrakech'),
(104, 'Ait Daoud'),
(115, 'Amizmiz'),
(116, 'Assahrij'),
(117, 'Aït Ourir'),
(118, 'Ben Guerir'),
(119, 'Chichaoua'),
(120, 'El Hanchane'),
(121, 'El Kelaâ des Sraghna'),
(122, 'Essaouira'),
(123, 'Fraïta'),
(124, 'Ghmate'),
(125, 'Ighounane'),
(126, 'Imintanoute'),
(127, 'Kattara'),
(128, 'Lalla Takerkoust'),
(129, 'Loudaya'),
(130, 'Lâattaouia'),
(131, 'Moulay Brahim'),
(132, 'Mzouda'),
(133, 'Ounagha'),
(134, 'Sid LMokhtar'),
(135, 'Sid Zouin'),
(136, 'Sidi Abdallah Ghiat'),
(137, 'Sidi Bou Othmane'),
(138, 'Sidi Rahhal'),
(139, 'Skhour Rehamna'),
(140, 'Smimou'),
(141, 'Tafetachte'),
(142, 'Tahannaout'),
(143, 'Talmest'),
(144, 'Tamallalt'),
(145, 'Tamanar'),
(146, 'Tamansourt'),
(147, 'Tameslouht'),
(148, 'Tanalt'),
(149, 'Zeubelemok'),
(150, 'Meknès‎'),
(151, 'Khénifra'),
(152, 'Agourai'),
(153, 'Ain Taoujdate'),
(154, 'MyAliCherif'),
(155, 'Rissani'),
(156, 'Amalou Ighriben'),
(157, 'Aoufous'),
(158, 'Arfoud'),
(159, 'Azrou'),
(160, 'Aïn Jemaa'),
(161, 'Aïn Karma'),
(162, 'Aïn Leuh'),
(163, 'Aït Boubidmane'),
(164, 'Aït Ishaq'),
(165, 'Boudnib'),
(166, 'Boufakrane'),
(167, 'Boumia'),
(168, 'El Hajeb'),
(169, 'Elkbab'),
(170, 'Er-Rich'),
(171, 'Errachidia'),
(172, 'Gardmit'),
(173, 'Goulmima'),
(174, 'Gourrama'),
(175, 'Had Bouhssoussen'),
(176, 'Haj Kaddour'),
(177, 'Ifrane'),
(178, 'Itzer'),
(179, 'Jorf'),
(180, 'Kehf Nsour'),
(181, 'Kerrouchen'),
(182, 'M\'haya'),
	(183, 'M\'rirt'),
(184, 'Midelt'),
(185, 'Moulay Ali Cherif'),
(186, 'Moulay Bouazza'),
(187, 'Moulay Idriss Zerhoun'),
(188, 'Moussaoua'),
(189, 'Nalat Bni Amar'),
(190, 'Ouaoumana'),
(191, 'Oued Ifrane'),
(192, 'Sabaa Aiyoun'),
(193, 'Sebt Jahjouh'),
(194, 'Sidi Addi'),
(195, 'Tichoute'),
(196, 'Tighassaline'),
(197, 'Tighza'),
(198, 'Timahdite'),
(199, 'Tinejdad'),
(200, 'Tizguite'),
(201, 'Toulal'),
(202, 'Tounfite'),
(203, 'Zaouia dIfrane'),
(204, 'Zaïda'),
(205, 'Ahfir'),
(206, 'Aklim'),
(207, 'Al Aroui'),
(208, 'Aïn Bni Mathar'),
(209, 'Aïn Erreggada'),
(210, 'Ben Taïeb'),
(211, 'Berkane'),
(212, 'Bni Ansar'),
(213, 'Bni Chiker'),
(214, 'Bni Drar'),
(215, 'Bni Tadjite'),
(216, 'Bouanane'),
(217, 'Bouarfa'),
(218, 'Bouhdila'),
(219, 'Dar El Kebdani'),
(220, 'Debdou'),
(221, 'Douar Kannine'),
(222, 'Driouch'),
(223, 'El Aïoun Sidi Mellouk'),
(224, 'Farkhana'),
(225, 'Figuig'),
(226, 'Ihddaden'),
(227, 'Jaâdar'),
(228, 'Jerada'),
(229, 'Kariat Arekmane'),
(230, 'Kassita'),
(231, 'Kerouna'),
(232, 'Laâtamna'),
(233, 'Madagh'),
(234, 'Midar'),
(235, 'Nador'),
(236, 'Naima'),
(237, 'Oued Heimer'),
(238, 'Oujda'),
(239, 'Ras El Ma'),
(240, 'Saïdia'),
(241, 'Selouane'),
(242, 'Sidi Boubker'),
(243, 'Sidi Slimane Echcharaa'),
(244, 'Talsint'),
(245, 'Taourirt'),
(246, 'Tendrara'),
(247, 'Tiztoutine'),
(248, 'Touima'),
(249, 'Touissit'),
(250, 'Zaïo'),
(251, 'Zeghanghane'),
(252, 'Rabat'),
(253, 'Salé'),
(254, 'Ain El Aouda'),
(255, 'Harhoura'),
(256, 'Khémisset'),
(257, 'Oulmès'),
(258, 'Rommani'),
(259, 'Sidi Allal El Bahraoui'),
(260, 'Sidi Bouknadel'),
(261, 'Skhirate'),
(262, 'Tamesna'),
(263, 'Témara'),
(264, 'Tiddas'),
(265, 'Tiflet'),
(266, 'Touarga'),
(267, 'Agadir'),
(268, 'Agdz'),
(269, 'Agni Izimmer'),
(270, 'Aït Melloul'),
(271, 'Alnif'),
(272, 'Anzi'),
(273, 'Aoulouz'),
(274, 'Aourir'),
(275, 'Arazane'),
(276, 'Aït Baha'),
(277, 'Aït Iaâza'),
(278, 'Aït Yalla'),
(279, 'Ben Sergao'),
(280, 'Biougra'),
(281, 'Boumalne-Dadès'),
(282, 'Dcheira El Jihadia'),
(283, 'Drargua'),
(284, 'El Guerdane'),
(285, 'Harte Lyamine'),
(286, 'Ida Ougnidif'),
(287, 'Ifri'),
(288, 'Igdamen'),
(289, 'Ighil nOumgoun'),
(290, 'Imassine'),
(291, 'Inezgane'),
(292, 'Irherm'),
(293, 'Kelaat-MGouna'),
(294, 'Lakhsas'),
(295, 'Lakhsass'),
(296, 'Lqliâa'),
(297, 'Msemrir'),
(298, 'Massa (Maroc)'),
(299, 'Megousse'),
(300, 'Ouarzazate'),
(301, 'Oulad Berhil'),
(302, 'Oulad Teïma'),
(303, 'Sarghine'),
(304, 'Sidi Ifni'),
(305, 'Skoura'),
(306, 'Tabounte'),
(307, 'Tafraout'),
(308, 'Taghzout'),
(309, 'Tagzen'),
(310, 'Taliouine'),
(311, 'Tamegroute'),
(312, 'Tamraght'),
(313, 'Tanoumrite Nkob Zagora'),
(314, 'Taourirt ait zaghar'),
(315, 'Taroudannt'),
(316, 'Temsia'),
(317, 'Tifnit'),
(318, 'Tisgdal'),
(319, 'Tiznit'),
(320, 'Toundoute'),
(321, 'Zagora'),
(322, 'Afourar'),
(323, 'Aghbala'),
(324, 'Azilal'),
(325, 'Aït Majden'),
(326, 'Beni Ayat'),
(327, 'Béni Mellal'),
(328, 'Bin elouidane'),
(329, 'Bradia'),
(330, 'Bzou'),
(331, 'Dar Oulad Zidouh'),
(332, 'Demnate'),
(333, 'Draa'),
(334, 'El Ksiba'),
(335, 'Foum Jamaa'),
(336, 'Fquih Ben Salah'),
(337, 'Kasba Tadla'),
(338, 'Ouaouizeght'),
(339, 'Oulad Ayad'),
(340, 'Oulad MBarek'),
(341, 'Oulad Yaich'),
(342, 'Sidi Jaber'),
(343, 'Souk Sebt Oulad Nemma'),
(344, 'Zaouïat Cheikh'),
(345, 'Tanger‎'),
(346, 'Tétouan‎'),
(347, 'Akchour'),
(348, 'Assilah'),
(349, 'Bab Berred'),
(350, 'Bab Taza'),
(351, 'Brikcha'),
(352, 'Chefchaouen'),
(353, 'Dar Bni Karrich'),
(354, 'Dar Chaoui'),
(355, 'Fnideq'),
(356, 'Gueznaia'),
(357, 'Jebha'),
(358, 'Karia'),
(359, 'Khémis Sahel'),
(360, 'Ksar El Kébir'),
(361, 'Larache'),
(362, 'Mdiq'),
(363, 'Martil'),
(364, 'Moqrisset'),
(365, 'Oued Laou'),
(366, 'Oued Rmel'),
(367, 'Ouazzane'),
(368, 'Point Cires'),
(369, 'Sidi Lyamani'),
(370, 'Sidi Mohamed ben Abdallah el-Raisuni'),
(371, 'Zinat'),
(372, 'Ajdir‎'),
(373, 'Aknoul‎'),
(374, 'Al Hoceïma‎'),
(375, 'Aït Hichem‎'),
(376, 'Bni Bouayach‎'),
(377, 'Bni Hadifa‎'),
(378, 'Ghafsai‎'),
(379, 'Guercif‎'),
(380, 'Imzouren‎'),
(381, 'Inahnahen‎'),
(382, 'Issaguen (Ketama)‎'),
(383, 'Karia (El Jadida)‎'),
(384, 'Karia Ba Mohamed‎'),
(385, 'Oued Amlil‎'),
(386, 'Oulad Zbair‎'),
(387, 'Tahla‎'),
(388, 'Tala Tazegwaght‎'),
(389, 'Tamassint‎'),
(390, 'Taounate‎'),
(391, 'Targuist‎'),
(392, 'Taza‎'),
(393, 'Taïnaste‎'),
(394, 'Thar Es-Souk‎'),
(395, 'Tissa‎'),
(396, 'Tizi Ouasli‎'),
(397, 'Laayoune‎'),
(398, 'El Marsa‎'),
(399, 'Tarfaya‎'),
(400, 'Boujdour‎'),
(401, 'Awsard'),
(402, 'Oued-Eddahab'),
(403, 'Stehat'),
(404, 'Aït Attab');
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
