/*
 Navicat Premium Data Transfer

 Source Server         : 虚拟机(1.116)
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 192.168.1.116:3306
 Source Schema         : test_db

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 19/04/2024 15:21:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_order_0
-- ----------------------------
DROP TABLE IF EXISTS `user_order_0`;
CREATE TABLE `user_order_0`  (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '订单名称',
  `consume` int(11) NOT NULL COMMENT '消费金额',
  `discount` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否优惠0-无优惠；1-有优惠',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `iname`(`name`) USING BTREE,
  INDEX `idx_userid`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 403301372285423617 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户订单表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
