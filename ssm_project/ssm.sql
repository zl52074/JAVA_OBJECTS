/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`id`,`NAME`,`nickname`,`phoneNum`,`email`) values ('m001','李四','笑死','001001001','001@qq.com'),('m002','张飞','啊飞','002002002','002@qq.com'),('m003','王五','小五','003003003','003@qq.com'),('m004','张三','小三','004004004','004@qq.com');

/*Table structure for table `order_traveller` */

DROP TABLE IF EXISTS `order_traveller`;

CREATE TABLE `order_traveller` (
  `orderId` varchar(32) NOT NULL DEFAULT '',
  `travellerId` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`orderId`,`travellerId`),
  KEY `travellerId` (`travellerId`),
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_traveller` */

insert  into `order_traveller`(`orderId`,`travellerId`) values ('o001','t001'),('o003','t001'),('o006','t001'),('o007','t001'),('o001','t002'),('o003','t002'),('o006','t002'),('o007','t002'),('o008','t002'),('o001','t003'),('o009','t003'),('o002','t004'),('o004','t004'),('o006','t004'),('o002','t005'),('o005','t005'),('o006','t005'),('o008','t005');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` varchar(32) NOT NULL,
  `orderNum` varchar(20) NOT NULL,
  `orderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `peopleCount` int(11) DEFAULT NULL,
  `orderDesc` varchar(500) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `productId` varchar(32) DEFAULT NULL,
  `memberId` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNum` (`orderNum`),
  KEY `productId` (`productId`),
  KEY `memberId` (`memberId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`orderNum`,`orderTime`,`peopleCount`,`orderDesc`,`payType`,`orderStatus`,`productId`,`memberId`) values ('o001','001','2019-10-02 16:56:36',3,'订单001',1,1,'p001','m001'),('o002','002','2019-10-02 16:47:17',2,'订单002',0,0,'p002','m002'),('o003','003','2019-10-02 16:56:30',2,'订单003',0,1,'p003','m003'),('o004','004','2019-10-02 16:56:26',1,'订单004',1,0,'p004','m004'),('o005','005','2019-10-02 16:56:31',1,'订单005',0,1,'p005','m004'),('o006','006','2019-10-02 16:51:28',4,'订单006',1,0,'p006','m001'),('o007','007','2019-12-19 16:52:10',2,'订单007',2,0,'p007','m001'),('o008','008','2019-10-02 16:56:33',2,'订单008',1,1,'p008','m002'),('o009','009','2019-11-01 16:54:53',1,'订单001',0,0,'p009','m003');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` varchar(32) NOT NULL,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`id`,`permissionName`,`url`) values ('140d94863fcb4eb3bb34b3e35fd3549c','删除订单','/orders/delete.do'),('16d4931e350240c0b5878f9090ed44eb','删除角色','/role/deleteRole.do'),('295e2a87aa164865bec0230d3faa9dac','添加产品','/product/save.do'),('46fb1d691f254e0f91c97c95aea4a8ec','添加用户','/users/save.do'),('51871f6ab2e34fa494fa80c154142340','角色分配权限','/role/addPermissionToRole.do'),('51a6ff901d104bf3967a431610222582','查询权限','/permission/findAll.do'),('57922c0d689a4e788955a7b6d56bc2d7','查询角色','/role/findAll.do'),('5a71d74821ee4b7fba5f80f5093b747e','用户分配角色','/users/addRoleToUser.do'),('6c227e4edd9642dfa3b599cd25b62567','删除产品','/product/delete.do'),('70403369016340dca13868ee62bcd708','添加角色','/role/save.do'),('896d7f3081264db79c44155ca1900e51','查询产品','/product/findAll.do'),('927c9e95ae4048f1aa6c0a6f5ffe7491','删除用户','/users/deleteUser.do'),('b13f76b455dd4de7b32bbbfd7cc0f561','查询用户','/users/findAll.do'),('b75b64f94a7943b0bd21955889b984e0','查询订单','/orders/findAll.do'),('c97c4b8413b143299c29fbc705a737b0','删除权限','/permission/deletePermission.do'),('cbff1ac40efb4768be2409d7eefd7b30','编辑产品','/product/edit.do'),('eb30fa29051d4df8a7d71dd81a6c7d13','添加权限','/permission/save.do'),('ec7061349e2249859ab5c01569793ac4','查询订单详情','/orders/findById.do');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` varchar(32) NOT NULL,
  `productNum` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `DepartureTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `productPrice` double DEFAULT NULL,
  `productDesc` varchar(500) DEFAULT NULL,
  `productStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product` (`id`,`productNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values ('289e6ebf9cf949178296533f2cdf0324','001','背景','是是是','2019-10-02 09:25:00',222,'换行',1),('b6f9cb26273e4c308e2606cc1668a4ad','001','背景','是是是','2019-10-02 09:25:00',222,'嘎嘎嘎嘎嘎\r\n							',0),('p001','001','产品1','城市1','2019-10-02 16:36:00',1999,'产品一产品一产品一产品一产品一\r\n							\r\n							',0),('p002','002','产品2','城市2','2019-10-02 16:37:42',2999,'产品二产品二产品二产品二产品二',1),('p003','003','产品3','城市3','2019-10-02 16:38:53',3999,'产品三产品三产品三产品三产品三',1),('p004','004','产品4','城市4','2019-10-10 16:39:09',4999,'产品四产品四产品四产品四产品四',1),('p005','005','产品5','城市5','2019-10-10 16:39:40',5999,'产品五产品五产品五产品五产品五',1),('p006','006','产品6','城市6','2019-10-01 16:40:12',6999,'产品六产品六产品六产品六产品六',1),('p007','007','产品7','城市7','2019-10-17 16:40:47',7999,'产品七产品七产品七产品七产品七',1),('p008','008','产品8','城市8','2019-10-10 16:41:46',8999,'产品八产品八产品八产品八产品八',1),('p009','009','产品9','城市9','2019-10-02 16:42:47',9999,'产品九产品九产品九产品九产品九',1),('p010','010','产品10','城市10','2019-10-02 16:44:06',10999,'产品十产品十产品十产品十产品十',0),('p011','011','产品11','城市11','2019-10-02 16:44:26',11999,'产品十一产品十一产品十一产品十一',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`,`roleDesc`) values ('3f7400cf17954a388e2cb2bdc9d5ba6e','ADMIN','ADMIN'),('528ec8d2955147c0966dc7572f2ddd9f','USER','USER'),('cb44171750584144b9c04124966a054a','VISITOR','VISITOR');

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `permissionId` varchar(32) NOT NULL DEFAULT '',
  `roleId` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`permissionId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_permission` */

