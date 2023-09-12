package com.demo.service;

import com.demo.pojo.Emp;
import com.demo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp searchEmpById(Integer id);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
