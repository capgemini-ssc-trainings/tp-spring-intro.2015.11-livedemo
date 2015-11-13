package com.capgemini.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnProperty(value = "my.app.property")
public class MyConfiguration {

    private final MyProperties myProperties;

    @Autowired
    public MyConfiguration(MyProperties myProperties) {
        this.myProperties = myProperties;
        System.out.println("MyConfiguration");
    }

    @PostConstruct
    public void init() {
        System.out.println("");
    }
}
