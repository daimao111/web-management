create table dept
(
    id          int unsigned auto_increment comment '主键ID'
        primary key,
    name        varchar(10) not null comment '部门名称',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '修改时间',
    constraint name
        unique (name)
)
    comment '部门表';

INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (1, '学工部', '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (2, '教研部', '2023-09-06 17:17:20', '2023-09-06 17:17:20');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (8, '后勤部', '2023-09-06 23:56:29', '2023-09-07 01:17:38');
INSERT INTO tlias.dept (id, name, create_time, update_time) VALUES (10, '人事部', '2023-09-13 01:51:28', '2023-09-13 01:51:28');