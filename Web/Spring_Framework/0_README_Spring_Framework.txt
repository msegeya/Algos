Refer:  https://www.youtube.com/watch?v=EKobsnv9dsA
	      http://www.tutorialspoint.com/spring/spring_interview_questions.htm

- Before going to Spring details let us first understand MVC framework
(Refer MVC.png)
User requests lands on the controller. 
From controller it calls the Model. 
Model returns data objects.
Controller pushes them back to the view.

Front Controller:
Front Controller is the place where the requests are captured.
It also does the following, 
Loads all the URL's and the components that need to be called for this URL.
Prepare the map for views.

Spring MVC Architecture: (Refer Spring_MVC_Arch.png)
1) Dispatched Servlet acts as the Front Controller.
2)When ever a request is landed at the Dispatcher Servlet it first calls the "Handler Mapping" which will have the map of teh URL and the controller that needs to be invoked.
3) Dispatcher Servlet will call the respective contoller that it got from Handler Mapping.
4) Controller will call the Model and gets the data and returns it back to Dispatcher.
5) Finally Dispatcher will initiate the view resolver and display the view with the data which it got.

For detailed Spring Architecture with request and response refer Spring_MVC_Arch_Detailed.png
1) Request comes to dispatcher.
2) Captures the request locale.
3) Then request goes to Handler Mapping where we have URL to "Controller mapping". It transfers to Handler Chain.
4) Handler Chain will take this request and does Interceptor pre-process and passes it to the controller and then it does the post-process.
5) Hanlder chain will pass to "View Resolver" and prepares view.
6) Finally the view is returned back to dispatcher Servlet.

- Advantages:
It supports RESTful URL's
Annotation Based configuration
Supports to plugin other frameworks like Struts etc.
Supports different views like JSP, velocity, XML

----------------------------------------------------------------------------------------------------------
What is Spring?
Spring is open source developement framework for enterprise Java. Spring framework targets J2EE development easier to use.

What version is been used currently?
version = 4.2.0 or 4.2.5
----------------------------------------------------------------------------------------------------------
- What is a bean?
  The objects that form the backbone of your application and that are managed by the Spring IoC container are called beans.

  What does Bean definition contain?
    1) Create a bean.
    2) Bean's life cycle details.
    3) Bean's dependencies.

  Life Cycle of a Bean?
    *) Instantiate - Spring will find the bean in the xml.
    *) Populate Properties - Using DI, Spring will populate all the properties specified in the Spring definition.
    *) PreInitialization - If this bean is dependent on other beans then Spring calls for initialization of those.
    *) Initialize Beans - Initialies the bean that is all the things will be ready for the bean now.
    *) Post Initialization - Post process methods will be called if there are any.
    *) Ready to Use - Can be used now.
    *) Destroy - If bean implements DisposableBean then Spring will call destroy() method finally.
----------------------------------------------------------------------------------------------------------
What are the benefits of Spring?
  *) Lightweight - It is light weight - basic version is around 2MB.

  *) Inversion Of Control (IOC) - IOC is achieved using Dependency Injection.
     By DI the responsibility of creating objects is shifted from our application code to Spring container hence the phenomenon is called IOC.
  		- Dependecny Injection (DI) - In spring objects define their associations (dependencies) and do not worry about how to get those dependencies ; now it is the responsibility of Spring to provide the required dependencies for creating objects.

      Consider the following example, Suppose we have an object Employee and it has a dependency on object Address. So we define a bean corresponding to Employee where it will define its dependency on object Address. When Spring try to create an Object Employee it sees that Employee has a dependency on object Address so first it will create the Address object (dependent object) and then inject this into the Employee Object.

      Refer: trunk/SpringTutorial/src/com/spring/tutorials/MainApp.java - DI_Tutorial()

  *) Aspect Oriented Programming (AOP) - It is an interceptor that intercepts some process for example if some method needs to execute then Sping AOP will hijack that method and add some functionality before and after that method.
      Refer: trunk/SpringTutorial/src/com/spring/tutorials/MainApp.java - AOP_Tutorial()
      Reference: http://www.mkyong.com/spring/spring-aop-examples-advice/

  *) Container - The Spring IoC creates the objects, wire them together, configure them, and manage their complete lifecycle from creation till destruction. The Spring container uses dependency injection (DI) to manage the components that make up an application.
        1) Bean Container - Simplest container provides basic support for DI. Ex. XmlBeanFactory class
        2) Spring ApplicationContext Container - Adds more enterprise specific funtionality such as ability to resolve textual messages. 
           Ex. ClassPathXmlApplicationContext, FileSystemXmlApplicationContext

  *) MVC Framework - It managed well to overcome the difficulties in Struts framework.

  *) Transaction Management - Spring provides very efficient transactional management servies.
      Reference: http://www.journaldev.com/2603/spring-transaction-management-example-with-jdbc

  *) Exception Handling - We can throw exceptions page when exceptions occur. If we need to display certain pages then if any error comes then return the error pages. Spring handles this well.
    Refernce: http://www.mkyong.com/spring-mvc/spring-mvc-exceptionhandler-example/

    Example:  ModelAndView model = new ModelAndView("error/generic_error");
              model.addObject("errCode", ex.getErrCode());
              model.addObject("errMsg", ex.getErrMsg());
              return model;
