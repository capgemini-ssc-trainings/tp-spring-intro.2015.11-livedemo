package com.capgemini.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

@Aspect
public class ProfilingAspect {

  @Autowired
  CallMonitor callMonitor;

  Logger sLogger = LoggerFactory.getLogger(ProfilingAspect.class);

  @Pointcut(value = "execution(* com.capgemini..service.BookService.*(..))")
  public void serviceMethod() {

  }

  @Around("serviceMethod()")
  public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    if (this.callMonitor.isEnabled()) {

      StopWatch sw = new StopWatch(proceedingJoinPoint.toShortString());
      this.sLogger.info("Profiling of " + proceedingJoinPoint.toString() + "started");
      try {
        sw.start();
        return proceedingJoinPoint.proceed();
      } finally {

        synchronized (this.callMonitor) {
          this.callMonitor.registerCall(1);
        }

        sw.stop();
        this.sLogger.info(sw.prettyPrint());
        this.sLogger.info("Profiling of " + proceedingJoinPoint.toString() + "finished after "
            + sw.getTotalTimeMillis() + "ms");
      }

    } else {
      return proceedingJoinPoint.proceed();
    }

  }

  public void setCallMonitor(CallMonitor callMonitor) {

    this.callMonitor = callMonitor;
  }
}
