/*
Navicat MySQL Data Transfer

Source Server         : swg
Source Server Version : 50728
Source Host           : 116.62.14.178:3306
Source Database       : StudentDB

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-08 17:21:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_ Class
-- ----------------------------
DROP TABLE IF EXISTS `T_ Class`;
CREATE TABLE `T_ Class` (
  `classid` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) NOT NULL,
  `majorid` int(11) DEFAULT NULL,
  `userid` varchar(11) DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`classid`),
  KEY `majorid` (`majorid`),
  CONSTRAINT `T_ Class_ibfk_1` FOREIGN KEY (`majorid`) REFERENCES `T_ major` (`majorid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Class
-- ----------------------------

-- ----------------------------
-- Table structure for T_ College
-- ----------------------------
DROP TABLE IF EXISTS `T_ College`;
CREATE TABLE `T_ College` (
  `collegeid` int(11) NOT NULL AUTO_INCREMENT,
  `collegeName` varchar(255) NOT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`collegeid`),
  KEY `userid` (`userid`),
  CONSTRAINT `T_ College_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `T_User` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ College
-- ----------------------------

-- ----------------------------
-- Table structure for T_ Course
-- ----------------------------
DROP TABLE IF EXISTS `T_ Course`;
CREATE TABLE `T_ Course` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `curriculumid` int(11) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `remakes` varchar(255) DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`courseid`),
  KEY `curriculumid` (`curriculumid`),
  CONSTRAINT `T_ Course_ibfk_1` FOREIGN KEY (`curriculumid`) REFERENCES `T_ Curriculum` (`curriculumid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Course
-- ----------------------------

-- ----------------------------
-- Table structure for T_ Curriculum
-- ----------------------------
DROP TABLE IF EXISTS `T_ Curriculum`;
CREATE TABLE `T_ Curriculum` (
  `curriculumid` int(11) NOT NULL AUTO_INCREMENT,
  `curriculumName` varchar(100) DEFAULT NULL,
  `semesterid` int(11) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`curriculumid`),
  KEY `semesterid` (`semesterid`),
  CONSTRAINT `T_ Curriculum_ibfk_1` FOREIGN KEY (`semesterid`) REFERENCES `T_ Semester` (`semesterid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Curriculum
-- ----------------------------

-- ----------------------------
-- Table structure for T_ major
-- ----------------------------
DROP TABLE IF EXISTS `T_ major`;
CREATE TABLE `T_ major` (
  `majorid` int(11) NOT NULL AUTO_INCREMENT,
  `majorName` varchar(255) NOT NULL,
  `collegeid` int(11) DEFAULT NULL,
  `userid` varchar(11) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`majorid`),
  KEY `collegeid` (`collegeid`),
  CONSTRAINT `T_ major_ibfk_1` FOREIGN KEY (`collegeid`) REFERENCES `T_ College` (`collegeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ major
-- ----------------------------

-- ----------------------------
-- Table structure for T_ Notice
-- ----------------------------
DROP TABLE IF EXISTS `T_ Notice`;
CREATE TABLE `T_ Notice` (
  `noticeid` int(11) NOT NULL AUTO_INCREMENT,
  `noticeName` varchar(255) NOT NULL,
  `noticecontent` text NOT NULL,
  `remarks` text,
  `userid` varchar(11) NOT NULL,
  `createdate` datetime NOT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`noticeid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Notice
-- ----------------------------
INSERT INTO `T_ Notice` VALUES ('12', '开学', '5月20开学', '无', 'admin', '2020-05-08 00:00:00', '0');

-- ----------------------------
-- Table structure for T_ Semester
-- ----------------------------
DROP TABLE IF EXISTS `T_ Semester`;
CREATE TABLE `T_ Semester` (
  `semesterid` int(11) NOT NULL AUTO_INCREMENT,
  `semesterName` varchar(255) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  PRIMARY KEY (`semesterid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Semester
-- ----------------------------
INSERT INTO `T_ Semester` VALUES ('2', '2016年度上学期', '2018-08-07 00:00:00', '2018-09-19 00:00:00', '0');
INSERT INTO `T_ Semester` VALUES ('4', '2016年度下学期', '2016-09-20 00:00:00', '2017-02-21 00:00:00', '0');

-- ----------------------------
-- Table structure for T_ Sheet
-- ----------------------------
DROP TABLE IF EXISTS `T_ Sheet`;
CREATE TABLE `T_ Sheet` (
  `sheetid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `stuinfoid` int(11) DEFAULT NULL,
  `fraction` double DEFAULT NULL,
  `evaluate` varchar(255) DEFAULT NULL,
  `isdelete` int(11) NOT NULL,
  `remakes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sheetid`),
  KEY `courseid` (`courseid`),
  CONSTRAINT `T_ Sheet_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `T_ Course` (`courseid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ Sheet
-- ----------------------------

-- ----------------------------
-- Table structure for T_AdminRole
-- ----------------------------
DROP TABLE IF EXISTS `T_AdminRole`;
CREATE TABLE `T_AdminRole` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_AdminRole
-- ----------------------------
INSERT INTO `T_AdminRole` VALUES ('1', '超级管理员', '超级管理员，拥有对管理员用户、权限的管理职权');
INSERT INTO `T_AdminRole` VALUES ('3', '????', '????');

-- ----------------------------
-- Table structure for T_photoInfo
-- ----------------------------
DROP TABLE IF EXISTS `T_photoInfo`;
CREATE TABLE `T_photoInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photopath` varchar(100) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_photoInfo
-- ----------------------------
INSERT INTO `T_photoInfo` VALUES ('1', 'user/defaultuser.jpg', '0');
INSERT INTO `T_photoInfo` VALUES ('25', 'xjj\\shiyuan.jpeg', '0');
INSERT INTO `T_photoInfo` VALUES ('26', '221\\shizi.jpg', '0');

-- ----------------------------
-- Table structure for T_RoleB
-- ----------------------------
DROP TABLE IF EXISTS `T_RoleB`;
CREATE TABLE `T_RoleB` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) DEFAULT NULL,
  `remark` longtext,
  `isDel` int(11) NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_RoleB
-- ----------------------------
INSERT INTO `T_RoleB` VALUES ('1', '管理员', '所有权限', '0');
INSERT INTO `T_RoleB` VALUES ('8', '院长', '部分权限', '0');
INSERT INTO `T_RoleB` VALUES ('9', '科长', '部分对学生权限', '0');
INSERT INTO `T_RoleB` VALUES ('10', '辅导员', '对学生信息修改查看', '0');
INSERT INTO `T_RoleB` VALUES ('11', '任课教师', '对学生成绩进行打分', '0');
INSERT INTO `T_RoleB` VALUES ('12', '学生', '普通学生用户', '0');

-- ----------------------------
-- Table structure for T_RoleSystemModel
-- ----------------------------
DROP TABLE IF EXISTS `T_RoleSystemModel`;
CREATE TABLE `T_RoleSystemModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleID` int(11) NOT NULL COMMENT '角色id',
  `sysid` int(11) NOT NULL COMMENT '菜单id',
  `isedit` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否有权限',
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleID`),
  KEY `sysid` (`sysid`),
  CONSTRAINT `T_RoleSystemModel_ibfk_2` FOREIGN KEY (`sysid`) REFERENCES `T_SystemModel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_RoleSystemModel
-- ----------------------------
INSERT INTO `T_RoleSystemModel` VALUES ('1', '1', '1', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('2', '1', '2', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('3', '1', '3', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('4', '1', '4', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('5', '1', '5', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('6', '1', '6', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('7', '1', '7', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('8', '1', '8', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('9', '1', '9', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('34', '1', '10', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('35', '1', '19', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('36', '1', '20', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('37', '1', '21', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('38', '1', '22', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('39', '1', '23', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('40', '1', '24', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('41', '7', '1', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('42', '8', '1', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('43', '8', '2', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('44', '8', '3', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('45', '8', '4', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('46', '8', '23', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('47', '8', '24', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('48', '8', '10', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('49', '8', '19', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('50', '8', '20', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('51', '8', '21', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('52', '8', '22', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('53', '8', '5', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('54', '8', '6', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('55', '8', '7', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('56', '8', '8', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('57', '8', '9', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('58', '9', '1', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('59', '9', '2', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('60', '9', '3', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('61', '9', '4', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('62', '9', '23', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('63', '9', '24', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('64', '9', '10', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('65', '9', '19', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('66', '9', '20', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('67', '9', '21', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('68', '9', '22', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('69', '9', '5', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('70', '9', '6', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('71', '9', '7', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('72', '9', '8', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('73', '9', '9', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('74', '10', '1', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('75', '10', '2', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('76', '10', '3', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('77', '10', '4', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('78', '10', '23', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('79', '10', '24', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('80', '10', '10', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('81', '10', '19', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('82', '10', '20', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('83', '10', '21', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('84', '10', '22', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('85', '10', '5', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('86', '10', '6', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('87', '10', '7', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('88', '10', '8', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('89', '10', '9', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('90', '11', '1', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('91', '11', '2', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('92', '11', '3', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('93', '11', '4', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('94', '11', '23', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('95', '11', '24', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('96', '11', '10', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('97', '11', '19', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('98', '11', '20', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('99', '11', '21', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('100', '11', '22', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('101', '11', '5', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('102', '11', '6', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('103', '11', '7', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('104', '11', '8', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('105', '11', '9', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('106', '1', '25', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('107', '1', '26', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('108', '1', '27', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('109', '1', '28', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('110', '8', '25', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('111', '8', '26', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('112', '8', '27', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('113', '8', '28', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('114', '9', '25', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('115', '10', '25', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('116', '11', '25', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('117', '9', '26', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('118', '10', '26', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('119', '11', '26', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('120', '9', '27', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('121', '10', '27', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('122', '11', '27', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('123', '9', '28', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('124', '10', '28', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('125', '11', '28', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('126', '1', '29', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('127', '1', '30', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('128', '1', '31', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('129', '1', '32', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('130', '8', '29', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('131', '8', '30', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('132', '8', '31', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('133', '8', '32', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('134', '9', '29', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('135', '9', '30', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('136', '9', '31', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('137', '9', '32', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('138', '10', '29', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('139', '10', '30', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('140', '10', '31', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('141', '10', '32', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('142', '11', '29', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('143', '11', '30', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('144', '11', '31', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('145', '11', '32', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('146', '12', '1', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('147', '12', '29', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('148', '12', '2', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('149', '12', '25', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('150', '12', '3', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('151', '12', '4', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('152', '12', '23', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('153', '12', '24', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('154', '12', '10', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('155', '12', '19', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('156', '12', '20', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('157', '12', '21', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('158', '12', '22', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('159', '12', '32', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('160', '12', '5', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('161', '12', '6', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('162', '12', '7', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('163', '12', '8', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('164', '12', '9', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('165', '12', '26', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('166', '12', '27', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('167', '12', '28', '\0', null);
INSERT INTO `T_RoleSystemModel` VALUES ('168', '12', '30', '', null);
INSERT INTO `T_RoleSystemModel` VALUES ('169', '12', '31', '', null);

-- ----------------------------
-- Table structure for T_Stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `T_Stuinfo`;
CREATE TABLE `T_Stuinfo` (
  `stuinfoid` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(50) DEFAULT NULL,
  `stunum` varchar(50) DEFAULT NULL,
  `agend` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `classid` int(50) NOT NULL,
  `isdelete` int(11) DEFAULT NULL,
  `stucard` varchar(50) DEFAULT NULL,
  `photoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuinfoid`),
  KEY `classid` (`classid`),
  KEY `photoid` (`photoid`),
  CONSTRAINT `T_Stuinfo_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `T_ Class` (`classid`),
  CONSTRAINT `T_Stuinfo_ibfk_2` FOREIGN KEY (`photoid`) REFERENCES `T_photoInfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_Stuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for T_SystemLog
-- ----------------------------
DROP TABLE IF EXISTS `T_SystemLog`;
CREATE TABLE `T_SystemLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opertype` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `opermethod` varchar(255) DEFAULT NULL,
  `requestip` varchar(255) DEFAULT NULL,
  `exceptioncode` varchar(255) DEFAULT NULL,
  `exceptiondetail` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_SystemLog
-- ----------------------------
INSERT INTO `T_SystemLog` VALUES ('5', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-12 09:02:00', 'admin');
INSERT INTO `T_SystemLog` VALUES ('6', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-12 11:58:13', 'admin');
INSERT INTO `T_SystemLog` VALUES ('7', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-13 08:37:48', 'admin');
INSERT INTO `T_SystemLog` VALUES ('8', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-13 08:37:48', 'admin');
INSERT INTO `T_SystemLog` VALUES ('9', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-13 08:37:50', 'admin');
INSERT INTO `T_SystemLog` VALUES ('10', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-13 08:47:28', 'admin');
INSERT INTO `T_SystemLog` VALUES ('11', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-14 14:05:37', 'admin');
INSERT INTO `T_SystemLog` VALUES ('12', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-11-25 08:36:29', 'admin');
INSERT INTO `T_SystemLog` VALUES ('13', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-12-02 16:43:22', 'admin');
INSERT INTO `T_SystemLog` VALUES ('14', 'query', '登录', 'business.impl.AdminUserDaoImpl.login', null, null, null, '{\"userid\":\"admin\",\"pwd\":\"123456\"}', '2019-12-03 08:52:53', 'admin');

-- ----------------------------
-- Table structure for T_SystemModel
-- ----------------------------
DROP TABLE IF EXISTS `T_SystemModel`;
CREATE TABLE `T_SystemModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `chinesename` varchar(255) DEFAULT NULL COMMENT '中文名称',
  `navurl` varchar(255) DEFAULT NULL COMMENT '路径',
  `deepth` int(255) DEFAULT NULL COMMENT '根节点',
  `parentid` int(255) DEFAULT NULL COMMENT '父节点',
  `displayorder` int(255) DEFAULT NULL COMMENT '排序',
  `imageurl` varchar(255) DEFAULT NULL COMMENT '图标',
  `isdelete` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_SystemModel
-- ----------------------------
INSERT INTO `T_SystemModel` VALUES ('1', '基本信息管理', '基本信息管理', null, '1', '0', '1', '&#xe66f;', '\0');
INSERT INTO `T_SystemModel` VALUES ('2', '学校信息管理', '学校信息管理', '', '1', '0', '2', '&#xe665;', '\0');
INSERT INTO `T_SystemModel` VALUES ('3', '学生管理', '学生管理', '', '1', '0', '4', '&#xe770;', '\0');
INSERT INTO `T_SystemModel` VALUES ('4', '系统管理', '系统管理', null, '1', '0', '5', '&#xe716;', '\0');
INSERT INTO `T_SystemModel` VALUES ('5', '管理员用户管理', '用户管理', 'userManagement.jsp', '2', '4', '1', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('6', '角色管理', '角色管理', 'roleManagement.jsp', '2', '4', '2', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('7', '菜单管理', '菜单管理', 'sysMenuManagement.jsp', '2', '4', '3', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('8', '角色权限管理', '角色权限管理', 'roleSystemModelDefault.jsp', '2', '4', '4', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('9', '系统日志管理', '系统日志管理', 'systemLogView.jsp', '2', '4', '5', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('10', '学院管理', '学院管理', 'collegeList.jsp', '2', '2', '1', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('19', '专业管理', '专业管理', 'majorList.jsp', '2', '2', '2', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('20', '班级管理', '班级管理', 'classList.jsp', '2', '2', '3', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('21', '学生信息管理', '学生信息列表', '../studentList.jsp', '2', '3', '1', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('22', '学生成绩管理', '学生成绩列表', 'achievementtList.jsp', '2', '3', '2', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('23', '公告管理', '公告管理', 'newslist.jsp', '2', '1', '1', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('24', '教师信息管理', '教师管理', 'teacher.jsp', '2', '1', '1', null, '\0');
INSERT INTO `T_SystemModel` VALUES ('25', '课程管理', '课程管理', '', '1', '0', '3', '&#xe60a;', '\0');
INSERT INTO `T_SystemModel` VALUES ('26', '学期管理', '学期管理', 'semester.jsp', '2', '25', '1', '', '\0');
INSERT INTO `T_SystemModel` VALUES ('27', '课程信息管理', '课程信息管理', 'curriculum.jsp', '2', '25', '2', '', '\0');
INSERT INTO `T_SystemModel` VALUES ('28', '任课管理', '任课管理', 'courseList.jsp', '2', '25', '4', '', '\0');
INSERT INTO `T_SystemModel` VALUES ('29', '我的信息', '我的信息', '', '1', '0', '1', '&#xe66f;', '\0');
INSERT INTO `T_SystemModel` VALUES ('30', '个人信息', '个人信息', '../studentinfo.jsp', '2', '29', '1', '', '\0');
INSERT INTO `T_SystemModel` VALUES ('31', '个人成绩', '个人成绩', 'myachieve.jsp', '2', '29', '2', '', '\0');
INSERT INTO `T_SystemModel` VALUES ('32', '学生成绩评定', '学生成绩评定', 'stuachieve.jsp', '2', '3', '3', null, '\0');

-- ----------------------------
-- Table structure for T_teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `T_teacherinfo`;
CREATE TABLE `T_teacherinfo` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `teaName` varchar(100) DEFAULT NULL,
  `teaphone` varchar(100) DEFAULT NULL,
  `userid` varchar(11) DEFAULT NULL,
  `teasex` varchar(100) DEFAULT NULL,
  `auditstatus` bit(1) DEFAULT NULL,
  `isdelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_teacherinfo
-- ----------------------------

-- ----------------------------
-- Table structure for T_User
-- ----------------------------
DROP TABLE IF EXISTS `T_User`;
CREATE TABLE `T_User` (
  `userid` varchar(11) NOT NULL,
  `account` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `roleID` int(11) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `usertype` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_User
-- ----------------------------
INSERT INTO `T_User` VALUES ('admin', '管理员', '123456', '1', '0', '');
INSERT INTO `T_User` VALUES ('lmm', '李苗苗', '123456', '8', '0', '');
INSERT INTO `T_User` VALUES ('ml', '马力', '123456', '9', '0', '');
INSERT INTO `T_User` VALUES ('wdl', '王大力', '123456', '10', '0', '');
INSERT INTO `T_User` VALUES ('xjj', '晓剑姬', '123456', '11', '0', '');
INSERT INTO `T_User` VALUES ('zl', '张龙', '123456', '12', '0', '');

-- ----------------------------
-- View structure for VAdminUser
-- ----------------------------
DROP VIEW IF EXISTS `VAdminUser`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `VAdminUser` AS select `A`.`userid` AS `userid`,`A`.`account` AS `account`,`A`.`pwd` AS `pwd`,`A`.`roleID` AS `roleID`,`A`.`isDel` AS `isDel`,`T_RoleB`.`roleName` AS `roleName`,`T_RoleB`.`remark` AS `remark`,`A`.`usertype` AS `usertype` from (`T_RoleB` join `T_User` `A` on((`T_RoleB`.`roleID` = `A`.`roleID`))) ;

-- ----------------------------
-- View structure for Vclass
-- ----------------------------
DROP VIEW IF EXISTS `Vclass`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `Vclass` AS select `T_ Class`.`classid` AS `classid`,`T_ Class`.`className` AS `className`,`T_ Class`.`majorid` AS `majorid`,`T_ Class`.`userid` AS `userid`,`T_ Class`.`isdelete` AS `isdelete`,`T_ major`.`majorName` AS `majorName`,`T_ College`.`collegeName` AS `collegeName`,`T_ College`.`collegeid` AS `collegeid` from ((`T_ Class` join `T_ major` on((`T_ Class`.`majorid` = `T_ major`.`majorid`))) join `T_ College` on((`T_ major`.`collegeid` = `T_ College`.`collegeid`))) ;

-- ----------------------------
-- View structure for VCourse
-- ----------------------------
DROP VIEW IF EXISTS `VCourse`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `VCourse` AS select `T_ Course`.`courseid` AS `courseid`,`T_ Course`.`curriculumid` AS `curriculumid`,`T_ Course`.`teacherid` AS `teacherid`,`T_ Course`.`classid` AS `classid`,`T_ Course`.`remakes` AS `remakes`,`T_ Course`.`isdelete` AS `isdelete`,`T_ Class`.`className` AS `className`,`T_teacherinfo`.`teaName` AS `teaName`,`T_ Curriculum`.`curriculumName` AS `curriculumName`,`T_ Curriculum`.`introduce` AS `introduce`,`T_ Semester`.`semesterName` AS `semesterName`,`T_ Semester`.`semesterid` AS `semesterid` from ((((`T_ Class` join `T_ Course` on((`T_ Class`.`classid` = `T_ Course`.`classid`))) join `T_ Curriculum` on((`T_ Course`.`curriculumid` = `T_ Curriculum`.`curriculumid`))) join `T_teacherinfo` on((`T_ Course`.`teacherid` = `T_teacherinfo`.`teacherid`))) join `T_ Semester` on((`T_ Curriculum`.`semesterid` = `T_ Semester`.`semesterid`))) ;

-- ----------------------------
-- View structure for VCurriculum
-- ----------------------------
DROP VIEW IF EXISTS `VCurriculum`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `VCurriculum` AS select `T_ Curriculum`.`curriculumid` AS `curriculumid`,`T_ Curriculum`.`curriculumName` AS `curriculumName`,`T_ Curriculum`.`semesterid` AS `semesterid`,`T_ Curriculum`.`introduce` AS `introduce`,`T_ Curriculum`.`remarks` AS `remarks`,`T_ Curriculum`.`isdelete` AS `isdelete`,`T_ Semester`.`semesterName` AS `semesterName`,`T_ Semester`.`startdate` AS `startdate`,`T_ Semester`.`enddate` AS `enddate` from (`T_ Curriculum` join `T_ Semester` on((`T_ Curriculum`.`semesterid` = `T_ Semester`.`semesterid`))) ;

-- ----------------------------
-- View structure for Vmajor
-- ----------------------------
DROP VIEW IF EXISTS `Vmajor`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `Vmajor` AS select `T_ College`.`collegeName` AS `collegeName`,`T_ major`.`majorName` AS `majorName`,`T_ major`.`majorid` AS `majorid`,`T_ major`.`collegeid` AS `collegeid`,`T_ major`.`userid` AS `userid`,`T_ major`.`isdelete` AS `isdelete` from (`T_ College` join `T_ major` on((`T_ College`.`collegeid` = `T_ major`.`collegeid`))) ;

-- ----------------------------
-- View structure for VRoleSystemModel
-- ----------------------------
DROP VIEW IF EXISTS `VRoleSystemModel`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `VRoleSystemModel` AS select `T_RoleSystemModel`.`id` AS `id`,`T_RoleSystemModel`.`roleID` AS `roleID`,`T_RoleSystemModel`.`sysid` AS `sysid`,`T_RoleSystemModel`.`isedit` AS `isedit`,`T_RoleSystemModel`.`createdate` AS `createdate`,`T_SystemModel`.`name` AS `name`,`T_SystemModel`.`chinesename` AS `chinesename`,`T_SystemModel`.`navurl` AS `navurl`,`T_SystemModel`.`deepth` AS `deepth`,`T_SystemModel`.`parentid` AS `parentid`,`T_SystemModel`.`displayorder` AS `displayorder`,`T_SystemModel`.`imageurl` AS `imageurl`,`T_RoleB`.`roleName` AS `roleName`,`T_RoleB`.`remark` AS `remark`,`T_SystemModel`.`isdelete` AS `isdelete` from ((`T_RoleB` join `T_RoleSystemModel` on((`T_RoleSystemModel`.`roleID` = `T_RoleB`.`roleID`))) join `T_SystemModel` on((`T_RoleSystemModel`.`sysid` = `T_SystemModel`.`id`))) ;

-- ----------------------------
-- View structure for Vsheet
-- ----------------------------
DROP VIEW IF EXISTS `Vsheet`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `Vsheet` AS select `T_ Sheet`.`sheetid` AS `sheetid`,`T_ Sheet`.`courseid` AS `courseid`,`T_ Sheet`.`stuinfoid` AS `stuinfoid`,`T_ Sheet`.`fraction` AS `fraction`,`T_ Sheet`.`evaluate` AS `evaluate`,`T_ Sheet`.`isdelete` AS `isdelete`,`VCourse`.`curriculumid` AS `curriculumid`,`VCourse`.`teacherid` AS `teacherid`,`VCourse`.`teaName` AS `teaName`,`VCourse`.`curriculumName` AS `curriculumName`,`VCourse`.`semesterName` AS `semesterName`,`VCourse`.`introduce` AS `introduce`,`Vstudent`.`stuname` AS `stuname`,`Vstudent`.`stunum` AS `stunum`,`Vstudent`.`agend` AS `agend`,`Vstudent`.`phone` AS `phone`,`Vstudent`.`classid` AS `classid`,`Vstudent`.`collegeid` AS `collegeid`,`Vstudent`.`collegeName` AS `collegeName`,`Vstudent`.`majorid` AS `majorid`,`Vstudent`.`majorName` AS `majorName`,`Vstudent`.`className` AS `className`,`VCourse`.`semesterid` AS `semesterid`,`Vstudent`.`userid` AS `userid`,`Vstudent`.`photoid` AS `photoid`,`T_ Sheet`.`remakes` AS `remakes` from ((`T_ Sheet` join `VCourse` on((`T_ Sheet`.`courseid` = `VCourse`.`courseid`))) join `Vstudent` on((`T_ Sheet`.`stuinfoid` = `Vstudent`.`stuinfoid`))) ;

-- ----------------------------
-- View structure for Vstudent
-- ----------------------------
DROP VIEW IF EXISTS `Vstudent`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `Vstudent` AS select `T_Stuinfo`.`stuinfoid` AS `stuinfoid`,`T_Stuinfo`.`stuname` AS `stuname`,`T_Stuinfo`.`stunum` AS `stunum`,`T_Stuinfo`.`agend` AS `agend`,`T_Stuinfo`.`birthday` AS `birthday`,`T_Stuinfo`.`phone` AS `phone`,`T_Stuinfo`.`email` AS `email`,`T_Stuinfo`.`userid` AS `userid`,`T_Stuinfo`.`classid` AS `classid`,`T_Stuinfo`.`isdelete` AS `isdelete`,`T_Stuinfo`.`stucard` AS `stucard`,`T_ College`.`collegeid` AS `collegeid`,`T_ College`.`collegeName` AS `collegeName`,`T_ major`.`majorid` AS `majorid`,`T_ major`.`majorName` AS `majorName`,`T_ Class`.`className` AS `className`,`T_Stuinfo`.`photoid` AS `photoid`,`T_photoInfo`.`photopath` AS `photopath` from ((((`T_ Class` join `T_ major` on((`T_ Class`.`majorid` = `T_ major`.`majorid`))) join `T_ College` on((`T_ major`.`collegeid` = `T_ College`.`collegeid`))) join `T_Stuinfo` on((`T_ Class`.`classid` = `T_Stuinfo`.`classid`))) join `T_photoInfo` on((`T_Stuinfo`.`photoid` = `T_photoInfo`.`id`))) ;

-- ----------------------------
-- View structure for VTeacher
-- ----------------------------
DROP VIEW IF EXISTS `VTeacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `VTeacher` AS select `T_teacherinfo`.`teacherid` AS `teacherid`,`T_teacherinfo`.`teaName` AS `teaName`,`T_teacherinfo`.`teaphone` AS `teaphone`,`T_teacherinfo`.`userid` AS `userid`,`T_teacherinfo`.`teasex` AS `teasex`,`T_teacherinfo`.`auditstatus` AS `auditstatus`,`T_teacherinfo`.`isdelete` AS `isdelete`,`T_User`.`account` AS `account`,`T_RoleB`.`roleName` AS `roleName`,`T_User`.`usertype` AS `usertype` from ((`T_teacherinfo` join `T_User` on((`T_teacherinfo`.`userid` = `T_User`.`userid`))) join `T_RoleB` on((`T_User`.`roleID` = `T_RoleB`.`roleID`))) ;
