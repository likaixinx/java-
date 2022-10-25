package com.jgs.mapper;

import com.jgs.pojo.Department;
import com.jgs.pojo.DepartmentExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department row);

    int insertSelective(Department row);

    List<Department> selectAllDept();

    List<Department> searchByDepartmentName(@Param("name") String name);

    List<Department> selectByExample(DepartmentExample example);

    @Delete("delete from t_department where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Department row, @Param("example") DepartmentExample example);

    int updateByExample(@Param("row") Department row, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department row);

    int updateByPrimaryKey(Department row);

    //修改部门信息
    Integer updateDeptMsg(@Param("departmentName") String deptName, @Param("departmentAddress") String deptAddress, @Param("id") Integer id);

    //添加部门信息
    @Insert("insert into t_department (department_name,department_address,department_eid) values(#{departmentName},#{departmentAddress},#{did})")
    Integer addDept(@Param("departmentName") String deptName, @Param("departmentAddress") String deptAddress, @Param("did") Integer did);

    @Select("select department_eid from t_department")
    List<Integer> selectByAllDid();

    //修改头像
    @Insert("insert into personal values(null,#{path})")
    Integer modifyHead(@Param("path") String path);

    //查头像
    @Select("  SELECT path FROM personal ORDER BY id  desc LIMIT 1")
    String selectHead();
}