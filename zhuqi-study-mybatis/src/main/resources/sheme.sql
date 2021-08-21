
DROP TABLE IF EXISTS `boot_user`;

CREATE TABLE `boot_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `boot_user` WRITE;
/*!40000 ALTER TABLE `boot_user` DISABLE KEYS */;

INSERT INTO `boot_user` (`id`, `name`, `tel`, `create_time`)
VALUES
	(1,'klay','13799008800','2016-06-27 00:01:39'),
	(2,'Tome','18988991234','2016-06-27 00:35:28'),
	(3,'smallerpig','13771010000','2018-07-25 00:00:00'),
	(4,'smallerpig','13771010000','2018-07-25 00:00:00'),
	(5,'smallerpig','13771010001','2018-07-25 00:00:00'),
	(6,'smallerpig','13771010001','2018-07-25 00:00:00');

/*!40000 ALTER TABLE `boot_user` ENABLE KEYS */;
UNLOCK TABLES;


