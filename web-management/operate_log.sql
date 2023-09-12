create table operate_log
(
    id            int unsigned auto_increment comment 'ID'
        primary key,
    operate_user  int unsigned  null comment '操作人ID',
    operate_time  datetime      null comment '操作时间',
    class_name    varchar(100)  null comment '操作的类名',
    method_name   varchar(100)  null comment '操作的方法名',
    method_params varchar(1000) null comment '方法参数',
    return_value  varchar(2000) null comment '返回值',
    cost_time     bigint        null comment '方法执行耗时, 单位:ms'
)
    comment '操作日志表';

INSERT INTO tlias.operate_log (id, operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (1, 1, '2023-09-13 01:51:28', 'com.demo.controller.DeptController', 'add', '[Dept(id=null, name=人事部, createTime=null, updateTime=null)]', '{"code":1,"msg":"success"}', 9);
INSERT INTO tlias.operate_log (id, operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) VALUES (2, 1, '2023-09-13 01:52:57', 'com.demo.controller.DeptController', 'delete', '[3]', '{"code":1,"msg":"success"}', 32);