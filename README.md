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
        











