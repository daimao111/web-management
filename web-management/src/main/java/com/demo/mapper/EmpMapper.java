package com.demo.mapper;

import com.demo.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

//    /**
//     * 计算emp全体员工数量
//     * @return
//     */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /**
//     * 分页查询获取列表数据
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     *
     * @return
     */
//    @Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);


    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp searchEmpById(Integer id);

    void updateEmp(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteDeptById(Integer deptId);
}