insert  into `role_permission`(`permissionId`,`roleId`) values ('140d94863fcb4eb3bb34b3e35fd3549c','3f7400cf17954a388e2cb2bdc9d5ba6e'),('16d4931e350240c0b5878f9090ed44eb','3f7400cf17954a388e2cb2bdc9d5ba6e'),('295e2a87aa164865bec0230d3faa9dac','3f7400cf17954a388e2cb2bdc9d5ba6e'),('46fb1d691f254e0f91c97c95aea4a8ec','3f7400cf17954a388e2cb2bdc9d5ba6e'),('51871f6ab2e34fa494fa80c154142340','3f7400cf17954a388e2cb2bdc9d5ba6e'),('51a6ff901d104bf3967a431610222582','3f7400cf17954a388e2cb2bdc9d5ba6e'),('57922c0d689a4e788955a7b6d56bc2d7','3f7400cf17954a388e2cb2bdc9d5ba6e'),('5a71d74821ee4b7fba5f80f5093b747e','3f7400cf17954a388e2cb2bdc9d5ba6e'),('6c227e4edd9642dfa3b599cd25b62567','3f7400cf17954a388e2cb2bdc9d5ba6e'),('70403369016340dca13868ee62bcd708','3f7400cf17954a388e2cb2bdc9d5ba6e'),('896d7f3081264db79c44155ca1900e51','3f7400cf17954a388e2cb2bdc9d5ba6e'),('927c9e95ae4048f1aa6c0a6f5ffe7491','3f7400cf17954a388e2cb2bdc9d5ba6e'),('b13f76b455dd4de7b32bbbfd7cc0f561','3f7400cf17954a388e2cb2bdc9d5ba6e'),('b75b64f94a7943b0bd21955889b984e0','3f7400cf17954a388e2cb2bdc9d5ba6e'),('c97c4b8413b143299c29fbc705a737b0','3f7400cf17954a388e2cb2bdc9d5ba6e'),('cbff1ac40efb4768be2409d7eefd7b30','3f7400cf17954a388e2cb2bdc9d5ba6e'),('eb30fa29051d4df8a7d71dd81a6c7d13','3f7400cf17954a388e2cb2bdc9d5ba6e'),('ec7061349e2249859ab5c01569793ac4','3f7400cf17954a388e2cb2bdc9d5ba6e'),('140d94863fcb4eb3bb34b3e35fd3549c','528ec8d2955147c0966dc7572f2ddd9f'),('295e2a87aa164865bec0230d3faa9dac','528ec8d2955147c0966dc7572f2ddd9f'),('51a6ff901d104bf3967a431610222582','528ec8d2955147c0966dc7572f2ddd9f'),('57922c0d689a4e788955a7b6d56bc2d7','528ec8d2955147c0966dc7572f2ddd9f'),('6c227e4edd9642dfa3b599cd25b62567','528ec8d2955147c0966dc7572f2ddd9f'),('896d7f3081264db79c44155ca1900e51','528ec8d2955147c0966dc7572f2ddd9f'),('927c9e95ae4048f1aa6c0a6f5ffe7491','528ec8d2955147c0966dc7572f2ddd9f'),('b13f76b455dd4de7b32bbbfd7cc0f561','528ec8d2955147c0966dc7572f2ddd9f'),('b75b64f94a7943b0bd21955889b984e0','528ec8d2955147c0966dc7572f2ddd9f'),('cbff1ac40efb4768be2409d7eefd7b30','528ec8d2955147c0966dc7572f2ddd9f'),('ec7061349e2249859ab5c01569793ac4','528ec8d2955147c0966dc7572f2ddd9f'),('896d7f3081264db79c44155ca1900e51','cb44171750584144b9c04124966a054a'),('b75b64f94a7943b0bd21955889b984e0','cb44171750584144b9c04124966a054a'),('ec7061349e2249859ab5c01569793ac4','cb44171750584144b9c04124966a054a');

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `id` varchar(32) NOT NULL,
  `visitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `executionTime` int(11) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syslog` */

