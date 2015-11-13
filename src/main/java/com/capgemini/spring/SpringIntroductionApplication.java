package com.capgemini.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.capgemini.spring.repository"})
@EntityScan(basePackages = "com.capgemini.spring.model")
public class SpringIntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroductionApplication.class, args);
    }
}