----------------------------------------------------------------------------------------------------------
- Spring MVC vs Struts 2
  Spring - Neat and clear separation of controllers, JavaBeans, and views is possible.
  Struts - Not possible in an efficient way.

  Spring is more flexible than Struts.

  Spring can be used with different platforms like velocity, XLST etc.

  Code is more testable than Spring because of DI than in Struts.
----------------------------------------------------------------------------------------------------------
- What are the modules in Spring?
  
  Refer - Spring_Modules.png
  Reference: http://docs.spring.io/spring-framework/docs/3.0.x/reference/overview.html

  Core Container - Contains Core, Beans, Context, Expression Language Module.
                   Core and Bean - has IOC and DI features.
                   Context - It provides base to access objects using above Core and Bean.
                   Expression Language Module - Provides modules for expression language

  Data Access/Integration - JDBC, ORM, OXM, Trnasaction modules
                            JDBC - Provides JDBC abstraction layer that removes the tedious JDBC coding and vendor related errors.
                            ORM - Provides Object-Relational mapping API's (For example JPA, Hibernate, iBatis)                 
                            OXM - Supports XML mapping API's
                            Transaction - Supports Transaction Management.

  Web - Web, Web-Servlet, Web-Struts, and Web-Portlet modules.
  AOP and Instrumentation - Provides method interceptors and pointcuts to cleanly decouple the code that implements functionality.
  Test - Provides test modules that supports the testing of Spring components usign JUnit TestING.
----------------------------------------------------------------------------------------------------------
- What is Spring configuration file?
  It is an XML file which contains information about how the classes are configured and introduced to each other.
----------------------------------------------------------------------------------------------------------
- Types of IOC:
  Two types,
    1) Contructor based dependecy Injection: Just create a constructor and call it from the xml.
        Refer: Refer: trunk/SpringTutorial/src/com/spring/tutorials/MainApp.java - Constructor_Based_DI()
    2) Setter based dependency Injection: The one which we usually do using setter methods

- Which one to use?
  Use Contructor based DI for mandatory dependencies.
  Use setter for optional dependencies.
  @Required will make the setter as required(mandatory) dependencies.
----------------------------------------------------------------------------------------------------------
- Uses of DI
  *) Less code to write
  *) Easy to test
  *) Lazy loading is supported by IOC so no need to load all the code at the start.
----------------------------------------------------------------------------------------------------------
- How to provide configuration metadata to the spring container?
  1) Annotation-based configuration
  2) XML based configuration
  3) java based configuration
----------------------------------------------------------------------------------------------------------
- What is scope in bean?
  Default scope is singleton.
  NOTE: singleton and prototype are most important.
  singleton - Same bean is instance will be returned everytime you call the Bean.xml
  prototype - Each time a new instance is provided.
  request - Bean definition is valid to an HTTP request.
  session - Valid for HTTP session
  global-session - Valid for HTTP session globally.

- Default scope of a bean is singleton. So is singleton scope bean thread safe?
  No.
----------------------------------------------------------------------------------------------------------
- How to inject list, set, map, props inside a bean?
  Refer - trunk/SpringTutorial/src/com/spring/tutorials/MainApp.java - COLLECTIONS_Inject_Bean()
----------------------------------------------------------------------------------------------------------
- What is Auto Wiring?
  Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
  Autowiring can't be used to inject primitive and string values. It works with reference only.

