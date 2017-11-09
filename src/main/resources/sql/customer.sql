/*
Navicat MySQL Data Transfer

Source Server         : 192.168.20.114
Source Server Version : 50554
Source Host           : 192.168.20.114:3306
Source Database       : QkPool

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2017-11-09 10:22:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(128) DEFAULT NULL COMMENT '会员名称',
  `login_name` varchar(128) DEFAULT NULL COMMENT '会员账户登录名',
  `sex` smallint(10) DEFAULT NULL COMMENT '性别',
  `tel_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `regis_date` datetime DEFAULT NULL COMMENT '注册时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(128) DEFAULT NULL COMMENT '更新人',
  `level` smallint(10) DEFAULT NULL COMMENT '账户等级',
  `accountType` smallint(10) DEFAULT NULL COMMENT '账户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
