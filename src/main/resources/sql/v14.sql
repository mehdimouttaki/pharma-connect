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
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.admin: ~2 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`) VALUES
(6),
(18);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.chat
CREATE TABLE IF NOT EXISTS `chat` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `created_at` datetime NOT NULL,
                                      `message` varchar(255) NOT NULL,
                                      `client_id` int(11) NOT NULL,
                                      `delivery_id` int(11) NOT NULL,
                                      `order_id` int(11) DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `pk_chat_client` (`client_id`) USING BTREE,
                                      KEY `pk_chat_delivery` (`delivery_id`) USING BTREE,
                                      KEY `pk_chat_order` (`order_id`) USING BTREE,
                                      CONSTRAINT `fk_chat_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE,
                                      CONSTRAINT `fk_chat_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE,
                                      CONSTRAINT `fk_chat_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.chat: ~4 rows (approximately)
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` (`id`, `created_at`, `message`, `client_id`, `delivery_id`, `order_id`) VALUES
(3, '2021-02-08 14:53:11', 'Merci', 12, 15, NULL),
(5, '2020-10-08 14:54:08', 'thanks', 43, 61, 10),
(6, '2019-09-08 14:55:30', 'bizarre', 50, 58, 7),
(7, '2020-11-08 14:56:49', 'good man ', 48, 58, 9);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.city
CREATE TABLE IF NOT EXISTS `city` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `city` varchar(100) NOT NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE KEY `uk_city` (`city`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.city: ~393 rows (approximately)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `city`) VALUES
(322, 'Afourar'),
(267, 'Agadir'),
(268, 'Agdz'),
(323, 'Aghbala'),
(269, 'Agni Izimmer'),
(152, 'Agourai'),
(205, 'Ahfir'),
(208, 'Aïn Bni Mathar'),
(59, 'Aïn Cheggag'),
(75, 'Aïn Dorij'),
(254, 'Ain El Aouda'),
(209, 'Aïn Erreggada'),
(1, 'Aïn Harrouda'),
(160, 'Aïn Jemaa'),
(161, 'Aïn Karma'),
(162, 'Aïn Leuh'),
(153, 'Ain Taoujdate'),
(404, 'Aït Attab'),
(276, 'Aït Baha'),
(163, 'Aït Boubidmane'),
(104, 'Ait Daoud'),
(375, 'Aït Hichem‎'),
(277, 'Aït Iaâza'),
(164, 'Aït Ishaq'),
(325, 'Aït Majden'),
(270, 'Aït Melloul'),
(117, 'Aït Ourir'),
(278, 'Aït Yalla'),
(372, 'Ajdir‎'),
(347, 'Akchour'),
(91, 'Akka'),
(206, 'Aklim'),
(373, 'Aknoul‎'),
(207, 'Al Aroui'),
(374, 'Al Hoceïma‎'),
(271, 'Alnif'),
(156, 'Amalou Ighriben'),
(115, 'Amizmiz'),
(272, 'Anzi'),
(157, 'Aoufous'),
(273, 'Aoulouz'),
(274, 'Aourir'),
(275, 'Arazane'),
(74, 'Arbaoua'),
(158, 'Arfoud'),
(92, 'Assa'),
(116, 'Assahrij'),
(348, 'Assilah'),
(401, 'Awsard'),
(33, 'Azemmour'),
(324, 'Azilal'),
(159, 'Azrou'),
(349, 'Bab Berred'),
(350, 'Bab Taza'),
(9, 'Bejaâd'),
(10, 'Ben Ahmed'),
(118, 'Ben Guerir'),
(279, 'Ben Sergao'),
(210, 'Ben Taïeb'),
(8, 'Ben Yakhlef'),
(326, 'Beni Ayat'),
(327, 'Béni Mellal'),
(11, 'Benslimane'),
(211, 'Berkane'),
(12, 'Berrechid'),
(60, 'Bhalil'),
(328, 'Bin elouidane'),
(280, 'Biougra'),
(34, 'Bir Jdid'),
(212, 'Bni Ansar'),
(376, 'Bni Bouayach‎'),
(213, 'Bni Chiker'),
(214, 'Bni Drar'),
(377, 'Bni Hadifa‎'),
(215, 'Bni Tadjite'),
(216, 'Bouanane'),
(217, 'Bouarfa'),
(165, 'Boudnib'),
(166, 'Boufakrane'),
(35, 'Bouguedra'),
(218, 'Bouhdila'),
(93, 'Bouizakarne'),
(400, 'Boujdour‎'),
(13, 'Boujniba'),
(14, 'Boulanouare'),
(61, 'Boulemane'),
(281, 'Boumalne-Dadès'),
(167, 'Boumia'),
(3, 'Bouskoura'),
(15, 'Bouznika'),
(329, 'Bradia'),
(351, 'Brikcha'),
(330, 'Bzou'),
(405, 'Casablanca'),
(352, 'Chefchaouen'),
(119, 'Chichaoua'),
(353, 'Dar Bni Karrich'),
(354, 'Dar Chaoui'),
(219, 'Dar El Kebdani'),
(76, 'Dar Gueddari'),
(331, 'Dar Oulad Zidouh'),
(282, 'Dcheira El Jihadia'),
(220, 'Debdou'),
(332, 'Demnate'),
(16, 'Deroua'),
(221, 'Douar Kannine'),
(333, 'Draa'),
(283, 'Drargua'),
(222, 'Driouch'),
(36, 'Echemmaia'),
(223, 'El Aïoun Sidi Mellouk'),
(17, 'El Borouj'),
(18, 'El Gara'),
(284, 'El Guerdane'),
(168, 'El Hajeb'),
(120, 'El Hanchane'),
(37, 'El Jadida'),
(121, 'El Kelaâ des Sraghna'),
(334, 'El Ksiba'),
(398, 'El Marsa‎'),
(62, 'El Menzel'),
(94, 'El Ouatia'),
(169, 'Elkbab'),
(170, 'Er-Rich'),
(171, 'Errachidia'),
(95, 'Es-Semara'),
(122, 'Essaouira'),
(96, 'Fam El Hisn'),
(224, 'Farkhana'),
(58, 'Fès'),
(225, 'Figuig'),
(355, 'Fnideq'),
(335, 'Foum Jamaa'),
(97, 'Foum Zguid'),
(336, 'Fquih Ben Salah'),
(123, 'Fraïta'),
(172, 'Gardmit'),
(378, 'Ghafsai‎'),
(124, 'Ghmate'),
(173, 'Goulmima'),
(174, 'Gourrama'),
(98, 'Guelmim'),
(379, 'Guercif‎'),
(356, 'Gueznaia'),
(63, 'Guigou'),
(19, 'Guisser'),
(175, 'Had Bouhssoussen'),
(77, 'Had Kourt'),
(176, 'Haj Kaddour'),
(255, 'Harhoura'),
(285, 'Harte Lyamine'),
(20, 'Hattane'),
(38, 'Hrara'),
(286, 'Ida Ougnidif'),
(177, 'Ifrane'),
(287, 'Ifri'),
(288, 'Igdamen'),
(289, 'Ighil nOumgoun'),
(39, 'Ighoud'),
(125, 'Ighounane'),
(226, 'Ihddaden'),
(290, 'Imassine'),
(126, 'Imintanoute'),
(64, 'Imouzzer Kandar'),
(65, 'Imouzzer Marmoucha'),
(380, 'Imzouren‎'),
(381, 'Inahnahen‎'),
(291, 'Inezgane'),
(292, 'Irherm'),
(382, 'Issaguen (Ketama)‎'),
(178, 'Itzer'),
(227, 'Jaâdar'),
(40, 'Jamâat Shaim'),
(357, 'Jebha'),
(228, 'Jerada'),
(179, 'Jorf'),
(78, 'Jorf El Melha'),
(41, 'Jorf Lasfar'),
(358, 'Karia'),
(383, 'Karia (El Jadida)‎'),
(384, 'Karia Ba Mohamed‎'),
(229, 'Kariat Arekmane'),
(337, 'Kasba Tadla'),
(230, 'Kassita'),
(127, 'Kattara'),
(180, 'Kehf Nsour'),
(293, 'Kelaat-MGouna'),
(79, 'Kénitra'),
(231, 'Kerouna'),
(181, 'Kerrouchen'),
(359, 'Khémis Sahel'),
(42, 'Khemis Zemamra'),
(256, 'Khémisset'),
(80, 'Khenichet'),
(151, 'Khénifra'),
(21, 'Khouribga'),
(360, 'Ksar El Kébir'),
(43, 'Laaounate'),
(232, 'Laâtamna'),
(130, 'Lâattaouia'),
(397, 'Laayoune‎'),
(294, 'Lakhsas'),
(295, 'Lakhsass'),
(81, 'Lalla Mimouna'),
(128, 'Lalla Takerkoust'),
(361, 'Larache'),
(129, 'Loudaya'),
(22, 'Loulad'),
(296, 'Lqliâa'),
(182, 'M\'haya'),
(183, 'M\'rirt'),
(233, 'Madagh'),
(103, 'Marrakech'),
(363, 'Martil'),
(298, 'Massa (Maroc)'),
(362, 'Mdiq'),
(82, 'Mechra Bel Ksiri'),
(5, 'Médiouna'),
(299, 'Megousse'),
(83, 'Mehdia'),
(150, 'Meknès‎'),
(234, 'Midar'),
(184, 'Midelt'),
(66, 'Missour'),
(6, 'Mohammadia'),
(364, 'Moqrisset'),
(44, 'Moulay Abdallah'),
(185, 'Moulay Ali Cherif'),
(186, 'Moulay Bouazza'),
(84, 'Moulay Bousselham'),
(131, 'Moulay Brahim'),
(187, 'Moulay Idriss Zerhoun'),
(67, 'Moulay Yaâcoub'),
(188, 'Moussaoua'),
(297, 'Msemrir'),
(154, 'MyAliCherif'),
(132, 'Mzouda'),
(189, 'Nalat Bni Amar'),
(235, 'Nador'),
(236, 'Naima'),
(45, 'Oualidia'),
(338, 'Ouaouizeght'),
(190, 'Ouaoumana'),
(300, 'Ouarzazate'),
(367, 'Ouazzane'),
(385, 'Oued Amlil‎'),
(237, 'Oued Heimer'),
(191, 'Oued Ifrane'),
(365, 'Oued Laou'),
(366, 'Oued Rmel'),
(23, 'Oued Zem'),
(402, 'Oued-Eddahab'),
(238, 'Oujda'),
(24, 'Oulad Abbou'),
(46, 'Oulad Amrane'),
(339, 'Oulad Ayad'),
(301, 'Oulad Berhil'),
(47, 'Oulad Frej'),
(48, 'Oulad Ghadbane'),
(25, 'Oulad HRiz Sahel'),
(26, 'Oulad M\rah'),
(340, 'Oulad MBarek'),
(27, 'Oulad Saïd'),
(28, 'Oulad Sidi Ben Daoud'),
(302, 'Oulad Teïma'),
(341, 'Oulad Yaich'),
(386, 'Oulad Zbair‎'),
(68, 'Ouled Tayeb'),
(257, 'Oulmès'),
(133, 'Ounagha'),
(69, 'Outat El Haj'),
(368, 'Point Cires'),
(252, 'Rabat'),
(29, 'Ras El Aïn'),
(239, 'Ras El Ma'),
(70, 'Ribate El Kheir'),
(155, 'Rissani'),
(258, 'Rommani'),
(192, 'Sabaa Aiyoun'),
(49, 'Safi'),
(240, 'Saïdia'),
(253, 'Salé'),
(303, 'Sarghine'),
(50, 'Sebt El Maârif'),
(51, 'Sebt Gzoula'),
(193, 'Sebt Jahjouh'),
(71, 'Séfrou'),
(241, 'Selouane'),
(30, 'Settat'),
(134, 'Sid LMokhtar'),
(135, 'Sid Zouin'),
(136, 'Sidi Abdallah Ghiat'),
(194, 'Sidi Addi'),
(52, 'Sidi Ahmed'),
(53, 'Sidi Ali Ban Hamdouche'),
(259, 'Sidi Allal El Bahraoui'),
(85, 'Sidi Allal Tazi'),
(54, 'Sidi Bennour'),
(137, 'Sidi Bou Othmane'),
(242, 'Sidi Boubker'),
(260, 'Sidi Bouknadel'),
(55, 'Sidi Bouzid'),
(304, 'Sidi Ifni'),
(342, 'Sidi Jaber'),
(86, 'Sidi Kacem'),
(369, 'Sidi Lyamani'),
(370, 'Sidi Mohamed ben Abdallah el-Raisuni'),
(138, 'Sidi Rahhal'),
(31, 'Sidi Rahhal Chataï'),
(87, 'Sidi Slimane'),
(243, 'Sidi Slimane Echcharaa'),
(56, 'Sidi Smaïl'),
(88, 'Sidi Taibi'),
(89, 'Sidi Yahya El Gharb'),
(72, 'Skhinate'),
(261, 'Skhirate'),
(139, 'Skhour Rehamna'),
(305, 'Skoura'),
(140, 'Smimou'),
(32, 'Soualem'),
(90, 'Souk El Arbaa'),
(343, 'Souk Sebt Oulad Nemma'),
(403, 'Stehat'),
(306, 'Tabounte'),
(73, 'Tafajight'),
(141, 'Tafetachte'),
(307, 'Tafraout'),
(99, 'Taghjijt'),
(308, 'Taghzout'),
(309, 'Tagzen'),
(142, 'Tahannaout'),
(387, 'Tahla‎'),
(393, 'Taïnaste‎'),
(388, 'Tala Tazegwaght‎'),
(310, 'Taliouine'),
(143, 'Talmest'),
(244, 'Talsint'),
(144, 'Tamallalt'),
(145, 'Tamanar'),
(146, 'Tamansourt'),
(389, 'Tamassint‎'),
(311, 'Tamegroute'),
(147, 'Tameslouht'),
(262, 'Tamesna'),
(312, 'Tamraght'),
(100, 'Tan-Tan'),
(148, 'Tanalt'),
(345, 'Tanger‎'),
(313, 'Tanoumrite Nkob Zagora'),
(390, 'Taounate‎'),
(245, 'Taourirt'),
(314, 'Taourirt ait zaghar'),
(399, 'Tarfaya‎'),
(391, 'Targuist‎'),
(315, 'Taroudannt'),
(101, 'Tata'),
(392, 'Taza‎'),
(263, 'Témara'),
(316, 'Temsia'),
(246, 'Tendrara'),
(346, 'Tétouan‎'),
(394, 'Thar Es-Souk‎'),
(195, 'Tichoute'),
(264, 'Tiddas'),
(265, 'Tiflet'),
(317, 'Tifnit'),
(196, 'Tighassaline'),
(197, 'Tighza'),
(198, 'Timahdite'),
(199, 'Tinejdad'),
(318, 'Tisgdal'),
(395, 'Tissa‎'),
(7, 'Tit Mellil'),
(200, 'Tizguite'),
(396, 'Tizi Ouasli‎'),
(319, 'Tiznit'),
(247, 'Tiztoutine'),
(266, 'Touarga'),
(248, 'Touima'),
(249, 'Touissit'),
(201, 'Toulal'),
(320, 'Toundoute'),
(202, 'Tounfite'),
(57, 'Youssoufia'),
(102, 'Zag'),
(321, 'Zagora'),
(204, 'Zaïda'),
(250, 'Zaïo'),
(203, 'Zaouia dIfrane'),
(344, 'Zaouïat Cheikh'),
(251, 'Zeghanghane'),
(149, 'Zeubelemok'),
(371, 'Zinat');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.client
CREATE TABLE IF NOT EXISTS `client` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `phone` varchar(255) NOT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `uk_client_phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.client: ~11 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `phone`) VALUES
(12, '0603060804'),
(43, '061111111'),
(53, '0612121212'),
(45, '06333333333'),
(46, '06444444444'),
(47, '06555555555'),
(48, '0666666666'),
(49, '067777777'),
(50, '068888888'),
(51, '069999999');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.delivery_man
CREATE TABLE IF NOT EXISTS `delivery_man` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `phone` varchar(255) NOT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE KEY `uk_delivery_man_phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.delivery_man: ~10 rows (approximately)
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

-- Dumping structure for table pharma_connect.detail_order
CREATE TABLE IF NOT EXISTS `detail_order` (
                                              `id` int(11) NOT NULL AUTO_INCREMENT,
                                              `product_code` varchar(255) NOT NULL,
                                              `order_id` int(11) NOT NULL,
                                              PRIMARY KEY (`id`),
                                              KEY `pk_detail_order_order` (`order_id`) USING BTREE,
                                              CONSTRAINT `fk_detail_order_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.detail_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `detail_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_order` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.historical_address
