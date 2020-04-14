package com.example.quartz_job.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @ProjectName: quartz
 * @Package: com.example.quartz_job.config
 * @ClassName: TaskConfig
 * @Author: wxy
 * @Description: gongchanglei
 * @Date: 2020/4/13 14:02
 * @Version: 1.0
 */
@Configuration
public class TaskConfig {

    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean getSchedulerFactoryBean(){
        return new SchedulerFactoryBean();
    }
}
