# Spring


<br><br>

## π± Framework, Architecture

<br><br>

## π± Polymorphism

<br><br>

## π± Container

<br><br>

## π± DL

<br><br>

## π± DI

<br><br>

## π± Business Component
- μννΈμ¨μ΄ λΆν, λͺ¨λ = μ»΄ν¬λνΈ
- νμ΄λΈ νλλΉ νλμ μ»΄ν¬λνΈ μμ±
- νμ΄λΈμ λν CRUD μμ μ²λ¦¬

a.  VO  : λ©€λ²λ³μ = νμ΄λΈμ μ»¬λΌ -> μΈμλ‘ μ΄μ© (μ»¨νμ΄λ μλ ν΄λΌμ΄μΈνΈκ° μμ±, κ²μμ‘°κ±΄/ν€μλ μΈν)  
b.  DAO  : νμ΄λΈ λ©μλ κ΅¬ν => λΉλ±λ‘  
c. Service  : DAO μ μμ μΈν°νμ΄μ€ => λ£©μλλ κ°μ²΄μ νμ, ν΄λΌμ΄μΈνΈμμ νΈμΆν λ μ¬μ©
(λ¦¬λͺ¨μ»¨, μ€μ λ‘λ λ¦¬λͺ¨μ»¨μ΄ μ°Έμ‘°νλ  Impl μ΄ λμν¨)  
d. ServiceImpl : DAO λ©μλ νΈμΆ => λΉλ±λ‘  , λ£©μλλ κ°μ²΄  
e. ServiceClient  :=> νμν κ°μ²΄ μμ±  
  -  μ»¨νμ΄λ μμ± : business-layer.xml λ‘λ©  
  -  Service κ°μ²΄ λ£©μ : λ¦¬λͺ¨μ»¨(μΈν°νμ΄μ€) λ‘ νμ΄λΈ λ©μλ νΈμΆ (μ€μ λ‘λ λ¦¬λͺ¨μ»¨μ΄ μ°Έμ‘°νλ Impl μ΄ λμν¨)  
  -  λ©μλ νμ€νΈ : vo μ λ΄μμ service λ‘ νμ΄λΈμ λ³΄λ  
  -  μ»¨νμ΄λ μ’λ£   

<br><br>

## π± Layered Annotation
@component μΈλΆν (λ©λͺ¨λ¦¬ νλ¦¬λ‘λ©, Component-scan)
- ServiceImpl -> `@service`
- DAO -> `@repository`
- Controller -> `@controller` 

<br><br>

## π± AOP
- Aspect Oriented Programming (κ΄μμ§ν₯ νλ‘κ·Έλλ°)
- λΉμ¦λμ€ ν΄λμ€ (ServiceImpl) μ μ¬λ¬λ©μλ μμ ν΅μ¬κ΄μ¬( = ν΅μ¬λ‘μ§, DAO μ΄μ©ν DB μ°λ) κ³Ό ν‘λ¨κ΄μ¬ (= Logging, Exception, Transaction) μ λΆλ¦¬
- κ°λμ±, μ μ§λ³΄μ, μ¬μ¬μ©μ±μ μν΄ λ©μλ νλλ μ΅λ 15μ€μ λμΌλ©΄ μλ

 <br><br>

## π± AOP Process
1. Joinpoint  
ν΄λΌμ΄μΈνΈκ° νΈμΆνλ λͺ¨λ  λΉμ¦λμ€ λ©μλ (ServiceImpl)
- `Signature getSinature()` : ν΄λΌμ΄μΈνΈκ° μμ²­ν λΉμ¦λμ€ λ©μλ λ°ν
- `Object getArgs()` : ν΄λΌμ΄μΈνΈκ° μμ²­ν λΉμ¦λμ€ λ©μλμ μ λ¬λ μΈμ λ°ν => μ ν¨μ± κ²μ¬
- `proceedingJoinPoint` : JoinPoint μμ = λ©μλ μμλ°μ + λ©μλ μΆκ° (` proceed()`)
 => Around λ‘ λμνλ μ΄λλ°μ΄μ€ λ©μλλ λ°λμ λ§€κ°λ³μλ‘ λ°μμΌ `proceed()` μ¬μ© κ°λ₯

