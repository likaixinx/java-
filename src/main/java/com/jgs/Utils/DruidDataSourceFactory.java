package com.jgs.Utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @ClassName: com.jgs.Utils.DruidDataSourceFactory
 * @author: likaixin
 * @create: 2022年10月16日 21:50
 * @description:
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {
    //将Mybatis的内置连接池Pooled的数据源修改成Druid的数据源
    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
