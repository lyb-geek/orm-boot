/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(200) DEFAULT NULL,
  `file_type` varchar(200) DEFAULT NULL,
  `file_path` longtext,
  `file_size` bigint(20) DEFAULT NULL,
  `belong` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

insert  into `t_file`(`id`,`file_name`,`file_type`,`file_path`,`file_size`,`belong`,`create_time`,`update_time`) values (1,'张三的附件','doc','http://www.geek.lyb.cn/file/zhangsan',350,'张三','2019-04-29 01:20:10','2019-04-29 01:20:10'),(2,'李四的附件','doc','http://www.geek.lyb.cn/file/lisi',150,'李四','2019-04-30 01:23:59','2019-04-30 01:23:59'),(3,'王珊的附件','pdf','http://www.geek.lyb.cn/file/wangshan',200,'王珊','2019-04-29 03:36:41','2019-04-29 03:36:41'),(4,'王达车的附件','doc','http://www.geek.lyb.cn/file/wangdache',250,'王达车','2019-04-29 03:37:53','2019-04-29 03:37:53'),(5,'陈文茵的附件','pdf','http://www.geek.lyb.cn/file/chenwenyin',300,'陈文茵','2019-04-29 03:39:20','2019-04-29 03:39:20');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `domain` varchar(50) DEFAULT NULL,
  `dept_name` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_name`,`sex`,`domain`,`dept_name`,`email`,`mobile`,`create_time`,`update_time`) values (1,'张三','男','geek.lyb.cn','oa产品部','zhangsan@geek.lyb.cn','18800000001','2019-04-28 02:53:06','2019-04-28 02:53:06'),(2,'李四','男','geek.lyb.cn','CRM产品部','lisi@geek.lyb.cn','18800000002','2019-04-28 02:54:56','2019-04-28 02:54:56'),(3,'王珊','女','geek.lyb.cn','邮局产品部','wangshan@geek.lyb.cn','18800000003','2019-04-28 02:58:40','2019-04-28 02:58:40'),(4,'王达车','男','geek.lyb.cn','建站事业部','wangdache@geek.lyb.cn','18800000004','2019-04-28 03:02:44','2019-04-28 03:02:44'),(5,'陈文茵','女','geek.lyb.test.cn','oa产品部','chenwenyin1@geek.lyb.cn','18800000006','2019-04-28 03:04:01','2019-04-28 03:07:49');

DROP TABLE IF EXISTS `t_domain`;

CREATE TABLE `t_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `domain_name` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `t_domain` */

insert  into `t_domain`(`id`,`domain_name`,`create_time`,`update_time`) values (1,'geek.lyb..cn','2019-04-29 14:20:10','2019-04-29 14:20:10'),(2,'test.cn','2019-04-29 03:18:43','2019-04-29 03:18:43'),(3,'onetest.cn','2019-04-29 03:19:22','2019-04-29 03:29:49'),(4,'demo.cn','2019-04-29 03:20:06','2019-04-29 03:20:06'),(5,'beta.cn','2019-04-29 03:21:01','2019-04-29 03:21:01');