2. Pointcut  
ν‘λ¨κ΄μ¬ λ©μλλ₯Ό λμμν¬ λΉμ¦λμ€ λ©μλμ λν νν°λ§ μ€μ 
- `id` : νν°λ§μ μ΄λ¦, `expression="execution()"` : ν¨ν€μ§, λ©μλ, λ§€κ°λ³μ

3. Advice  
- `method` : ν‘λ¨κ΄μ¬ λ©μλ
- λΉμ¦λμ€ λ©μλ κΈ°μ€μΌλ‘ ν‘λ¨ κ΄μ¬ λ©μλκ° λμνλ μμ  : before, after, after-return, after-throwing, around

4. Aspect = Advisor  
ν¬μΈνΈμ»·(`pointcut-ref`)κ³Ό  μ΄λλ°μ΄μ€(`ref` , `method`)μ μ°κ²°
- `returning` : λΉμ¦λμ€ λ©μλμ λ°νκ°μ ν‘λ¨κ΄μ¬ λ©μλμ μΈμλ‘ λ°μ μ¬νμ²λ¦¬ κ°λ₯
- `throwing` : λΉμ¦λμ€ λ©μλμμ λ°μν λͺ¨λ  μμΈλ₯Ό νλ¨κ΄μ¬ λ©μλμμ μΈμλ‘ λ°μ λΆκΈ°μ²λ¦¬ κ°λ₯
- `around` : λΉμ¦λμ€ λ©μλμ μλ€μ ν‘λ¨κ΄μ¬ λ©μλ λμ (ν΄λΌμ΄μΈνΈμ λΉμ¦λμ€ λ©μλ μμ²­μ κ°λ‘μ±ν μ¬μ μ²λ¦¬, λΉμ¦λμ€ λ©μλλ‘ λκΈ°κ³  μ μ΄κΆ λμμμ μ¬νμ²λ¦¬ ν ν΄λΌμ΄μΈνΈμ λ°ν)

5. Weaving  
ν΄λΌμ΄μΈνΈκ° λΉμ¦λμ€ λ©μλ νΈμΆνμ¬ μ€νλλ μκ° μ΄λλ°μ΄μ€ λ©μλκ° λμνλλ‘ ν΄μ£Όλ κ² (λΌλ¦¬μ μΈ λ΄μ©μΌλΏ μ€μX)
 <br><br>

## π± AOP Annotation
`<aop:aspectj-autoproxy/>` : AOP κ΄λ ¨ Annotation μ¬μ©νκΈ° μν μ€μ  
- ν‘λ¨ κ΄μ¬ κ°μ²΄μ λΉλ±λ‘(νλ¦¬λ‘λ©)   ->   @Service 
- <aop:aspect>   ->   @Aspect
- <aop:pointcut>   ->   @Pointcut()
- <aop:before>   ->   @Before(), @AfterReturning, @AfterThrowing, @After, @Around

## π± SpringDAO (JDBCTemplate)

- JDBC API (java.sql) μ λ¬Έμ  κ·Ήλ³΅ (μ ν΄μ§ κ΅¬ν μμμ κ·μΉμ΄ λ§μ, λ©μλκ° μ€λ³΅λλ μ½λκ° λ§κ³  SQL λ§ λ€λ¦)
- λλΌμ΄λ² λ‘λ©, μ»€λ₯μ μ°κ²°,  preparedStatement μμ±, λ¬Όμνμ κ° μΈν, SQLμ DBμ μ μ‘, μ»€λ₯μ close => νμ€λ‘ 

- BoardDAOSpring
1.  try/~catch/~finally μ­μ 
2. JdbcTemplate spring , @Autowired
3. .update(SQLλ³μ, λ¬Όμν) : insert, update, delete  
   .query(SQLλ³μ, new BoardRowMapper(), λ¬Όμν) : get  
   .queryForObject(SQL, new BoardRowMapper(), λ¬Όμν) : getList   
- XML
1. dataSource (μ»€λ₯μ μ λ³΄ κ°μ§ κ°μ²΄) λ±λ‘
2.  νΉμ  DBMS μ»€λ₯μ μν μΈν° μΈμ μ
3. JDBCTemplate κ°μ²΄ μμ± ν dataSource (νΉμ  DBMS μ»€λ₯μ μ λ³΄) μΈν°μΈμ μμΌλ‘ λκ²¨μ£ΌκΈ°

- BoardRowMapper   
BoardVO μμ±ν΄μ ResultSetμ κ° row νλλ₯Ό λ³μμ λ§€ν   

