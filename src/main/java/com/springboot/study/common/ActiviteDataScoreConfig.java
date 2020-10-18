package com.springboot.study.common;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class ActiviteDataScoreConfig extends AbstractProcessEngineAutoConfiguration {

    @Bean(name={"activitiDataSource"})
    @Qualifier("activitiDataSource")
    @ConfigurationProperties(prefix = "activiti.datasource")
    public DataSource activitiDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
//            PlatformTransactionManager transactionManager,
//            SpringAsyncExecutor springAsyncExecutor) throws IOException {
//
//        return baseSpringProcessEngineConfiguration(
//                activitiDataSource(),
//                transactionManager,
//                springAsyncExecutor);
//    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            @Qualifier("activitiDataSource") DataSource activitidataSource,
            PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                activitidataSource,
                transactionManager,
                springAsyncExecutor);
    }


    }
