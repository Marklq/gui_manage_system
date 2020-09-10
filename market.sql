
CREATE TABLE 'loj '(
  'username' varchar(255) ,
  'action' varchar(255) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `loj` VALUES ('chilam', '登录动作');
INSERT INTO `loj` VALUES ('bob', '注册动作');


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `p_name` varchar(255) NOT NULL,
  `p_num` int(11) DEFAULT NULL,
  `p_price` int(11) DEFAULT NULL,
  `p_clazz` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `product` VALUES ('榴莲', '20', '50', '水果');
INSERT INTO `product` VALUES ('苹果', '50', '2', '水果');


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES ('bob', '123');
INSERT INTO `user` VALUES ('chilam', '123456');
