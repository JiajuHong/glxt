CREATE TABLE IF NOT EXISTS `tblcontact`
(
    `contId`
    INT
    UNSIGNED
    AUTO_INCREMENT,
    `contName`
    varchar
(
    20
),
    `contSex` char
(
    2
),
    `contBirthday` DATE,
    `contNative` varchar
(
    20
),
    `contClass` varchar
(
    20
),
    `contDuty` char
(
    20
),
    `contUnit` varchar
(
    50
),
    PRIMARY KEY
(
    `contId`
)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `tblcontact`
VALUES ('1', '李明', '男', '2000-05-06', '湖北', '计算机31631', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('2', '李明', '男', '2000-05-06', '安徽', '计算机31633', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('3', '李小明', '男', '2000-05-06', '江苏', '网络31631', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('4', '李明明', '女', '2000-08-06', '山东', '机械31631', '维修师', '无锡大行');
INSERT INTO `tblcontact`
VALUES ('5', '张朋', '男', '2000-05-06', '安徽', '计算机31632', '工程师', '安徽格致');
INSERT INTO `tblcontact`
VALUES ('6', '李萌', '女', '2001-05-06', '江苏', '网络31731', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('7', '杨小东', '男', '2000-05-06', '山东', '计算机31631', '工程师', '安徽格致');
INSERT INTO `tblcontact`
VALUES ('8', '李明', '男', '2000-07-06', '四川', '会计31631', '会计师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('9', '许多多', '女', '2000-05-06', '浙江', '计算机31631', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('10', '李明', '男', '2000-05-06', '安徽', '物联网31631', '工程师', '浙江宁远');
INSERT INTO `tblcontact`
VALUES ('11', '陈松明', '男', '2000-05-06', '江苏', '计算机31633', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('12', '赵晓波', '女', '1998-05-06', '江苏', '软件31431', 'UI工程师', '南京海润');
INSERT INTO `tblcontact`
VALUES ('13', '李明', '男', '2001-06-06', '浙江', '计算机31632', '工程师', '江苏远方');
INSERT INTO `tblcontact`
VALUES ('14', '王小波', '男', '2000-05-06', '安徽', '计算机31631', '工程师', '南京海润');
INSERT INTO `tblcontact`
VALUES ('15', '陈冬', '男', '2000-05-06', '湖北', '电商31631', '营销师', '浙江拼宝有限');