- μλ°μμ€ λ³κ²½ μμ΄ λλΉμ°λ λ³κ²½νκΈ°
1. BoardServeiceImpl  =>  λ©€λ²λ³μ μΈν°νμ΄μ€ νμ 
2. BoardDAO, BoardDAOJDBC, BoardDAOSpring => μΈν°νμ΄μ€, μμ 
3. //@Repository 
4. νλμ μΈν°νμ΄μ€ μμν λκ°μ κ°μ²΄ μ€ νλλ§ λ©λͺ¨λ¦¬μ λ μΌ νλ―λ‘ νλλ§ λΉλ±λ‘  
 => μΈλΆ properties νμΌλ‘ DB λ°μ΄ν° λΆλ¦¬νκΈ° -> ${key} 
5. USER λ λμΌνκ²

<br><br>

## π± Transaction
```
delete board
select * from board
rollback    // λλλ¦¬κΈ°  
select * from board
delete board
commit;    // insert, update, delete μκ΅¬ λ°μ => rollback μλ¨Ήν       
rollback
select * from board
```
- insert, update, delete -> λ©λͺ¨λ¦¬μμ λ¨Όμ  μ€ν, λ©λͺ¨λ¦¬ μμ μμ μ΄κΈ°ν rollback , μκ΅¬μ  λ°μ commit
- μλ μ»€λ° νμ΄μ£ΌκΈ° 


```
public void κ³μ’μ΄μ²΄() {
    μ νμνμμμΈμΆνλ€();
    μ°λ¦¬μνμμκΈνλ€();
}
private void μ°λ¦¬μνμμκΈνλ€() {
    System.out.println("μ°λ¦¬μνμμκΈνλ€");
}
public void μ νμνμμμΈμΆνλ€() {
    System.out.println("μ νμνμμμΈμΆνλ€");
}
```
- all or nothing, λΆλ¦¬ λ  μ μλ μμ λ¨μ   
- νΈλμ­μ κ΄λ¦¬ν΄μΌ νλ λΉμ¦λμ€ λ©μλ λ΄λΆ κ³Όμ μ λ¬Έμ  μκΈ°λ©΄ rollback, λ¬Έμ  μμΌλ©΄ commit   
- μ΄μ²΄() = μΈμΆ() -> μκΈ()   

<br>

- XML μ€μ  
<<<<<<< HEAD
1. txManageri(DataSourceTransactionManager)  κ°μ²΄ λ©λͺ¨λ¦¬ λ‘λ©,  dataSource  μΈν° μΈμ μ μΌλ‘ μμ‘΄μ± μ£Όμ  
2. advisor λ‘ txPointcut (νν°λ§λ λΉμ¦λμ€ λ©μλ) μ txAcvice  μ μ°κ²°  
3. μμΈ λ°μ μ, λͺ¨λ  λΉμ¦λμ€ λ©μλμ λνμ¬ txAdivce  κ° txManager  μ doCommit() , doRollback()  νΈμΆ  
=======
1. txManageri(DataSourceTransactionManager)  κ°μ²΄ λ©λͺ¨λ¦¬ λ‘λ©,  dataSource  μΈν° μΈμ μ μΌλ‘ μμ‘΄μ± μ£Όμ   
2. advisor λ‘ txPointcut (νν°λ§λ λΉμ¦λμ€ λ©μλ) μ txAcvice  μ μ°κ²°  
3. μμΈ λ°μ μ, λͺ¨λ  λΉμ¦λμ€ λ©μλμ λνμ¬ txAdivce  κ° txManager  μ doCommit() , doRollback()  νΈμΆ    
>>>>>>> 046b7beccdcae5bf9665d6d2557737c08f71530f
=> insert νλ²λ μ€νλμ§ μμλ€λ©΄ νΈλμ­μ μ±κ³΅  

<br><br>

## π± Spring MVC
<<<<<<< HEAD
- Model : DAO, VO, JDBCUtil -> μ°λ¦¬κ° κ΅¬ν   
- View : JSP -> λμμ΄λ   
- Controller : DispatcherServlet, HandlerMapping, -Controller, ModelAndView, ViewResolver ->  -Controller λ§ μ°λ¦¬κ° κ΅¬ν    
<br>

### π JDBC, JSP, Servlet λ³΅μ΅
- jsp, servlet ν΄λμ€ λ³΅λΆ  
- @ λμ  web.xml μ μλΈλ¦Ώ λ±λ‘  
- μΈμ½λ© νν°  
- μ‘°νμ μ¦κ° κ΅¬ν  
<br>

