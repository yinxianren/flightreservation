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

insert  into `fr_company`(`cpy_id`,`cpy_com_name`,`cpy_com_sh_name`,`cpy_reg_addr`,`cpy_bus_lic`,`cpy_legal_rep`,`cpy_legal_rep_num`,`cpy_ind_type`,`cpy_bus_sco`,`cpy_web_addr`,`cpy_icp_num`,`cpy_bank_acc_name`,`cpy_bank_num`,`cpy_bank_name`,`c_date`,`up_date`) values (10000,'厦门思满朵艺术设计有限公司','思满朵','福建省厦门市思明区吕岭路2号B36之四','91350203MA2YF9NB4Q','刘辉','230222**********0614','其他','文化、艺术活动策划；','http://www.xmsmdys.top','闽ICP备04000001号','厦门思满朵艺术设计有限公司','403450*********6802','中国农业银行股份有限公司厦门槟榔支行','2018-08-20 11:34:00','2018-09-04 10:33:04'),(10002,'厦门研丽贸易有限公司','研丽','福建省厦门市思明区吕岭路2号B36之四','91350203MA2YF9NB4Q','研丽','230222**********0614','其他','文化、艺术活动策划；专业化设计服务；其他文化用品批发；文具用品批发；','http://www.xmsmdys.top','闽ICP备04000001号','厦门研丽贸易有限公司','403450*********6802','中国农业银行股份有限公司厦门槟榔支行','2018-08-20 11:34:00','2018-08-20 11:34:00'),(10003,'读者出版传媒股份有限公司','读者出版传媒股份有限公司','甘肃省兰州市城关区南滨河东路520号','91620000079251370M','马建东','350425197806012638','新闻和出版业','教育、图书出版；','','','读者出版传媒股份有限公司','51458745269874525','中国农业银行股份有限公司厦门槟榔支行','2018-09-05 17:33:48','2018-09-05 17:33:48');

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
) ENGINE=InnoDB AUTO_INCREMENT=10026 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';

/*Data for the table `fr_dep` */

insert  into `fr_dep`(`dep_id`,`dep_company`,`dep_name`,`dep_pricipal`,`dep_abbreviation`,`dep_addr`,`dep_phone`,`description`,`c_date`,`up_date`) values (10000,10000,'财务部','郭靖','MD','福建省厦门市思明区镇海路民盛大厦8楼804','17805089928','打造新的财务部，让部门发扬光大','2018-08-20 11:34:00','2018-09-05 16:02:27'),(10001,10000,'市场部','王五六','FD','福建省厦门市思明区镇海路民盛大厦8楼804','17805089958','企业发展的关键部门','2018-08-20 11:34:00','2018-08-20 11:34:00'),(10018,10002,'研发部','赵氏','RD','福建省厦门市思明区镇海路民盛大厦8楼804','17805089958','企业创新部门','2018-08-20 11:34:00','2018-08-20 11:34:00'),(10022,10002,'开发部','蓝布懒','DP','福建省厦门市思明区吕岭路2号B36之四','13785412586','我在这里------------福建省厦门市思明区吕岭路2号B36之四','2018-09-05 15:50:58','2018-09-05 17:34:31');

/*Table structure for table `fr_user` */

DROP TABLE IF EXISTS `fr_user`;

CREATE TABLE `fr_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长ID',
  `u_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `u_password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `u_sex` varchar(2) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `u_idNum` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `u_censusRegister` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '户籍',
  `u_addr` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '目前居住地址',
  `u_company` int(11) NOT NULL COMMENT '所属公司',
  `u_department` int(11) NOT NULL COMMENT '所属部门',
  `u_phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '用户手机号码',
  `u_time` date DEFAULT NULL COMMENT '入职时间',
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
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

/*Data for the table `fr_user` */

insert  into `fr_user`(`u_id`,`u_name`,`u_password`,`u_sex`,`u_idNum`,`u_censusRegister`,`u_addr`,`u_company`,`u_department`,`u_phone`,`u_time`,`u_type`,`u_status`,`description`,`c_date`,`up_date`) values (10000,'root','123456','男','350425199856214785','福建省厦门市思明区镇海路民盛大厦8楼804','福建省厦门市思明区镇海路民盛大厦8楼804',10000,10000,'15887452596','2018-09-04',10000,1,NULL,'2018-09-04 09:56:59','2018-09-04 09:57:03'),(10001,'root','123456','男','350425199856214785','福建省厦门市思明区镇海路民盛大厦8楼804','福建省厦门市思明区镇海路民盛大厦8楼804',10000,10000,'15887452596','2018-09-04',10000,1,NULL,'2018-09-04 09:56:59','2018-09-04 09:57:03'),(10002,'root','123456','男','350425199856214785','福建省厦门市思明区镇海路民盛大厦8楼804','福建省厦门市思明区镇海路民盛大厦8楼804',10000,10000,'15887452596','2018-09-04',10000,1,NULL,'2018-09-04 09:56:59','2018-09-04 09:57:03');

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