CREATE TABLE IF NOT EXISTS `historical_address` (
                                                    `id` int(11) NOT NULL AUTO_INCREMENT,
                                                    `address` varchar(255) NOT NULL,
                                                    `last_modified_date` datetime DEFAULT NULL,
                                                    `client_id` int(11) NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    KEY `pk_historical_address_client` (`client_id`) USING BTREE,
                                                    CONSTRAINT `fk_historical_adress_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.historical_address: ~0 rows (approximately)
/*!40000 ALTER TABLE `historical_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `historical_address` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.lk_pharmacy_permanent
CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent` (
                                                       `pharmacy_id` int(11) NOT NULL,
                                                       `permanent_id` int(11) NOT NULL,
                                                       KEY `pk_pharmacy_permanent_permanent` (`permanent_id`) USING BTREE,
                                                       KEY `pk_pharmacy_permanent_pharmacy` (`pharmacy_id`) USING BTREE,
                                                       CONSTRAINT `fk_pharmacy_permanent_permanent` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`),
                                                       CONSTRAINT `fk_pharmacy_permanent_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.lk_pharmacy_permanent: ~0 rows (approximately)
/*!40000 ALTER TABLE `lk_pharmacy_permanent` DISABLE KEYS */;
/*!40000 ALTER TABLE `lk_pharmacy_permanent` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.orders
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
                                        CONSTRAINT `fk_orders_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `fk_orders_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                        CONSTRAINT `fk_orders_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.orders: ~5 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `nbr_product`, `price`, `client_id`, `delivery_id`, `pharmacy_id`) VALUES
