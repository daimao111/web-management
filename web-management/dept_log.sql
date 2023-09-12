create table dept_log
(
    id          int auto_increment comment '主键ID'
        primary key,
    create_time datetime     null comment '操作时间',
    description varchar(300) null comment '操作描述'
)
    comment '部门操作日志表';

INSERT INTO tlias.dept_log (id, create_time, description) VALUES (1, '2023-09-12 17:09:04', '执行了解散部门的操作，解散的是 3 号部门');
INSERT INTO tlias.dept_log (id, create_time, description) VALUES (2, '2023-09-13 01:51:33', '执行了解散部门的操作，解散的是 3 号部门');
INSERT INTO tlias.dept_log (id, create_time, description) VALUES (3, '2023-09-13 01:52:57', '执行了解散部门的操作，解散的是 3 号部门');