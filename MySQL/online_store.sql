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

 Date: 21/07/2021 11:24:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for online_store
-- ----------------------------
DROP TABLE IF EXISTS `online_store`;
CREATE TABLE `online_store`  (
  `shop_id` int NOT NULL AUTO_INCREMENT COMMENT '序号\r\n',
  `shop_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网店平台类别\r\n',
  `shop_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int NULL DEFAULT NULL COMMENT '状态',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6457 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of online_store
-- ----------------------------
INSERT INTO `online_store` VALUES (1, '淘宝', 'taobao.com', '123456', '520520', 1, '2021-07-20 15:14:08', '李万', NULL, NULL);
INSERT INTO `online_store` VALUES (2, '京东', 'jd.com', '6564654', '35413453', 1, '2021-07-20 15:47:24', '张会钦', NULL, NULL);
INSERT INTO `online_store` VALUES (3, '拼夕夕', 'xixi.com', '6543456', '134654', 1, '2021-07-20 21:31:58', '小左', NULL, NULL);
INSERT INTO `online_store` VALUES (4, '苏宁易购', 'suning.com', '687464', '654687', 1, '2021-07-20 15:48:16', '夏雷', NULL, NULL);
INSERT INTO `online_store` VALUES (5, '得物', 'du.com', '84654', '6746135', 0, '2021-07-20 15:14:14', '瞿立航', NULL, NULL);
INSERT INTO `online_store` VALUES (6456, '算法', 'suanfa.com', '15644135', '1354645', 1, '2021-07-20 16:04:24', '萨格', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
