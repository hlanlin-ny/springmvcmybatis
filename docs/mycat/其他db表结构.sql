/*
Navicat MySQL Data Transfer

Source Server         : my_mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : intelligence_management_411329

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-31 14:10:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID，一级为0',
  `type` int(11) DEFAULT NULL COMMENT '类型：1省份、2市、3区县',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(45) DEFAULT NULL COMMENT '编码',
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
  KEY `idx_sys_area_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统行政区划表';

-- ----------------------------
-- Records of sys_area
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
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
) ENGINE=InnoDB AUTO_INCREMENT=801 DEFAULT CHARSET=utf8 COMMENT='系统日志';


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='系统用户表';


-- ----------------------------
-- Table structure for sys_user_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_department`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户部门表';



-- ----------------------------
-- Table structure for sys_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission`;
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
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8 COMMENT='系统用户权限表';


-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_permission`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色权限关系表';

-- ----------------------------
-- Records of sys_user_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_user_role`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色关系表';




DROP TABLE IF EXISTS `intelligence_business_type`;

CREATE TABLE `intelligence_business_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID，一级为0',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `icon` varchar(255) DEFAULT NULL COMMENT '时间轴图标',
  `background_color` varchar(45) DEFAULT NULL COMMENT '时间轴图标背景色',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='情报业务类型';


DROP TABLE IF EXISTS `intelligence_import`;

CREATE TABLE `intelligence_import` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) NOT NULL COMMENT '情报业务类型ID',
  `file_type` int DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `filename` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `file_url` varchar(1000) DEFAULT NULL COMMENT '文件上传路径',
  `file_desc` varchar(4000) DEFAULT NULL COMMENT '文件内容描述',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',

  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='情报导入记录';


CREATE DEFINER=`root`@`localhost` FUNCTION `getParentListSysArea`(rootId varchar(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE fid varchar(100) default '';
DECLARE str varchar(1000) default rootId;

WHILE rootId is not null  do
    SET fid =(SELECT parent_id FROM sys_area WHERE id = rootId);
    IF fid is not null THEN
        SET str = concat(str, ',', fid);
        SET rootId = fid;
    ELSE
        SET rootId = fid;
    END IF;
END WHILE;
return str;
END



DROP function IF EXISTS `getParentListSysArea`;

DELIMITER $$
# USE `intelligence_management_02`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `getParentListSysArea`(rootId varchar(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE fid varchar(100) default '';
DECLARE str varchar(1000) default rootId;

WHILE rootId is not null  do
    SET fid =(SELECT parent_id FROM sys_area WHERE id = rootId);
    IF fid is not null THEN
        SET str = concat(str, ',', fid);
        SET rootId = fid;
    ELSE
        SET rootId = fid;
    END IF;
END WHILE;
return str;
END$$

DELIMITER ;

-- select * from sys_area where FIND_IN_SET(id,getParentListSysArea(1))


CREATE DEFINER=`root`@`localhost` FUNCTION `getParentListIntelligenceBusinessType`(rootId varchar(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE fid varchar(100) default '';
DECLARE str varchar(1000) default rootId;

WHILE rootId is not null  do
    SET fid =(SELECT parent_id FROM intelligence_business_type WHERE id = rootId);
    IF fid is not null THEN
        SET str = concat(str, ',', fid);
        SET rootId = fid;
    ELSE
        SET rootId = fid;
    END IF;
END WHILE;
return str;
END



DROP function IF EXISTS `getParentListIntelligenceBusinessType`;

DELIMITER $$
# USE `intelligence_management_02`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `getParentListIntelligenceBusinessType`(rootId varchar(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE fid varchar(100) default '';
DECLARE str varchar(1000) default rootId;

WHILE rootId is not null  do
    SET fid =(SELECT parent_id FROM intelligence_business_type WHERE id = rootId);
    IF fid is not null THEN
        SET str = concat(str, ',', fid);
        SET rootId = fid;
    ELSE
        SET rootId = fid;
    END IF;
END WHILE;
return str;
END$$

DELIMITER ;

-- select * from intelligence_business_type where FIND_IN_SET(id,getParentListIntelligenceBusinessType(1))







DROP TABLE IF EXISTS `intelligence_share_permission`;

CREATE TABLE `intelligence_share_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划ID',
  `share_to_area_id` bigint(20) DEFAULT NULL COMMENT '共享给的行政区划ID',
  `intelligence_business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='情报共享授权关系表';





DROP TABLE IF EXISTS `search_log`;

CREATE TABLE `search_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划ID',
  `file_type` int DEFAULT NULL COMMENT '文件类型',
  `intelligence_business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `keyword` varchar(500) DEFAULT NULL COMMENT '关键词',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='搜索日志表';



DROP TABLE IF EXISTS `common_tool`;

CREATE TABLE `common_tool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `url` varchar(1000) DEFAULT NULL COMMENT '链接地址',
  `is_deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='常用工具表';




-- ----------------------------
-- Table structure for logistics_company
-- ----------------------------

DROP TABLE IF EXISTS `logistics_company`;
CREATE TABLE `logistics_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',

  `name` varchar(500) DEFAULT NULL COMMENT '公司名称',
  `address` varchar(1000) DEFAULT NULL COMMENT '公司地址',
  `police_office` varchar(500) DEFAULT NULL COMMENT '所属公安机关',
  `contact_person` varchar(500) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系电话',
  `emergency_contact_person` varchar(500) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(500) DEFAULT NULL COMMENT '紧急联系电话',

  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='物流公司信息表';

# CREATE TABLE `logistics_company` (
#   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
#   `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
#   `name` varchar(500) DEFAULT NULL COMMENT '公司名称',
#   `remark` varchar(500) DEFAULT NULL COMMENT '备注',
#   `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
#   `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#   `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
#   `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
#   `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
#   `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
#   `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
#   PRIMARY KEY (`id`),
#   UNIQUE KEY `key` (`name`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流公司信息表';


-- ----------------------------
-- Table structure for logistics_company
-- ----------------------------
DROP TABLE IF EXISTS `logistics_user`;

CREATE TABLE `logistics_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司编号',

  `branch_name` varchar(100) DEFAULT NULL COMMENT '网点名称',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `police_office` varchar(500) DEFAULT NULL COMMENT '所属公安机关',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `password_salt` varchar(500) DEFAULT NULL COMMENT '密码盐值',
  `seckey` varchar(500) DEFAULT NULL COMMENT '密钥',

  `contact_person` varchar(500) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系电话',

  `emergency_contact_person` varchar(500) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(500) DEFAULT NULL COMMENT '紧急联系电话',


  `activated` bit(1) DEFAULT b'0' COMMENT '激活状态  0：未激活   1：已激活',
  `locked` bit(1) DEFAULT b'0' COMMENT '锁定状态  0：正常   1：锁定',
  `disabled` bit(1) DEFAULT b'0' COMMENT '禁用状态  0：正常 1：已禁用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='物流网点信息表';

# CREATE TABLE `logistics_user` (
#   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
#   `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
#   `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司编号',
#   `real_name` varchar(100) DEFAULT NULL COMMENT '姓名',
#   `username` varchar(20) NOT NULL COMMENT '用户名',
#   `password` varchar(500) NOT NULL COMMENT '密码',
#   `password_salt` varchar(500) DEFAULT NULL COMMENT '密码盐值',
#   `mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
#   `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
#   `address` varchar(1000) DEFAULT NULL COMMENT '网点地址',
#   `activated` bit(1) DEFAULT b'0' COMMENT '激活状态  0：未激活   1：已激活',
#   `locked` bit(1) DEFAULT b'0' COMMENT '锁定状态  0：正常   1：锁定',
#   `disabled` bit(1) DEFAULT b'0' COMMENT '禁用状态  0：正常 1：已禁用',
#   `remark` varchar(500) DEFAULT NULL COMMENT '备注',
#   `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
#   `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#   `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
#   `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
#   `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
#   `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
#   `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
#   PRIMARY KEY (`id`),
#   UNIQUE KEY `key` (`username`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流用户信息表';


DROP TABLE IF EXISTS `logistics_record`;
CREATE TABLE `logistics_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',

  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',

  `sender_id_card_num` varchar(50) NOT NULL COMMENT '发件人身份证号码',
  `sender_name` varchar(500) NOT NULL COMMENT '发件人姓名',
  `sender_phone` varchar(50) DEFAULT NULL COMMENT '发件人电话',
  `receiver_name` varchar(500) NOT NULL COMMENT '收件人姓名',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '收件人电话',
  `receiver_address` varchar(1000) DEFAULT NULL COMMENT '收件人地址',
  `goods_name`  varchar(500) NOT NULL COMMENT '货物名称',

  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流记录表';




-- ----------------------------
-- Table structure for express_company
-- ----------------------------
DROP TABLE IF EXISTS `express_company`;
CREATE TABLE `express_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `name` varchar(500) DEFAULT NULL COMMENT '公司名称',

  `address` varchar(1000) DEFAULT NULL COMMENT '公司地址',
  `police_office` varchar(500) DEFAULT NULL COMMENT '所属公安机关',
  `contact_person` varchar(500) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系电话',
  `emergency_contact_person` varchar(500) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(500) DEFAULT NULL COMMENT '紧急联系电话',

  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快递公司信息表';


-- ----------------------------
-- Table structure for express_company
-- ----------------------------
DROP TABLE IF EXISTS `express_user`;
CREATE TABLE `express_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司编号',
  `branch_name` varchar(100) DEFAULT NULL COMMENT '网点名称',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `police_office` varchar(500) DEFAULT NULL COMMENT '所属公安机关',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `password_salt` varchar(500) DEFAULT NULL COMMENT '密码盐值',
  `seckey` varchar(500) DEFAULT NULL COMMENT '密钥',

  `contact_person` varchar(500) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(500) DEFAULT NULL COMMENT '联系电话',

  `emergency_contact_person` varchar(500) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(500) DEFAULT NULL COMMENT '紧急联系电话',

  `activated` bit(1) DEFAULT b'0' COMMENT '激活状态  0：未激活   1：已激活',
  `locked` bit(1) DEFAULT b'0' COMMENT '锁定状态  0：正常   1：锁定',
  `disabled` bit(1) DEFAULT b'0' COMMENT '禁用状态  0：正常 1：已禁用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快递网点信息表';


DROP TABLE IF EXISTS `express_record`;
CREATE TABLE `express_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',

  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',

  `sender_id_card_num` varchar(50) NOT NULL COMMENT '发件人身份证号码',
  `sender_name` varchar(500) NOT NULL COMMENT '发件人姓名',
  `sender_phone` varchar(50) DEFAULT NULL COMMENT '发件人电话',
  `receiver_name` varchar(500) NOT NULL COMMENT '收件人姓名',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '收件人电话',
  `receiver_address` varchar(1000) DEFAULT NULL COMMENT '收件人地址',
  `goods_name`  varchar(500) NOT NULL COMMENT '货物名称',

  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快递记录表';




DROP TABLE IF EXISTS `intelligence_officer`;
CREATE TABLE `intelligence_officer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` bit(1) NOT NULL DEFAULT b'0' COMMENT '性别  0:男 1:女',
  `id_numbers` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证号',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `adress` varchar(1000) DEFAULT NULL COMMENT '住址',
  `hire_date` datetime DEFAULT NULL COMMENT '入职时间',
  `profession` varchar(100) DEFAULT NULL COMMENT '职业',
  `marital_status` int(1) DEFAULT NULL COMMENT '婚姻状况',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(20) DEFAULT NULL COMMENT '微信号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `status` int(1) DEFAULT '0' COMMENT '信息员状态 0:启用 1,停用 2,失效',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `belongwechat` int(10) DEFAULT NULL COMMENT '所属微信群',
  `is_officer` bit(1) DEFAULT b'0' COMMENT '是否升级为情报员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='情报员信息表';


DROP TABLE IF EXISTS `intelligence`;
CREATE TABLE `intelligence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `title` varchar(1000) NOT NULL COMMENT '协查标题',
  `intelligence_officer_id` varchar(50) NOT NULL COMMENT '上报人',
  `reporting_time` datetime DEFAULT NULL COMMENT '上报时间',
  `info_desc` varchar(1000) NOT NULL,
  `found_time` date DEFAULT NULL COMMENT '发现时间',
  `level` int(1) DEFAULT '0' COMMENT '情报级别 0，一般；1，重要；2，非常重要',
  `awards_status` bit(1) DEFAULT b'0' COMMENT '奖励状态：0，未奖励；1，已奖励',
  `awards_desc` varchar(1000) DEFAULT NULL COMMENT '奖励描述',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='情报信息表';



DROP TABLE IF EXISTS `sys_wechat`;
CREATE TABLE `sys_wechat` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `name` varchar(500) NOT NULL COMMENT '群名称',
  `desc` varchar(1000) DEFAULT NULL COMMENT '描述',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='信息员微信群';




-- ----------------------------
-- Records of sys_wechat
-- ----------------------------
INSERT INTO `sys_wechat` VALUES ('1', '客车司机群', null, '', '2017-08-19 09:47:09', null, null, '2017-08-19 09:47:09', null, null);
INSERT INTO `sys_wechat` VALUES ('2', '保安群', null, '', '2017-08-19 09:47:09', null, null, '2017-08-19 09:47:09', null, null);
INSERT INTO `sys_wechat` VALUES ('3', '骑手群', null, '', '2017-08-19 09:47:09', null, null, '2017-08-19 09:47:09', null, null);
INSERT INTO `sys_wechat` VALUES ('4', '环卫部门群', null, '', '2017-08-17 09:31:22', null, null, '2017-08-17 09:31:22', null, null);
INSERT INTO `sys_wechat` VALUES ('5', '快递群', null, '', '2017-08-19 09:47:09', null, null, '2017-08-19 09:47:09', null, null);



DROP TABLE IF EXISTS `sys_searchwarning_config`;
CREATE TABLE `sys_searchwarning_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `keywords` varchar(255) NOT NULL COMMENT '关键字',
  `businessTypeId` varchar(255) DEFAULT NULL COMMENT '情报类型',
  `businessTypeName` varchar(1000) DEFAULT NULL COMMENT '情报类型',
  `fileType` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `fileTypeName` varchar(1000) DEFAULT NULL COMMENT '文件类型',
  `start_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '查询数据开始时间',
  `notice_to` varchar(255) DEFAULT NULL COMMENT '通知人',
  `notice_to_name` varchar(500) DEFAULT NULL COMMENT '通知人名称',
  `notice_bccs` varchar(30) DEFAULT NULL COMMENT '抄送人们，多个抄送人ID用逗号隔开',
  `is_Exact_matching` bit(1) DEFAULT b'0' COMMENT '是否精确匹配  0：否   1：是',
  `status` int(10) DEFAULT '0' COMMENT '状态  1：使用   0：禁用',
  `notice_frequency` varchar(30) DEFAULT NULL COMMENT '提醒频率，单位分钟',
  `cron_frequency` varchar(10) DEFAULT NULL COMMENT '执行频率',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `area_id` bigint(20) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='搜索预警配置表';


DROP TABLE IF EXISTS `sys_searchwarning_log`;
CREATE TABLE `sys_searchwarning_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `searchwarning_config_id` bigint(20) NOT NULL,
  `record_count` bigint(20) DEFAULT NULL COMMENT '记录条数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统搜索预警通知日志表';


DROP TABLE IF EXISTS `important_person`;
CREATE TABLE `important_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `name` varchar(100) NOT NULL COMMENT '重点人员姓名',
  `id_card_no` varchar(255) NOT NULL COMMENT '身份证号码',
  `sex` varchar(100) NOT NULL COMMENT '重点人员性别',
  `nation` varchar(100) DEFAULT NULL COMMENT '民族',
  `born_time` datetime NOT NULL COMMENT '出生日期',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `person_type`varchar(255) NOT NULL COMMENT '人员类别（涉恐人员、涉稳人员、在逃人员、涉毒人员、刑事犯罪前科人员、肇事肇祸精神病人、重点上访人员）',
  `full_name` varchar(100) DEFAULT NULL COMMENT '外文姓名',
  `other_certificate_no` varchar(255) DEFAULT NULL COMMENT '其他证件号码',
  `tel` varchar(255) NOT NULL COMMENT '手机号',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建人IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_card_no_UNIQUE` (`id_card_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='重点人员信息表';



DROP TABLE IF EXISTS `activity_detail`;
CREATE TABLE `activity_detail` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增id',
  `occur_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发生时间',
  `area_id` BIGINT(20) NULL DEFAULT NULL COMMENT '行政区划id',
  `area_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '行政区划名字',
  `provider_address` VARCHAR(255) NULL DEFAULT NULL COMMENT '发生地址',
  `information_provider` VARCHAR(255) NULL DEFAULT NULL COMMENT '消息归属',
  `police_office` VARCHAR(255) NULL DEFAULT NULL COMMENT '所属公安机关',
  `activity_information` VARCHAR(255) NULL DEFAULT NULL COMMENT '活动相关信息',
  `register_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '登记姓名',
  `register_idcard_no` VARCHAR(255) NULL DEFAULT NULL COMMENT '登记身份证号码',
  `register_born_date` DATETIME NULL DEFAULT NULL COMMENT '登记出生日期',
  `dynamic_information_type` VARCHAR(100) NULL DEFAULT NULL COMMENT '动态信息类别',
  `dynamic_information_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '动态信息提供单位',
  `accept_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '预警接受单位',
  `warning_level` VARCHAR(100) NULL DEFAULT NULL COMMENT '预警级别',
  `warning_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预警时间',
  `relate_id` BIGINT(20) NULL DEFAULT NULL COMMENT '关联id',
  `is_deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建人',
  `created_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建IP',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modification_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人',
  `modification_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人IP',
  `remark` VARCHAR(255) NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`))
  COMMENT = '活动信息详情';


DROP TABLE IF EXISTS `warning_dispostion`;
CREATE TABLE `warning_dispostion` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增id',
  `name` VARCHAR(100) NULL DEFAULT NULL COMMENT '重点人员姓名',
  `id_card_no` VARCHAR(100) NULL DEFAULT NULL COMMENT '身份证号码',
  `important_person_type` VARCHAR(100) NULL DEFAULT NULL COMMENT '重点人员类别',
  `warning_level` VARCHAR(100) NOT NULL DEFAULT '一般' COMMENT '预警级别：一般，重要，紧急',
  `warning_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预警时间',
  `information_type` VARCHAR(100) NULL DEFAULT NULL COMMENT '信息类别',
  `issue_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '指令发布单位',
  `information_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '所属社会场所',
  `provider_address` VARCHAR(100) NULL DEFAULT NULL COMMENT '活动发生区域',
  `police_office` VARCHAR(100) NULL DEFAULT NULL COMMENT '所属公安机关',
  `accept_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '预警接受单位',
  `disposition_status` VARCHAR(100) NOT NULL DEFAULT '未处置' COMMENT '处置状态 ： 未处置  处置中 处置完成',
  `disposition_time` DATETIME NULL DEFAULT NULL COMMENT '处置时间',
  `feed_back_status` VARCHAR(100) NULL DEFAULT '未反馈' COMMENT '反馈状态：未反馈，已反馈',
  `feed_back_time` DATETIME NULL DEFAULT NULL COMMENT '反馈时间',
  `feed_back_result` VARCHAR(100) NULL DEFAULT NULL COMMENT '反馈结果',
  `is_deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建人',
  `created_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建IP',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modification_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人',
  `modification_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人IP',
  `remark` VARCHAR(255) NULL DEFAULT '' COMMENT '备注',
  `relate_id` BIGINT(20) NULL DEFAULT NULL COMMENT '关联importantPerson id',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_card_no_UNIQUE` (`id_card_no` ASC))
  COMMENT = '预警处置详情';


DROP TABLE IF EXISTS `disposal_measures`;
CREATE TABLE `disposal_measures` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增id',
  `issuer_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '发布人',
  `disposition_time` DATETIME NULL DEFAULT NULL COMMENT '处置时间',
  `first_feed_time` DATETIME NULL DEFAULT NULL COMMENT '首次反馈时间',
  `issuer_provider` VARCHAR(100) NULL DEFAULT NULL COMMENT '发布单位',
  `remark` VARCHAR(255) NULL DEFAULT '' COMMENT '备注',
  `instruct_reuqest` VARCHAR(255) NULL DEFAULT '' COMMENT '指令要求',
  `result` VARCHAR(255) NULL DEFAULT '' COMMENT '研判结果',
  `relate_id` BIGINT(20) NULL DEFAULT NULL COMMENT '关联importantPerson id',
  `is_deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建人',
  `created_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建IP',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modification_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人',
  `modification_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`))
  COMMENT = '处置措施表';

;

DROP TABLE IF EXISTS `disposition_result`;
CREATE TABLE `disposition_result` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键  自增id',
  `disposition_time` DATETIME NULL DEFAULT NULL COMMENT '处置时间',
  `disposition_status` VARCHAR(45) NULL DEFAULT '未处置' COMMENT '处置状态',
  `disposition_result` VARCHAR(255) NULL DEFAULT '' COMMENT '处置结果',
  `relate_id` BIGINT(20) NULL DEFAULT NULL COMMENT '关联 importantPerson id',
  `is_deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建人',
  `created_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建IP',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modification_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人',
  `modification_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`))
  COMMENT = '处置结果';


DROP TABLE IF EXISTS `hospital_user`;
CREATE TABLE `hospital_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `hospital_id` bigint(20) DEFAULT NULL COMMENT '所属医院编号',
  `branch_name` varchar(100) DEFAULT NULL COMMENT '医院网点名称',
  `police_office` varchar(255) DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `password_salt` varchar(500) DEFAULT NULL COMMENT '密码盐值',
  `seckey` varchar(30) DEFAULT NULL COMMENT '密钥',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(1000) DEFAULT NULL COMMENT '地址',
  `contact_phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `emergency_contact_person` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(45) DEFAULT NULL COMMENT '紧急联系电话',
  `contact_person` varchar(255) DEFAULT NULL COMMENT '联系人',
  `activated` bit(1) DEFAULT b'0' COMMENT '激活状态  0：未激活   1：已激活',
  `locked` bit(1) DEFAULT b'0' COMMENT '锁定状态  0：正常   1：锁定',
  `disabled` bit(1) DEFAULT b'0' COMMENT '禁用状态  0：正常 1：已禁用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='医院网点信息';


DROP TABLE IF EXISTS `hospital_unit_information`;
CREATE TABLE `hospital_unit_information` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键 自增ID',
  `hospital_name` VARCHAR(100) NOT NULL COMMENT '医院名称',
  `hospital_address` VARCHAR(200) NOT NULL COMMENT '医院地址（详细地址）',
  `area` VARCHAR(100) NOT NULL COMMENT '所属区县(所属行政区划)',
  `police_office` VARCHAR(100) NOT NULL COMMENT '所属公安机关',
  `contact` VARCHAR(100) NULL COMMENT '联系人',
  `tel` VARCHAR(100) NULL COMMENT '联系电话',
  `emergency_contact` VARCHAR(100) NULL COMMENT '紧急联系人',
  `emergency-tel` VARCHAR(100) NULL COMMENT '紧急联系电话',
  `remark` VARCHAR(255) NULL COMMENT '备注',
  `is_deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建人',
  `created_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '创建IP',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modification_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人',
  `modification_ip` VARCHAR(255) NULL DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`))
  COMMENT = '医院单位信息';

DROP TABLE IF EXISTS `medical_checkin_checkout_record`;
CREATE TABLE `medical_checkin_checkout_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `info_key` bigint(20) DEFAULT NULL COMMENT '信息主键编号',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `name_spell` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `sex_code` varchar(225) DEFAULT NULL COMMENT '性别代码',
  `born_time` datetime DEFAULT NULL COMMENT '出生日期',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `id_card_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `profession` varchar(500) DEFAULT NULL COMMENT '职业',
  `organization` varchar(500) DEFAULT NULL COMMENT '工作单位',
  `house_head_name` varchar(255) DEFAULT NULL COMMENT '户主姓名',
  `family_population` int(11) DEFAULT NULL COMMENT '家庭人口数',
  `family_type` varchar(255) DEFAULT NULL COMMENT '家庭类别',
  `family_type_code` varchar(255) DEFAULT NULL COMMENT '家庭类型代码',
  `hospital_unit_name` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `medical_guarantee_number` varchar(255) DEFAULT NULL COMMENT '医保证号',
  `hospitalization_no` varchar(500) DEFAULT NULL COMMENT '住院号',
  `hospitalization_department` varchar(500) DEFAULT NULL COMMENT '住院科室',
  `bed_number` varchar(255) DEFAULT NULL COMMENT '床号',
  `hospital_way` varchar(500) DEFAULT NULL COMMENT '入院途径',
  `doctor_name` varchar(255) DEFAULT NULL COMMENT '医生名字',
  `admitting_diagnosis` varchar(500) DEFAULT NULL COMMENT '入院诊断',
  `discharge_diagnosis` varchar(500) DEFAULT NULL COMMENT '出院诊断',
  `subject_salvage` varchar(255) DEFAULT NULL COMMENT '救助对象',
  `subject_salvage_type` varchar(255) DEFAULT NULL COMMENT '救助对象类别',
  `subject_salvage_cost` decimal(18,2) DEFAULT NULL COMMENT '救助金额',
  `responsible_person_name` varchar(255) DEFAULT NULL COMMENT '经办人姓名',
  `hospitalization_datetime` datetime DEFAULT NULL COMMENT '住院时间',
  `leaveHospital_datetime` datetime DEFAULT NULL COMMENT '出院时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8 COMMENT='医疗住（出）院信息传输';

-- ----------------------------
-- Table structure for medical_checkin_checkout_record_transfer
-- ----------------------------
DROP TABLE IF EXISTS `medical_checkin_checkout_record_transfer`;
CREATE TABLE `medical_checkin_checkout_record_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `XXZJBH` bigint(20) DEFAULT NULL COMMENT '信息编号主键',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `XMHYPY` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `XB` varchar(100) DEFAULT NULL COMMENT '性别',
  `XBDM` varchar(225) DEFAULT NULL COMMENT '性别代码1 - 男性2 - 女性',
  `CSRQ` datetime DEFAULT NULL COMMENT '出生日期',
  `NL` int(11) DEFAULT NULL COMMENT '年龄',
  `idCardNo` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `profession` varchar(500) DEFAULT NULL COMMENT '职业',
  `workUnit` varchar(500) DEFAULT NULL COMMENT '工作单位',
  `HZ_XM` varchar(255) DEFAULT NULL COMMENT '户主姓名',
  `JTRK_RS` int(11) DEFAULT NULL COMMENT '家庭人口数',
  `JTLBDM` varchar(255) DEFAULT NULL COMMENT '家庭类别',
  `JTLB` varchar(255) DEFAULT NULL COMMENT '家庭类型代码',
  `YY_DWMC` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `YBZ_ZJHM` varchar(255) DEFAULT NULL COMMENT '医保证号',
  `hospitalizationNo` varchar(500) DEFAULT NULL COMMENT '住院号',
  `hospitalizationDepartment` varchar(500) DEFAULT NULL COMMENT '住院科室',
  `CH` varchar(255) DEFAULT NULL COMMENT '床号',
  `RYTJ_JYQK` varchar(500) DEFAULT NULL COMMENT '入院途径',
  `YS_XM` varchar(255) DEFAULT NULL COMMENT '医生名字',
  `RYZD_JYQK` varchar(500) DEFAULT NULL COMMENT '入院诊断',
  `CYZD_JYQK` varchar(500) DEFAULT NULL COMMENT '出院诊断',
  `JZDX_PDBZ` varchar(255) DEFAULT '' COMMENT '救助对象',
  `JZDXLB` varchar(255) DEFAULT '' COMMENT '救助对象类别',
  `JZJ_JE` decimal(18,2) DEFAULT NULL COMMENT '救助金额',
  `JBR_XM` varchar(255) DEFAULT NULL COMMENT '经办人姓名',
  `hospitalizationDatetime` datetime DEFAULT NULL COMMENT '住院时间',
  `leaveHospitalDatetime` datetime DEFAULT NULL COMMENT '出院时间',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8 COMMENT='医疗住（出）院信息传输';

-- ----------------------------
-- Table structure for medical_examination_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_examination_record`;
CREATE TABLE `medical_examination_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) NOT NULL COMMENT '姓名',
  `id_card_num` varchar(50) NOT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `profession` varchar(500) NOT NULL COMMENT '职业',
  `organization` varchar(500) NOT NULL COMMENT '工作单位',
  `examination_dateime` datetime NOT NULL COMMENT '体检时间',
  `examination_term` varchar(4000) NOT NULL COMMENT '体检项目',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='医疗体检信息';

-- ----------------------------
-- Table structure for medical_insurance_card_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_insurance_card_record`;
CREATE TABLE `medical_insurance_card_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `info_key` bigint(20) DEFAULT NULL COMMENT '信息主键编号',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `medical_type` varchar(255) DEFAULT NULL COMMENT '医疗类型',
  `medical_type_code` varchar(255) DEFAULT NULL COMMENT '医疗类型代码',
  `cost` decimal(18,6) DEFAULT NULL COMMENT '医疗费用金额',
  `hospitalization_datetime` datetime DEFAULT NULL COMMENT '住院时间',
  `leaveHospital_datetime` datetime DEFAULT NULL COMMENT '出院时间',
  `hospitalization_illness` varchar(255) DEFAULT NULL COMMENT '入院疾病',
  `diagnosis_hospitalization` varchar(255) DEFAULT NULL COMMENT '确诊疾病',
  `complication_detail` varchar(1000) DEFAULT NULL COMMENT '并发症简要情况',
  `leaveHospital_reason` varchar(500) DEFAULT NULL COMMENT '出院原因',
  `doctor` varchar(255) DEFAULT NULL COMMENT '医生姓名',
  `hospitalization_no` varchar(500) DEFAULT NULL COMMENT '住院号',
  `hospitalization_department` varchar(500) DEFAULT NULL COMMENT '住院科室',
  `take_datetime` datetime DEFAULT NULL COMMENT '办理日期',
  `responsible_person_name` varchar(255) DEFAULT NULL COMMENT '经办人姓名',
  `hospital_number` varchar(255) DEFAULT NULL COMMENT '医院编号',
  `person_number` varchar(255) DEFAULT NULL COMMENT '个人编号',
  `organization_number` varchar(255) DEFAULT NULL COMMENT '单位编号',
  `reimbursement_sign` varchar(255) DEFAULT NULL COMMENT '报销标志',
  `reimbursement_sign_detail` varchar(500) DEFAULT NULL COMMENT '报销标志_简要情况',
  `account_end_status` varchar(255) DEFAULT NULL COMMENT '结算状态',
  `account_end_status_detail` varchar(255) DEFAULT NULL COMMENT '结算状态_简要情况',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='医保刷卡记录信息';

-- ----------------------------
-- Table structure for medical_insurance_card_record_transfer
-- ----------------------------
DROP TABLE IF EXISTS `medical_insurance_card_record_transfer`;
CREATE TABLE `medical_insurance_card_record_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `XXZJBH` bigint(20) DEFAULT NULL COMMENT '信息编号主键',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `YLLBDM` varchar(255) DEFAULT NULL COMMENT '医疗类型',
  `YLLB` varchar(255) DEFAULT NULL COMMENT '医疗类型代码',
  `YLF_JE` decimal(18,6) DEFAULT NULL COMMENT '医疗费用金额',
  `RYRQ` datetime DEFAULT NULL COMMENT '住院时间',
  `CYRQ` datetime DEFAULT NULL COMMENT '出院时间',
  `RYJB_JYQK` varchar(255) DEFAULT NULL COMMENT '入院疾病',
  `QZJB_JYQK` varchar(255) DEFAULT NULL COMMENT '确诊疾病',
  `BFZ_JYQK` varchar(1000) DEFAULT NULL COMMENT '并发症简要情况',
  `CYYY_JYQK` varchar(500) DEFAULT NULL COMMENT '出院原因',
  `YS_XM` varchar(255) DEFAULT NULL COMMENT '医生姓名',
  `ZYH` varchar(500) DEFAULT NULL COMMENT '住院号',
  `KS_DWMC` varchar(500) DEFAULT NULL COMMENT '住院科室',
  `BLRQ` datetime DEFAULT NULL COMMENT '办理日期',
  `JBR_XM` varchar(255) DEFAULT NULL COMMENT '经办人姓名',
  `YYBH` varchar(255) DEFAULT NULL COMMENT '医院编号',
  `GRBH` varchar(255) DEFAULT NULL COMMENT '个人编号',
  `DWBH` varchar(255) DEFAULT NULL COMMENT '单位编号',
  `BXBZ` varchar(255) DEFAULT NULL COMMENT '报销标志',
  `BXBZ_JYQK` varchar(500) DEFAULT NULL COMMENT '报销标志_简要情况',
  `JSZT` varchar(255) DEFAULT NULL COMMENT '结算状态',
  `JSZT_JYQK` varchar(255) DEFAULT NULL COMMENT '结算状态_简要情况',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='医保刷卡记录信息ZQH-22-143600002 传输';

-- ----------------------------
-- Table structure for medical_newborn_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_newborn_record`;
CREATE TABLE `medical_newborn_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `info_key` bigint(20) DEFAULT NULL COMMENT '信息主键编号',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `sex_detail` varchar(500) DEFAULT NULL COMMENT '性别描述',
  `born_time` datetime DEFAULT NULL COMMENT '出生日期',
  `id_card_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `deliver_organization` varchar(255) DEFAULT NULL COMMENT '接生机构名称',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `check_in_datetime` datetime DEFAULT NULL COMMENT '信息登记时间',
  `mother_name` varchar(255) DEFAULT NULL COMMENT '母亲姓名',
  `mother_nation` varchar(255) DEFAULT NULL COMMENT '母亲民族',
  `mother_nation_detail` varchar(255) DEFAULT NULL COMMENT '母亲民族描述',
  `mother_idcardnum` varchar(255) DEFAULT NULL COMMENT '母亲身份证号',
  `mother_phone` varchar(255) DEFAULT NULL COMMENT '母亲联系电话',
  `father_name` varchar(255) DEFAULT NULL COMMENT '父亲姓名',
  `father_nation` varchar(255) DEFAULT NULL COMMENT '父亲民族',
  `father_nation_detail` varchar(255) DEFAULT NULL COMMENT '父亲民族描述',
  `father_idcardnum` varchar(255) DEFAULT NULL COMMENT '父亲身份证号',
  `father_phone` varchar(255) DEFAULT NULL COMMENT '父亲联系电话',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='新生儿出生信息';

-- ----------------------------
-- Table structure for medical_newborn_record_transfer
-- ----------------------------
DROP TABLE IF EXISTS `medical_newborn_record_transfer`;
CREATE TABLE `medical_newborn_record_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `XXZJBH` bigint(20) DEFAULT NULL COMMENT '信息编号主键',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `XM` varchar(500) DEFAULT NULL COMMENT '姓名',
  `XB` varchar(100) DEFAULT NULL COMMENT '性别',
  `XB_DMMS` varchar(500) DEFAULT NULL COMMENT '性别描述',
  `CSRQ` datetime DEFAULT NULL COMMENT '出生日期',
  `GMSFZH` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `JSJGMC` varchar(255) DEFAULT NULL COMMENT '接生机构名称',
  `JTZZ_DZMC` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `XXDJSJ` datetime DEFAULT NULL COMMENT '信息登记时间',
  `MQ_XM` varchar(255) DEFAULT NULL COMMENT '母亲姓名',
  `MQ_MZ` varchar(255) DEFAULT NULL COMMENT '母亲民族',
  `MQ_MZ_DMMS` varchar(255) DEFAULT NULL COMMENT '母亲民族描述',
  `MQ_GMSFZH` varchar(255) DEFAULT NULL COMMENT '母亲身份证号',
  `MQ_LXDH` varchar(255) DEFAULT NULL COMMENT '母亲联系电话',
  `FQ_XM` varchar(255) DEFAULT NULL COMMENT '父亲姓名',
  `FQ_MZ` varchar(255) DEFAULT NULL COMMENT '父亲民族',
  `FQ_MZ_DMMS` varchar(255) DEFAULT NULL COMMENT '父亲民族描述',
  `FQ_GMSFZH` varchar(255) DEFAULT NULL COMMENT '父亲身份证号',
  `FQ_LXDH` varchar(255) DEFAULT NULL COMMENT '父亲联系电话',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='新生儿出生信息ZQH-22-113600005 传输';

-- ----------------------------
-- Table structure for medical_outpatient_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_outpatient_record`;
CREATE TABLE `medical_outpatient_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `info_key` bigint(20) DEFAULT NULL COMMENT '信息主键编号',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `name_spell` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `sex_code` varchar(225) DEFAULT NULL COMMENT '性别代码',
  `born_time` datetime DEFAULT NULL COMMENT '出生日期',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `id_card_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `profession` varchar(500) DEFAULT NULL COMMENT '职业',
  `organization` varchar(500) DEFAULT NULL COMMENT '工作单位',
  `hospital_unit_name` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `diagnose_datetime` datetime DEFAULT NULL COMMENT '就诊时间',
  `diagnose_no` varchar(255) DEFAULT NULL COMMENT '门诊号',
  `diagnose_department` varchar(255) DEFAULT NULL COMMENT '科室名称',
  `cost_type` varchar(255) DEFAULT NULL COMMENT '人员费用类别（自费、医保（城镇医保、农村医保）等）',
  `cost_type_code` varchar(255) DEFAULT NULL COMMENT '人员类别代码',
  `medicare_card_no` varchar(255) DEFAULT NULL COMMENT '医保证号（含城镇医保、农村医保、费医保病人填就诊卡卡号（自费人员、外地人员））',
  `diagnose_result` varchar(4000) DEFAULT NULL COMMENT '医院诊断结果',
  `cost` decimal(10,0) DEFAULT NULL COMMENT '费用金额',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='医疗门诊信息';

-- ----------------------------
-- Table structure for medical_outpatient_record_transfer
-- ----------------------------
DROP TABLE IF EXISTS `medical_outpatient_record_transfer`;
CREATE TABLE `medical_outpatient_record_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `XXZJBH` bigint(20) DEFAULT NULL COMMENT '信息编号主键',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `XMHYPY` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `XB` varchar(100) DEFAULT NULL COMMENT '性别',
  `XBDM` varchar(225) DEFAULT NULL COMMENT '性别代码',
  `CSRQ` datetime DEFAULT NULL COMMENT '出生日期',
  `NL` int(11) DEFAULT NULL COMMENT '年龄',
  `idCardNo` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `profession` varchar(500) DEFAULT NULL COMMENT '职业',
  `workUnit` varchar(500) DEFAULT NULL COMMENT '工作单位',
  `YY_DWMC` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `diagnose_datetime` datetime DEFAULT NULL COMMENT '就诊时间',
  `diagnose_no` varchar(255) DEFAULT NULL COMMENT '门诊号',
  `diagnose_department` varchar(255) DEFAULT NULL COMMENT '科室名称',
  `cost_type` varchar(255) DEFAULT NULL COMMENT '人员费用类别（自费、医保（城镇医保、农村医保）等）',
  `RYLBDM` varchar(255) DEFAULT NULL COMMENT '人员类别代码',
  `medicare_card_no` varchar(255) DEFAULT NULL COMMENT '医保证号（含城镇医保、农村医保、费医保病人填就诊卡卡号（自费人员、外地人员））',
  `diagnose_result` varchar(4000) DEFAULT NULL COMMENT '医院诊断结果',
  `cost` decimal(10,0) DEFAULT NULL COMMENT '费用金额',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='医疗门诊信息传输';

-- ----------------------------
-- Table structure for medical_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `medical_patient_record`;
CREATE TABLE `medical_patient_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `info_key` bigint(20) DEFAULT NULL COMMENT '信息主键编号',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `name_spell` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `sex_code` varchar(225) DEFAULT NULL COMMENT '性别代码1 - 男性2 - 女性',
  `born_time` datetime DEFAULT NULL COMMENT '出生日期',
  `id_card_num_code` varchar(225) DEFAULT NULL COMMENT '身份证代码',
  `id_card_num_name` varchar(225) DEFAULT NULL COMMENT '身份证名称',
  `id_card_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `address` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `contact_person` varchar(500) DEFAULT NULL COMMENT '联系人',
  `contact_person_spell` varchar(255) DEFAULT NULL COMMENT '联系人姓名拼音',
  `contact_card_code` varchar(255) DEFAULT NULL COMMENT '常用证件代码',
  `contact_card_name` varchar(255) DEFAULT NULL COMMENT '常用证件名称',
  `contact_card_number` varchar(255) DEFAULT NULL COMMENT '常用证件号码',
  `contact_address` varchar(1000) DEFAULT NULL COMMENT '联系人现居地址',
  `contact_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `relation` varchar(255) DEFAULT NULL COMMENT '与患者的关系',
  `hospital_unit_name` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `blood_type` varchar(255) DEFAULT NULL COMMENT '血型',
  `blood_type_code` varchar(255) DEFAULT NULL COMMENT '血型代码',
  `hospitalized_reason` varchar(255) DEFAULT NULL COMMENT '住院原因',
  `hospitalized_datetime` datetime DEFAULT NULL COMMENT '住院日期',
  `leaveHospital_datetime` datetime DEFAULT NULL COMMENT '出院时间',
  `hospital_number` varchar(255) DEFAULT NULL COMMENT '医院编号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='医疗机构患者信息';

-- ----------------------------
-- Table structure for medical_patient_record_transfer
-- ----------------------------
DROP TABLE IF EXISTS `medical_patient_record_transfer`;
CREATE TABLE `medical_patient_record_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID',
  `XXZJBH` bigint(20) DEFAULT NULL COMMENT '信息编号主键',
  `area_id` bigint(20) DEFAULT NULL COMMENT '行政区划编号',
  `business_type_id` bigint(20) DEFAULT NULL COMMENT '情报业务分类ID',
  `file_type` int(11) DEFAULT NULL COMMENT '文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）',
  `details_url` varchar(1000) DEFAULT NULL COMMENT '详情页面url',
  `collect_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收集时间',
  `es_index_name` varchar(100) DEFAULT NULL COMMENT '插入es的时候用的es的索引名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '所属用户编号',
  `HZ_XM` varchar(500) DEFAULT NULL COMMENT '姓名',
  `HZ_XMHYPY` varchar(225) DEFAULT NULL COMMENT '姓名拼音',
  `HZ_XB` varchar(100) DEFAULT NULL COMMENT '性别',
  `HZ_XBDM` varchar(225) DEFAULT NULL COMMENT '性别代码1 - 男性2 - 女性',
  `HZ_CSRQ` datetime DEFAULT NULL COMMENT '出生日期',
  `HZ_CYZJDM` varchar(255) DEFAULT NULL COMMENT '患者_常用证件代码',
  `HZ_CYZJMC` varchar(255) DEFAULT NULL COMMENT '患者_常用证件名称',
  `HZ_ZJHM` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `HZ_XZZ_DZMC` varchar(1000) DEFAULT NULL COMMENT '家庭地址',
  `HZ_LXDH` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `LXR_XM` varchar(500) DEFAULT NULL COMMENT '联系人',
  `LXR_XMHYPY` varchar(255) DEFAULT NULL COMMENT '联系人姓名拼音',
  `LXR_CYZJDM` varchar(255) DEFAULT NULL COMMENT '常用证件代码',
  `LXR_CYZJMC` varchar(255) DEFAULT NULL COMMENT '常用证件名称',
  `LXR_ZJHM` varchar(255) DEFAULT NULL COMMENT '常用证件号码',
  `LXR_XZZ_DZMC` varchar(1000) DEFAULT NULL COMMENT '联系人现居地址',
  `LXR_LXDH` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `LXR_YHZGX_JYQK` varchar(255) DEFAULT NULL COMMENT '与患者的关系',
  `YYBH` varchar(255) DEFAULT NULL COMMENT '医院编号',
  `YY_DWMC` varchar(255) DEFAULT NULL COMMENT '医院单位名称',
  `XX` varchar(255) DEFAULT NULL COMMENT '血型',
  `XXDM` varchar(255) DEFAULT NULL COMMENT '血型代码',
  `ZYYY_JYQK` varchar(255) DEFAULT NULL COMMENT '住院原因',
  `ZYRQ` datetime DEFAULT NULL COMMENT '住院日期',
  `CYRQ` datetime DEFAULT NULL COMMENT '出院时间',
  `BZ` varchar(500) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_ip` varchar(255) DEFAULT NULL COMMENT '创建IP',
  `modification_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `modification_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `modification_ip` varchar(255) DEFAULT NULL COMMENT '修改人IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='医疗机构患者信息ZQH-22-113600001 传输';




DROP TABLE IF EXISTS `control_apply_application`;
CREATE TABLE `control_apply_application` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增ID' ,
  `control_by_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '被布控人姓名' ,
  `nick_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '绰号' ,
  `sex`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '性别' ,
  `born_time`  datetime NULL COMMENT '出生日期' ,
  `nation`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '民族' ,
  `card_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '证件类型' ,
  `card_number`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '证件号码' ,
  `address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '地址' ,
  `work_unit`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '工作单位' ,
  `control_reason`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '布控事由' ,
  `control_measure_require`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '布控措施要求' ,
  `control_require_type`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '布控指令类型' ,
  `control_begin_time`  datetime NULL COMMENT '布控开始时间' ,
  `control_end_time`  datetime NULL COMMENT '布控结束时间' ,
  `control_days`  int(11) NULL COMMENT '布控天数' ,
  `control_unit`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '布控单位' ,
  `feed_back_contact`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '反馈联系方式' ,
  `apply_unit`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请单位' ,
  `apply_unit_contact_tel`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请单位联系电话' ,
  `apply_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请人姓名' ,
  `apply_unit_principal`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请单位负责人姓名' ,
  `apply_safe_organ`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请公安机关负责人签字' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `is_deleted`  bit(1) NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除' ,
  `created_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `created_by`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
  `created_ip`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建IP' ,
  `modification_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间' ,
  `modification_by`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人' ,
  `modification_ip`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人IP' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='临时布控申请单'
  AUTO_INCREMENT=1
  ROW_FORMAT=DYNAMIC
;




DROP TABLE IF EXISTS `static_file_class`;
CREATE TABLE `static_file_class` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT ,
  `name`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '姓名' ,
  `sex`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '性别' ,
  `id_card_no`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '身份证号码' ,
  `address`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '户籍地址' ,
  `nation`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '民族' ,
  `profession`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '职业' ,
  `detail`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `is_deleted`  bit(1) NULL DEFAULT b'0' COMMENT '删除状态  0：正常   1：已删除' ,
  `created_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `created_by`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
  `created_ip`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建IP' ,
  `modification_time`  datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间' ,
  `modification_by`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人' ,
  `modification_ip`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人IP' ,
  PRIMARY KEY (`id`)
)
  COMMENT='静态文件上传类'
;




