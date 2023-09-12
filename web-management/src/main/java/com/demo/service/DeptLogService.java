package com.demo.service;

import com.demo.pojo.DeptLog;

/**
 * 部门管理操作日志
 */
public interface DeptLogService {

    /**
     * 插入部门操作日志
     */
    public void insert(DeptLog deptLog);
}
