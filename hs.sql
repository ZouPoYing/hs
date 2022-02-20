/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : hs

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 20/02/2022 20:08:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'app 主键',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `auth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需要的权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES (1, 'column', '个人档案', '/pages/myinfo/myinfo', 'my-menu', '2');
INSERT INTO `app` VALUES (2, 'smile', '测试游客', '/pages/index/index', 'my-menu', '0');
INSERT INTO `app` VALUES (3, 'friends', '会员信息', '/pages/vips/vips', 'my-menu', '9');
INSERT INTO `app` VALUES (4, '/images/tabbar/home.png', '首页', '/pages/home/home', 'tabbar', NULL);
INSERT INTO `app` VALUES (5, '/images/tabbar/haircut.png', '剪发', '/pages/haircut/haircut', 'tabbar', NULL);
INSERT INTO `app` VALUES (6, '/images/tabbar/order.png', '订单', '/pages/order/order', 'tabbar', NULL);
INSERT INTO `app` VALUES (7, '/images/tabbar/my.png', '我的', '/pages/my/my', 'tabbar', NULL);
INSERT INTO `app` VALUES (8, 'setting', '页面配置', '/pages/setting/setting', 'my-menu', '9');
INSERT INTO `app` VALUES (9, 'friends', '理发师管理', '/pages/mbarbers/mbarbers', 'my-menu', '9');
INSERT INTO `app` VALUES (10, '/images/haircuter/haircuter1.jpg', '理发师1', '/pages/barber/barber?title=Tony Liu&barber_id=1', 'haircuter', NULL);
INSERT INTO `app` VALUES (11, '/images/haircuter/haircuter2.jpg', '理发师2', '/pages/barber/barber?title=Tony Wang&barber_id=3', 'haircuter', NULL);
INSERT INTO `app` VALUES (12, '/images/haircuter/haircuter3.jpg', '理发师3', '/pages/barber/barber?title=王一博&barber_id=4', 'haircuter', NULL);
INSERT INTO `app` VALUES (13, '/images/haircuter/haircuter4.jpg', '理发师4', '/pages/barber/barber?title=ui&barber_id=5', 'haircuter', NULL);
INSERT INTO `app` VALUES (14, '/images/haircuter/haircuter5.jpg', '理发师5', '/pages/barber/barber?title=迪丽热巴&barber_id=6', 'haircuter', NULL);
INSERT INTO `app` VALUES (15, '10', '价格配置--基础收费-洗剪吹', NULL, 'skillPrice1', NULL);
INSERT INTO `app` VALUES (16, '20', '价格配置--基础收费-烫发', NULL, 'skillPrice2', NULL);
INSERT INTO `app` VALUES (17, '30', '价格配置--基础收费-染发', NULL, 'skillPrice3', NULL);
INSERT INTO `app` VALUES (18, '50', '价格配置--基础收费-发型设计', NULL, 'skillPrice4', NULL);
INSERT INTO `app` VALUES (19, '18', '价格配置--手艺收费-初级理发师', NULL, 'positionPrice1', NULL);
INSERT INTO `app` VALUES (20, '28', '价格配置--手艺收费-中级理发师', NULL, 'positionPrice2', NULL);
INSERT INTO `app` VALUES (21, '38', '价格配置--手艺收费-高级理发师', NULL, 'positionPrice3', NULL);
INSERT INTO `app` VALUES (22, '58', '价格配置--手艺收费-总监', NULL, 'positionPrice4', NULL);
INSERT INTO `app` VALUES (23, '/images/swiper/swiper1.jpg', '轮播图1', NULL, 'swiper', NULL);
INSERT INTO `app` VALUES (24, '/images/swiper/swiper2.jpg', '轮播图2', NULL, 'swiper', NULL);
INSERT INTO `app` VALUES (25, '/images/swiper/swiper3.jpg', '轮播图3', NULL, 'swiper', NULL);
INSERT INTO `app` VALUES (26, NULL, '注意啦！注意啦！咕咕美发店正式开业啦！开业大酬宾！走过路过不要错过！赶紧过来围观吧！', NULL, 'notice', NULL);

-- ----------------------------
-- Table structure for barber
-- ----------------------------
DROP TABLE IF EXISTS `barber`;
CREATE TABLE `barber`  (
  `barber_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '理发师主键',
  `barber_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理发师名字',
  `barber_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理发师头像',
  `barber_back` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理发师背景',
  `skill` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '擅长发型',
  `star_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上班时间',
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下班时间',
  `entry_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '入职时间',
  `is_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否在上班',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `skill_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述手艺',
  PRIMARY KEY (`barber_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of barber
-- ----------------------------
INSERT INTO `barber` VALUES (1, 'Tony Liu', 'http://localhost:9191/hs/1_1645157046642_1645157046642.9j.png', 'http://localhost:9191/hs/1_1645157049258_1645157049258.9j.png', '发型设计', '00:00', '18:00', '2000-02-19 17:13:10', '是', '总监', '这是一段描述自己的文字，00000000000描述一下手艺啥的');
INSERT INTO `barber` VALUES (2, '小李', 'http://localhost:9191/hs/1_1645157046642_1645157046642.9j.png', 'http://localhost:9191/hs/1_1645157049258_1645157049258.9j.png', '洗剪吹', '12:34', '18:34', '2022-02-19 13:23:20', '否', '初级发型师', '我是初级理发师');
INSERT INTO `barber` VALUES (3, 'Tony Wang', 'http://localhost:9191/hs/1_1645157046642_1645157046642.9j.png', 'http://localhost:9191/hs/1_1645157049258_1645157049258.9j.png', '发型设计', '00:00', '22:00', '2018-02-19 11:41:19', '是', '总监', '我的手艺很好 ，专业tony老师帮你设计发型一条龙服务 ');
INSERT INTO `barber` VALUES (4, '王一博', 'http://localhost:9191/hs/1_1645158348365_1645158348366.PJuncjkxyEbz1wjRexVrwjJm9tq1daogtoFK6xRgKlBGbCLWVT.png', 'http://localhost:9191/hs/1_1645158354796_1645158354796.9j.png', '烫发', '02:24', '17:24', '2020-12-19 11:41:52', '是', '中级发型师', '我是王一博，I AM GOOD AT DANCE');
INSERT INTO `barber` VALUES (5, 'ui', 'http://localhost:9191/hs/1_1645158903269_1645158903269.2J0bZtnQFKtr9w.png', 'http://localhost:9191/hs/1_1645158907148_1645158907148.9j.png', '染发', '12:34', '18:38', '2019-02-19 11:42:20', '是', '高级发型师', '我是ui，I AM GOOD AT SING');
INSERT INTO `barber` VALUES (6, '迪丽热巴', 'http://localhost:9191/hs/1_1645159131045_1645159131045.9j.png', 'http://localhost:9191/hs/1_1645159134488_1645159134488.9j.png', '发型设计', '12:38', '15:38', '2021-01-18 23:02:05', '是', '中级发型师', '我是迪丽热巴');
INSERT INTO `barber` VALUES (7, '易烊千玺', 'http://localhost:9191/hs/1_1645161423453_1645161423453.9j.jpg', 'http://localhost:9191/hs/1_1645163996781_1645163996781.fMwjLdPaDkYiWWhTFGS8uydLsbJTGEnVheSiRY6pZyCYZQizsRy6hB5NL9dQ8gxAQKFQKy3gAv4AUxCTEpN7vGmMTt7oXEAlOJhVJWaWIRdHe7e5Z15rzWmdk1s8sMfc7T53Sfb.png', '烫发', '13:13', '13:24', '2021-06-19 11:43:05', '是', '中级发型师', '我是易烊千玺');
INSERT INTO `barber` VALUES (8, '赵丽颖', 'http://localhost:9191/hs/1_1645164502044_1645164502044.9j.jpg', 'http://localhost:9191/hs/1_1645164511027_1645164511027.vrnTE+KDtZRFtBTUuIquD0ANmEzPYFAXqV1dIiUryfQAmzIqLAm7vkol7m4tyq5cN6hYWWB6kiAWwuJuobsrkXkkAsrDxxpFQclaPtESfIRMz83tnzU3SemC092n50zPOTO.png', '染发', '12:08', '23:08', '2020-10-01 11:43:31', '是', '高级发型师', '我是赵丽颖');
INSERT INTO `barber` VALUES (11, 'a112', 'http://localhost:9191/hs/1_1645170401543_1645170401543.Zx3zjnf+b73IwgFjz1Qtmf6N4RiAAW6eIx8KUWgqCQcDsoyWRE94Iu.png', 'http://localhost:9191/hs/1_1645175960663_1645175960663.+w+9H3ue9PO.png', '烫发', '15:46', '20:19', '2022-02-19 11:44:47', '否', '初级发型师', '132131232142142142422222222222222213213214sdsadsadsadsa');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `evaluate_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评价主键',
  `level` int(0) NULL DEFAULT NULL COMMENT '评价等级',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片链接',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`evaluate_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, 5, 'http://localhost:9191/hs/2_1645334583142_1645334583142.f.jpg', '别说了，五星好评必须的，巴拉巴拉巴拉巴拉，扬帆起航');
INSERT INTO `evaluate` VALUES (2, 5, 'http://localhost:9191/hs/1_1645354005088_1645354005088.9j.jpg', '女人味');
INSERT INTO `evaluate` VALUES (3, 5, 'http://localhost:9191/hs/1_1645354089327_1645354089327.9j.jpg', '长发造型烫');
INSERT INTO `evaluate` VALUES (4, 5, 'http://localhost:9191/hs/1_1645354165635_1645354165635.9j.jpg', '黑茶冷棕');
INSERT INTO `evaluate` VALUES (5, 4, 'http://localhost:9191/hs/1_1645354202379_1645354202379.9j.jpg', '造型 造型效果自然时尚');
INSERT INTO `evaluate` VALUES (6, 4, 'http://localhost:9191/hs/1_1645354253725_1645354253725.9j.jpg', '今年最流行的发色 蜜茶棕色，超级好看，显白，搭配大卷超级温柔，绝了');
INSERT INTO `evaluate` VALUES (7, 4, 'http://localhost:9191/hs/1_1645354276436_1645354276436.9j.jpg', '锁骨发');
INSERT INTO `evaluate` VALUES (8, 5, 'http://localhost:9191/hs/1_1645354297439_1645354297439.9j.jpg', '#初恋波波头');
INSERT INTO `evaluate` VALUES (9, 5, 'http://localhost:9191/hs/1_1645354321882_1645354321882.9j.jpg', '染发  生活色');
INSERT INTO `evaluate` VALUES (10, 5, 'http://localhost:9191/hs/1_1645354343996_1645354343996.9j.jpg', '创意挑染#光线染');
INSERT INTO `evaluate` VALUES (11, 5, 'http://localhost:9191/hs/1_1645354384650_1645354384650.9j.jpg', '爆顶染，潮流必备！');
INSERT INTO `evaluate` VALUES (12, 5, 'http://localhost:9191/hs/1_1645354426362_1645354426362.9j.jpg', '海王红');
INSERT INTO `evaluate` VALUES (13, 5, 'http://localhost:9191/hs/1_1645354444703_1645354444703.9j.jpg', '适合居家自己打理的发型和发色');
INSERT INTO `evaluate` VALUES (14, 5, 'http://localhost:9191/hs/1_1645354479379_1645354479379.9j.jpg', '今日潮色#茶灰色');
INSERT INTO `evaluate` VALUES (15, 5, 'http://localhost:9191/hs/1_1645354512870_1645354512870.9j.jpg', '暖棕色魅惑波浪卷');
INSERT INTO `evaluate` VALUES (16, 5, 'http://localhost:9191/hs/1_1645354555698_1645354555698.9j.jpg', '”烫“不一样的你');
INSERT INTO `evaluate` VALUES (17, 5, 'http://localhost:9191/hs/1_1645354592113_1645354592113.9j.jpg', '元气少女短发');
INSERT INTO `evaluate` VALUES (18, 5, 'http://localhost:9191/hs/1_1645354614596_1645354614596.9j.jpg', '夏天的风，就应该短#气质');
INSERT INTO `evaluate` VALUES (19, 5, 'http://localhost:9191/hs/1_1645354645228_1645354645228.9j.jpg', '女生长发');
INSERT INTO `evaluate` VALUES (20, 5, 'http://localhost:9191/hs/1_1645354667997_1645354667997.9j.jpg', '清爽发型');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `file_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文件主键',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户主键',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (23, '1_1645122285505_1645122285505.9j.png', '2022-02-18 02:56:09', 1);
INSERT INTO `file` VALUES (24, '1_1645122852968_1645122852968.9j.png', '2022-02-18 02:34:37', 1);
INSERT INTO `file` VALUES (25, '1_1645124008819_1645124008819.9j.png', '2022-02-18 02:53:28', 1);
INSERT INTO `file` VALUES (26, '1_1645124057637_1645124057637.efk3nvzXsJdm2SwMqVK7epVqv.png', '2022-02-18 02:54:17', 1);
INSERT INTO `file` VALUES (27, '1_1645125534358_1645125534358.9j.png', '2022-02-18 03:18:54', 1);
INSERT INTO `file` VALUES (28, '1_1645125670610_1645125670610.9j.png', '2022-02-18 03:21:10', 1);
INSERT INTO `file` VALUES (29, '1_1645127538449_1645127538449.9j.png', '2022-02-18 03:52:18', 1);
INSERT INTO `file` VALUES (30, '1_1645153686800_1645153686800.9j.png', '2022-02-18 11:08:06', 1);
INSERT INTO `file` VALUES (31, '1_1645153921598_1645153921598.9j.png', '2022-02-18 11:12:01', 1);
INSERT INTO `file` VALUES (32, '1_1645153951077_1645153951077.9j.png', '2022-02-18 11:12:31', 1);
INSERT INTO `file` VALUES (33, '1_1645155446206_1645155446206.9j.png', '2022-02-18 11:37:26', 1);
INSERT INTO `file` VALUES (34, '1_1645155449772_1645155449772.9j.png', '2022-02-18 11:37:29', 1);
INSERT INTO `file` VALUES (35, '1_1645155726132_1645155726132.9j.png', '2022-02-18 11:42:06', 1);
INSERT INTO `file` VALUES (36, '1_1645155728616_1645155728616.9j.png', '2022-02-18 11:42:08', 1);
INSERT INTO `file` VALUES (37, '1_1645156219791_1645156219791.9j.png', '2022-02-18 11:50:19', 1);
INSERT INTO `file` VALUES (38, '1_1645156222264_1645156222264.9j.png', '2022-02-18 11:50:22', 1);
INSERT INTO `file` VALUES (39, '1_1645157046642_1645157046642.9j.png', '2022-02-18 12:04:06', 1);
INSERT INTO `file` VALUES (40, '1_1645157049258_1645157049258.9j.png', '2022-02-18 12:04:09', 1);
INSERT INTO `file` VALUES (41, '1_1645158348365_1645158348366.PJuncjkxyEbz1wjRexVrwjJm9tq1daogtoFK6xRgKlBGbCLWVT.png', '2022-02-18 12:25:48', 1);
INSERT INTO `file` VALUES (42, '1_1645158354796_1645158354796.9j.png', '2022-02-18 12:25:54', 1);
INSERT INTO `file` VALUES (43, '1_1645158903269_1645158903269.2J0bZtnQFKtr9w.png', '2022-02-18 12:35:03', 1);
INSERT INTO `file` VALUES (44, '1_1645158907148_1645158907148.9j.png', '2022-02-18 12:35:07', 1);
INSERT INTO `file` VALUES (45, '1_1645159131045_1645159131045.9j.png', '2022-02-18 12:38:51', 1);
INSERT INTO `file` VALUES (46, '1_1645159134488_1645159134488.9j.png', '2022-02-18 12:38:54', 1);
INSERT INTO `file` VALUES (47, '1_1645159677513_1645159677513.9j.png', '2022-02-18 12:47:57', 1);
INSERT INTO `file` VALUES (48, '1_1645160132969_1645160132969.83u3ancqdtylXvFHXdjU0x3oYWWBEgIBBIC.png', '2022-02-18 12:55:32', 1);
INSERT INTO `file` VALUES (49, '1_1645161423453_1645161423453.9j.jpg', '2022-02-18 13:17:03', 1);
INSERT INTO `file` VALUES (50, '1_1645163070147_1645163070147.9j.jpg', '2022-02-18 13:44:30', 1);
INSERT INTO `file` VALUES (51, '1_1645163572710_1645163572710.buqe6br1jk5NDPfXf7v.png', '2022-02-18 13:52:53', 1);
INSERT INTO `file` VALUES (52, '1_1645163996781_1645163996781.fMwjLdPaDkYiWWhTFGS8uydLsbJTGEnVheSiRY6pZyCYZQizsRy6hB5NL9dQ8gxAQKFQKy3gAv4AUxCTEpN7vGmMTt7oXEAlOJhVJWaWIRdHe7e5Z15rzWmdk1s8sMfc7T53Sfb.png', '2022-02-18 13:59:57', 1);
INSERT INTO `file` VALUES (53, '1_1645164502044_1645164502044.9j.jpg', '2022-02-18 14:08:22', 1);
INSERT INTO `file` VALUES (54, '1_1645164511027_1645164511027.vrnTE+KDtZRFtBTUuIquD0ANmEzPYFAXqV1dIiUryfQAmzIqLAm7vkol7m4tyq5cN6hYWWB6kiAWwuJuobsrkXkkAsrDxxpFQclaPtESfIRMz83tnzU3SemC092n50zPOTO.png', '2022-02-18 14:08:31', 1);
INSERT INTO `file` VALUES (55, '1_1645168695141_1645168695141.efk3nvzXsJdm2SwMqVK7epVqv.png', '2022-02-18 15:18:15', 1);
INSERT INTO `file` VALUES (56, '1_1645168699051_1645168699051.933ZiZlJh0CBEIIEIp0qSqoIDaKXXH.png', '2022-02-18 15:18:19', 1);
INSERT INTO `file` VALUES (57, '1_1645170019988_1645170019988.u7M7KZtGoEEQgmd0HsXQUVQimJBfba.png', '2022-02-18 15:40:19', 1);
INSERT INTO `file` VALUES (58, '1_1645170022682_1645170022682.+nbzIBFDIL8hDkoaIiqwiiK6KrIi4qKxjFB6KyAVEjkOnqSTYg+Bh3ZRFMpk.png', '2022-02-18 15:40:22', 1);
INSERT INTO `file` VALUES (59, '1_1645170401543_1645170401543.Zx3zjnf+b73IwgFjz1Qtmf6N4RiAAW6eIx8KUWgqCQcDsoyWRE94Iu.png', '2022-02-18 15:46:41', 1);
INSERT INTO `file` VALUES (60, '1_1645170404253_1645170404253.+nbzIBFDIL8hDkoaIiqwiiK6KrIi4qKxjFB6KyAVEjkOnqSTYg+Bh3ZRFMpk.png', '2022-02-18 15:46:44', 1);
INSERT INTO `file` VALUES (61, '1_1645175281948_1645175281948.ek0yGhlRdgkuiMqiIDo6DGoQkOPAqICDUTaZVicJafrVP+fPeY09TS91.png', '2022-02-18 17:08:01', 1);
INSERT INTO `file` VALUES (62, '1_1645175489725_1645175489725.+w+9H3ue9PO.png', '2022-02-18 17:11:29', 1);
INSERT INTO `file` VALUES (63, '1_1645175777862_1645175777862.+w+9H3ue9PO.png', '2022-02-18 17:16:17', 1);
INSERT INTO `file` VALUES (64, '1_1645175960663_1645175960663.+w+9H3ue9PO.png', '2022-02-18 17:19:20', 1);
INSERT INTO `file` VALUES (65, '1_1645176024935_1645176024935.efk3nvzXsJdm2SwMqVK7epVqv.png', '2022-02-18 17:20:24', 1);
INSERT INTO `file` VALUES (66, '1_1645176027312_1645176027312.933ZiZlJh0CBEIIEIp0qSqoIDaKXXH.png', '2022-02-18 17:20:27', 1);
INSERT INTO `file` VALUES (67, '2_1645332161456_1645332161456.9j.jpg', '2022-02-20 12:42:41', 2);
INSERT INTO `file` VALUES (68, '2_1645334583142_1645334583142.f.jpg', '2022-02-20 13:23:03', 2);
INSERT INTO `file` VALUES (69, '1_1645354005088_1645354005088.9j.jpg', '2022-02-20 18:46:45', 1);
INSERT INTO `file` VALUES (70, '1_1645354089327_1645354089327.9j.jpg', '2022-02-20 18:48:09', 1);
INSERT INTO `file` VALUES (71, '1_1645354165635_1645354165635.9j.jpg', '2022-02-20 18:49:25', 1);
INSERT INTO `file` VALUES (72, '1_1645354202379_1645354202379.9j.jpg', '2022-02-20 18:50:02', 1);
INSERT INTO `file` VALUES (73, '1_1645354253725_1645354253725.9j.jpg', '2022-02-20 18:50:53', 1);
INSERT INTO `file` VALUES (74, '1_1645354276436_1645354276436.9j.jpg', '2022-02-20 18:51:16', 1);
INSERT INTO `file` VALUES (75, '1_1645354297439_1645354297439.9j.jpg', '2022-02-20 18:51:37', 1);
INSERT INTO `file` VALUES (76, '1_1645354321882_1645354321882.9j.jpg', '2022-02-20 18:52:01', 1);
INSERT INTO `file` VALUES (77, '1_1645354343996_1645354343996.9j.jpg', '2022-02-20 18:52:23', 1);
INSERT INTO `file` VALUES (78, '1_1645354384650_1645354384650.9j.jpg', '2022-02-20 18:53:04', 1);
INSERT INTO `file` VALUES (79, '1_1645354426362_1645354426362.9j.jpg', '2022-02-20 18:53:46', 1);
INSERT INTO `file` VALUES (80, '1_1645354444703_1645354444703.9j.jpg', '2022-02-20 18:54:04', 1);
INSERT INTO `file` VALUES (81, '1_1645354479379_1645354479379.9j.jpg', '2022-02-20 18:54:39', 1);
INSERT INTO `file` VALUES (82, '1_1645354512870_1645354512870.9j.jpg', '2022-02-20 18:55:12', 1);
INSERT INTO `file` VALUES (83, '1_1645354555698_1645354555698.9j.jpg', '2022-02-20 18:55:55', 1);
INSERT INTO `file` VALUES (84, '1_1645354592113_1645354592113.9j.jpg', '2022-02-20 18:56:32', 1);
INSERT INTO `file` VALUES (85, '1_1645354614596_1645354614596.9j.jpg', '2022-02-20 18:56:54', 1);
INSERT INTO `file` VALUES (86, '1_1645354645228_1645354645228.9j.jpg', '2022-02-20 18:57:25', 1);
INSERT INTO `file` VALUES (87, '1_1645354667997_1645354667997.9j.jpg', '2022-02-20 18:57:48', 1);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '订单主键',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户主键',
  `barber_id` int(0) NULL DEFAULT NULL COMMENT '理发师主键',
  `evaluate_id` int(0) NULL DEFAULT NULL COMMENT '评价主键',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格',
  `order_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单类型 对应barber.skill',
  `start_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '结束时间',
  `pay_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '支付时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (6, 2, 3, 1, '完成', '108', '发型设计', '2022-02-19 18:47:00', '2022-02-20 13:23:06', '2022-02-20 02:38:00');
INSERT INTO `order` VALUES (7, 3, 3, NULL, '服务中', '108', '发型设计', '2022-02-19 19:05:46', '2022-02-20 00:52:38', '2022-02-20 00:56:29');
INSERT INTO `order` VALUES (8, 3, 3, NULL, '取消排队', '108', '发型设计', '2022-02-20 00:11:13', '2022-02-20 00:19:29', '2022-02-20 00:56:29');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片链接',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生年代',
  `hair` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发长',
  `face` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '脸型',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '孤独的人总是晚归', '管理员', '1588643851', 'https://thirdwx.qlogo.cn/mmopen/vi_32/KgJSDhA6S2Lt0SmoJcoic141WBoXvsWw4vzAp04Seqh1HicLzaEQjpSsEMzicx1E0tD23jAv2Vp7ibKz6x3fZuUG1A/132', '女', '90后', '短发', '椭圆形', '程序员', '大专/本科');
INSERT INTO `user` VALUES (2, 'Jack Sparrow', 'vip', '15886438518', 'http://localhost:9191/hs/jack.jpg', '男', '90后', '短发', '椭圆形', '程序员', '大专/本科');
INSERT INTO `user` VALUES (3, 'Davy Jones', 'vip', '15886438511', 'http://localhost:9191/hs/davyjones(1).png', '男', '90后', '短发', '椭圆形', '程序员', '大专/本科');

SET FOREIGN_KEY_CHECKS = 1;
