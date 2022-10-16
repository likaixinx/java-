package com.jgs.test;

import com.jgs.Utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName: com.jgs.test.test
 * @author: likaixin
 * @create: 2022年10月16日 21:53
 * @description:
 */
public class test {
    @Test
    public void t1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        System.out.println("sqlSession = " + sqlSession);
    }
}
