DROP TABLE IF EXISTS `edu`.`student`;
CREATE TABLE `edu`.`student` (
  `id` INT NOT NULL COMMENT '主键',
  `username` VARCHAR(45) NULL COMMENT '用户名',
  `password` VARCHAR(32) NULL COMMENT '密码',
  `nick` VARCHAR(45) NULL COMMENT '昵称',
  `real_name` VARCHAR(45) NULL COMMENT '真实姓名',
  `photo` VARCHAR(255) NULL COMMENT '头像',
  `age` TINYINT NULL COMMENT '年龄',
  `gender` CHAR(1) NULL COMMENT '性别',
  `birthday` DATE NULL COMMENT '生日',
  `cellphone` VARCHAR(45) NULL COMMENT '电话',
  `email` VARCHAR(45) NULL COMMENT '邮箱',
  `we_chat` VARCHAR(45) NULL COMMENT '微信',
  `wei_bo` VARCHAR(45) NULL COMMENT '微博',
  `qq` VARCHAR(45) NULL COMMENT 'qq',
  `province` VARCHAR(45) NULL COMMENT '省',
  `city` VARCHAR(45) NULL COMMENT '市',
  `district` VARCHAR(45) NULL COMMENT '区',
  `address` VARCHAR(45) NULL COMMENT '地址',
  `school` VARCHAR(45) NULL COMMENT '学校',
  `grade` VARCHAR(45) NULL COMMENT '年级',
  `status` CHAR(1) NULL COMMENT '状态，0：无效，1：有效',
  `version` TINYINT NULL COMMENT '版本',
  `creator` VARCHAR(45) NULL COMMENT '创建人',
  `created` DATETIME NULL COMMENT '创建时间',
  `modifier` VARCHAR(45) NULL COMMENT '修改人',
  `modified` DATETIME NULL COMMENT '修改时间',
  PRIMARY KEY (`id`));

  DROP TABLE IF EXISTS `edu`.`category`;
CREATE TABLE `edu`.`category` (
  `id` INT NOT NULL COMMENT '主键',
  `code` VARCHAR(45) NULL COMMENT '编号',
  `name` VARCHAR(32) NULL COMMENT '名称',
  `imgUrl` VARCHAR(45) NULL COMMENT '图片链接地址',
  `sequence` VARCHAR(45) NULL COMMENT '排序号',
  `status` CHAR(1) NULL COMMENT '状态，0：无效，1：有效',
  `version` TINYINT NULL COMMENT '版本',
  `creator` VARCHAR(45) NULL COMMENT '创建人',
  `created` DATETIME NULL COMMENT '创建时间',
  `modifier` VARCHAR(45) NULL COMMENT '修改人',
  `modified` DATETIME NULL COMMENT '修改时间',
  PRIMARY KEY (`id`));

