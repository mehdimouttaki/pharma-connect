CREATE TABLE IF NOT EXISTS `user`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `username`   varchar(200) NOT NULL,
    `password`   varchar(255) NOT NULL,
    `role`       varchar(20)  NOT NULL DEFAULT 'CLIENT',
    `first_name` varchar(200) NOT NULL,
    `last_name`  varchar(200) NOT NULL,
    `created_at` datetime     NOT NULL DEFAULT current_timestamp(),
    `status`     varchar(20)  NOT NULL DEFAULT 'ACTIVE',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`) USING BTREE
);

CREATE TABLE IF NOT EXISTS `admin`
(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `city`
(
    `id`   int(11)      NOT NULL AUTO_INCREMENT,
    `city` varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_city` (`city`) USING BTREE
);

CREATE TABLE IF NOT EXISTS `client`
(
    `id`    int(11)      NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_client_phone` (`phone`) USING BTREE
);

CREATE TABLE IF NOT EXISTS `historical_address`
(
    `id`                 int(11)      NOT NULL AUTO_INCREMENT,
    `address`            varchar(255) NOT NULL,
    `last_modified_date` datetime DEFAULT NULL,
    `client_id`          int(11)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_historical_address_client` (`client_id`) USING BTREE,
    CONSTRAINT `fk_historical_address_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `delivery_man`
(
    `id`    int(11)      NOT NULL AUTO_INCREMENT,
    `phone` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_delivery_man_phone` (`phone`) USING BTREE
);

CREATE TABLE IF NOT EXISTS `pharmacy`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `address`    varchar(255) NOT NULL,
    `lat`        double       DEFAULT NULL,
    `lng`        double       DEFAULT NULL,
    `name`       varchar(255) NOT NULL,
    `pharmacist` varchar(255) DEFAULT NULL,
    `city`       varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_pharmacy_city` (`city`) USING BTREE,
    CONSTRAINT `FK_pharmacy_city` FOREIGN KEY (`city`) REFERENCES `city` (`city`) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `product`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT,
    `code`         varchar(255) NOT NULL,
    `name`         varchar(255) NOT NULL,
    `prescription` bit(1)       NOT NULL,
    `price`        double       NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_product_code` (`code`)
);

CREATE TABLE IF NOT EXISTS `orders`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `price`       double       NOT NULL,
    `client_id`   int(11)      NOT NULL,
    `delivery_id` int(11) DEFAULT NULL,
    `pharmacy_id` int(11) DEFAULT NULL,
    `address`     varchar(200) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_orders_client` (`client_id`) USING BTREE,
    KEY `pk_orders_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_orders_pharmacy` (`pharmacy_id`) USING BTREE,
    CONSTRAINT `fk_orders_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_orders_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_orders_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `detail_order`
(
    `id`           int(11)      NOT NULL AUTO_INCREMENT,
    `product_code` varchar(255) NOT NULL,
    `order_id`     int(11) DEFAULT NULL,
    `nbr_product`  int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_detail_order_order` (`order_id`) USING BTREE,
    KEY `fk_detail_order_product` (`product_code`),
    CONSTRAINT `fk_detail_order_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL,
    CONSTRAINT `fk_detail_order_product` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `payment`
(
    `id`       int(11)     NOT NULL AUTO_INCREMENT,
    `method`   varchar(20) NOT NULL,
    `status`   varchar(20) NOT NULL,
    `order_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_payment_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_payment_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `chat`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `created_at`  datetime     NOT NULL,
    `message`     varchar(255) NOT NULL,
    `client_id`   int(11)      NOT NULL,
    `delivery_id` int(11)      NOT NULL,
    `order_id`    int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_chat_client` (`client_id`) USING BTREE,
    KEY `pk_chat_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_chat_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_chat_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_chat_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_chat_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `permanent`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `end_date`   datetime     NOT NULL,
    `start_date` datetime     NOT NULL,
    `type`       varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `lk_pharmacy_permanent`
(
    `pharmacy_id`  int(11) NOT NULL,
    `permanent_id` int(11) NOT NULL,
    KEY `fk_pharmacy_permanent_permanent` (`permanent_id`) USING BTREE,
    KEY `fk_pharmacy_permanent_pharmacy` (`pharmacy_id`) USING BTREE,
    CONSTRAINT `Ffk_pharmacy_permanent_permanent` FOREIGN KEY (`permanent_id`) REFERENCES `permanent` (`id`) ON DELETE CASCADE,
    CONSTRAINT `Ffk_pharmacy_permanent_pharmacy` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `review`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `rate`        int(5)       DEFAULT NULL,
    `label`       varchar(100) DEFAULT NULL,
    `client_id`   int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `order_id`    int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `pk_review_client` (`client_id`) USING BTREE,
    KEY `pk_review_delivery` (`delivery_id`) USING BTREE,
    KEY `pk_review_order` (`order_id`) USING BTREE,
    CONSTRAINT `fk_review_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_review_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_review_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE SET NULL
);
