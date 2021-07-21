/*
 Navicat Premium Data Transfer

 Source Server         : temp
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : data_wanjiale

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 21/07/2021 11:25:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_member_role_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_role_info`;
CREATE TABLE `t_member_role_info`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `role_remark` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` int NULL DEFAULT NULL COMMENT '态状1：启用 2：禁用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member_role_info
-- ----------------------------
INSERT INTO `t_member_role_info` VALUES (15, '采购部', '商品采购', 1, '2021-07-19 16:41:51', '2021-07-19 16:41:51', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (17, '财务部', '财务管理', 1, '2021-07-19 14:19:22', '2021-07-19 14:19:22', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (18, '电商部', '电商业务', 1, '2021-07-19 16:42:24', '2021-07-19 16:42:24', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (19, 'IT部', 'IT业务', 1, '2021-07-19 16:43:16', '2021-07-19 16:43:16', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (20, '生产部', '生产管理', 1, '2021-07-19 16:43:31', '2021-07-19 16:43:31', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (21, '总经办', '总理事物', 1, '2021-07-19 16:43:46', '2021-07-19 16:43:46', 'system', 'system');
INSERT INTO `t_member_role_info` VALUES (22, '李万', '挺帅的', 1, '2021-07-21 10:00:49', '2021-07-21 10:01:18', 'system', 'system');

SET FOREIGN_KEY_CHECKS = 1;
