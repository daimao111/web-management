package com.demo.mapper;

import com.demo.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept (name,create_time,update_time) value(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查找部门
     * @param id
     * @return
     */
    @Select("select name,id,create_time,update_time from dept where id = #{id}")
    Dept searchDeptById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    @Update("update dept set name = #{name},create_time = #{createTime}, update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);
}
