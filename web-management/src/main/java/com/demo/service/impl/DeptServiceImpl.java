package com.demo.service.impl;


import com.demo.mapper.DeptMapper;
import com.demo.mapper.EmpMapper;
import com.demo.pojo.Dept;
import com.demo.pojo.DeptLog;
import com.demo.service.DeptLogService;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptLogService deptLogService;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)  //spring的事务管理
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id);
            empMapper.deleteDeptById(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，解散的是 "+id+" 号部门");
            deptLogService.insert(deptLog);
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept searchDeptById(Integer id) {
        Dept dept = deptMapper.searchDeptById(id);
        return dept;
    }

    @Override
    public void updateDept(Dept dept) {
        Dept dept1 = deptMapper.searchDeptById(dept.getId());
        dept.setCreateTime(dept1.getCreateTime());
        dept.setUpdateTime(LocalDateTime.now());

//        deptMapper.deleteById(dept.getId());
//        deptMapper.insert(dept);
        deptMapper.updateDept(dept);
    }
}
