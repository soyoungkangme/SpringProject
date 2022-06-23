# Spring
1. [Framework, Architecture](## 🌱 Framework, Architecture)


<br><br>

## 🌱 Framework, Architecture

<br><br>

## 🌱 Polymorphism

<br><br>

## 🌱 Container

<br><br>

## 🌱 DL

<br><br>

## 🌱 DI

<br><br>

## 🌱 Business Component
- 소프트웨어 부품, 모듈 = 컴포넌트
- 테이블 하나당 하나의 컴포넌트 작성
- 테이블에 대한 CRUD 작업 처리

a.  VO  : 멤버변수 = 테이블의 컬럼 -> 인자로 이용 (컨테이너 아닌 클라이언트가 생성, 검색조건/키워드 세팅)  
b.  DAO  : 테이블 메서드 구현 => 빈등록  
c. Service  : DAO 의 상위 인터페이스 => 룩업되는 객체의 타입, 클라이언트에서 호출할때 사용
(리모컨, 실제로는 리모컨이 참조하는  Impl 이 동작함)  
d. ServiceImpl : DAO 메서드 호출 => 빈등록  , 룩업되는 객체  
e. ServiceClient  :=> 필요한 객체 생성  
  -  컨테이너 생성 : business-layer.xml 로딩  
  -  Service 객체 룩업 : 리모컨(인터페이스) 로 테이블 메서드 호출 (실제로는 리모컨이 참조하는 Impl 이 동작함)  
  -  메서드 테스트 : vo 에 담아서 service 로 테이블에 보냄  
  -  컨테이너 종료   

<br><br>

## 🌱 Layered Annotation
@component 세분화 (메모리 프리로딩, Component-scan)
- ServiceImpl -> `@service`
- DAO -> `@repository`
- Controller -> `@controller` 

<br><br>

## 🌱 AOP
- Aspect Oriented Programming (관시지향 프로그래밍)
- 비즈니스 클래스 (ServiceImpl) 의 여러메서드 에서 핵심관심( = 핵심로직, DAO 이용한 DB 연동) 과 횡단관심 (= Logging, Exception, Transaction) 의 분리
- 가독성, 유지보수, 재사용성을 위해 메소드 하나는 최대 15줄을 넘으면 안됌

 <br><br>

## 🌱 AOP Process
1. Joinpoint  
클라이언트가 호출하는 모든 비즈니스 메소드 (ServiceImpl)
- `Signature getSinature()` : 클라이언트가 요청한 비즈니스 메서드 반환
- `Object getArgs()` : 클라이언트가 요청한 비즈니스 메서드에 전달된 인자 반환 => 유효성 검사
- `proceedingJoinPoint` : JoinPoint 상속 = 메서드 상속받음 + 메서드 추가 (` proceed()`)
 => Around 로 동작하는 어드바이스 메서드는 반드시 매개변수로 받아야 `proceed()` 사용 가능

2. Pointcut  
횡단관심 메서드를 동작시킬 비즈니스 메서드에 대한 필터링 설정
- `id` : 필터링의 이름, `expression="execution()"` : 패키지, 메서드, 매개변수

3. Advice  
- `method` : 횡단관심 메서드
- 비즈니스 메서드 기준으로 횡단 관심 메서드가 동작하는 시점 : before, after, after-return, after-throwing, around

4. Aspect = Advisor  
포인트컷(`pointcut-ref`)과  어드바이스(`ref` , `method`)의 연결
- `returning` : 비즈니스 메서드의 반환값을 횡단관심 메서드의 인자로 받아 사후처리 가능
- `throwing` : 비즈니스 메서드에서 발생한 모든 예외를 횐단관심 메서드에서 인자로 받아 분기처리 가능
- `around` : 비즈니스 메서드의 앞뒤에 횡단관심 메서드 동작 (클라이언트의 비즈니스 메소드 요청을 가로챈후 사전처리, 비즈니스 메서드로 넘기고 제어권 돌아와서 사후처리 후 클라이언트에 반환)

5. Weaving  
클라이언트가 비즈니스 메서드 호출하여 실행되는 순간 어드바이스 메서드가 동작하도록 해주는 것 (논리적인 내용일뿐 중요X)
 <br><br>

## 🌱 AOP Annotation
`<aop:aspectj-autoproxy/>` : AOP 관련 Annotation 사용하기 위한 설정 
- 횡단 관심 객체의 빈등록(프리로딩)   ->   @Service 
- <aop:aspect>   ->   @Aspect
- <aop:pointcut>   ->   @Pointcut()
- <aop:before>   ->   @Before(), @AfterReturning, @AfterThrowing, @After, @Around

## 🌱 SpringDAO (JDBCTemplate)

- JDBC API (java.sql) 의 문제 극복 (정해진 구현 순서와 규칙이 많음, 메서드간 중복되는 코드가 많고 SQL 만 다름)
- 드라이버 로딩, 커넥션 연결,  preparedStatement 생성, 물음표에 값 세팅, SQL을 DB에 전송, 커넥션 close => 한줄로 

- BoardDAOSpring
1.  try/~catch/~finally 삭제
2. JdbcTemplate spring , @Autowired
3. .update(SQL변수, 물음표) : insert, update, delete  
   .query(SQL변수, new BoardRowMapper(), 물음표) : get  
   .queryForObject(SQL, new BoardRowMapper(), 물음표) : getList   
- XML
1. dataSource (커넥션 정보 가진 객체) 등록
2.  특정 DBMS 커넥션 위한 세터 인젝션
3. JDBCTemplate 객체 생성 후 dataSource (특정 DBMS 커넥션 정보) 세터인젝션으로 넘겨주기

- BoardRowMapper   
BoardVO 생성해서 ResultSet의 각 row 하나를 변수에 매핑   

- 자바소스 변경 없이 디비연동 변경하기
1. BoardServeiceImpl  =>  멤버변수 인터페이스 타입 
2. BoardDAO, BoardDAOJDBC, BoardDAOSpring => 인터페이스, 상속 
3. //@Repository 
4. 하나의 인터페이스 상속한 두개의 객체 중 하나만 메모리에 떠야 하므로 하나만 빈등록  
 => 외부 properties 파일로 DB 데이터 분리하기 -> ${key} 
5. USER 도 동일하게

<br><br>

## 🌱 Transaction
```
delete board
select * from board
rollback    // 되돌리기  
select * from board
delete board
commit;    // insert, update, delete 영구 반영 => rollback 안먹힘       
rollback
select * from board
```
- insert, update, delete -> 메모리에서 먼저 실행, 메모리 상의 작업 초기화 rollback , 영구적 반영 commit
- 자동 커밋 풀어주기 


```
public void 계좌이체() {
    신한은행에서인출한다();
    우리은행에입금한다();
}
private void 우리은행에입금한다() {
    System.out.println("우리은행에입금한다");
}
public void 신한은행에서인출한다() {
    System.out.println("신한은행에서인출한다");
}
```
- all or nothing, 분리 될 수 없는 작업 단위   
- 트랙잭션 관리해야 하는 비즈니스 메서드 내부 과정에 문제 생기면 rollback, 문제 없으면 commit   
- 이체() = 인출() -> 입금()   

<br>

- XML 설정 
<<<<<<< HEAD
1. txManageri(DataSourceTransactionManager)  객체 메모리 로딩,  dataSource  세터 인젝션 으로 의존성 주입  
2. advisor 로 txPointcut (필터링된 비즈니스 메서드) 와 txAcvice  의 연결  
3. 예외 발생 시, 모든 비즈니스 메서드에 대하여 txAdivce  가 txManager  의 doCommit() , doRollback()  호출  
=======
1. txManageri(DataSourceTransactionManager)  객체 메모리 로딩,  dataSource  세터 인젝션 으로 의존성 주입   
2. advisor 로 txPointcut (필터링된 비즈니스 메서드) 와 txAcvice  의 연결  
3. 예외 발생 시, 모든 비즈니스 메서드에 대하여 txAdivce  가 txManager  의 doCommit() , doRollback()  호출    
>>>>>>> 046b7beccdcae5bf9665d6d2557737c08f71530f
=> insert 한번도 실행되지 않았다면 트랜잭션 성공  

<br><br>

## 🌱 Spring MVC
<<<<<<< HEAD
- Model : DAO, VO, JDBCUtil -> 우리가 구현   
- View : JSP -> 디자이너   
- Controller : DispatcherServlet, HandlerMapping, -Controller, ModelAndView, ViewResolver ->  -Controller 만 우리가 구현    
<br>

### 🏗 JDBC, JSP, Servlet 복습
- jsp, servlet 클래스 복붙  
- @ 대신 web.xml 에 서블릿 등록  
- 인코딩 필터  
- 조회수 증가 구현  
<br>

### 🏗 Controller (Servlet) 세분화 (Servlet Container)  
1.  DispatcherServlet : 클라이언트의 .do 요청에 의해 실행, 요청 uri 에서 path 추출  
2.  HandlerMapping : 특정 path 와 Controller 매핑/반환  
3. ~Controller : handleRequest() -> 사용자 입력 정보 추출, DAO 생성하여 JDBC/SPRING 기반으로 글목록 반환, request에 담고, 문자열(~.jsp) 반환  
4.  DispatcherServlet : 반환한 문자열 브라우저에 출력 (포워드 화면이동)
![](https://velog.velcdn.com/images/kangnang/post/936a5d8e-9865-4893-8edb-696b1e65199c/image.png)

-  String MVC 에서 제공함 (이해하기 위해 직접 만들어보고 스프링껄로 바꾸기)  
- 구조 복잡해지지만 유지보수 편함 (Controller, DispatcherServlet 수정X)  
- Controller (DispatcherServlet, HandleMapping, Conroller, ViewResolver) 중에 DispatcherServlet 만 서블릿  
-> 왜냐하면 모든 .do 요청에 대해 서블릿이 동작하므로  (FrontController, 창구 역할) 
<br>

### 🏗 .do 요청 받을때마다 HandlerMapping 객체 생성 (모든 컨트롤러 생성하여 Map에 등록) 안되도록
1.  service() 메서드 내부X, 멤버변수로 선언  
2.  init() 로 new 
<br>

### 🏗  ViewController 추가 
- localhost:8080/getBoardList.jsp -> 데이터 없는 목록 뜨므로 브라우저가 직접 요청 못하도록 차단 해야함 (expression language) 
- 특정 화면으로 이동하는 기능 뿐 
- localhost:8080/insertUserView.do 

1.  index 제외한 모든 jsp를 WEB-INF로 옮기기 (모든 서버는 WEB-INF 폴더 보호, 브라우저가 요청하면 404)  
2. HandlerMapping 에 InsertUserViewController  등록하고 객체 생성 (브라우저가 url로 요청 못하므로 우회)  
 -> insertBoardViewController , loginViewController 도 동일  
3.  getBoard, getBoardList 는 반환 하는 문자열이 jsp 이므로 return 경로에 WEB-INF  추가 (브라우저 아닌 서버 안에서 컨트롤러가 WEB-INF 밑 jsp로 접근 하는 것은 가능)  
4.  header.jsp 에서 .jsp  => View.do (index.jsp 제외)  

~~ 아이패드 그림~~

<br>

### 🏗 프로젝트에 변화가 반영되지 않을때
1.  refresh, clean  
2.  tomcat 다시 등록, server.xml 에서 path="/" 로 수정  
- 로컬에 다운받은 아파치 톰캣은 이클립스에 바인드된 톰캣 아님 (원본에 대한 복사본 만들어짐)  
- eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/temp0 = 복사본 톰캣 (내부가 원본 톰캣과 같음) 

<br>

### 🏗 `action-servlet.xml`  
- 스프링 컨테이너(XmlWebApplicationContext)가 로딩  
- bean 등록 : HandlerMapping , Controller, ViewResolver  
- POJO  
- GenericXmlApplicationContext (웹 아닌 환경에서 사용하는 컨테이너, business-layer.xml 넘겨서 내가 직접 new 해서 생성) 와 다르게 내가 생성하지 않고 컨테이너가 생성  
- /WEB-INF/config/presentation-layer.xml 로 변경, DispatcherServlet 의 <init-param> 으로 등록하여 스프링 컨테이너 생성 시 로딩 가능하도록 설정 

<br>

### 🏗 서블릿 컨테이너와 스프링 컨테이너의 관계 
1. 톰캣 서버 (catalina) 생성 ->  
2. web.xml 로딩 -> 서블릿 컨테이너 생성 ->  ChracterEncodingFilter 프리로딩 ->  
3. .do 요청 -> DispatcherServlet 생성 (lazy-loading) ->   init() 실행 ->  
4.  action-sevlet.xml 로딩 -> 스프링 컨테이너(xmlWebApplicationCotext) ->  
5. 빈등록된 객체 프리로딩 (HandlerMapping, Controller, ViewResolver -> 컨테이너 생성 직후 메모리 로딩)  

- 스프링 컨테이너 => 포조, 그냥 자바 클래스를 생성하고 관리 (HandlerMapping, Controller, ViewResolver)  
  서블릿 컨테이너 => 서블릿, 필터, 리스터만 생성하고 관리  
- 우리가 만든 DispatcherServlet => HandlerMapping 직접 생성  
!= 스프링의 DispatcherServlet => 아님 => 디스패처 서블릿이 내부적으로 이용하는 객체들을 메모리에 생성하고 관리하는 스프링 컨테이너  
- DispatcherServlet : FrontServlet (모든 .do 요청 한곳에서 받아들이는 창구, 진입점)

![](https://velog.velcdn.com/images/kangnang/post/ab247270-7d88-4d8d-bb5a-881f1a404ade/image.png

<br>

### 🏗 Model and View
- spring 이 제공하는 -Conroller 의 handleRequest() 의 반환값 (내가 만든 Controller의 반환값 : Spring)  
- addObject() : 뿌릴 정보 저장,  setViewName() : 뿌릴 화면 저장  
  
Controller :  
1. ModelAndView 객체 생성  
2. 검색결과(Model)와 뿌릴화면(View) 저장하여 리턴  
DispatcherServlet  
3. 리턴된 Model and View 에서 Model 정보 request에 담음, view 에 해당하는 jsp 찾아서 실행(포워딩)  
4. request에 등록된 정보를 EL( ${} ) 으로 뿌림 

<br>

### 🏗 Collection Injection
`CollectionBean.java`  `CollectionUser.java`   `applicationContext.java`  
- 세터 인젝션 : 세터 메서드의 매개변수로 받아 의존하는 객체 타입의 멤버변수에 할당 하여 NotNullPointException  
- ->  멤버변수 = 매개변수 가 컬렉션 = <property> 의 name 속성  =>  자바 아닌 XML 에 등록 (수정시 컴파일X)  
- List<String>, 배열   =>   <list>  
Set<String>   =>   <Set>  
Map<String>   =>   <Map>  
Properties<String>   =>   <props>, <prop>  
- List<String> : 순서, 중복 O  
  Set<String> : X  
  Map : 키밸류 형태로 저장 (밸류로 객체 저장 가능)  
  Properties : 키밸류 형태로 저장, 문자나 숫자만 밸류로 저장 가능 

<br>

### 🏗 ViewResolver
- presentaion-layer.xml 에 객체 등록  
- 생성자 인젝션으로 의존성 주입  
- setViewName("") : jsp 정보 저장  
1. forward:index.jsp = ViewResolver 적용X  
2. login = /WEB-INF/board/login.jsp  
3. forward:getBoardList.do

<br><br>

## 🌱 Annotation 기반 Spring MVC 
=======
1. JDBC, JSP, Servlet 복습 (Model2 Architecture)
- 웹 개발 모델  
Model(DAO, VO) : 디비 연동 -> 자바 개발자  
Controller(Servlet) : Control 로직 (사용자 입력 정보 추출 getParameter() , DB 연동 처리 getUser() , 화면 네비게이션 sendRedirect() ) -> MVC 프레임워크  
view(JSP) : 웹 디자이너  
- jsp, servlet 클래스 복붙
- @ 대신 web.xml 에 서블릿 등록
- 인코딩 필터
- 조회수 증가 구현

<br>

2. Controller (Servlet) 세분화  
a. DispatcherServlet : 클라이언트의 .do 요청에 의해 실행, 요청 uri 에서 path 추출  
b. HandlerMapping : 특정 path 와 Controller 매핑/반환  
c.~Controller : handleRequest() -> 사용자 입력 정보 추출, DAO 생성하여 JDBC/SPRING 기반으로 글목록 반환, request에 담고, 문자열(~.jsp) 반환   
d. DispatcherServlet : 반환한 문자열 브라우저에 출력 (포워드 화면이동)  
![](https://velog.velcdn.com/images/kangnang/post/7f171700-48a1-4eee-bf42-f6090d48095b/image.png)
<br>
- 구조 복잡해지지만 유지보수 편함 (Controller, DispatcherServlet 수정X)  
- .do 요청 받을때마다 HandlerMapping 객체 생성 (모든 컨트롤러 생성하여 Map에 등록) 안되도록  
a. service() 메서드 내부X, 멤버변수로 선언  
b. init() 로 new  
>>>>>>> 046b7beccdcae5bf9665d6d2557737c08f71530f
