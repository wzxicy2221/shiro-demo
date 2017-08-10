/*
Navicat MySQL Data Transfer

Source Server         : south
Source Server Version : 50631
Source Host           : 192.168.0.35:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2017-08-10 17:46:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `shiro_permission`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shiro_permission
-- ----------------------------
INSERT INTO shiro_permission VALUES ('1', '1', '/admin/add.htm', null);
INSERT INTO shiro_permission VALUES ('2', '2', '/user/add.htm', null);

-- ----------------------------
-- Table structure for `shiro_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_role
-- ----------------------------
INSERT INTO shiro_role VALUES ('1', '1', 'admin', '超级管理员', '0');
INSERT INTO shiro_role VALUES ('2', '2', 'user', '用户', '0');
INSERT INTO shiro_role VALUES ('3', '2', 'teacher', '老师', '0');

-- ----------------------------
-- Table structure for `shiro_user`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shiro_user
-- ----------------------------
INSERT INTO shiro_user VALUES ('1', 'admin', '123456', '0');
INSERT INTO shiro_user VALUES ('2', 'wzx', '123456', '0');