- Types of auto wiring:
  
  autodetect (default) - Spring first tries to wire using autowire by constructor, if it does not work, Spring tries to autowire by byType.

  no - No Auto wiring. You should do the explicit reference.

  byName - Autowiring by property name. Spring container looks at the properties of the beans on which autowire attribute is set to byName in the XML configuration file. It then tries to match and wire its properties with the beans defined by the same names in the configuration file.

  byType - Autowiring by property data type. Spring container looks at the properties of the beans on which autowire attribute is set to byType in the XML configuration file. It then tries to match and wire a property if its type matches with exactly one of the beans name in configuration file. If more than one such beans exist, a fatal exception is thrown.

  constructor - Similar to byType, but type applies to constructor arguments.

  Disadvantages of Autowiring:
    1) Primitive data types: You cannot autowire so-called simple properties such as primitives, Strings, and Classes.
    2) Confusing nature: Autowiring is less exact than explicit wiring, so if possible prefer using explicit wiring.
    3) Overriding possibility: You can still specify dependencies using <constructor-arg> and <property> settings which will always override autowiring.
----------------------------------------------------------------------------------------------------------
- Can you inject null or empty values in Spring ?
  YES
----------------------------------------------------------------------------------------------------------
- What is Annotation Based Configuration
  An alternative to XML setups is provided by annotation-based configuration which relies on the bytecode metadata for wiring up components instead of angle-bracket declarations.

  How to turn on Annotation wiring?
    By default it is off. If you want to turn it on then go to Spring configuration file by configuring <context:annotation-config/>
----------------------------------------------------------------------------------------------------------
- @Required
  This annotation simply indicates that the affected bean property must be populated at configuration time, through an explicit property value in a bean definition or through autowiring. Else you will get "BeanInitializationException".

  @Autowired
  This annotation provides more fine-grained control over where and how autowiring should be accomplished.

  @Qualifier
  There may be a situation when you create more than one bean of the same type and want to wire only one of them with a property, in such case you can use @Qualifier annotation along with @Autowired to remove the confusion by specifying which exact bean will be wired.

  @Acpect
  A style of delcaring acpects.

  @Controller
  The @Controller annotation indicates that a particular class serves the role of a controller. Spring does not require you to extend any controller base class or reference the Servlet API.

  @RequestMapping
  This annotation is used to map a URL to either an entire class or a particular handler method.
----------------------------------------------------------------------------------------------------------
- How is event handling done in Spring?
  Event handling in the ApplicationContext is provided through the ApplicationEvent class and ApplicationListener interface.

  Reference: http://www.tutorialspoint.com/spring/event_handling_in_spring.htm
----------------------------------------------------------------------------------------------------------
- What is an Aspect?
  A module which has a set of API's providing cross-cutting requirements.
  Ex: Logging module.
----------------------------------------------------------------------------------------------------------
- Joint Point: 
  Point were we can plug in AOP aspect.

- Point Cut: 
  One or more Joint Points.

- Introduction:
  Adding new methods/attributes to existing classes.

- Target Object:
  Object being advised by one or more aspects.

- Weaving: 
  Weaving is the process of linking objects. Weaving can be done at compile/run/load time.

- Types of advices:
  *) before - Run advice before method execution
  *) after - Run advice after method execution
  *) after-retruning - Run advice after methof exectuion only if the method completes successfully.
  *) after-throwing - Run advice after methof exectuion only if the method exits by throwing an exception
  *) around - run advice before and after method execution. (above all together.)
----------------------------------------------------------------------------------------------------------
- How is jdbc been used more effectively in Spring MVC?
  Spring provides a template called jdbc template using which jdbc has been used effectively.
----------------------------------------------------------------------------------------------------------
- Types of Transaction management
  *) Declarative Transaction Management: Separate transaction management from business code by using xml notations. 
  *) Programmatic Transaction Management: Managing trnsaction with the help of programming. hard to maintain. 

- Which of the above is preferred ?
  Declarative Transaction Management. 
----------------------------------------------------------------------------------------------------------
- What are controllers in Spring MVC?
  Controllers provide access to the application behavior that you typically define through a service interface. Controllers interpret user input and transform it into a model that is represented to the user by the view.
----------------------------------------------------------------------------------------------------------
- Ways to access Hibernate in Spring MVC?
  1) Inversion of Control with a Hibernate Template and Callback.
  2) Extending HibernateDAOSupport and Applying an AOP Interceptor node.
----------------------------------------------------------------------------------------------------------