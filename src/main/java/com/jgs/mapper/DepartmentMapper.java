package com.jgs.mapper;

import com.jgs.pojo.Department;
import com.jgs.pojo.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Department row);

    int insertSelective(Department row);

    List<Department> selectAllDept();
    List<Department> searchByDepartmentName(@Param("name") String name);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Department row, @Param("example") DepartmentExample example);

    int updateByExample(@Param("row") Department row, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department row);

    int updateByPrimaryKey(Department row);
    //修改部门信息
    Integer updateDeptMsg(@Param("departmentName") String deptName,@Param("departmentAddress") String deptAddress,@Param("id") Integer id);
}