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

 Date: 19/04/2024 15:21:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `gender` tinyint(4) NULL DEFAULT 0 COMMENT '性别（0-男  ： 1-女）',
  `age` tinyint(4) NULL DEFAULT 0 COMMENT '年龄',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_name_gender`(`name`, `gender`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3299271 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'app用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