(7, 8, 390.76, 12, 15, 6),
(9, 5, 156.84, 45, 14, 9),
(10, 7, 245, 47, 59, 8),
(11, 3, 88.67, 51, 60, 11),
(12, 8, 56.78, 49, 14, 10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.payment
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

-- Dumping data for table pharma_connect.payment: ~0 rows (approximately)
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.permanent
CREATE TABLE IF NOT EXISTS `permanent` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT,
                                           `end_date` datetime NOT NULL,
                                           `start_date` datetime NOT NULL,
                                           `type` varchar(255) NOT NULL,
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.permanent: ~3 rows (approximately)
/*!40000 ALTER TABLE `permanent` DISABLE KEYS */;
INSERT INTO `permanent` (`id`, `end_date`, `start_date`, `type`) VALUES
(3, '2021-02-08 14:57:53', '2021-02-24 14:57:56', 'DAY'),
(4, '2021-03-08 14:58:18', '2021-04-08 14:58:26', 'NIGHT'),
(5, '2020-02-08 14:58:43', '2020-02-16 14:58:49', 'DAY');
/*!40000 ALTER TABLE `permanent` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
                                          `address` varchar(255) NOT NULL,
                                          `lat` double DEFAULT NULL,
                                          `lng` double DEFAULT NULL,
                                          `name` varchar(255) NOT NULL,
                                          `pharmacist` varchar(255) DEFAULT NULL,
                                          `city` varchar(100) NOT NULL,
                                          PRIMARY KEY (`id`),
                                          KEY `FK_pharmacy_city` (`city`) USING BTREE,
                                          CONSTRAINT `FK_pharmacy_city` FOREIGN KEY (`city`) REFERENCES `city` (`city`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.pharmacy: ~10 rows (approximately)
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` (`id`, `address`, `lat`, `lng`, `name`, `pharmacist`, `city`) VALUES
(6, 'lissasfa', 9.77, -7.092, 'othman', 'abdo', 'Casablanca'),
(7, 'oulfa', 17, -89, 'naha', 'rida', 'Casablanca'),
(8, 'zoubir', 16.788, -12.77, 'alakhwayn', 'fatiha', 'Agdz'),
(9, 'anfa', 5.98, -78.99, 'Habiba', 'hassan', 'Agadir'),
(10, 'Dar 16', NULL, NULL, 'Falah', 'khadija', 'Aghbala'),
(11, 'sidi rihal', NULL, NULL, 'zraktouni', 'mohamed', 'Agourai'),
(12, 'bouskoura', 7.988, -34.88, 'boustan', 'moughit', 'Bouskoura'),
(13, 'sidi Maroof', 67.84, -56.78, 'warda', 'youssef', 'Agourai'),
(15, 'SALAM', NULL, NULL, 'SALAM', 'SALAM', 'Afourar'),
(16, 'SALAM', NULL, NULL, 'SALAM', 'SALAM', 'Afourar');
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.product
CREATE TABLE IF NOT EXISTS `product` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT,
                                         `code` varchar(255) NOT NULL,
                                         `name` varchar(255) NOT NULL,
                                         `prescription` bit(1) NOT NULL,
                                         `price` double NOT NULL,
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.product: ~9 rows (approximately)
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

-- Dumping structure for table pharma_connect.review
CREATE TABLE IF NOT EXISTS `review` (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `rate` int(5) DEFAULT NULL,
                                        `review` varchar(100) DEFAULT NULL,
                                        `client_id` int(11) NOT NULL,
                                        `delivery_id` int(11) NOT NULL,
                                        `order_id` int(11) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `pk_review_client` (`client_id`) USING BTREE,
                                        KEY `pk_review_delivery` (`delivery_id`) USING BTREE,
                                        KEY `pk_review_order` (`order_id`) USING BTREE,
                                        CONSTRAINT `fk_review_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE,
                                        CONSTRAINT `fk_review_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE,
                                        CONSTRAINT `fk_review_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table pharma_connect.review: ~3 rows (approximately)
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` (`id`, `rate`, `review`, `client_id`, `delivery_id`, `order_id`) VALUES
(8, 0, '5', 12, 15, NULL),
(12, 0, '1', 53, 60, 11),
(14, 0, '5', 51, 56, 9);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

-- Dumping structure for table pharma_connect.user
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

-- Dumping data for table pharma_connect.user: ~18 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `first_name`, `last_name`) VALUES
(18, 'admin', '$2a$10$.tRRcd7IPTbKvO.KRwb0.Ot1Yg3gSUfm3RdPVEHJeCNv2tsFRghuy', 'ADMIN', 'Mehdi', 'Mouttaki'),
(43, 'mehdimouttaki99@gmail.com', '$2a$10$l9Npvq1ENjpIpyH5XM7KI.XR6ogtkzBApy.uZ.dB3X1jgvO.G0cLW', 'CLIENT', 'mehdi', 'mouttaki'),
(45, 'moughitmoustain@gmail.com', '$2a$10$wXMiagEA.6JAraWdrFCuZOszzJFJ3w6TYje.4fJGvBrr6am0n2HYq', 'CLIENT', 'moughit', 'mostain'),
(46, 'youssefnajeh@gmail.com', '$2a$10$6Wb0Lq6sVjfbCUmXWFt5x.FaOipQGFBdRxTQmptbXFhRxcXbvnu6.', 'CLIENT', 'youssef', 'najeh'),
(47, 'abdomostain@gmail.com', '$2a$10$yot121GaXDlN1KjqljyJt.85wEhF4GneeRARIXaj3jdKPB8aVknGm', 'CLIENT', 'abdejlil', 'moustain'),
(48, 'youssefelkaoumi@gmail.com', '$2a$10$Fp6F/tCQg7HjtmT9g3zILegHlwYxMaz5QxNGscCVhEM37CmmNlj.e', 'CLIENT', 'youssef', 'elkaoumi'),
(49, 'omarelkaoumi@gmail.com', '$2a$10$1CQPsKzvaJ8kezk1xR/2L.6ZgpCYFtPMHKGBf6TXYV/NJn0I/ByMe', 'CLIENT', 'omar', 'elkaoumi'),
(50, 'saidelgarch@gmail.com', '$2a$10$WjHcmvdgdC80BubSwmAR5uoFrHQvYCiH1Mjp1EY/fe4TC.KFoXh3u', 'CLIENT', 'said', 'elgerch'),
(51, 'mouadbaso@gmail.com', '$2a$10$wp6QKntLUzA1.qMeY36f6.IDgRgtDx5KAG5rSeoorX0CM82T0XC3G', 'CLIENT', 'mouad', 'baso'),
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

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
