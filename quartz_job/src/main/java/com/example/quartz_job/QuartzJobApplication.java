package com.example.quartz_job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuartzJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzJobApplication.class, args);
    }

}
