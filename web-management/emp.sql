create table emp
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)                  not null comment '用户名',
    password    varchar(32) default '123456' null comment '密码',
    name        varchar(10)                  not null comment '姓名',
    gender      tinyint unsigned             not null comment '性别, 说明: 1 男, 2 女',
    image       varchar(300)                 null comment '图像',
    job         tinyint unsigned             null comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
    entrydate   date                         null comment '入职时间',
    dept_id     int unsigned                 null comment '部门ID',
    create_time datetime                     not null comment '创建时间',
    update_time datetime                     not null comment '修改时间',
    constraint username
        unique (username)
)
    comment '员工表';

INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.emp (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES (18, 'linpingzhi', '123456', '林平之', 1, 'http://tlias.itheima.com/1.jpg', 1, '2015-09-18', 1, '2023-09-07 15:20:28', '2023-09-07 15:20:28');