# study_AOP

Spring AOP(Aspect Oriented Programming) - 관점 지향 프로그래밍 <br>
- 트랜잭션,로깅,보안 등 여러 모듈, 여러 계층에서 공통으로 필요로 하는 기능의 경우 해당 기능들을 분리하여 관리 <br>
- 성능향상을 위해 테스트를 해봐야할때 사용 <br>
- 중복되는 공통 코드 부분을 별도의 영역으로 분리하고 코드가 실행되기 전이나 후의 시점에 해당 코드를 붙여 넣어 소스 코드 중복을 줄이고 필요할때마다 가져다 쓸 수 있게 객체화하는 기술 <br>

-Aspect : 여러 객체에 공통으로 적용되는 기능을 분리하여 작성한 클래스 <br>
-JoinPoint : 객체(인스턴스) 생성 시점, 메소드 호출 시점, 예외 발생지점등 특정 작업이 시작되는 시점 <br>
-Advice : JoinPoint에 삽입되어 동작될 코드, 메소드
<ol>
    <li> @Before() //JoinPoint 앞에 서 실행</li>
	  <li> @After() //호출이 리턴되기 직전에 실행됨</li>
	  <li> @AfterReturning() //After + 돌아온 리턴값에 대해서 간섭가능</li>
	  <li> @AfterThrowing() //After +오류 처리 간섭가능</li>
	  <li> @Around() //앞뒤에서 실행</li>
</ol>
-PointCut : 조인 포인트의 부분 집합 / 실제 Advice가 적용되는 시점 <br>
-Introduction : 정적인 방식의 AOP 기술 <br>
-Weaving : 작성한 Advice(공통 코드)를 핵심 로직 코드에 삽입
<ol>
    <li>컴파일 시 위빙</li>
	  <li>클래스 로딩 시 위빙</li>
	  <li>런타임 시 위빙</li>
</ol>

-pointcut 정의 표현식 <br>
<ul>
  <li>within : 특정 패키지 or 클래스의 모든 메소드를 지정</li>
  <li>target : 특정 인터페이스와 그의 자식 클래스의 메소드를 지정(풀경로작성/만약 인터페이스면 구현체도 전부 적용)</li>
  <li>args : 특정 매개변수 형태를 갖는 모든 메소드르 지정</li>
  <li>this : 특정 인터페이스를 구현하는 프록시 객체를 지정</li>
  <li>execution L 표현식으로 형태를 지정하여 간섭</li>
</ul>
