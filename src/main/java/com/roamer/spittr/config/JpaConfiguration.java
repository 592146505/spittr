package com.roamer.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

/**
 * JPA相关配置
 * @author roamer
 * @version V1.0
 * @date 2018/1/31
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.roamer.spittr.**.dao"})
public class JpaConfiguration {

    /**
     * 使用Spring容器管理的EntityManagerFactory
     *
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        //设置JPA数据源
        entityManagerFactory.setDataSource(dataSource);
        //setJpaVendorAdapter方法用于指明所使用的是哪一个厂商的JPA实现
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setPackagesToScan("com.roamer.spittr.**.pojo");
        return entityManagerFactory;
    }

    /**
     * JPA实现
     *
     * @return
     */
    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setShowSql(true);
        //关闭自动根据pojo创建表
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return jpaVendorAdapter;
    }
}
