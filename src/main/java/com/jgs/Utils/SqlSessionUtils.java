package com.jgs.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: com.jgs.mybatis.utils.SqlSessionUtils
 * @author: likaixin
 * @create: 2022年09月26日 18:51
 * @description:
 */
public class SqlSessionUtils {
    private static  SqlSessionFactory factory;
    //使用线程锁实现只需打开一次Session，防止资源浪费
    private static final ThreadLocal<SqlSession> Local = new ThreadLocal<SqlSession>();

    //使用静态方法使得只需加载一次配置文件，防止资源浪费
    static {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //会话工厂
            factory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getFactory(){
        return factory;
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = Local.get();
        if (sqlSession == null){
            sqlSession = factory.openSession();
            Local.set(sqlSession);
        }
        return sqlSession;
    }

    public static <E extends Object>E getMapper(Class<E> c){
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(c);
    }
}
