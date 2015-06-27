# LianJiaSpider
链家地产房产信息收集程序-个人使用


MySQL配置：root     123456 字符集：UTF-8

表名：lianjia_table

建表：

```SQL

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : webdata

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-25 09:49:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lianjia_table
-- ----------------------------
DROP TABLE IF EXISTS `lianjia_table`;
CREATE TABLE `lianjia_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` text,
  `house_title` text,
  `house_location` text,
  `house_room` text,
  `house_area` text,
  `house_direction` text,
  `house_price` text,
  `price_per_square` text,
  `house_url` longtext,
  `region_url` longtext,
  `is_down` tinyint(2) DEFAULT NULL,
  `create_date` text,
  `house_type` text,
  `house_height` text,
  `house_build_year` text,
  `house_build_type` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2901 DEFAULT CHARSET=utf8;

```