/*Table structure for table `traveller` */

DROP TABLE IF EXISTS `traveller`;

CREATE TABLE `traveller` (
  `id` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `credentialsType` int(11) DEFAULT NULL,
  `credentialsNum` varchar(50) DEFAULT NULL,
  `travellerType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `traveller` */

insert  into `traveller`(`id`,`NAME`,`sex`,`phoneNum`,`credentialsType`,`credentialsNum`,`travellerType`) values ('t001','汤姆','男','001001001',0,'001001001001',1),('t002','成龙','男','002002002',1,'002002002002',0),('t003','李彪','男 ','003003003',2,'003003003003',0),('t004','张小龙','男','004004004',0,'004004004004',1),('t005','张龙','男','004005005',0,'005005005005',0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`email`,`username`,`PASSWORD`,`phoneNum`,`STATUS`) values ('aa2c925603b546d7985d543d9dd90042','user@qq.com','user','$2a$10$RMWHSD7zB6MTNq7bV7c.du3.GNfARDtnFOj5A4FytOWGU9Jfaq3pu','002002002002',1),('c08e32923ce74893a11a142e45f9e3e0','visitor@qq.com','visitor','$2a$10$JCZWYakG6bTq.FncKbV8JuCPyvsg.ykYQGzmszorHEpy5uu/oa0oq','003003003003',1),('ebe019c44215473e8413e81d64ffd29e','admin@qq.com','admin','$2a$10$gdbe.SyHUOEZ8jVCIyZ82.CsJ0iC0Vs0NxaB4oBkdNr7ONC8edfgS','001001001001',1);

/*Table structure for table `users_role` */

DROP TABLE IF EXISTS `users_role`;

CREATE TABLE `users_role` (
  `userId` varchar(32) NOT NULL DEFAULT '',
  `roleId` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users_role` */

insert  into `users_role`(`userId`,`roleId`) values ('ebe019c44215473e8413e81d64ffd29e','3f7400cf17954a388e2cb2bdc9d5ba6e'),('aa2c925603b546d7985d543d9dd90042','528ec8d2955147c0966dc7572f2ddd9f'),('ebe019c44215473e8413e81d64ffd29e','528ec8d2955147c0966dc7572f2ddd9f'),('aa2c925603b546d7985d543d9dd90042','cb44171750584144b9c04124966a054a'),('c08e32923ce74893a11a142e45f9e3e0','cb44171750584144b9c04124966a054a'),('ebe019c44215473e8413e81d64ffd29e','cb44171750584144b9c04124966a054a');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
