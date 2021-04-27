SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int AUTO_INCREMENT NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` float NOT NULL,
  `desp` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `goods` VALUES (1, '手机', 2000.00, '黑色，存储容量32G');
INSERT INTO `goods` VALUES (2, '冰箱', 1500.00, '银色，对门开');
INSERT INTO `goods` VALUES (3, '洗衣机', 3000.00, '滚筒');
INSERT INTO `goods` VALUES (4, '空调', 4000.00, '变频空调');

SET FOREIGN_KEY_CHECKS = 1;
