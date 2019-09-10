DROP DATABASE IF EXISTS springmvcmybatis;

CREATE DATABASE springmvcmybatis;
GRANT ALL ON springmvcmybatis.* TO 'yaofei'@'localhost' IDENTIFIED BY 'yaofei123456';

USE springmvcmybatis;





CREATE TABLE `schedule_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `bean_name` varchar(200) NOT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) NOT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) NOT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT '0' COMMENT '任务状态。0：正常；1：暂停',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务表';



CREATE TABLE `schedule_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `schedule_job_id` bigint(20) NOT NULL COMMENT '任务ID',
  `bean_name` varchar(200) NOT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) NOT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  PRIMARY KEY (`id`),
  KEY `job_id` (`schedule_job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';



CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `item_key` varchar(50) DEFAULT NULL COMMENT '参数名',
  `item_value` varchar(2000) DEFAULT NULL COMMENT '参数值',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`item_key`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';




CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_real_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `opertion_class_name` varchar(255) DEFAULT NULL COMMENT '操作的类名称',
  `opertion_method_name` varchar(255) DEFAULT NULL COMMENT '操作的方法名称',
  `opertion_param_value` varchar(8000) DEFAULT NULL COMMENT '操作类的方法的参数值',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端ip',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统日志';



CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `user_department_id` bigint(20) NOT NULL COMMENT '部门ID',
  `real_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `password_salt` varchar(500) DEFAULT NULL COMMENT '密码盐值',
  `is_admin` bit(1) DEFAULT b'0' COMMENT '是否管理员',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `activated` bit(1) DEFAULT b'0' COMMENT '激活状态  0：未激活   1：已激活',
  `locked` bit(1) DEFAULT b'0' COMMENT '锁定状态  0：正常   1：锁定',
  `disabled` bit(1) DEFAULT b'0' COMMENT '禁用状态  0：正常 1：已禁用',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `idx_sys_user_modification_date` (`modification_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户表';



CREATE TABLE `sys_user_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父部门ID，一级部门为0',
  `parent_name` varchar(255) DEFAULT NULL COMMENT '父部门名称，一级部门为根部门',
  `name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `type` int(11) DEFAULT NULL COMMENT '类型   备用',
  `icon` varchar(255) DEFAULT NULL COMMENT '部门图标',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_sys_user_department_modification_date` (`modification_time`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统用户部门表';



CREATE TABLE `sys_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限ID，一级权限为0',
  `parent_name` varchar(255) DEFAULT NULL COMMENT '父权限名称，一级权限为根菜单',
  `name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `type` int(11) DEFAULT NULL COMMENT '类型。  1：系统  2：目录  3：菜单  4：按钮  5：接口',
  `url` varchar(255) DEFAULT NULL COMMENT '权限URL',
  `permission_code` varchar(255) DEFAULT NULL COMMENT '	权限代码。(多个用逗号分隔，如：user:list,user:create)',
  `icon` varchar(255) DEFAULT NULL COMMENT '权限图标',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_code_UNIQUE` (`permission_code`),
  KEY `idx_sys_user_permission_modification_date` (`modification_time`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='系统用户权限表';




CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色代码',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code_UNIQUE` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';




CREATE TABLE `sys_user_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `user_role_id` bigint(20) DEFAULT NULL COMMENT '用户角色ID',
  `user_permission_id` bigint(20) DEFAULT NULL COMMENT '用户权限ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户角色权限关系表';



CREATE TABLE `sys_user_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_role_id` bigint(20) DEFAULT NULL COMMENT '用户角色ID',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='系统用户角色关系表';









-- 初始化数据
INSERT INTO `schedule_job` (`id`,`bean_name`,`method_name`,`params`,`cron_expression`,`status`,`remark`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`) VALUES (1,'testTask','test','姚飞','0 0/30 * * * ?',0,'有参数测试','0','2017-02-22 18:22:11','admin','127.0.0.1','2017-02-23 18:39:02','admin','127.0.0.1');
INSERT INTO `schedule_job` (`id`,`bean_name`,`method_name`,`params`,`cron_expression`,`status`,`remark`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`) VALUES (2,'testTask','test2','','0 0/30 * * * ?',0,'无参数测试','0','2017-02-22 18:24:01','admin','127.0.0.1','2017-02-23 18:38:53','admin','127.0.0.1');



INSERT INTO `sys_user` (`id`,`user_department_id`,`real_name`,`username`,`password`,`password_salt`,`is_admin`,`mobile`,`email`,`activated`,`locked`,`disabled`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (1,1,'姚飞','admin','211f6e745e4fc502668341219776249de01ef8248445469825e5f7e900b8c08d','9c1c48b282a8cffe4d258ab8028502de','1','18637725488','cnyaofei@163.com','1','0','0','0','2017-02-15 22:46:28','admin','127.0.0.1','2017-02-21 19:53:51','admin','127.0.0.1','');
INSERT INTO `sys_user` (`id`,`user_department_id`,`real_name`,`username`,`password`,`password_salt`,`is_admin`,`mobile`,`email`,`activated`,`locked`,`disabled`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (2,3,'部门信息查看','bmxxck','79c118a2bc463bf1170121eb0667adc37e71a1b0b5a9bf4190fea54fb5c46e33','dea669584bf63ebfbe15c7729e6339c3','0','','','1','0','0','0','2017-02-16 09:57:08','admin','127.0.0.1','2017-02-21 19:53:51','admin','127.0.0.1','');
INSERT INTO `sys_user` (`id`,`user_department_id`,`real_name`,`username`,`password`,`password_salt`,`is_admin`,`mobile`,`email`,`activated`,`locked`,`disabled`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (3,4,'部门信息查看','bmxxwh','7d84d64eda194abb9ea5158de0f430636acb062606eba0af905aa492dc46c1dc','eecf00a8642118e0ee1ab300ce00ee95','0','','','1','0','0','0','2017-02-16 09:57:23','admin','127.0.0.1','2017-02-21 19:53:51','admin','127.0.0.1','');



INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (1,0,'根部门','IT技术部',NULL,NULL,1,'0','2017-02-15 22:38:26','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (2,1,'IT技术部','软件部',NULL,NULL,1,'0','2017-02-15 22:38:46','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (3,2,'软件部','开发一部',NULL,NULL,1,'0','2017-02-15 22:39:02','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (4,2,'软件部','开发二部',NULL,NULL,2,'0','2017-02-15 22:39:12','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (5,1,'IT技术部','系统集成部',NULL,NULL,2,'0','2017-02-15 22:39:26','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (6,0,'根部门','销售部',NULL,NULL,2,'0','2017-02-15 22:39:37','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');
INSERT INTO `sys_user_department` (`id`,`parent_id`,`parent_name`,`name`,`type`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (7,0,'根部门','行政部',NULL,NULL,3,'0','2017-02-15 22:39:47','admin','127.0.0.1','2017-02-21 19:55:40','admin','127.0.0.1','');




INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (1,0,'根目录','系统管理子系统',1,'','sysmanage:system','fa fa-support',1,'0','2017-02-15 22:49:56','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (2,1,'系统管理子系统','首页',2,'','index:menu','fa fa-home',1,'0','2017-02-19 10:58:59','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (3,1,'系统管理子系统','用户权限管理',2,'','userpermission:menu','fa fa-user-secret',2,'0','2017-02-16 09:37:49','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (4,3,'用户权限管理','部门管理',3,'admin/sysuserdepartment/list.html','sysuserdepartment:list','fa fa-institution',1,'0','2017-02-15 22:51:33','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (5,4,'部门管理','查询',4,'','sysuserdepartment:search','',1,'0','2017-02-15 22:52:20','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (6,4,'部门管理','添加',4,'','sysuserdepartment:add','',1,'0','2017-02-15 22:52:53','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (7,4,'部门管理','编辑',4,'','sysuserdepartment:edit','',1,'0','2017-02-15 22:53:14','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (8,4,'部门管理','删除',4,'','sysuserdepartment:delete','',1,'0','2017-02-15 22:53:35','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (9,4,'部门管理','批量删除',4,'','sysuserdepartment:batchdelete','',1,'0','2017-02-15 22:54:06','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (10,4,'部门管理','刷新',4,'','sysuserdepartment:refersh','',1,'0','2017-02-15 22:54:32','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (11,4,'部门管理','导出',4,'','sysuserdepartment:export','',1,'0','2017-02-15 22:54:51','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (12,3,'用户权限管理','权限管理',3,'admin/sysuserpermission/list.html','sysuserpermission:list','fa fa-key',1,'0','2017-02-15 22:56:07','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (13,12,'权限管理','查询',4,'','sysuserpermission:search','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (14,12,'权限管理','添加',4,'','sysuserpermission:add','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (15,12,'权限管理','编辑',4,'','sysuserpermission:edit','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (16,12,'权限管理','删除',4,'','sysuserpermission:delete','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (17,12,'权限管理','批量删除',4,'','sysuserpermission:batchdelete','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (18,12,'权限管理','刷新',4,'','sysuserpermission:refersh','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (19,12,'权限管理','导出',4,'','sysuserpermission:export','',1,'0','2017-02-15 22:57:08','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (20,3,'用户权限管理','角色管理',3,'admin/sysuserrole/list.html','sysuserrole:list','fa fa-users',1,'0','2017-02-15 23:04:31','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (21,20,'角色管理','查询',4,'','sysuserrole:search','',1,'0','2017-02-15 23:05:02','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (22,20,'角色管理','添加',4,'','sysuserrole:add','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (23,20,'角色管理','编辑',4,'','sysuserrole:edit','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (24,20,'角色管理','删除',4,'','sysuserrole:delete','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (25,20,'角色管理','批量删除',4,'','sysuserrole:batchdelete','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (26,20,'角色管理','刷新',4,'','sysuserrole:refersh','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (27,20,'角色管理','导出',4,'','sysuserrole:export','',1,'0','2017-02-15 23:08:01','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (28,3,'用户权限管理','用户管理',3,'admin/sysuser/list.html','sysuser:list','fa fa-user',1,'0','2017-02-15 23:09:42','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (29,28,'用户管理','查询',4,'','sysuser:search','',1,'0','2017-02-15 23:10:05','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (30,28,'用户管理','添加',4,'','sysuser:add','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (31,28,'用户管理','编辑',4,'','sysuser:edit','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (32,28,'用户管理','删除',4,'','sysuser:delete','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (33,28,'用户管理','批量删除',4,'','sysuser:batchdelete','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (34,28,'用户管理','刷新',4,'','sysuser:refersh','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (35,28,'用户管理','导出',4,'','sysuser:export','',1,'0','2017-02-15 23:12:11','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (36,1,'系统管理子系统','系统管理',2,'','sysmanage:menu','fa fa-laptop',3,'0','2017-02-20 18:49:32','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (37,36,'系统管理','参数管理',3,'admin/sysconfig/list.html','sysconfig:list','fa fa-gg',1,'0','2017-02-20 18:55:22','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (38,37,'参数管理','查询',4,'','sysconfig:search','',1,'0','2017-02-20 18:56:24','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (39,37,'参数管理','添加',4,'','sysconfig:add','',1,'0','2017-02-20 18:57:36','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (40,37,'参数管理','编辑',4,'','sysconfig:edit','',1,'0','2017-02-20 18:58:06','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (41,37,'参数管理','删除',4,'','sysconfig:delete','',1,'0','2017-02-20 18:58:29','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (42,37,'参数管理','批量删除',4,'','sysconfig:batchdelete','',1,'0','2017-02-20 18:59:45','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (43,37,'参数管理','刷新',4,'','sysconfig:refersh','',1,'0','2017-02-20 19:00:17','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (44,37,'参数管理','导出',4,'','sysconfig:export','',1,'0','2017-02-20 19:00:43','admin','127.0.0.1','2017-02-21 19:52:49','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (45,36,'系统管理','系统日志',3,'admin/syslog/list.html','syslog:list','fa fa-eye',1,'0','2017-02-21 17:55:20','admin','127.0.0.1','2017-02-21 17:55:20','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (46,45,'系统日志','查询',4,'','syslog:search','',1,'0','2017-02-21 18:03:42','admin','127.0.0.1','2017-02-21 18:03:42','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (47,45,'系统日志','刷新',4,'','syslog:refersh','',1,'0','2017-02-21 18:04:12','admin','127.0.0.1','2017-02-21 18:04:12','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (48,45,'系统日志','导出',4,'','syslog:export','',1,'0','2017-02-21 18:04:32','admin','127.0.0.1','2017-02-21 18:04:32','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (49,36,'系统管理','Druid监控',3,'/druid','druid:list','fa fa-heartbeat',1,'0','2017-02-21 18:05:33','admin','127.0.0.1','2017-02-21 19:50:56','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (50,36,'系统管理','定时任务管理',3,'admin/schedulejob/list.html','schedulejob:list','fa fa-clock-o',1,'0','2017-02-21 22:18:22','admin','127.0.0.1','2017-02-21 22:18:22','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (51,50,'定时任务管理','查询',4,'','schedulejob:search','',1,'0','2017-02-22 09:44:36','admin','127.0.0.1','2017-02-22 09:44:36','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (52,50,'定时任务管理','添加',4,'','schedulejob:add','',1,'0','2017-02-22 09:45:00','admin','127.0.0.1','2017-02-22 09:45:00','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (53,50,'定时任务管理','编辑',4,'','schedulejob:edit','',1,'0','2017-02-22 09:45:39','admin','127.0.0.1','2017-02-22 09:45:39','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (54,50,'定时任务管理','删除',4,'','schedulejob:delete','',1,'0','2017-02-22 09:46:04','admin','127.0.0.1','2017-02-22 09:46:04','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (55,50,'定时任务管理','批量删除',4,'','schedulejob:batchdelete','',1,'0','2017-02-22 09:46:37','admin','127.0.0.1','2017-02-22 09:46:37','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (56,50,'定时任务管理','暂停',4,'','schedulejob:pause','',1,'0','2017-02-22 09:47:02','admin','127.0.0.1','2017-02-22 09:47:02','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (57,50,'定时任务管理','恢复',4,'','schedulejob:resume','',1,'0','2017-02-22 09:47:26','admin','127.0.0.1','2017-02-22 09:47:26','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (58,50,'定时任务管理','立即执行',4,'','schedulejob:run','',1,'0','2017-02-22 09:47:43','admin','127.0.0.1','2017-02-22 09:47:43','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (59,50,'定时任务管理','刷新',4,'','schedulejob:refersh','',1,'0','2017-02-22 09:48:06','admin','127.0.0.1','2017-02-22 09:48:06','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (60,50,'定时任务管理','导出',4,'','schedulejob:export','',1,'0','2017-02-22 09:48:22','admin','127.0.0.1','2017-02-22 09:48:22','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (61,36,'系统管理','定时任务日志',3,'admin/schedulejoblog/list.html','schedulejoblog:list','fa fa-history',1,'0','2017-02-22 09:49:20','admin','127.0.0.1','2017-02-22 09:49:20','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (62,61,'定时任务日志','查询',4,'','schedulejoblog:search','',1,'0','2017-02-22 09:49:58','admin','127.0.0.1','2017-02-22 09:49:58','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (63,61,'定时任务日志','刷新',4,'','schedulejoblog:refersh','',1,'0','2017-02-22 09:50:19','admin','127.0.0.1','2017-02-22 09:50:19','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (64,61,'定时任务日志','导出',4,'','schedulejoblog:export','',1,'0','2017-02-22 09:50:36','admin','127.0.0.1','2017-02-22 09:50:36','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (65,36,'系统管理','代码生成器',3,'admin/syscodegenerator/list.html','syscodegenerator:list','fa fa-code',1,'0','2017-02-22 09:52:44','admin','127.0.0.1','2017-02-24 13:18:05','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (66,65,'代码生成器','查询',4,'','syscodegenerator:search','',1,'0','2017-02-24 13:35:31','admin','127.0.0.1','2017-02-24 13:35:31','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (67,65,'代码生成器','刷新',4,'','syscodegenerator:refersh','',1,'0','2017-02-24 13:31:46','admin','127.0.0.1','2017-02-24 13:31:46','admin','127.0.0.1','');
INSERT INTO `sys_user_permission` (`id`,`parent_id`,`parent_name`,`name`,`type`,`url`,`permission_code`,`icon`,`order_num`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (68,65,'代码生成器','生成代码',4,'','syscodegenerator:generatorCode','',1,'0','2017-02-24 13:32:45','admin','127.0.0.1','2017-02-24 13:32:45','admin','127.0.0.1','');






INSERT INTO `sys_user_role` (`id`,`name`,`role_code`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (1,'管理员','admin','0','2017-02-16 09:52:38','admin','127.0.0.1','2017-02-21 19:56:14','admin','127.0.0.1','');
INSERT INTO `sys_user_role` (`id`,`name`,`role_code`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (2,'部门信息维护角色','bmxxwhjs','0','2017-02-16 09:55:09','admin','127.0.0.1','2017-02-21 19:56:14','admin','127.0.0.1','');
INSERT INTO `sys_user_role` (`id`,`name`,`role_code`,`is_deleted`,`created_time`,`created_by`,`created_ip`,`modification_time`,`modification_by`,`modification_ip`,`remark`) VALUES (3,'部门信息查看角色','bmxxckjs','0','2017-02-16 09:56:25','admin','127.0.0.1','2017-02-21 19:56:14','admin','127.0.0.1','');







--  quartz相关表结构
CREATE TABLE QRTZ_JOB_DETAILS(
SCHED_NAME VARCHAR(120) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
JOB_CLASS_NAME VARCHAR(250) NOT NULL,
IS_DURABLE VARCHAR(1) NOT NULL,
IS_NONCONCURRENT VARCHAR(1) NOT NULL,
IS_UPDATE_DATA VARCHAR(1) NOT NULL,
REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
JOB_NAME VARCHAR(200) NOT NULL,
JOB_GROUP VARCHAR(200) NOT NULL,
DESCRIPTION VARCHAR(250) NULL,
NEXT_FIRE_TIME BIGINT(13) NULL,
PREV_FIRE_TIME BIGINT(13) NULL,
PRIORITY INTEGER NULL,
TRIGGER_STATE VARCHAR(16) NOT NULL,
TRIGGER_TYPE VARCHAR(8) NOT NULL,
START_TIME BIGINT(13) NOT NULL,
END_TIME BIGINT(13) NULL,
CALENDAR_NAME VARCHAR(200) NULL,
MISFIRE_INSTR SMALLINT(2) NULL,
JOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPLE_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
REPEAT_COUNT BIGINT(7) NOT NULL,
REPEAT_INTERVAL BIGINT(12) NOT NULL,
TIMES_TRIGGERED BIGINT(10) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CRON_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
CRON_EXPRESSION VARCHAR(120) NOT NULL,
TIME_ZONE_ID VARCHAR(80),
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_BLOB_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
BLOB_DATA BLOB NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
INDEX (SCHED_NAME,TRIGGER_NAME, TRIGGER_GROUP),
FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_CALENDARS (
SCHED_NAME VARCHAR(120) NOT NULL,
CALENDAR_NAME VARCHAR(200) NOT NULL,
CALENDAR BLOB NOT NULL,
PRIMARY KEY (SCHED_NAME,CALENDAR_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS (
SCHED_NAME VARCHAR(120) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP))
ENGINE=InnoDB;

CREATE TABLE QRTZ_FIRED_TRIGGERS (
SCHED_NAME VARCHAR(120) NOT NULL,
ENTRY_ID VARCHAR(95) NOT NULL,
TRIGGER_NAME VARCHAR(200) NOT NULL,
TRIGGER_GROUP VARCHAR(200) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
FIRED_TIME BIGINT(13) NOT NULL,
SCHED_TIME BIGINT(13) NOT NULL,
PRIORITY INTEGER NOT NULL,
STATE VARCHAR(16) NOT NULL,
JOB_NAME VARCHAR(200) NULL,
JOB_GROUP VARCHAR(200) NULL,
IS_NONCONCURRENT VARCHAR(1) NULL,
REQUESTS_RECOVERY VARCHAR(1) NULL,
PRIMARY KEY (SCHED_NAME,ENTRY_ID))
ENGINE=InnoDB;

CREATE TABLE QRTZ_SCHEDULER_STATE (
SCHED_NAME VARCHAR(120) NOT NULL,
INSTANCE_NAME VARCHAR(200) NOT NULL,
LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
CHECKIN_INTERVAL BIGINT(13) NOT NULL,
PRIMARY KEY (SCHED_NAME,INSTANCE_NAME))
ENGINE=InnoDB;

CREATE TABLE QRTZ_LOCKS (
SCHED_NAME VARCHAR(120) NOT NULL,
LOCK_NAME VARCHAR(40) NOT NULL,
PRIMARY KEY (SCHED_NAME,LOCK_NAME))
ENGINE=InnoDB;

CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS(SCHED_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS(SCHED_NAME,JOB_GROUP);

CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS(SCHED_NAME,CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_GROUP,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS(SCHED_NAME,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_STATE,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS(SCHED_NAME,MISFIRE_INSTR,NEXT_FIRE_TIME,TRIGGER_GROUP,TRIGGER_STATE);

CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,INSTANCE_NAME,REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS(SCHED_NAME,TRIGGER_GROUP);
