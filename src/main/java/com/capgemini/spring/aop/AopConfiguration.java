package com.capgemini.spring.aop;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@EnableLoadTimeWeaving
public class AopConfiguration {

  @Bean
  public ProfilingAspect getProfilingAspect(CallMonitor callMonitor) {

    ProfilingAspect aspect = Aspects.aspectOf(ProfilingAspect.class);
    aspect.setCallMonitor(callMonitor);
    return aspect;

  }

}
