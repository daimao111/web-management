package com.demo.service;

import com.demo.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    /**
     * 查询全部部门信息
     *
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept searchDeptById(Integer id);

    void updateDept(Dept dept);
}
