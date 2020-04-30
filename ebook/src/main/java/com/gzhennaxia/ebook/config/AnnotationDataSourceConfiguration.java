package com.gzhennaxia.ebook.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.gzhennaxia.ebook.mapper.annotation", sqlSessionFactoryRef = "annotationSqlSessionFactory",sqlSessionTemplateRef = "annotationSqlSessionTemplate")
public class AnnotationDataSourceConfiguration {

    @Bean(name = "annotationDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.annotation")
    public DataSource annotationDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "annotationSqlSessionFactory")
    public SqlSessionFactory annotationSqlSessionFactory(@Qualifier("annotationDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/annotation/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("annotationSqlSessionTemplate")
    public SqlSessionTemplate annotationSqlSessionTemplate(@Qualifier("annotationSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
