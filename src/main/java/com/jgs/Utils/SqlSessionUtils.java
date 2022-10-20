package com.jgs.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ClassName: com.jgs.mybatis.utils.SqlSessionUtils
 * @author: likaixin
 * @create: 2022年09月26日 18:51
 * @description:
 */
public class SqlSessionUtils {
    private SqlSessionUtils(){

    }

    private static  SqlSessionFactory sessionFactory;
    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        try {
            sessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static SqlSession openSession(){
        return sessionFactory.openSession();
    }
}
