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
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.admin : ~0 rows (environ)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
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
    KEY `FKrrnwynvawopofurxfkbgtrame` (`client_id`),
    KEY `FKsahshgfgf40qvn9u0w5dq4j86` (`delivery_id`),
    KEY `FK3034d4gqj9h171m81ebdqjroh` (`order_id`),
    CONSTRAINT `FK3034d4gqj9h171m81ebdqjroh` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
    CONSTRAINT `FKrrnwynvawopofurxfkbgtrame` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKsahshgfgf40qvn9u0w5dq4j86` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.chat : ~0 rows (environ)
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. client
CREATE TABLE IF NOT EXISTS `client` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_qe9dtj732yl9u3oqhhsee4lps` (`phone`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.client : ~0 rows (environ)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. delivery_man
CREATE TABLE IF NOT EXISTS `delivery_man` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_j6a8sbhehsoi45sba3frraeo5` (`phone`)
    ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.delivery_man : ~0 rows (environ)
/*!40000 ALTER TABLE `delivery_man` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_man` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. detail_order
CREATE TABLE IF NOT EXISTS `detail_order` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `product_code` varchar(255) NOT NULL,
    `order_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKjdf2te6dqo3a74nru9wknvcp8` (`order_id`),
    CONSTRAINT `FKjdf2te6dqo3a74nru9wknvcp8` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
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
    KEY `FK6dvcxo3ejhvvag2s0sidj13m1` (`client_id`),
    CONSTRAINT `FK6dvcxo3ejhvvag2s0sidj13m1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.historical_address : ~0 rows (environ)
/*!40000 ALTER TABLE `historical_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `historical_address` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. lk_pharmacy_permanent
CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent` (
    `pharmacy_id` int(11) NOT NULL,
    `permanent_id` int(11) NOT NULL,
    KEY `FKswg008p0q7l738tuxsfm8rdba` (`permanent_id`),
    KEY `FK80rdw8mib5wb3vde65wfhqtw4` (`pharmacy_id`),
    CONSTRAINT `FK80rdw8mib5wb3vde65wfhqtw4` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`),
    CONSTRAINT `FKswg008p0q7l738tuxsfm8rdba` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`)
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
    KEY `FK17yo6gry2nuwg2erwhbaxqbs9` (`client_id`),
    KEY `FKottfdcheyhpx5d6petq7v7u97` (`delivery_id`),
    KEY `FKttmxvmgcfr0cf63sb6w2vd9b` (`pharmacy_id`),
    CONSTRAINT `FK17yo6gry2nuwg2erwhbaxqbs9` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKottfdcheyhpx5d6petq7v7u97` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`),
    CONSTRAINT `FKttmxvmgcfr0cf63sb6w2vd9b` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.orders : ~0 rows (environ)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

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
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.permanent : ~0 rows (environ)
/*!40000 ALTER TABLE `permanent` DISABLE KEYS */;
/*!40000 ALTER TABLE `permanent` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `address` varchar(255) NOT NULL,
    `lat` double DEFAULT NULL,
    `lng` double DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `pharmacist` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.pharmacy : ~0 rows (environ)
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. product
CREATE TABLE IF NOT EXISTS `product` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `prescription` bit(1) NOT NULL,
    `price` double NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.product : ~0 rows (environ)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

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
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.review : ~0 rows (environ)
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
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
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.user : ~0 rows (environ)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Listage de la structure de la table pharma_connect. ville
CREATE TABLE IF NOT EXISTS `ville` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `ville` varchar(500) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8mb4;

-- Listage des données de la table pharma_connect.ville : ~0 rows (environ)
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
	(26, 'Oulad Mrah'),
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
	(182, 'Mhaya'),
(183, 'Mrirt'),
	(184, 'Midelt'),
	(185, 'Moulay Ali Cherif'),
	(186, 'Moulay Bouazza'),
	(187, 'Moulay Idriss Zerhoun'),
	(188, 'Moussaoua'),
	(189, 'NZalat Bni Amar'),
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
