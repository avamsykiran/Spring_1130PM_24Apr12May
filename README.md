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
            

            





