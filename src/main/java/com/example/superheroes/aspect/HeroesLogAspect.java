package com.example.superheroes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.superheroes.annotation.HeroesLogMonitor;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class HeroesLogAspect {
  
	@Pointcut("@annotation(com.example.superheroes.annotation.HeroesLogMonitor)")
	public void pointCut() {

	}
  
	@Around(value = "pointCut()  && @annotation(heroesLogMonitor)")
	public Object recordSystemLog(ProceedingJoinPoint joinPoint, HeroesLogMonitor heroesLogMonitor ) throws Throwable {
	      long startTime = System.currentTimeMillis();
	      
	      var result = joinPoint.proceed(joinPoint.getArgs());
	      long endTime = System.currentTimeMillis();
	      var value = heroesLogMonitor.value();
	
	      log.info ("Accedió al módulo [{}] consumiendo {} / MS.", value, (endTime-startTime));
	      return result;
	  }
}
