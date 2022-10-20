package com.jgs.service;

import com.jgs.pojo.Department;

import java.io.IOException;
import java.util.List;

/**
 * @author likaixin
 * @ClassName com.jgs.service.DeptPageService
 * @create 2022年10月17日 11:07
 * @desc:
 */
public interface DeptPageService {
    List<Department> selectAllPage() throws IOException;
}
