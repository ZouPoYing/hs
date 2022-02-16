/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : hs

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-02-16 19:35:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'app 主键',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `link` varchar(255) DEFAULT NULL COMMENT '链接',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `auth` varchar(255) DEFAULT NULL COMMENT '需要的权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('1', 'column', '个人档案', '/pages/myinfo/myinfo', 'my-menu', '2');
INSERT INTO `app` VALUES ('2', 'smile', '测试游客', '/pages/index/index', 'my-menu', '0');
INSERT INTO `app` VALUES ('3', 'friends', '会员信息', '/pages/index/index', 'my-menu', '9');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `user_type` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `phone_number` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像图片链接',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '孤独的人总是晚归', 'vip', '15886438518', 'https://thirdwx.qlogo.cn/mmopen/vi_32/KgJSDhA6S2Lt0SmoJcoic141WBoXvsWw4vzAp04Seqh1HicLzaEQjpSsEMzicx1E0tD23jAv2Vp7ibKz6x3fZuUG1A/132');
