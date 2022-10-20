package com.jgs.mapper;

import com.jgs.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author likaixin
 * @ClassName com.jgs.dao.AdminMapper
 * @create 2022年09月29日 21:47
 * @desc:
 */
public interface AdminMapper {
    //查询账号密码是否正确
    @Select("select `name`,`pwd` from `admin` where `name`=#{username} and `pwd`=#{password}")
    Admin selectAdmin(@Param("username") String username, @Param("password") String password);

    //添加新管理员
    @Insert("insert into `admin` (id,name,pwd) values(null,#{username},#{password})")
    Integer addAdmin(@Param("username") String username, @Param("password") String password);

    //查询是否有这个用户
    @Select("select * from `admin` where name=#{name}")
    Admin selectAdminExist(@Param("name") String name);

    //查询是否有这个用户
    @Select("select * from `admin` where name =#{name}")
    Admin SelectForget(String name);

    //修改密码
    @Update("update `admin` set `pwd`=#{pwd} where `name`=#{username}")
    Integer updatePassword(@Param("pwd") String password, @Param("username") String username);

    //查询是否和旧密码一致
    @Select("select `name`,pwd from `admin` where name=#{name} and pwd=#{pwd}")
    Admin selectOldPassword(@Param("name") String name, @Param("pwd") String pwd);

}
