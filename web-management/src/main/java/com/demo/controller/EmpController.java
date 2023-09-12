package com.demo.controller;

import com.demo.anno.Log;
import com.demo.pojo.Emp;
import com.demo.pojo.PageBean;
import com.demo.pojo.Result;
import com.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询参数{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    /**
     * 批量删除
     * @return
     */
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除的id为：{}",ids);
        empService.delete(ids);

        return Result.success();
    }

    /**
     * 添加员工
     * @param emp
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增的员工：{}",emp);
        empService.add(emp);

        return Result.success();
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result searchEmpById(@PathVariable Integer id){
        log.info("查询的员工id为{}",id);

        Emp emp = empService.searchEmpById(id);
        return Result.success(emp);
    }

    /**
     * 修改员工
     * @return
     */
    @Log
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        log.info("修改的员工信息为：{}",emp);

        empService.updateEmp(emp);
        return Result.success();

    }


}
