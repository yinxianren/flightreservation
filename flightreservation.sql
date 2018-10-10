/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.23 : Database - flightreservation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flightreservation` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `flightreservation`;

/*Table structure for table `fr_company` */

DROP TABLE IF EXISTS `fr_company`;

CREATE TABLE `fr_company` (
  `cpy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `cpy_com_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '公司名称',
  `cpy_com_sh_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '公司简称',
  `cpy_reg_addr` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '注册地址',
  `cpy_bus_lic` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '营业执照号',
  `cpy_legal_rep` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '法定代表人',
  `cpy_legal_rep_num` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '法定代表人身份证号码',
  `cpy_ind_type` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '行业类型',
  `cpy_bus_sco` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '经营范围',
  `cpy_web_addr` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '网址',
  `cpy_icp_num` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT 'ipc备案号',
  `cpy_bank_acc_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '银行开户名',
  `cpy_bank_num` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '卡号',
  `cpy_bank_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '开户银行',
  `c_date` datetime NOT NULL COMMENT '创建时间',
  `up_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`cpy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='公司表';

/*Data for the table `fr_company` */

insert  into `fr_company`(`cpy_id`,`cpy_com_name`,`cpy_com_sh_name`,`cpy_reg_addr`,`cpy_bus_lic`,`cpy_legal_rep`,`cpy_legal_rep_num`,`cpy_ind_type`,`cpy_bus_sco`,`cpy_web_addr`,`cpy_icp_num`,`cpy_bank_acc_name`,`cpy_bank_num`,`cpy_bank_name`,`c_date`,`up_date`) values (10000,'厦门思满朵艺术设计有限公司','思满朵','福建省厦门市思明区吕岭路2号B36之四','91350203MA2YF9NB4Q','刘辉','230222**********0614','其他','文化、艺术活动策划；','http://www.xmsmdys.top','闽ICP备04000001号','厦门思满朵艺术设计有限公司','403450*********6802','中国农业银行股份有限公司厦门槟榔支行','2018-08-20 11:34:00','2018-09-04 10:33:04'),(10002,'厦门研丽贸易有限公司','研丽','福建省厦门市思明区吕岭路2号B36之四','91350203MA2YF9NB4Q','研丽','350425188905052536','其他','文化、艺术活动策划；专业化设计服务；其他文化用品批发；文具用品批发；','http://www.xmsmdys.top','闽ICP备04000001号','厦门研丽贸易有限公司','45856987452255874','中国农业银行股份有限公司厦门槟榔支行','2018-08-20 11:34:00','2018-09-12 11:52:12'),(10003,'读者出版传媒股份有限公司','读者出版传媒股份有限公司','甘肃省兰州市城关区南滨河东路520号','91620000079251370M','马建东','350425197806012638','新闻和出版业','教育、图书出版；','','','读者出版传媒股份有限公司','51458745269874525','中国农业银行股份有限公司厦门槟榔支行','2018-09-05 17:33:48','2018-09-05 17:33:48');

/*Table structure for table `fr_dep` */

DROP TABLE IF EXISTS `fr_dep`;

CREATE TABLE `fr_dep` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `dep_company` int(11) NOT NULL COMMENT '所属公司',
  `dep_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '部门名',
  `dep_pricipal` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '部门负责人',
  `dep_abbreviation` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '部门简称',
  `dep_addr` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '部门地址',
  `dep_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '部门电话',
  `description` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dep_id`),
  KEY `fk_dep_company` (`dep_company`),
  CONSTRAINT `fk_dep_company` FOREIGN KEY (`dep_company`) REFERENCES `fr_company` (`cpy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';

/*Data for the table `fr_dep` */

insert  into `fr_dep`(`dep_id`,`dep_company`,`dep_name`,`dep_pricipal`,`dep_abbreviation`,`dep_addr`,`dep_phone`,`description`,`c_date`,`up_date`) values (10000,10000,'财务部','郭靖','MD','福建省厦门市思明区镇海路民盛大厦8楼804','17805089928','打造新的财务部，让部门发扬光大','2018-08-20 11:34:00','2018-09-05 16:02:27'),(10001,10000,'市场部','王五六','FD','福建省厦门市思明区镇海路民盛大厦8楼804','17805089958','企业发展的关键部门','2018-08-20 11:34:00','2018-08-20 11:34:00');

/*Table structure for table `fr_photo` */

DROP TABLE IF EXISTS `fr_photo`;

