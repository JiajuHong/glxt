/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : jiaju

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 10/10/2022 20:20:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbluser
-- ----------------------------
DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPass` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `userRole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbluser
-- ----------------------------
INSERT INTO `tbluser` VALUES (1, 'aa', '123', '普通用户');
INSERT INTO `tbluser` VALUES (2, 'admin', '123', '管理员');
INSERT INTO `tbluser` VALUES (3, 'admin', '123', '管理员');
INSERT INTO `tbluser` VALUES (4, 'bb', '123', '普通用户');
INSERT INTO `tbluser` VALUES (5, 'cc', '123', '普通用户');
INSERT INTO `tbluser` VALUES (7, 'a01', '999', '普通用户');
INSERT INTO `tbluser` VALUES (8, 'aa', '999', '普通用户');
INSERT INTO `tbluser` VALUES (10, 'd', 'd', '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