### π Controller (Servlet) μΈλΆν (Servlet Container)  
1.  DispatcherServlet : ν΄λΌμ΄μΈνΈμ .do μμ²­μ μν΄ μ€ν, μμ²­ uri μμ path μΆμΆ  
2.  HandlerMapping : νΉμ  path μ Controller λ§€ν/λ°ν  
3. ~Controller : handleRequest() -> μ¬μ©μ μλ ₯ μ λ³΄ μΆμΆ, DAO μμ±νμ¬ JDBC/SPRING κΈ°λ°μΌλ‘ κΈλͺ©λ‘ λ°ν, requestμ λ΄κ³ , λ¬Έμμ΄(~.jsp) λ°ν  
4.  DispatcherServlet : λ°νν λ¬Έμμ΄ λΈλΌμ°μ μ μΆλ ₯ (ν¬μλ νλ©΄μ΄λ)
![](https://velog.velcdn.com/images/kangnang/post/936a5d8e-9865-4893-8edb-696b1e65199c/image.png)

-  String MVC μμ μ κ³΅ν¨ (μ΄ν΄νκΈ° μν΄ μ§μ  λ§λ€μ΄λ³΄κ³  μ€νλ§κ»λ‘ λ°κΎΈκΈ°)  
- κ΅¬μ‘° λ³΅μ‘ν΄μ§μ§λ§ μ μ§λ³΄μ νΈν¨ (Controller, DispatcherServlet μμ X)  
- Controller (DispatcherServlet, HandleMapping, Conroller, ViewResolver) μ€μ DispatcherServlet λ§ μλΈλ¦Ώ  
-> μλνλ©΄ λͺ¨λ  .do μμ²­μ λν΄ μλΈλ¦Ώμ΄ λμνλ―λ‘  (FrontController, μ°½κ΅¬ μ­ν ) 
<br>

### π .do μμ²­ λ°μλλ§λ€ HandlerMapping κ°μ²΄ μμ± (λͺ¨λ  μ»¨νΈλ‘€λ¬ μμ±νμ¬ Mapμ λ±λ‘) μλλλ‘
1.  service() λ©μλ λ΄λΆX, λ©€λ²λ³μλ‘ μ μΈ  
2.  init() λ‘ new 
<br>

### π  ViewController μΆκ° 
- localhost:8080/getBoardList.jsp -> λ°μ΄ν° μλ λͺ©λ‘ λ¨λ―λ‘ λΈλΌμ°μ κ° μ§μ  μμ²­ λͺ»νλλ‘ μ°¨λ¨ ν΄μΌν¨ (expression language) 
- νΉμ  νλ©΄μΌλ‘ μ΄λνλ κΈ°λ₯ λΏ 
- localhost:8080/insertUserView.do 

1.  index μ μΈν λͺ¨λ  jspλ₯Ό WEB-INFλ‘ μ?κΈ°κΈ° (λͺ¨λ  μλ²λ WEB-INF ν΄λ λ³΄νΈ, λΈλΌμ°μ κ° μμ²­νλ©΄ 404)  
2. HandlerMapping μ InsertUserViewController  λ±λ‘νκ³  κ°μ²΄ μμ± (λΈλΌμ°μ κ° urlλ‘ μμ²­ λͺ»νλ―λ‘ μ°ν)  
 -> insertBoardViewController , loginViewController λ λμΌ  
3.  getBoard, getBoardList λ λ°ν νλ λ¬Έμμ΄μ΄ jsp μ΄λ―λ‘ return κ²½λ‘μ WEB-INF  μΆκ° (λΈλΌμ°μ  μλ μλ² μμμ μ»¨νΈλ‘€λ¬κ° WEB-INF λ° jspλ‘ μ κ·Ό νλ κ²μ κ°λ₯)  
4.  header.jsp μμ .jsp  => View.do (index.jsp μ μΈ)  

~~ μμ΄ν¨λ κ·Έλ¦Ό~~

<br>

### π νλ‘μ νΈμ λ³νκ° λ°μλμ§ μμλ
1.  refresh, clean  
2.  tomcat λ€μ λ±λ‘, server.xml μμ path="/" λ‘ μμ   
- λ‘μ»¬μ λ€μ΄λ°μ μνμΉ ν°μΊ£μ μ΄ν΄λ¦½μ€μ λ°μΈλλ ν°μΊ£ μλ (μλ³Έμ λν λ³΅μ¬λ³Έ λ§λ€μ΄μ§)  
- eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/temp0 = λ³΅μ¬λ³Έ ν°μΊ£ (λ΄λΆκ° μλ³Έ ν°μΊ£κ³Ό κ°μ) 

<br>

### π `action-servlet.xml`  
- μ€νλ§ μ»¨νμ΄λ(XmlWebApplicationContext)κ° λ‘λ©  
- bean λ±λ‘ : HandlerMapping , Controller, ViewResolver  
- POJO  
- GenericXmlApplicationContext (μΉ μλ νκ²½μμ μ¬μ©νλ μ»¨νμ΄λ, business-layer.xml λκ²¨μ λ΄κ° μ§μ  new ν΄μ μμ±) μ λ€λ₯΄κ² λ΄κ° μμ±νμ§ μκ³  μ»¨νμ΄λκ° μμ±  
- /WEB-INF/config/presentation-layer.xml λ‘ λ³κ²½, DispatcherServlet μ <init-param> μΌλ‘ λ±λ‘νμ¬ μ€νλ§ μ»¨νμ΄λ μμ± μ λ‘λ© κ°λ₯νλλ‘ μ€μ  

<br>

### π μλΈλ¦Ώ μ»¨νμ΄λμ μ€νλ§ μ»¨νμ΄λμ κ΄κ³ 
1. ν°μΊ£ μλ² (catalina) μμ± ->  
2. web.xml λ‘λ© -> μλΈλ¦Ώ μ»¨νμ΄λ μμ± ->  ChracterEncodingFilter νλ¦¬λ‘λ© ->  
3. .do μμ²­ -> DispatcherServlet μμ± (lazy-loading) ->   init() μ€ν ->  
4.  action-sevlet.xml λ‘λ© -> μ€νλ§ μ»¨νμ΄λ(xmlWebApplicationCotext) ->  
5. λΉλ±λ‘λ κ°μ²΄ νλ¦¬λ‘λ© (HandlerMapping, Controller, ViewResolver -> μ»¨νμ΄λ μμ± μ§ν λ©λͺ¨λ¦¬ λ‘λ©)  

- μ€νλ§ μ»¨νμ΄λ => ν¬μ‘°, κ·Έλ₯ μλ° ν΄λμ€λ₯Ό μμ±νκ³  κ΄λ¦¬ (HandlerMapping, Controller, ViewResolver)  
  μλΈλ¦Ώ μ»¨νμ΄λ => μλΈλ¦Ώ, νν°, λ¦¬μ€ν°λ§ μμ±νκ³  κ΄λ¦¬  
- μ°λ¦¬κ° λ§λ  DispatcherServlet => HandlerMapping μ§μ  μμ±  
!= μ€νλ§μ DispatcherServlet => μλ => λμ€ν¨μ² μλΈλ¦Ώμ΄ λ΄λΆμ μΌλ‘ μ΄μ©νλ κ°μ²΄λ€μ λ©λͺ¨λ¦¬μ μμ±νκ³  κ΄λ¦¬νλ μ€νλ§ μ»¨νμ΄λ  
- DispatcherServlet : FrontServlet (λͺ¨λ  .do μμ²­ νκ³³μμ λ°μλ€μ΄λ μ°½κ΅¬, μ§μμ )

![](https://velog.velcdn.com/images/kangnang/post/ab247270-7d88-4d8d-bb5a-881f1a404ade/image.png)

<br>

### π Model and View
- spring μ΄ μ κ³΅νλ -Conroller μ handleRequest() μ λ°νκ° (λ΄κ° λ§λ  Controllerμ λ°νκ° : Spring)  
- addObject() : λΏλ¦΄ μ λ³΄ μ μ₯,  setViewName() : λΏλ¦΄ νλ©΄ μ μ₯  
  
Controller :  
1. ModelAndView κ°μ²΄ μμ±  
2. κ²μκ²°κ³Ό(Model)μ λΏλ¦΄νλ©΄(View) μ μ₯νμ¬ λ¦¬ν΄  
DispatcherServlet  
3. λ¦¬ν΄λ Model and View μμ Model μ λ³΄ requestμ λ΄μ, view μ ν΄λΉνλ jsp μ°Ύμμ μ€ν(ν¬μλ©)  
4. requestμ λ±λ‘λ μ λ³΄λ₯Ό EL( ${} ) μΌλ‘ λΏλ¦Ό 

<br>

### π Collection Injection
`CollectionBean.java`  `CollectionUser.java`   `applicationContext.java`  
- μΈν° μΈμ μ : μΈν° λ©μλμ λ§€κ°λ³μλ‘ λ°μ μμ‘΄νλ κ°μ²΄ νμμ λ©€λ²λ³μμ ν λΉ νμ¬ NotNullPointException  
- ->  λ©€λ²λ³μ = λ§€κ°λ³μ κ° μ»¬λ μ = <property> μ name μμ±  =>  μλ° μλ XML μ λ±λ‘ (μμ μ μ»΄νμΌX)  
- List<String>, λ°°μ΄   =>   <list>  
Set<String>   =>   <Set>  
Map<String>   =>   <Map>  
Properties<String>   =>   <props>, <prop>  
- List<String> : μμ, μ€λ³΅ O  
  Set<String> : X  
  Map : ν€λ°Έλ₯ ννλ‘ μ μ₯ (λ°Έλ₯λ‘ κ°μ²΄ μ μ₯ κ°λ₯)  
  Properties : ν€λ°Έλ₯ ννλ‘ μ μ₯, λ¬Έμλ μ«μλ§ λ°Έλ₯λ‘ μ μ₯ κ°λ₯ 

<br>

### π ViewResolver
- presentaion-layer.xml μ κ°μ²΄ λ±λ‘  
- μμ±μ μΈμ μμΌλ‘ μμ‘΄μ± μ£Όμ  
- setViewName("") : jsp μ λ³΄ μ μ₯  
1. forward:index.jsp = ViewResolver μ μ©X  
2. login = /WEB-INF/board/login.jsp  
3. forward:getBoardList.do

<br><br>

## π± Annotation κΈ°λ° Spring MVC 
1. JDBC, JSP, Servlet λ³΅μ΅ (Model2 Architecture)
- μΉ κ°λ° λͺ¨λΈ  
Model(DAO, VO) : λλΉ μ°λ -> μλ° κ°λ°μ  
Controller(Servlet) : Control λ‘μ§ (μ¬μ©μ μλ ₯ μ λ³΄ μΆμΆ getParameter() , DB μ°λ μ²λ¦¬ getUser() , νλ©΄ λ€λΉκ²μ΄μ sendRedirect() ) -> MVC νλ μμν¬  
view(JSP) : μΉ λμμ΄λ  
- jsp, servlet ν΄λμ€ λ³΅λΆ
- @ λμ  web.xml μ μλΈλ¦Ώ λ±λ‘
- μΈμ½λ© νν°
- μ‘°νμ μ¦κ° κ΅¬ν

<br>

2. Controller (Servlet) μΈλΆν  
a. DispatcherServlet : ν΄λΌμ΄μΈνΈμ .do μμ²­μ μν΄ μ€ν, μμ²­ uri μμ path μΆμΆ  
b. HandlerMapping : νΉμ  path μ Controller λ§€ν/λ°ν  
c.~Controller : handleRequest() -> μ¬μ©μ μλ ₯ μ λ³΄ μΆμΆ, DAO μμ±νμ¬ JDBC/SPRING κΈ°λ°μΌλ‘ κΈλͺ©λ‘ λ°ν, requestμ λ΄κ³ , λ¬Έμμ΄(~.jsp) λ°ν   
d. DispatcherServlet : λ°νν λ¬Έμμ΄ λΈλΌμ°μ μ μΆλ ₯ (ν¬μλ νλ©΄μ΄λ)  
![](https://velog.velcdn.com/images/kangnang/post/7f171700-48a1-4eee-bf42-f6090d48095b/image.png)
<br>
- κ΅¬μ‘° λ³΅μ‘ν΄μ§μ§λ§ μ μ§λ³΄μ νΈν¨ (Controller, DispatcherServlet μμ X)  
- .do μμ²­ λ°μλλ§λ€ HandlerMapping κ°μ²΄ μμ± (λͺ¨λ  μ»¨νΈλ‘€λ¬ μμ±νμ¬ Mapμ λ±λ‘) μλλλ‘  
a. service() λ©μλ λ΄λΆX, λ©€λ²λ³μλ‘ μ μΈ  
b. init() λ‘ new  