CREATE TABLE `fr_photo` (
  `ph_id` int(11) NOT NULL,
  `ph_usr_id` int(11) NOT NULL COMMENT '对应的账户id',
  `ph_host` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '保存主机IP',
  `ph_domain_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '主机域名',
  `ph_old_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '老名字',
  `ph_new_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '新名字',
  `ph_save_path` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '图片保存的路径',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(2) NOT NULL DEFAULT '1' COMMENT '是否已经删除，0表示已经删除，1表示未删除',
  PRIMARY KEY (`ph_id`),
  KEY `fk_account_photo` (`ph_usr_id`),
  CONSTRAINT `fk_account_photo` FOREIGN KEY (`ph_usr_id`) REFERENCES `fr_user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='照片表';

/*Data for the table `fr_photo` */

insert  into `fr_photo`(`ph_id`,`ph_usr_id`,`ph_host`,`ph_domain_name`,`ph_old_name`,`ph_new_name`,`ph_save_path`,`c_date`,`up_date`,`is_delete`) values (22,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','身份证反.jpg','dm1.jpg','asdfs/demo/','2018-09-29 19:01:41','2018-09-14 19:01:41',0),(23,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','詹光活-反.jpg','d02.jpg','asdfs/demo/','2018-09-29 19:02:20','2018-09-06 19:02:20',0),(24,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','郭佳滨1.jpg','do3.jpg','asdfs/demo/','2018-09-29 19:02:20','2018-09-29 19:02:20',1),(25,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','承诺书.jpg','图片1.jpg','asdfs/图片/','2018-09-29 19:10:12','2018-02-23 19:10:12',0),(26,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','816866617121191303.png','测试1.png','asdfs/测试/','2018-09-29 19:11:24','2018-09-29 19:11:24',1),(27,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','e914d5e3372e45e - 副本.jpg','成都市.jpg','asdfs/测试/','2018-09-29 19:11:24','2018-09-02 19:11:24',1),(28,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','创码.jpg','图片1.jpg','asdfs/图片/','2018-09-29 19:11:24','2018-09-29 19:11:24',0),(29,10004,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','天启文.jpg','多少.jpg','asdfs/测试/','2018-09-29 19:11:24','2018-07-21 19:11:24',1),(30,10008,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','微信图片_20180801143435.jpg','身份证.jpg','sudo/图片/','2018-09-30 08:37:03','2018-09-30 08:37:03',1),(31,10008,'192.168.0.120','http://2197b82t91.iask.in:8080/images/','创码.jpg','logo.jpg','sudo/文件/','2018-09-30 08:37:34','2018-09-30 08:37:34',1);

/*Table structure for table `fr_photo_title` */

DROP TABLE IF EXISTS `fr_photo_title`;

CREATE TABLE `fr_photo_title` (
  `pt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pt_usr_id` int(11) NOT NULL COMMENT '对应的账户id',
  `pt_title` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(2) NOT NULL DEFAULT '1' COMMENT '是否已经删除，0表示已经删除，1表示未删除',
  PRIMARY KEY (`pt_id`),
  KEY `fk_account_title` (`pt_usr_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户图片路径之title';

/*Data for the table `fr_photo_title` */

insert  into `fr_photo_title`(`pt_id`,`pt_usr_id`,`pt_title`,`c_date`,`up_date`,`is_delete`) values (13,10008,'文件','2018-09-30 08:36:43','2018-09-30 08:36:43',1),(12,10008,'图片','2018-09-30 08:36:37','2018-09-30 08:36:37',1),(11,10004,'测试','2018-09-29 19:10:46','2018-09-29 19:10:46',1),(10,10004,'图片','2018-09-29 19:09:53','2018-09-29 19:09:53',1),(9,10004,'demo','2018-09-29 19:01:25','2018-09-29 19:01:25',1),(14,10007,'图片','2018-10-09 11:25:43','2018-10-09 11:25:43',1);

/*Table structure for table `fr_user` */

DROP TABLE IF EXISTS `fr_user`;

CREATE TABLE `fr_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `u_account` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '账号名',
  `u_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `u_password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `u_sex` varchar(2) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `u_idNum` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `u_censusRegister` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '户籍',
  `u_addr` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '目前居住地址',
  `u_company` int(11) NOT NULL COMMENT '所属公司',
  `u_department` int(11) NOT NULL COMMENT '所属部门',
  `u_phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '用户手机号码',
  `u_time` date DEFAULT NULL,
  `u_type` int(11) NOT NULL COMMENT '用户类型',
  `u_status` tinyint(2) NOT NULL COMMENT '用户状态，0冻结、1可用',
  `description` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`u_id`),
  KEY `fk_user_company` (`u_company`),
  KEY `fk_user_dep` (`u_department`),
  KEY `fk_user_type` (`u_type`),
  CONSTRAINT `fk_user_company` FOREIGN KEY (`u_company`) REFERENCES `fr_company` (`cpy_id`),
  CONSTRAINT `fk_user_dep` FOREIGN KEY (`u_department`) REFERENCES `fr_dep` (`dep_id`),
  CONSTRAINT `fk_user_type` FOREIGN KEY (`u_type`) REFERENCES `user_type` (`ut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10014 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

/*Data for the table `fr_user` */

insert  into `fr_user`(`u_id`,`u_account`,`u_name`,`u_password`,`u_sex`,`u_idNum`,`u_censusRegister`,`u_addr`,`u_company`,`u_department`,`u_phone`,`u_time`,`u_type`,`u_status`,`description`,`c_date`,`up_date`) values (10000,'root','张三','dc483e80a7a0bd9ef71d8cf973673924','男','350425199856214785','福建省厦门市思明区镇海路民盛大厦8楼804','福建省厦门市思明区镇海路民盛大厦8楼804',10000,10000,'15887452596','2018-09-04',10000,1,NULL,'2018-09-04 09:56:59','2018-09-11 17:09:37'),(10004,'asdfs','收到撒旦法','dc483e80a7a0bd9ef71d8cf973673924','男','352415888965478541','是大法师的发','范德萨发沙发',10000,10001,'14785236985','2018-09-07',10000,0,'safsa','2018-09-07 17:30:26','2018-09-07 17:30:26'),(10005,'asdf144','阿士大夫','dc483e80a7a0bd9ef71d8cf973673924','男','352485966325418596','是大法师的发','是大法师的发',10000,10001,'14785236987','2018-09-12',10000,0,'阿斯顿发多少','2018-09-11 15:00:27','2018-09-11 15:00:27'),(10007,'admin','王五','dc483e80a7a0bd9ef71d8cf973673924','男','350425199005071586','福建省厦门市同安区同济路1542号','福建省厦门市同安区同济路1542号',10000,10001,'15887445896','2018-09-13',10000,0,'普通人','2018-09-27 17:37:00','2018-09-27 17:37:00'),(10008,'sudo','窝窝头','dc483e80a7a0bd9ef71d8cf973673924','男','352415788965415258','复习沙发沙发沙发','速度发顺丰',10000,10001,'12365478542','2018-09-02',10000,0,'阿士大夫','2018-09-27 18:04:15','2018-09-27 18:04:15'),(10013,'test','测试','dc483e80a7a0bd9ef71d8cf973673924','男','352485966325418596','福建省厦门市思明区镇海路民盛大厦8楼804','福建省厦门市思明区镇海路民盛大厦8楼804',10000,10001,'14785236985','2018-09-28',10000,0,'测试','2018-09-28 16:51:43','2018-09-28 16:51:43');

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `u_account` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `ip_addr` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'ip地址',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=295 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登入记录表';

/*Data for the table `login_log` */

insert  into `login_log`(`id`,`u_account`,`ip_addr`,`c_date`,`up_date`) values (1,'root','0:0:0:0:0:0:0:1',NULL,'2018-09-10 18:22:21'),(2,'root','127.0.0.1',NULL,'2018-09-10 18:25:50'),(3,'root','127.0.0.1','2018-09-10 18:26:27',NULL),(4,'root','192.168.0.107','2018-09-10 18:28:36',NULL),(5,'root','192.168.0.107','2018-09-10 18:29:39',NULL),(6,'root','192.168.0.107','2018-09-10 18:29:55',NULL),(7,'root','192.168.0.107','2018-09-10 18:31:28',NULL),(8,'root','117.28.173.223','2018-09-10 18:36:07',NULL),(9,'root','117.28.173.223','2018-09-10 18:37:28',NULL),(10,'root','117.28.173.223','2018-09-10 18:37:45',NULL),(11,'root','127.0.0.1','2018-09-11 09:47:47',NULL),(12,'root','127.0.0.1','2018-09-11 09:50:09',NULL),(13,'root','127.0.0.1','2018-09-11 09:52:32',NULL),(14,'root','127.0.0.1','2018-09-11 10:02:44',NULL),(15,'root','127.0.0.1','2018-09-11 10:06:07',NULL),(16,'root','127.0.0.1','2018-09-11 10:09:34',NULL),(17,'root','127.0.0.1','2018-09-11 11:23:50',NULL),(18,'root','127.0.0.1','2018-09-11 14:30:38',NULL),(19,'root','127.0.0.1','2018-09-11 15:37:40',NULL),(20,'root','127.0.0.1','2018-09-11 16:40:23',NULL),(21,'root','127.0.0.1','2018-09-11 16:43:26',NULL),(22,'root','127.0.0.1','2018-09-11 16:47:16',NULL),(23,'root','127.0.0.1','2018-09-11 16:50:06',NULL),(24,'root','127.0.0.1','2018-09-11 16:54:45',NULL),(25,'root','127.0.0.1','2018-09-11 17:07:59',NULL),(26,'root','0:0:0:0:0:0:0:1','2018-09-11 17:44:29',NULL),(27,'admin','0:0:0:0:0:0:0:1','2018-09-11 17:52:09',NULL),(28,'admin','0:0:0:0:0:0:0:1','2018-09-11 18:20:40',NULL),(29,'admin','0:0:0:0:0:0:0:1','2018-09-11 18:47:12',NULL),(30,'admin','0:0:0:0:0:0:0:1','2018-09-12 09:06:33',NULL),(31,'admin','0:0:0:0:0:0:0:1','2018-09-12 09:07:13',NULL),(32,'admin','0:0:0:0:0:0:0:1','2018-09-12 09:07:34',NULL),(33,'admin','127.0.0.1','2018-09-12 10:13:50',NULL),(34,'admin','127.0.0.1','2018-09-12 10:16:05',NULL),(35,'admin','127.0.0.1','2018-09-12 11:45:13',NULL),(36,'admin','127.0.0.1','2018-09-12 12:12:37',NULL),(37,'admin','0:0:0:0:0:0:0:1','2018-09-12 15:14:55',NULL),(38,'admin','0:0:0:0:0:0:0:1','2018-09-12 15:52:46',NULL),(39,'admin','0:0:0:0:0:0:0:1','2018-09-12 17:08:20',NULL),(40,'admin','0:0:0:0:0:0:0:1','2018-09-13 08:40:42',NULL),(41,'admin','0:0:0:0:0:0:0:1','2018-09-13 11:41:26',NULL),(42,'admin','0:0:0:0:0:0:0:1','2018-09-13 12:15:06',NULL),(43,'admin','0:0:0:0:0:0:0:1','2018-09-13 14:30:10',NULL),(44,'admin','0:0:0:0:0:0:0:1','2018-09-13 16:14:03',NULL),(45,'admin','0:0:0:0:0:0:0:1','2018-09-14 08:38:28',NULL),(46,'admin','0:0:0:0:0:0:0:1','2018-09-14 10:28:29',NULL),(47,'admin','127.0.0.1','2018-09-14 11:07:12',NULL),(48,'admin','127.0.0.1','2018-09-14 12:18:18',NULL),(49,'admin','127.0.0.1','2018-09-14 14:33:06',NULL),(50,'admin','0:0:0:0:0:0:0:1','2018-09-14 15:33:22',NULL),(51,'admin','0:0:0:0:0:0:0:1','2018-09-14 17:03:24',NULL),(52,'admin','0:0:0:0:0:0:0:1','2018-09-18 09:41:08',NULL),(53,'root','117.28.175.230','2018-09-18 16:20:58',NULL),(54,'root','117.28.175.230','2018-09-18 17:35:13',NULL),(55,'root','117.28.175.230','2018-09-19 08:32:47',NULL),(56,'root','117.28.175.230','2018-09-19 10:55:12',NULL),(57,'root','117.28.175.230','2018-09-19 12:31:34',NULL),(58,'root','117.28.175.230','2018-09-19 14:44:16',NULL),(59,'root','117.28.175.230','2018-09-19 17:01:50',NULL),(60,'root','117.28.175.230','2018-09-20 10:17:02',NULL),(61,'root','117.28.175.230','2018-09-20 12:34:48',NULL),(62,'root','117.28.175.230','2018-09-20 12:36:11',NULL),(63,'root','117.28.175.230','2018-09-20 12:48:17',NULL),(64,'root','117.28.175.230','2018-09-20 14:57:13',NULL),(65,'root','117.28.175.230','2018-09-20 17:50:58',NULL),(66,'root','117.28.173.102','2018-09-21 11:06:00',NULL),(67,'root','117.28.173.102','2018-09-21 12:31:49',NULL),(68,'root','117.28.173.102','2018-09-21 13:11:00',NULL),(69,'root','117.28.173.102','2018-09-21 13:37:18',NULL),(70,'root','117.28.173.102','2018-09-21 14:37:56',NULL),(71,'root','117.28.173.102','2018-09-21 14:39:13',NULL),(72,'root','117.28.173.102','2018-09-21 14:43:11',NULL),(73,'root','117.28.173.102','2018-09-21 14:55:50',NULL),(74,'root','117.28.173.102','2018-09-21 14:56:50',NULL),(75,'root','117.28.173.102','2018-09-21 15:07:24',NULL),(76,'root','117.28.173.102','2018-09-21 15:14:14',NULL),(77,'root','117.28.173.102','2018-09-21 15:18:25',NULL),(78,'root','117.28.173.102','2018-09-21 15:20:39',NULL),(79,'root','117.28.173.102','2018-09-21 15:43:34',NULL),(80,'root','117.28.173.102','2018-09-21 15:44:25',NULL),(81,'root','117.28.173.102','2018-09-21 15:46:59',NULL),(82,'root','117.28.173.102','2018-09-21 16:04:24',NULL),(83,'root','117.28.173.102','2018-09-21 16:11:24',NULL),(84,'root','117.28.173.102','2018-09-21 16:21:06',NULL),(85,'root','117.28.173.102','2018-09-21 16:22:24',NULL),(86,'root','117.28.173.102','2018-09-21 16:26:21',NULL),(87,'root','117.28.173.102','2018-09-21 16:34:31',NULL),(88,'root','117.28.173.102','2018-09-21 17:10:44',NULL),(89,'root','117.28.173.102','2018-09-21 17:24:17',NULL),(90,'root','117.28.173.102','2018-09-21 17:25:36',NULL),(91,'root','117.28.173.102','2018-09-21 17:41:01',NULL),(92,'root','117.28.173.102','2018-09-21 18:05:34',NULL),(93,'root','117.28.173.102','2018-09-21 19:54:50',NULL),(94,'root','117.28.173.102','2018-09-21 19:58:37',NULL),(95,'root','117.28.173.102','2018-09-21 20:01:01',NULL),(96,'root','117.28.173.102','2018-09-21 20:05:30',NULL),(97,'root','117.28.174.2','2018-09-25 09:15:43',NULL),(98,'root','117.28.174.2','2018-09-25 14:41:16',NULL),(99,'root','117.28.174.2','2018-09-25 16:02:35',NULL),(100,'root','117.28.174.2','2018-09-25 16:11:37',NULL),(101,'root','117.28.174.2','2018-09-25 16:13:12',NULL),(102,'root','117.28.174.2','2018-09-25 18:06:39',NULL),(103,'root','117.28.174.2','2018-09-25 18:12:15',NULL),(104,'root','117.28.174.2','2018-09-25 18:17:43',NULL),(105,'root','117.28.174.2','2018-09-25 18:20:13',NULL),(106,'root','117.28.174.2','2018-09-25 18:24:31',NULL),(107,'root','117.28.174.2','2018-09-25 18:33:53',NULL),(108,'root','117.28.174.2','2018-09-25 18:39:02',NULL),(109,'root','117.28.174.2','2018-09-25 18:42:07',NULL),(110,'root','117.28.175.63','2018-09-26 15:52:56',NULL),(111,'root','117.28.175.63','2018-09-26 15:57:37',NULL),(112,'root','117.28.175.63','2018-09-26 16:07:18',NULL),(113,'root','117.28.175.63','2018-09-26 16:21:58',NULL),(114,'root','117.28.175.63','2018-09-26 16:28:27',NULL),(115,'root','117.28.175.63','2018-09-26 16:30:44',NULL),(116,'root','117.28.175.63','2018-09-26 16:35:11',NULL),(117,'root','117.28.175.63','2018-09-26 16:41:55',NULL),(118,'root','117.28.175.63','2018-09-26 16:45:26',NULL),(119,'root','117.28.175.63','2018-09-26 16:48:04',NULL),(120,'root','117.28.175.63','2018-09-26 16:50:02',NULL),(121,'root','117.28.175.63','2018-09-26 16:52:16',NULL),(122,'root','117.28.175.63','2018-09-26 17:20:47',NULL),(123,'root','117.28.175.63','2018-09-26 17:26:55',NULL),(124,'root','117.28.175.63','2018-09-26 17:42:43',NULL),(125,'root','117.28.175.63','2018-09-26 17:55:20',NULL),(126,'root','117.28.175.63','2018-09-26 18:02:36',NULL),(127,'root','117.28.175.63','2018-09-26 18:05:06',NULL),(128,'root','117.28.175.63','2018-09-26 18:15:41',NULL),(129,'root','117.28.175.63','2018-09-26 18:19:14',NULL),(130,'root','117.28.175.63','2018-09-26 18:27:13',NULL),(131,'root','117.28.175.63','2018-09-26 18:32:11',NULL),(132,'root','117.28.175.63','2018-09-26 18:32:58',NULL),(133,'root','117.28.175.63','2018-09-26 18:40:19',NULL),(134,'root','117.28.175.63','2018-09-26 18:43:51',NULL),(135,'root','117.28.172.104','2018-09-27 08:47:24',NULL),(136,'root','117.28.172.104','2018-09-27 09:06:21',NULL),(137,'root','117.28.172.104','2018-09-27 09:23:10',NULL),(138,'root','117.28.172.104','2018-09-27 09:30:08',NULL),(139,'root','117.28.172.104','2018-09-27 09:32:20',NULL),(140,'root','117.28.172.104','2018-09-27 09:45:14',NULL),(141,'root','117.28.172.104','2018-09-27 09:58:07',NULL),(142,'root','117.28.172.104','2018-09-27 10:01:06',NULL),(143,'root','117.28.172.104','2018-09-27 10:06:07',NULL),(144,'root','117.28.172.104','2018-09-27 10:07:49',NULL),(145,'root','117.28.172.104','2018-09-27 10:09:52',NULL),(146,'root','117.28.172.104','2018-09-27 10:18:20',NULL),(147,'root','117.28.172.104','2018-09-27 10:20:31',NULL),(148,'root','117.28.172.104','2018-09-27 10:24:50',NULL),(149,'root','117.28.172.104','2018-09-27 10:27:13',NULL),(150,'root','117.28.172.104','2018-09-27 10:30:25',NULL),(151,'root','117.28.172.104','2018-09-27 10:35:00',NULL),(152,'root','117.28.172.104','2018-09-27 10:38:44',NULL),(153,'root','117.28.172.104','2018-09-27 10:39:45',NULL),(154,'root','117.28.172.104','2018-09-27 10:40:49',NULL),(155,'root','117.28.172.104','2018-09-27 10:43:18',NULL),(156,'root','117.28.172.104','2018-09-27 10:54:57',NULL),(157,'root','117.28.172.104','2018-09-27 10:56:19',NULL),(158,'root','117.28.172.104','2018-09-27 11:01:54',NULL),(159,'root','117.28.172.104','2018-09-27 11:05:06',NULL),(160,'root','117.28.172.104','2018-09-27 11:06:58',NULL),(161,'root','117.28.172.104','2018-09-27 11:09:18',NULL),(162,'root','117.28.172.104','2018-09-27 11:10:54',NULL),(163,'root','117.28.172.104','2018-09-27 11:14:10',NULL),(164,'root','117.28.172.104','2018-09-27 11:15:41',NULL),(165,'root','117.28.172.104','2018-09-27 11:22:51',NULL),(166,'root','117.28.172.104','2018-09-27 12:13:06',NULL),(167,'root','117.28.172.104','2018-09-27 12:23:54',NULL),(168,'root','117.28.172.104','2018-09-27 12:29:23',NULL),(169,'root','117.28.172.104','2018-09-27 12:30:53',NULL),(170,'root','117.28.172.104','2018-09-27 12:33:00',NULL),(171,'root','117.28.172.104','2018-09-27 12:34:15',NULL),(172,'root','117.28.172.104','2018-09-27 12:37:08',NULL),(173,'root','117.28.172.104','2018-09-27 12:38:22',NULL),(174,'root','117.28.172.104','2018-09-27 12:43:53',NULL),(175,'root','117.28.172.104','2018-09-27 12:46:37',NULL),(176,'root','117.28.172.104','2018-09-27 14:44:11',NULL),(177,'root','117.28.172.104','2018-09-27 16:39:40',NULL),(178,'asdfs','117.28.172.104','2018-09-27 16:58:47',NULL),(179,'asdfs','117.28.172.104','2018-09-27 17:02:29',NULL),(180,'asdfs','117.28.172.104','2018-09-27 17:05:41',NULL),(181,'asdfs','117.28.172.104','2018-09-27 17:11:03',NULL),(182,'asdfs','117.28.172.104','2018-09-27 17:14:00',NULL),(183,'asdfs','117.28.172.104','2018-09-27 17:16:26',NULL),(184,'asdfs','117.28.172.104','2018-09-27 17:20:45',NULL),(185,'asdf144','117.28.172.104','2018-09-27 17:22:13',NULL),(186,'asdf144','117.28.172.104','2018-09-27 17:26:31',NULL),(187,'asdfs','117.28.172.104','2018-09-27 17:33:35',NULL),(188,'admin','117.28.172.104','2018-09-27 17:37:45',NULL),(189,'admin','117.28.172.104','2018-09-27 18:00:28',NULL),(190,'sudo','117.28.172.104','2018-09-27 18:04:43',NULL),(191,'root','117.28.172.104','2018-09-27 18:30:42',NULL),(192,'admin','117.28.175.64','2018-09-28 08:22:50',NULL),(193,'admin','117.28.175.64','2018-09-28 09:38:03',NULL),(194,'admin','117.28.175.64','2018-09-28 09:41:00',NULL),(195,'admin','117.28.175.64','2018-09-28 09:48:08',NULL),(196,'admin','117.28.175.64','2018-09-28 09:54:29',NULL),(197,'asdf144','117.28.175.64','2018-09-28 10:05:59',NULL),(198,'admin','117.28.175.64','2018-09-28 16:11:42',NULL),(199,'admin','117.28.175.64','2018-09-28 16:15:49',NULL),(200,'admin','117.28.175.64','2018-09-28 16:15:49',NULL),(201,'admin','117.28.175.64','2018-09-28 16:50:40',NULL),(202,'test','117.28.175.64','2018-09-28 16:52:25',NULL),(203,'admin','117.28.175.64','2018-09-28 17:26:17',NULL),(204,'root','117.28.175.64','2018-09-28 17:31:02',NULL),(205,'root','117.28.175.64','2018-09-28 17:39:45',NULL),(206,'root','117.28.175.64','2018-09-28 17:39:45',NULL),(207,'admin','117.28.175.64','2018-09-28 17:42:57',NULL),(208,'admin','117.28.175.64','2018-09-28 17:42:58',NULL),(209,'root','117.28.175.64','2018-09-28 17:45:29',NULL),(210,'root','117.28.175.64','2018-09-28 18:06:28',NULL),(211,'asdfs','117.28.175.64','2018-09-28 18:52:38',NULL),(212,'asdf144','117.28.175.64','2018-09-28 18:59:44',NULL),(213,'asdfs','117.28.172.140','2018-09-29 09:41:52',NULL),(214,'root','117.28.172.140','2018-09-29 10:00:26',NULL),(215,'sudo','117.28.172.140','2018-09-29 11:18:59',NULL),(216,'sudo','117.28.172.140','2018-09-29 11:31:33',NULL),(217,'admin','117.28.172.140','2018-09-29 15:20:07',NULL),(218,'sudo','117.28.172.140','2018-09-29 16:08:50',NULL),(219,'sudo','117.28.172.140','2018-09-29 16:09:56',NULL),(220,'sudo','117.28.172.140','2018-09-29 16:17:19',NULL),(221,'sudo','117.28.172.140','2018-09-29 16:17:19',NULL),(222,'sudo','117.28.172.140','2018-09-29 16:30:32',NULL),(223,'sudo','117.28.172.140','2018-09-29 16:32:42',NULL),(224,'sudo','117.28.172.140','2018-09-29 17:20:09',NULL),(225,'sudo','117.28.172.140','2018-09-29 17:20:09',NULL),(226,'admin','117.28.172.140','2018-09-29 18:56:09',NULL),(227,'asdfs','117.28.172.140','2018-09-29 19:01:13',NULL),(228,'asdfs','117.28.172.140','2018-09-29 19:09:40',NULL),(229,'sudo','117.28.173.154','2018-09-30 08:36:22',NULL),(230,'sudo','117.28.173.154','2018-09-30 08:36:22',NULL),(231,'asdfs','117.28.173.154','2018-09-30 08:38:16',NULL),(232,'asdfs','117.28.173.154','2018-09-30 09:50:19',NULL),(233,'asdfs','117.28.173.154','2018-09-30 09:52:29',NULL),(234,'asdfs','117.28.173.154','2018-09-30 10:37:24',NULL),(235,'asdfs','117.28.173.154','2018-09-30 10:38:55',NULL),(236,'asdfs','117.28.173.154','2018-09-30 10:40:52',NULL),(237,'asdfs','117.28.173.154','2018-09-30 10:47:19',NULL),(238,'asdfs','117.28.173.154','2018-09-30 11:11:57',NULL),(239,'asdfs','117.28.173.154','2018-09-30 11:58:57',NULL),(240,'asdfs','117.28.173.154','2018-09-30 12:33:39',NULL),(241,'asdfs','117.28.173.154','2018-09-30 12:34:15',NULL),(242,'asdfs','117.28.173.154','2018-09-30 12:35:38',NULL),(243,'asdf144','117.28.173.154','2018-09-30 12:55:45',NULL),(244,'admin','117.28.173.154','2018-09-30 14:10:26',NULL),(245,'asdfs','117.28.173.154','2018-09-30 14:48:16',NULL),(246,'asdfs','117.28.173.154','2018-09-30 14:54:38',NULL),(247,'asdfs','117.28.173.154','2018-09-30 15:18:05',NULL),(248,'admin','117.28.175.215','2018-10-08 08:59:23',NULL),(249,'admin','117.28.175.215','2018-10-08 10:43:21',NULL),(250,'admin','117.28.175.215','2018-10-08 10:55:01',NULL),(251,'admin','117.28.175.215','2018-10-08 11:03:08',NULL),(252,'admin','117.28.175.215','2018-10-08 11:05:46',NULL),(253,'admin','117.28.175.215','2018-10-08 11:30:21',NULL),(254,'admin','117.28.175.215','2018-10-08 11:38:05',NULL),(255,'admin','117.28.175.215','2018-10-08 11:39:14',NULL),(256,'admin','117.28.175.215','2018-10-08 12:34:20',NULL),(257,'admin','117.28.175.215','2018-10-08 14:37:37',NULL),(258,'admin','117.28.175.215','2018-10-08 14:39:28',NULL),(259,'admin','117.28.175.215','2018-10-08 16:23:45',NULL),(260,'admin','117.28.175.215','2018-10-08 16:25:51',NULL),(261,'admin','117.28.175.215','2018-10-08 16:41:33',NULL),(262,'admin','117.28.175.215','2018-10-08 16:44:51',NULL),(263,'admin','117.28.175.215','2018-10-08 16:51:14',NULL),(264,'admin','117.28.175.215','2018-10-08 16:52:42',NULL),(265,'admin','117.28.175.215','2018-10-08 16:53:56',NULL),(266,'admin','117.28.175.215','2018-10-08 17:09:22',NULL),(267,'admin','117.28.175.215','2018-10-08 17:56:53',NULL),(268,'admin','117.28.175.215','2018-10-08 17:58:09',NULL),(269,'admin','117.28.175.215','2018-10-08 18:00:10',NULL),(270,'admin','117.28.174.39','2018-10-09 10:14:02',NULL),(271,'admin','117.28.174.39','2018-10-09 10:17:57',NULL),(272,'admin','117.28.174.39','2018-10-09 10:20:23',NULL),(273,'asdf144','117.28.174.39','2018-10-09 10:22:28',NULL),(274,'admin','117.28.174.39','2018-10-09 10:25:44',NULL),(275,'admin','117.28.174.39','2018-10-09 10:27:58',NULL),(276,'admin','117.28.174.39','2018-10-09 10:39:31',NULL),(277,'asdf144','117.28.174.39','2018-10-09 10:48:06',NULL),(278,'admin','117.28.174.39','2018-10-09 11:03:04',NULL),(279,'admin','117.28.174.39','2018-10-09 12:32:05',NULL),(280,'admin','117.28.174.39','2018-10-09 14:47:21',NULL),(281,'admin','117.28.174.39','2018-10-09 15:30:32',NULL),(282,'asdf144','117.28.174.39','2018-10-09 15:32:10',NULL),(283,'admin','117.28.174.39','2018-10-09 16:30:35',NULL),(284,'admin','117.28.174.39','2018-10-09 16:40:25',NULL),(285,'admin','117.28.174.39','2018-10-09 16:50:13',NULL),(286,'admin','117.28.174.39','2018-10-09 16:51:59',NULL),(287,'admin','117.28.174.39','2018-10-09 16:53:03',NULL),(288,'admin','117.28.175.121','2018-10-10 11:48:33',NULL),(289,'admin','117.28.175.121','2018-10-10 13:07:47',NULL),(290,'admin','117.28.175.121','2018-10-10 13:18:31',NULL),(291,'admin','117.28.175.121','2018-10-10 13:23:13',NULL),(292,'admin','117.28.175.121','2018-10-10 13:25:32',NULL),(293,'admin','117.28.175.121','2018-10-10 13:50:05',NULL),(294,'admin','117.28.175.121','2018-10-10 14:29:56',NULL);

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `ut_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `ut_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户类型',
  `ut_authority` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '用户权限，储存结构为json',
  `c_date` datetime DEFAULT NULL COMMENT '创建时间',
  `up_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户类型权限表';

/*Data for the table `user_type` */

insert  into `user_type`(`ut_id`,`ut_name`,`ut_authority`,`c_date`,`up_date`) values (10000,'普通用户',NULL,'2018-09-04 09:40:35','2018-09-04 09:40:40'),(10001,'超级用户',NULL,'2018-09-04 09:41:01','2018-09-04 09:41:04');

/*Table structure for table `view_fr_photo` */

DROP TABLE IF EXISTS `view_fr_photo`;

/*!50001 DROP VIEW IF EXISTS `view_fr_photo` */;
/*!50001 DROP TABLE IF EXISTS `view_fr_photo` */;

/*!50001 CREATE TABLE  `view_fr_photo`(
 `ph_id` int(11) ,
 `ph_usr_id` int(11) ,
 `ph_domain_name` varchar(64) ,
 `ph_new_name` varchar(64) ,
 `ph_save_path` varchar(128) ,
 `up_date` datetime ,
 `short_up_date` varchar(8) 
)*/;

/*View structure for view view_fr_photo */

/*!50001 DROP TABLE IF EXISTS `view_fr_photo` */;
/*!50001 DROP VIEW IF EXISTS `view_fr_photo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `view_fr_photo` AS select `fr_photo`.`ph_id` AS `ph_id`,`fr_photo`.`ph_usr_id` AS `ph_usr_id`,`fr_photo`.`ph_domain_name` AS `ph_domain_name`,`fr_photo`.`ph_new_name` AS `ph_new_name`,`fr_photo`.`ph_save_path` AS `ph_save_path`,`fr_photo`.`up_date` AS `up_date`,date_format(`fr_photo`.`up_date`,'%Y%m%d') AS `short_up_date` from `fr_photo` where (`fr_photo`.`is_delete` = 1) order by `fr_photo`.`up_date` desc */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
