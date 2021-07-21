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

 Date: 21/07/2021 11:24:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_management_info
-- ----------------------------
DROP TABLE IF EXISTS `product_management_info`;
CREATE TABLE `product_management_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品编号',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品型号',
  `product_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类目',
  `bar_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  `product_unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `product_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格',
  `product_price` double(11, 2) NULL DEFAULT NULL COMMENT '零售价（元）',
  `product_invoice_price` double(11, 2) NULL DEFAULT NULL COMMENT '开票价',
  `product_bug_price` double(11, 2) NULL DEFAULT NULL COMMENT '提货价',
  `product_weight` double(11, 2) NULL DEFAULT NULL COMMENT '重量（Kg）',
  `product_bulk` double(11, 2) NULL DEFAULT NULL COMMENT '体积（m3)',
  `product_length` double(11, 2) NULL DEFAULT NULL COMMENT '长度（cm)',
  `product_width` double(11, 2) NULL DEFAULT NULL COMMENT '宽度（cm)',
  `deliver_from_godown` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出货仓库',
  `expiry_date` date NULL DEFAULT NULL COMMENT '失效日期',
  `product_after_sale` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '售后产品型号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_management_info
-- ----------------------------
INSERT INTO `product_management_info` VALUES (14, '546464', '高压锅', 'R123', '厨房电商', '5645356', 'cm', '20×30', 200.00, 200.00, 54.00, 415.00, 51.00, 54.00, 51.00, '武汉', '2000-06-10', '北京');
INSERT INTO `product_management_info` VALUES (15, 'FHS', '抽烟机', 'FFF', '厨房电商', '564655', '个', '30×30', 300.00, 300.00, 200.00, 6.50, 0.50, 30.00, 30.00, '北京', '2020-06-02', '武汉');
INSERT INTO `product_management_info` VALUES (16, 'QQF112', '热水器', 'FF1FG', '热水电商', '54646', '个', '60×80', 1600.00, 1600.00, 1000.00, 30.00, 3.00, 60.00, 80.00, '济南', '2025-06-12', '武汉');
INSERT INTO `product_management_info` VALUES (17, 'GSDG445', '电水壶', 'SFG', '热水电商', '684351', '个', '30×20', 100.00, 100.00, 50.00, 1.00, 0.30, 30.00, 20.00, '乌鲁木齐', '2050-06-10', '沈阳');
INSERT INTO `product_management_info` VALUES (18, 'NF1', '太阳能热水器', 'GDG1156', '热水电商', '5456165', '个', '100×100', 2600.00, 2600.00, 1500.00, 30.00, 3.00, 100.00, 100.00, '长春', '2026-06-21', '长春');

SET FOREIGN_KEY_CHECKS = 1;
