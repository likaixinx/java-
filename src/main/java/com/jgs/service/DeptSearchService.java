package com.jgs.service;

import com.jgs.pojo.Department;

import java.util.List;

/**
 * @ClassName: com.jgs.service.DeptSearchService
 * @author: likaixin
 * @create: 2022年10月18日 20:58
 * @description:
 */
public interface DeptSearchService {
    List<Department> search(String name);
}
