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
@MapperScan(basePackages = "com.gzhennaxia.ebook.mapper.library", sqlSessionFactoryRef = "librarySqlSessionFactory", sqlSessionTemplateRef = "librarySqlSessionTemplate")
public class LibraryDataSourceConfiguration {

    @Bean(name = "libraryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.library")
    public DataSource libraryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "librarySqlSessionFactory")
    public SqlSessionFactory librarySqlSessionFactory(@Qualifier("libraryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/library/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("librarySqlSessionTemplate")
    public SqlSessionTemplate librarySqlSessionTemplate(@Qualifier("librarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
