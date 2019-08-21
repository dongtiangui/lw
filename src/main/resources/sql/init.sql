CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_admin`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`adminId` VARCHAR(32) NOT NULL ,
	`adminName` VARCHAR(128) NOT NULL,
	`adminPass` VARCHAR(256) NOT NULL,
	`status` INT(2) NOT NULL ,
	`salt` VARCHAR(128) NOT NULL,
	`createTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`upTime` VARCHAR(64) NULL,
	 PRIMARY KEY (`id`,`adminId`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_role`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` varchar(20) NOT NULL COMMENT '角色id',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称',
  `roleDescription` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `roleStatus` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_permission`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionId` varchar(20) NOT NULL COMMENT '权限id',
  `permissionName` varchar(100) NOT NULL COMMENT '权限名称',
  `permissionDescription` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `permissionUrl` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `permissionPerms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parentId` int(11) DEFAULT NULL COMMENT '父级权限id',
  `permissionType` int(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `permissionIcon` varchar(50) DEFAULT NULL COMMENT '图标',
  `permissionStatus` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_role_permision`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` varchar(20) NOT NULL COMMENT '用户id',
  `permissionId` varchar(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_admin_role`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` varchar(20) NOT NULL COMMENT '用户id',
  `roleId` varchar(20) NOT NULL COMMENT '角色id',
   PRIMARY KEY (`id`)

)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lovewall`.`lovewall_ user_info`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`userId` VARCHAR(64) NOT NULL COMMENT '用户id',
	`userName` VARCHAR(128) NOT NULL COMMENT '用户名',
	`passWord` VARCHAR(256) NOT NULL COMMENT '',
	`userPhone` VARCHAR(32) NOT NULL COMMENT '',
	`userAge` INT(11) NULL COMMENT '',
	`userGender` INT(1) NULL COMMENT '',
	`nowLoginTime` VARCHAR(32) NULL COMMENT '',
	`lastLoginTime` VARCHAR(32) NULL COMMENT '',
	`loginCode` VARCHAR(32) NULL COMMENT '',
	`isMember` INT(1) NULL COMMENT '',
	PRIMARY KEY(id,userId)

)ENGINE=InnoDB DEFAULT CHARSET=utf8



-- oauth2
CREATE TABLE IF NOT EXISTS `lovewall`.`oauth_clientdetails` (
  `appId` VARCHAR(128) NOT NULL,
  `resourceIds` VARCHAR(256) NULL DEFAULT NULL,
  `appSecret` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `grantTypes` VARCHAR(256) NULL DEFAULT NULL,
  `redirectUrl` VARCHAR(256) NULL DEFAULT NULL,
  `authorities` VARCHAR(256) NULL DEFAULT NULL,
  `access_token_validity` INT(11) NULL DEFAULT NULL,
  `refresh_token_validity` INT(11) NULL DEFAULT NULL,
  `additionalInformation` VARCHAR(4096) NULL DEFAULT NULL,
  `autoApproveScopes` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`appId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 
 
-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_access_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lovewall`.`oauth_access_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL,
  `refresh_token` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 
 
-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_approvals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lovewall`.`oauth_approvals` (
  `userId` VARCHAR(256) NULL DEFAULT NULL,
  `clientId` VARCHAR(256) NULL DEFAULT NULL,
  `scope` VARCHAR(256) NULL DEFAULT NULL,
  `status` VARCHAR(10) NULL DEFAULT NULL,
  `expiresAt` DATETIME NULL DEFAULT NULL,
  `lastModifiedAt` DATETIME NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 
-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_client_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lovewall`.`oauth_client_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication_id` VARCHAR(128) NOT NULL,
  `user_name` VARCHAR(256) NULL DEFAULT NULL,
  `client_id` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 
 
-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lovewall`.`oauth_code` (
  `code` VARCHAR(256) NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 
 
-- -----------------------------------------------------
-- Table `oatuh2`.`oauth_refresh_token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oauth2`.`oauth_refresh_token` (
  `token_id` VARCHAR(256) NULL DEFAULT NULL,
  `token` BLOB NULL DEFAULT NULL,
  `authentication` BLOB NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `lovewall_system_log` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID', 
`username` varchar(50) DEFAULT NULL COMMENT '操作用户', 
 `operation` text COMMENT '操作内容', 
 `time` decimal(11,0) DEFAULT NULL COMMENT '耗时',  
 `method` text COMMENT '操作方法',
 `params` text COMMENT '方法参数', 
 `ip_address` varchar(64) DEFAULT NULL COMMENT '操作者IP',
 `create_time` varchar(128) DEFAULT NULL COMMENT'创建时间', 
 `location` text COMMENT '操作地点',`ip` varchar(255) DEFAULT NULL,
 `time_field` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=6929 DEFAULT CHARSET=utf8

CREATE TABLE `system_announcement` (
  `an_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_create_time` timestamp NULL DEFAULT NULL,
  `an_title` varchar(128) DEFAULT NULL,
  `an_content` text,
  `an_pub_person` varchar(45) DEFAULT NULL,
  `an_version` int(11) DEFAULT NULL,
  `an_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`an_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
