package com.demo.service.impl;


import com.demo.mapper.EmpMapper;
import com.demo.pojo.Emp;
import com.demo.pojo.PageBean;
import com.demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//
//        //获取分页查询结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> page1 = empMapper.page(start, pageSize);
//
//        PageBean pageBean = new PageBean(count, page1);
//        return pageBean;
//
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        //执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;

    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.add(emp);
    }

    @Override
    public Emp searchEmpById(Integer id) {
        return empMapper.searchEmpById(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.updateEmp(emp);

    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);

    }
}
