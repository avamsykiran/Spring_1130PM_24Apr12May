Lab Setup
----------------------------------------------------------------------------------------

    JDK 1.8
    STS 4 IDE

Spring
----------------------------------------------------------------------------------------

    is a java based application framework.

    features with light weight, highly modular and interoperable 

    Spring Modules

        Spring Core                 is the common part of all other spring modules
        Spring Beans                offers Dependency Injection and a context called BeanFactory
        Spring Context              offers ApplicationContext - an enhanced BeanFactory
        Spring EL                   Expression Language is used to construct and process dependency injection expressions.

        Spring Boot                 offers RAD )(Rapid Application Development)

        Spring Jdbc                 offers data connectivity over JDBC

        Spring Web                  offers support for MVC WebApplications and REST api
        Spring Test                 offers testing on DI


    Dependency Injection

        DAO/REPO    <------------>      SERVICE         <---------->       UI

        EmployeeRepo                    EmployeeService
        EmployeeRepoJdbcImpl            EmployeeServiceImpl
        EmployeeRepoJpaImpl

                                        class EmployeeServiceImpl implements EmployeeService {
                                            private EmployeeRepo eRepo;

                                            public EmployeeServiceImpl() {}

                                            public EmployeeServiceImpl(EmployeeRepo eRepo){
                                                this.eRepo = eRepo;
                                            }

                                            public void setERepo(EmployeeRepo eRepo){
                                                this.eRepo = eRepo;
                                            }
                                        }

                                        //Constructor Injection or Injection By Constructor
                                        EmployeeService eService1 = new EmployeeServiceImpl(new EmployeeRepoJdbcImpl());
                                        EmployeeService eService2 = new EmployeeServiceImpl(new EmployeeRepoJpaImpl());

                                        //Setter Injection or Injection by Setter Method
                                        EmployeeService eServie3 = new EmployeeServiceImpl();
                                        eService3.setERepo(new EmployeeRepoJdbcImpl());


    Inversion Of Control (IoC)

        to let a software manage DI; and such software is called a CONTAINER.

        CONTAINER has to manage the life cycle of a BEAN including its creation, destroy and injection.

        BEAN is an object of a COMPONENT and the BEAN life cycle is managed by a CONTAINER.

        COMPONENT is a class of a BEAN.

    Spring Beans and Spring Context
    ------------------------------------------------------------------------------------------------

        Spring Bean module offers BeanFactory as a container.
        Spring Context module offers ApplicationContext as a container.

        Spring Bean Configuaration

            to inform the bean contianer how many components we have and their dependency.

            Xml Based Configuration

                    beans.xml

                    <beans>
                        <bean id="erepo1" class="com.cts.hrapp.repos.EmployeeRepoJdbcImpl" />                        
                        <bean id="erepo2" class="com.cts.hrapp.repos.EmployeeRepoJpaImpl" />                        

                        <bean id="eService1" class="com.cts.hrapp.services.EmployeeServiceImpl">
                            <constructor-arg index="0" ref="erepo1" />
                        </bean>

                        <bean id="eService2" class="com.cts.hrapp.services.EmployeeServiceImpl">
                            <property name="eRepo" ref="erepo2" />
                        </bean>

                    </beans>


                    ApplicationContext context = new XmlConfigApplicationContext("beans.xml");

                    EmployeeService es1 = (EmployeeService) context.getBean("eService2");


            Annotation Based Configuration

                @Configuration
                @ComponentScan("base-package")
                class MyBeanConfig{

                }

                @Component
                    @Servcie
                    @Repository
                    @Controller
                    @Resource
                    ...etc.,

                @Autowired              byConstructor / bySetter / byField
                @Qualiffier
                @Primary
                                        //employeeServiceImpl is the id 
                                        @Servcie
                                        class EmployeeServiceImpl implements EmployeeService {
                                            @Autowired  
                                            private EmployeeRepo eRepo;

                                        }

                                        //employeeServiceImpl is the id 
                                        @Service
                                        class EmployeeServiceImpl implements EmployeeService {
                                           
                                            private EmployeeRepo eRepo;
                                            
                                            @Autowired 
                                            public EmployeeServiceImpl(EmployeeRepo eRepo){
                                                this.eRepo = eRepo;
                                            }

                                        }

                                        //employeeServiceImpl is the id 
                                        @Service
                                        class EmployeeServiceImpl implements EmployeeService {
                                           
                                            private EmployeeRepo eRepo;

                                            public EmployeeServiceImpl() {}

                                            @Autowired
                                            public void setERepo(EmployeeRepo eRepo){
                                                this.eRepo = eRepo;
                                            }

                                        }

                @PropertySource("classpath:fileName.properties")
                @Value(spEL)

                @Scope("singleton|prototype|request|session|global-session")
            
            Java Based Configuration

                @Configuration
                class MyBeanConfig {

                    //scan is the bean id.
                    @Bean
                    public Scanner scan(){  
                        return new Scanner(System.in);
                    }
                }
            

    Spring Boot
    -------------------------------------------------------------------------------

        is a spring module that offers auto-configuration and thus promoting
        rapid application development.

        spring context          where is the properties
                                what is the bae package
                                what is the configuration class ...etc.,

        spring jdbc              what type of datasource and jdbctemplate are we using

        spring security         what type of authourization and authentication we use
                                what is the source of user id and password records
                                how roles work ..et.,

                                .......etc.,

        these configuaraion by default provided by Spring Boot as and when a dependency
        of that module is detected. And hence the developer need not worry of suppling the
        config and hence can proceed to the application logic and this promotes rapid
        application development. however, the automatically provided config can be cusomized
        if needed.

        @SpringBootApplication
            = @Configuration + 
                @ComponentScan("thePackageOfTheClassOnWhichThisAnnotationIsApplied") +
                @PropertySource("classpath:application.properties")

        Spring Boot app can be created in three differetn ways
            1. Using 'Spring Starter Project' wizard from STS.
            2. use 'http://start.spring.io' web site to create a project and import it into any IDE.
            3. use Spring Boot CLI and create a project and import it into any IDE.

        @SpringBootApplication
        public class SpringBootDemoApplication {

            public static void main(String[] args) {
                // can not use ApplicationContext here, as it is not created yet
                SpringApplication.run(SpringBootDemoApplication.class, args);
                // can not use ApplicationContext here, as it is destroyed already.
            }

        }

        SpringApplication.run
            1. it create an ApplicationContext taking the main class as configuration class.
            2. the ApplicationContext will scan for components and prepare a bena injection plan
            3. the CommadnLineRunner or ApplicationRunner are executed (if any)
            4. the embeded servers are initiated (if any)
            5. the ApplicationContext is destroyed just before the main exits.


    Spring JDBC on Spring Boot
    ------------------------------------------------------------------------------------

        Maven Dependencies

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-jdbc</artifactId>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <scope>runtime</scope>
            </dependency>

        Configuration

            spring.datasource.url=jdbc:mysql://localhost:3306/databaseName
            spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
            spring.datasource.username=guest_user
            spring.datasource.password=guest_password

        JdbcTemplate
            ::queryForObject(selectQry)
            ::update(dmlStatement)
        
        NamedParameterJdbcTemplate

        database script

             create database springJdbcDemoDB;
             use springJdbcDemoDB;

             create table Emps(
                empId int primary key auto_increment,
                ename varchar(50) not null,
                sal double not null
             );

             insert into emps(ename,sal) 
             values("Vamsy Kiran",90000);

             insert into emps(ename,sal) 
             values("Suseela",95000);

             insert into emps(ename,sal) 
             values("Sagar",99000);

        Assignment # 1:

            Develop a Spring Boot based console application using Spring JDBC to 
            perform CRUD operation on the Entity:
                
                Item        
                    itemId : int
                    name : String
                    price : double
                    packagedDate : LocalDate
        

    Standard Java Dynamic Web Application Project Structure
    ----------------------------------------------------------------------

        my-web-project
            | - src
            | - webapp
                 |- WEB-INF
                 |      |- lib              //.jar                              managed by maven
                 |      |- classes          //.class                            managed by maven (javac)
                 |      |- viewsOrPages     //.html,.css,.js,.jsp ...etc.,      managed by developer
                 |- META-INF
                 |- web.xml                 // web deployment descriptor
                                            // application title, number of servlet and their url mappings
                                            // application or servlet level parameters like database configs, ..etc.,
                                            // filters, tag libraries ..etc.,
                                            // a list of home pages in order of presedency.

                                            //is now replaced by a class called WebServletAdapter and
                                            //all the above configs are done via annotations.
                                            


    Spring Web MVC on Spring Boot
    ----------------------------------------------------------------------------------------------

        Web MVC (Model - View - Controller)
        -------------------------------------

            Repositories <-model-> Services <-model-> Controllers <--------REQ------- Client
                                                         |                                 ↑
                                                         |                                 |
                                                         | model                           |
                                                         |                                 |
                                                         ↓                                 |
                                                        View(s) ------------RESP---------->|
                                                (jsp/jsf/html/thymeleaf)



        Single Front Controller Web MVC (Model - View - Controller)
        --------------------------------------------------------------

         Repositories <-model-> Services <-model-> Controllers <-model-> FrontController <-REQ-- Client
                                                                            |                     ↑
                                                                            |                     |
                                                                            | model               |
                                                                            |                     |
                                                                            ↓                     |
                                                                          View(s) -------RESP---->|
                                                                    (jsp/jsf/html/thymeleaf)

        In Spring Web MVC Framework

            FrontController ?       
                    DispatcherServlet   offered by the framework

                    1. it receives all the requests from the clients
                    2. it extract the information like url-path, query params / path params ..etc., from the request
                    3. it will find out to which controller#action method this request has to be handed over
                        and such action method from the identified controller is invoked 
                    4. the returned view name from the action method and the return model from the action method
                        are collected.
                    5. a view mapping to the given view name is identified and the model is shared with the view.
            
            How are the requests mapped to a specific action of a specific controller?

                UrlHandlerMapping       is an interface
                    SimpleUrlHandlerMapping is one of its implementation.

                    Each action and controller can be mapped to a particular url using an annotation 
                        @RequestMapping(url,httpMethod)

                        @Controller
                        @RequestMapping("/emps")
                        public class EmpController {
                            
                            //@RequestMapping(value="/list",method=HttpMethod.GET)
                            @GetMapping("/list")
                            public ModelAndView listAllEmployees(){
                                //return some list of emps and veiwName
                            }
                        }

                        assuming our web server is running on port number 9999

                        http://localhost:9999/emps/list will be handled by the above mehtod.


                        @RequestMapping
                            @GetMapping
                            @PostMApping
                            @PutMapping
                            @DeleteMapping
                            ....etc.,

        How are the ViewNames mapped to a specific VIEWS?

            ViewResolver        is an interface
                |
                |- XmlResourceViewResolver
                |- MessageBundleResourceViewResolver
                |- InternalResourceViewResolver


            InterlResourceViewResolver
                prefix and suffix are two of its properties

                view = prefix + viewName + suffix

                if we have configured prefix="/pages/" and suffix=".jsp"
                then for given viewNaem=index   the view path is /pages/index.jsp

                order is another proeprty of a ViewResolver. it cna take an integer as a value.
                in case of multiple view resolvers, the froncontroller will take the help of the 
                view resolver in the givne order to figure out the view.

        Controller?

            is a POJO marked with @Controller .

            1. the controller has to have a list of method that are capable of processing requests, and such
                methods are called action methods.
            2. the action method are expected to return a String (as view name) or a an object of ModelAndView class,
                    where ModelAndView class binds a viewName and a model.

        Views ?

            is a server side executing program that is generally a combination of java and html.

            these view will render complete html dynamically once some data (model) is supplied to them.

            We have many view engines like 
                JSP (Java Server Pages)
                Thyeamleaf
                JSF (JAva Server Faces) 
                XHTML ...etc.,

            JSP is the view engine that we are gonna use.

        Java Server Pages

            this is a view engine proposed by the same team who wrote Java Specifications.

            is a combination of java embeded into html.

            here java is used only for presentation logic, and html is employed for content.

            Java is embed via five types of server side elements (tags):
                1. Directives       
                2. Expression
                3. Declaratives
                4. Scriplets
                5. JSP-Actions

            Directives

                <%@ directiveName attributes..... %>

                1. <%@ page import="" %>
                2. <%@ taglib uri="" prefix="" %>

            Expression

                <%=javaExpression %>

                java expression language as an alternate
                ${ javaEL }

                JSP Implicit Objects

                    request     HttpServletRequest
                    response    HttpServletResponse
                    session     HttpSession
                    application ServletContext
                    config      ServletConfig
                    exception   Exception

                ${ attribute }

                JSP will serach for this attribute in request , session , application

                if the attribute is not a string or not a premitive value and is an object, then the fields of the object
                can be directly accessed and are directed to the getter automatically:

                ${ emp.firstName }  //this is understood as <%=emp.getFirstNAme() %>
                ${ emp.married }    //this is understood as <%=emp.isMArried() %>


            Declaratives

                <%! declaration %>

            Scriptlet

                <%
                    //any java code like if,for,....etc.,
                %>

                <% if(!team.isEmpty()) { %>
                    <ol>
                        <% for(String member : team) { %>
                            <li> <%=member%> </li>
                        <% } >
                    </ol>
                <% } %>

                JSTL (Java standard tag library) Core Tags as alternate.


                    <c:if test="${team.isEmpty()}">
                        <p>No team members are found! </p>
                    </c:if>

                    <c:choose>
                        <c:when test="${team==null}">
                            <p>Sorry! unable to extract team from database. </p>
                        </c:when>
                        <c:when test="${team.isEmpth()}">
                            <p>No team members are found! </p>
                        </c:when>
                        <c:otherwise>
                            <h4> ${team.size()} team members are found </h4>

                            <ol>
                                <c:foreach items="${team}" var="member">
                                    <li>${member} </li>
                                </c:foreach>
                            </ol>
                        </c:otherwise>
                    </c:choose>


            JSP Actions

                <jsp:actionName attributes>
                </jsp:actionName>


                <jsp:include page="" />

                <jsp:forward page="' />
                <jsp:useBean />
                ...etc.,













