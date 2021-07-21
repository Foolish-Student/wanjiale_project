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

 Date: 21/07/2021 11:25:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_member_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_member_user_info`;
CREATE TABLE `t_member_user_info`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别： 男  女',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `remark` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int NULL DEFAULT NULL COMMENT '状态 1： 启用   2 ：禁用   10：删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member_user_info
-- ----------------------------
INSERT INTO `t_member_user_info` VALUES (5, '李万', 'password', '撒地方', '总经办', '男', 'sdfsdf', '575', 'f', 1, '2021-07-16 15:35:05', '2021-07-16 15:35:05', 'system', 'system');
INSERT INTO `t_member_user_info` VALUES (6, '1', 'password', '1', '总经办', '男', '1', '1', '1', 1, '2021-07-18 11:52:23', '2021-07-18 11:52:23', 'system', 'system');
INSERT INTO `t_member_user_info` VALUES (7, '1', 'password', '1', '总经办', '男', '1', '1', '1', 1, '2021-07-18 11:58:22', '2021-07-18 11:58:22', 'system', 'system');
INSERT INTO `t_member_user_info` VALUES (8, 'asf ', 'password', 'saf ', '总经办', '男', 'dsf', 'sadf', 'asdf', 1, '2021-07-19 10:03:18', '2021-07-19 10:03:18', 'system', 'system');
INSERT INTO `t_member_user_info` VALUES (9, '阿道夫', 'password', '撒地方', '总经办', '男', 'saf', '654534', 'sf', 1, '2021-07-21 10:02:01', '2021-07-21 10:02:01', 'system', 'system');

SET FOREIGN_KEY_CHECKS = 1;
