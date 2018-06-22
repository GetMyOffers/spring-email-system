package io.nebulas.notify_platform.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * created by Keqi Huang on 2018/6/20.
 */
@Configuration
@Import(DataSourceProperties.class)
@MapperScan(basePackages = {"io.nebulas.notify_platform.domain.mapper"})
public class NotifyplatformDataSourceConfig {

    @Autowired
    private DataSourceProperties properties;

    @Primary
    @Bean(name = "notifyplatformDataSource")
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(properties.getNotifyplatformJdbcUrl());
        ds.setDriverClassName(properties.getDriverClass());
        ds.setUsername(properties.getNotifyplatformUsername());
        ds.setPassword(properties.getNotifyplatformPassword());
        ds.setInitialSize(properties.getMinPoolSize());
        ds.setMinIdle(properties.getMinPoolSize());
        ds.setMaxActive(properties.getMaxPoolSize());
        ds.setMaxWait(60000);
        ds.setMinEvictableIdleTimeMillis(300000);
        return ds;
    }

    @Primary
    @Bean(name = "notifyplatformSqlSessionFactory")
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("notifyplatformDataSource") DataSource dataSource) {
        MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        return fb;
    }

    @Primary
    @Bean(name = "notifyplatformTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("notifyplatformDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "notifyplatformSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("notifyplatformSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
