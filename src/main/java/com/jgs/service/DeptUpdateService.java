package com.jgs.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author likaixin
 * @ClassName com.jgs.service.DeptUpdateService
 * @create 2022年10月19日 9:39
 * @desc:
 */
public interface DeptUpdateService {
    Integer updateDeptMsg( String deptName, String deptAddress, Integer id);
}
