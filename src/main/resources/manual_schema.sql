
DROP SCHEMA IF EXISTS ds_master;
DROP SCHEMA IF EXISTS ds_slave_0;
DROP SCHEMA IF EXISTS ds_slave_1;

CREATE SCHEMA IF NOT EXISTS ds_master;
CREATE SCHEMA IF NOT EXISTS ds_slave_0;
CREATE SCHEMA IF NOT EXISTS ds_slave_1;




USE ds_master;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('1', '51', 'INSERT_TEST'), ('2', '51', 'INSERT_TEST'), ('3', '51', 'INSERT_TEST'), ('4', '51', 'INSERT_TEST'), ('5', '51', 'INSERT_TEST'), ('6', '51', 'INSERT_TEST'), ('7', '51', 'INSERT_TEST'), ('8', '51', 'INSERT_TEST'), ('9', '51', 'INSERT_TEST'), ('10', '51', 'INSERT_TEST');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_item` VALUES ('1', '1', '51'), ('2', '2', '51'), ('3', '3', '51'), ('4', '4', '51'), ('5', '5', '51'), ('6', '6', '51'), ('7', '7', '51'), ('8', '8', '51'), ('9', '9', '51'), ('10', '10', '51');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;




USE ds_slave_0;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('1', '51', 'INSERT_TEST'), ('2', '51', 'INSERT_TEST'), ('3', '51', 'INSERT_TEST'), ('4', '51', 'INSERT_TEST'), ('5', '51', 'INSERT_TEST'), ('6', '51', 'INSERT_TEST'), ('7', '51', 'INSERT_TEST'), ('8', '51', 'INSERT_TEST'), ('9', '51', 'INSERT_TEST'), ('10', '51', 'INSERT_TEST');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_item` VALUES ('1', '1', '51'), ('2', '2', '51'), ('3', '3', '51'), ('4', '4', '51'), ('5', '5', '51'), ('6', '6', '51'), ('7', '7', '51'), ('8', '8', '51'), ('9', '9', '51'), ('10', '10', '51');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;




USE ds_slave_1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('1', '51', 'INSERT_TEST'), ('2', '51', 'INSERT_TEST'), ('3', '51', 'INSERT_TEST'), ('4', '51', 'INSERT_TEST'), ('5', '51', 'INSERT_TEST'), ('6', '51', 'INSERT_TEST'), ('7', '51', 'INSERT_TEST'), ('8', '51', 'INSERT_TEST'), ('9', '51', 'INSERT_TEST'), ('10', '51', 'INSERT_TEST');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `t_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_item` VALUES ('1', '1', '51'), ('2', '2', '51'), ('3', '3', '51'), ('4', '4', '51'), ('5', '5', '51'), ('6', '6', '51'), ('7', '7', '51'), ('8', '8', '51'), ('9', '9', '51'), ('10', '10', '51');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

