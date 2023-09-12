package com.demo.controller;

import com.demo.anno.Log;
import com.demo.pojo.Dept;
import com.demo.pojo.Result;
import com.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;


    /**
     * 查询全部部门数据
     *
     * @return
     */
    //    @RequestMapping("depts")
//    @GetMapping("/depts")
    @GetMapping
    public Result list() {
        log.info("查询全部部门信息");

        //调用service查询部门信息
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     *
     * @return
     */
//    @DeleteMapping("/depts/{id}")
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
//    @PostMapping("/depts")
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result searchDeptById(@PathVariable Integer id){
        log.info("查询部门id为：{}",id);
        Dept dept = deptService.searchDeptById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @Log
    @PutMapping()
    public Result updateDept(@RequestBody Dept dept){
        log.info("修改部门:{}",dept);
        deptService.updateDept(dept);
        log.info("修改部门:{}",dept);
        return Result.success();
    }

}
