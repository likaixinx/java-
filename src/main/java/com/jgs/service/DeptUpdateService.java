package com.jgs.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author likaixin
 * @ClassName com.jgs.service.DeptUpdateService
 * @create 2022年10月19日 9:39
 * @desc:
 */
public interface DeptUpdateService {
    //修改部门
    Integer updateDeptMsg( String deptName, String deptAddress, Integer id);
    //添加部门
    Integer addDept(String deptName, String deptAddress);
    //删除部门
    Integer delDeptId(Integer id);
}
