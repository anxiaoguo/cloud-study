package com.axg.cloud.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import javax.sql.DataSource;

import io.seata.rm.datasource.xa.DataSourceProxyXA;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author wangzhongxiang
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
     @ConfigurationProperties(prefix = "spring.datasource")
     public DruidDataSource druidDataSource() {
         return new DruidDataSource();
     }

     @Bean("dataSourceProxy")
     public DataSource dataSource(DruidDataSource druidDataSource) {
         // DataSourceProxy for AT mode
         // return new DataSourceProxy(druidDataSource);

         // DataSourceProxyXA for XA mode
         return new DataSourceProxyXA(druidDataSource);
     }

}
