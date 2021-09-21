package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component // Bean 으로 등록해야 하므로
@Aspect // Aspect Class
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	// Around 애노테이션으로 pointcut 표시 해줌 (advice 가 적용될 위치)
	@Around("@annotation(LogExecutionTime)")
	// joinPoint => target method (LogExecutionTime 애노테이션이 붙은 method)
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// target method 실행하기 전 앞 뒤로 부가 기능을 붙여줌
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed(); // target method 실행

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return proceed;
	}

}
