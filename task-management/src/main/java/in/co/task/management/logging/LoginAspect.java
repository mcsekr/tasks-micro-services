package in.co.task.management.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAspect.class);

	@Pointcut("execution ( * in.co.task.management.tasks..*(..))")
	public void pointcut() {

	}

	@Around("pointcut()")
	public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("start ->> " + joinPoint.getSignature());
		Object result = joinPoint.proceed();
		LOGGER.info("end ->> " + joinPoint.getSignature());
		return result;

	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "error")
	public void afterThrowingException(JoinPoint jp, Throwable error) {
		LOGGER.error(error.getMessage(), error);
	}

}
