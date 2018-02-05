package com.roamer.spittr.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/10
 */
@Configuration
@ComponentScan(basePackages = {"com.roamer.spittr"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)}
)
@Import(value = {JpaConfiguration.class})
public class RootConfig {

    /**
     * 用于将带有@Repository注解的类产生的异常转换为Spring的统一数据访问异常
     *
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * 内存数据源
     *
     * @return
     */
    @Bean
    public DataSource embeddedDataSource() {
        //内存数据源
        return new EmbeddedDatabaseBuilder()
                //声明数据库类型
                .setType(EmbeddedDatabaseType.H2)
                //启动脚本
                .addScript("classpath:/sql/h2_type.sql")
                .addScript("classpath:/sql/schema.sql")
                .addScript("classpath:/sql/test-data.sql")
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
