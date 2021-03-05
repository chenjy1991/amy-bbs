/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : amy_bbs

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 05/03/2021 16:30:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_config
-- ----------------------------
DROP TABLE IF EXISTS `bbs_config`;
CREATE TABLE `bbs_config` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `key` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置项',
  `value` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置值',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置项名称',
  `description` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置项描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统配置信息';

-- ----------------------------
-- Table structure for site_link
-- ----------------------------
DROP TABLE IF EXISTS `site_link`;
CREATE TABLE `site_link` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint DEFAULT NULL,
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `summary` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `logo` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='友情链接';

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `name` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='标签';

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `status` int NOT NULL DEFAULT '0',
  `node_id` int unsigned NOT NULL COMMENT '话题节点id，topic_node.id',
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  `title` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `summary` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '摘要',
  `recommend` tinyint NOT NULL DEFAULT '0' COMMENT '是否推广',
  `recommend_time` datetime(3) DEFAULT NULL COMMENT '推广时间',
  `view_count` int unsigned NOT NULL DEFAULT '0' COMMENT '浏览数',
  `comment_count` int unsigned NOT NULL DEFAULT '0' COMMENT '访问数',
  `like_count` int unsigned NOT NULL DEFAULT '0' COMMENT '点赞数',
  `last_comment_time` datetime(3) DEFAULT NULL COMMENT '最后评论时间',
  `last_comment_user_id` int unsigned DEFAULT NULL COMMENT '最后评论人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题';

-- ----------------------------
-- Table structure for topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `topic_comment`;
CREATE TABLE `topic_comment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态()',
  `topic_id` int unsigned NOT NULL COMMENT '话题id',
  `content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `quote_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '引用的评论id',
  `like_count` int unsigned NOT NULL DEFAULT '0' COMMENT '点赞数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题评论';

-- ----------------------------
-- Table structure for topic_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `topic_comment_like`;
CREATE TABLE `topic_comment_like` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `comment_id` bigint unsigned NOT NULL COMMENT '用户话题回复id，topic_comment.id',
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题回复点赞表';

-- ----------------------------
-- Table structure for topic_content
-- ----------------------------
DROP TABLE IF EXISTS `topic_content`;
CREATE TABLE `topic_content` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `topic_id` int unsigned NOT NULL,
  `body_content` text COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章内容',
  `extra_content` text COLLATE utf8mb4_general_ci COMMENT '扩展内容，图片，附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题内容';

-- ----------------------------
-- Table structure for topic_like
-- ----------------------------
DROP TABLE IF EXISTS `topic_like`;
CREATE TABLE `topic_like` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `topic_id` int unsigned NOT NULL COMMENT '话题id',
  `user_id` int unsigned NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户点赞表';

-- ----------------------------
-- Table structure for topic_node
-- ----------------------------
DROP TABLE IF EXISTS `topic_node`;
CREATE TABLE `topic_node` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `is_activated` tinyint NOT NULL COMMENT '是否激活',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `node_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题板块';

-- ----------------------------
-- Table structure for topic_tag
-- ----------------------------
DROP TABLE IF EXISTS `topic_tag`;
CREATE TABLE `topic_tag` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `topic_id` int unsigned NOT NULL COMMENT '话题id',
  `tag_id` int unsigned NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='话题标签';

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `id_deleted` tinyint NOT NULL DEFAULT '0',
  `is_activated` tinyint NOT NULL DEFAULT '0' COMMENT '账户是否激活',
  `roles` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色',
  `nickname` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `avatar` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `background_image` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个人主页背景图',
  `home_page` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个人主页',
  `desc` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个人描述',
  `score` bigint unsigned NOT NULL DEFAULT '0' COMMENT '积分',
  `topic_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '主题(帖子)数量',
  `comment_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '回复数量',
  `forbidden_end_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '禁言结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_base_nickname_uindex` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户基础表';

-- ----------------------------
-- Table structure for user_message
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  `is_read` tinyint NOT NULL DEFAULT '0' COMMENT '是否已读',
  `from_user_id` int unsigned NOT NULL COMMENT '发信人',
  `send_user_id` int unsigned NOT NULL COMMENT '收信人id',
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `content` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容，最大200字符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户站内信';

-- ----------------------------
-- Table structure for user_secret
-- ----------------------------
DROP TABLE IF EXISTS `user_secret`;
CREATE TABLE `user_secret` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `user_id` bigint unsigned NOT NULL COMMENT '用户id',
  `secret_type` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密钥类型',
  `secret_id` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密钥id',
  `secret_key` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密钥值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户密钥';

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `create_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `user_id` bigint unsigned NOT NULL,
  `refresh_token` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `refresh_expire` datetime(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户token表';

SET FOREIGN_KEY_CHECKS = 1;
