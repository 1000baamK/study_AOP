package com.kh.aop.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

//특정 대상의 소요시간을 측정하기 위한 간섭 객체

@Slf4j
@Aspect
public class TimerAspect {

	/*
	 * 간섭 메소드(Advice)
	 * - 특수한 경우가 아니라면 메소드의 형태가 정해져있다.
	 * - 누구를 어떤 시점에 간섭할지는 어노테이션으로 설정한다.
	 * 
	 */
	
	/*
	@Before("target(com.kh.aop.model.dao.CategoryDaoImpl)")
	public void before() {
		
		log.debug("before 실행");
	}
	*/

	/*
	@Before("target(com.kh.aop.model.dao.CategoryDaoImpl)")
	public void before(JoinPoint jp) {
		log.debug("메소드 이름 : {}", jp.getSignature().getName());
		log.debug(jp.getSignature().toString());
		log.debug(jp.getSignature().getDeclaringTypeName());
		log.debug("before 실행");
	}
	*/
	
	/*
	@After("target(com.kh.aop.model.dao.CategoryDaoImpl)")
	public void complete(JoinPoint jp) {
		log.debug("메소드 이름 : {}", jp.getSignature().getName());
		log.debug(jp.getSignature().toString());
		log.debug(jp.getSignature().getDeclaringTypeName());
		log.debug("after 실행");
	}
	*/
	
	/*
	@AfterReturning(pointcut = "target(com.kh.aop.model.dao.CategoryDaoImpl)",
					returning = "returnObj")
	//돌아온 리턴값에 대해서 간섭가능
	public void complete(JoinPoint jp, Object returnObj) {
		System.out.println("jp : "+jp);
		System.out.println("메소드 : "+jp.getSignature().getName());
		System.out.println("리턴 : ");
		System.out.println(returnObj);
		
		for(Category c : (ArrayList<Category>)returnObj) {
			System.out.println(c);
		}
	}
	*/
	
	/*	
	@AfterThrowing(pointcut = "target(com.kh.aop.model.dao.CategoryDaoImpl)",
					throwing = "excepObj")
	public void afterThrowing(JoinPoint jp, Exception excepObj) {
		System.out.println(excepObj);
	}
	 */
	
	//전반적인 간섭을 수행하는 간선메소드(Advice)
	//메소드형태가 지정되어있다.
	/*
	 * pointcut 정의 표현식
	 * - within : 특정 패키지 or 클래스의 모든 메소드를 지정
	 * - target : 특정 인터페이스와 그의 자식 클래스의 메소드를 지정(풀경로작성/만약 인터페이스면 구현체도 전부 적용)
	 * - args : 특정 매개변수 형태를 갖는 모든 메소드르 지정
	 * -this : 특정 인터페이스를 구현하는 프록시 객체를 지정
	 * -execution L 표현식으로 형태를 지정하여 간섭
	 */
	
//	@Around("target(com.kh.aop.model.dao.CategoryDao)")
//	@Around("within(com.kh.aop.model.dao.*)")
	@Around("execution(public * com.kh.aop.model.dao.*.*)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis(); //시작시간 - @Before 시점
		
		Object result = joinPoint.proceed(); //대상을 실행시키는 명령
		
		long finish = System.currentTimeMillis(); //종료시간 - @After 시점
		
		long time = finish - start;
		
		log.debug("time = {} result = {} joinPoint = {}",
				time,result,joinPoint.getSignature().toString()); //걸린시간
		
		return result;
	}
	
}
