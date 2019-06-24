# Spring Boot Swagger Integration

- Refer https://blog.napagoda.com/2017/09/integrating-swagger-with-spring-boot.html
- Build the Project https://github.com/pramasamy65/spring/tree/master/spring-boot-swagger and hit the following url's
  - [http://localhost:8085/v2/api-docs](http://localhost:8085/v2/api-docs)
  - [http://localhost:8085/swagger-ui.html](http://localhost:8085/swagger-ui.html)

#### What is Swagger

* [Swagger](https://swagger.io/)(Swagger 2) is a specification for describing and **documenting a REST API**. It specifies the **format of the REST web services** including **URL, Resources, methods**, etc. Swagger will generate documentation from the application code

* **Using [Springfox](http://springfox.github.io/springfox/) implementation** to generate the swagger documentation

* Springfox works by e**xamining an application at runtime** using API semantics based on spring configurations

* **Springfox provides two dependencies** to generate API Doc and Swagger UI. If you are not expecting to integrate Swagger UI into your API level, no need to add  **Swagger UI dependency**

  * <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>**springfox-swagger2**</artifactId>
        <version>2.7.0</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>**springfox-swagger-ui**</artifactId>
        <version>2.7.0</version>
    </dependency>

    <dependency>
        <groupId>guava</groupId>
        <artifactId>com.google.guava</artifactId>
        <type>jar</type>

    ​    <version>15.0</version>

    ​	</dependency>

#### @EnableSwagger2 & ApiInfo

* ~~~java
  @Configuration
  @EnableSwagger2
  public class ApplicationConfig {
  @Bean
  	public Docket api() {
  		return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo()).select()	.apis
  		(RequestHandlerSelectors
   				.basePackage("com.exaple.springboot.swagger.controllers"))
  				.paths(PathSelectors.any()).build();
  }
  	private ApiInfo getApiInfo() {
  		Contact contact = 
        new Contact("Prakash Ramasamy", "https://tst.com", "test@gmail.com");
  		return new ApiInfoBuilder()
          .title("Sample Swagger Implementation")
  				.description("This is Sample Swagger Service").version("1.0.0")
  				.license("Apache 2.0")
          .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
  				.build();
  	}
  }
  ~~~

* The ApiInfo class contains **custom information** about the API

* Can change these default values by adding apiInfo(**ApiInfo apiInfo**) method

* Refer https://github.com/pramasamy65/spring/blob/master/spring-boot-swagger/src/main/java/com/exaple/springboot/swagger/config/**ApplicationConfig.java**

---

-----

#### @Configuration & @Bean - **JavaConfig** 

##### 		*Refer ApplicationConfig.java*

* Annotating a class with the @**Configuration** indicates that the **class** can be used by the Spring IoC container as a **source of bean definitions**

* Method annotated with @Bean will return an object that should be registered as a bean in the Spring application context

* **Method name** is annotated with @Bean works as **bean ID** and it creates and returns the actual bean

  ```java
  package com.test;
  import org.springframework.context.annotation.*;
  
  @Configuration
  public class HelloWorldConfig {
     @Bean 
     public HelloWorld helloWorld(){
        return new HelloWorld();
     }
  }
  ```

  The above code will be equivalent to the following XML configuration −

  ```java
  <beans>
     <bean id = "helloWorld" class = "com.test.HelloWorld" />
  </beans>
  ```

* **JavaConfig** features are included in core Spring module, it allow developer to move bean definition and Spring configuration out of XML file into Java class

* **JavaConfig** refers to the annotation based configuration, as opposed to the older, original XML based configuration

* Once your configuration classes are defined, you can load and provide them to Spring container using AnnotationConfigApplicationContext

* You can load various configuration classes as follows −

  ```java
  public static void main(String[] args) {
     AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  
     ctx.register(HelloWorldConfig.class, OtherConfig.class);
     ctx.register(AdditionalConfig.class);
     ctx.refresh();
  
     HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
     helloWorld.setMessage("Hello World!");
     helloWorld.getMessage();
  }
  ```

* Example

* ```java
  public class HelloWorld {
     private String message;
  
     public void setMessage(String message){
        this.message  = message;
     }
     public void getMessage(){
        System.out.println("Your Message : " + message);
     }
  }
  ```

* @**ComponentScan** annotation along with @**Configuration** annotation to specify the **packages** that we want to be **scanned**

* @ComponentScan without arguments tells Spring to scan the **current** **package** and all of its s**ub-packages**

  ```java
  @Configuration
  @ComponentScan
  public class SpringComponentScanApp {
      @Bean
      .....
  }    
  ```

#### @Component

* Enable Spring auto component scanning features, Annotate with **@Component** to indicate this is class is an auto scan component.

* Put this “`context:component`” in bean configuration file, it means, enable auto scanning feature in Spring. The **base-package** is indicate where are your components stored, Spring will scan this folder and find out the bean (annotated with @Component) and register it in Spring container

* ```java
  <context:component-scan base-package="com.test.demo" />
  ```

  OR

* ```java
  @ComponentScan(basePackages = "com.test.demo")
  @Configuration
  public class SpringComponentScanApp
  ```

* By default, Spring will **lower case the first character of the component** – from ‘CustomerService’ to ‘customerService’. And you can retrieve this component with name ‘customerService’.

* ```java
  CustomerService cust = (CustomerService)context.getBean("customerService");
  ```

* To create a custom name for component, you can put custom name like this :

  ```java
  @Component("AAA")
  public class CustomerService 
  ...
  ```

#### @ComponentScan

* Component scanning enables auto-detection of beans by Spring container

* `@ComponentScan` annotation enables component scanning in Spring

*  Java classes that are decorated with stereotypes such as `@Component`, `@Configuration`, `@Service` are auto-detected by Spring

* With `@ComponentScan's` `basePackages` attribute specifies which packages should be scanned for decorated beans

  ##### @ComponentScan – Identifying Base Packages

  * Provide the package names in attribute `basePackages`. You can also provide one of the class from the package using `basePackageClasses`

  ```java
  @ComponentScan(basePackages = {
          "com.javarticles.spring.annotations.packageA",
          "com.javarticles.spring.annotations.packageB",
          "com.javarticles.spring.annotations.packageE" }, basePackageClasses = BeanC1.class)
  ```

  ##### Disabling Default Filters

  * The default filter automatically detects the components from the list of base packages specified, So need to manually register the beans

    ```java
    @ComponentScan(value="....packageA", useDefaultFilters=false)
    public class SpringComponentScanDisableDefaultFiltersExample {
        public static void main(String[] args) {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(SpringComponentScanDisableDefaultFiltersExample.class);
            ctx.refresh();
    }
    ```

  ##### Exclude Filters

  * Exclude one or more classes, you can do that using `excludeFilters`

  ```java
  @Configuration
  @ComponentScan(basePackageClasses = BeanC1.class, 
                excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanC3.class))
  public class SpringComponentScanExcludeAnnotationExample {...}
  ```

  ##### Include Filters

  * In order for this to work, need to specify the base packages, **disable the default filters** and explicitly include the components using `@ComponentScan.Filter`

    ```java
    @ComponentScan(basePackages = { "...packageB", "...packageE" }, 
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, 
                 value = Custom.class), useDefaultFilters = false)
    ```

#### @Component Vs @Bean

* The essential thing **both annotations** help with is **adding Spring Bean to the Spring Context**

* @Component **auto detects** and configures the beans using classpath scanning whereas @Bean **explicitly declares** a single bean, rather than letting Spring (IOC container) do it automatically
* @Component **does not decouple** the declaration of the bean from the class definition where as @Bean **decouples** the declaration of the bean from the class definition
* @Component is a **class level annotation** where as @Bean is a **method level annotation** and name of the method serves as the bean name
* @Component **need not to be used with the @Configuration** annotation where as @Bean annotation has to be **used within the class which is annotated with @Configuration**
* @Component has **different specializations** like @Controller, @Repository and @Service whereas @Bean has **no specializations**

#### Difference between @Component, @Service, @Controller, and @Repository in Spring

- Major difference between these stereotypes is they are used for **different classification**
- Provide **better Modularity** to the Enterprise application
- In a **multitier** application, we will have different **layers like presentation, service, business, data** access etc
  - @Service – **Service layer level**
    - Service Hold business Logic, Calculations etc.
  - @Controller – **presentatione layer level**
    - Controllers just do stuff like **dispatching, forwarding, calling service methods** etc.
    - Classes annotated with this, are intended to receive a **request from the client side**. The **first** request comes to the **Dispatcher Servlet,** from where it passes the request to the particular controller using the value of `@RequestMapping` annotation
  - @Repository – **persistence** layer level
    - Are the DAOs (Data Access Objects), they access the database directly
    - Catch **persistence specific exceptions** and rethrow them as one of Spring’s unified **unchecked exception**. Means basicallly It will convert into Spring specific exceptions

- @Service, @Controller, @Repository, @Configuration = {**@Component + some more special functionality}** - Each of this classes are intern annotated with @Component

#### @RestController

- Combines @Controller and @ResponseBody
- Every request handling method of the controller class automatically serializes return objects into *HttpResponse*

#### @ResponseBody 

* ResponseBody annotation on a method, Spring converts the return value and writes it to the HTTP response automatically

* Each method in the Controller class must be annotated with @ResponseBody

* Every time an issued request hits @ResponseBody, Spring loops through all registered HTTPMessageConverters seeking the first that fits the given mime type and class, and then uses it for the actual conversion

  ```java
   @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
      public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name) {
         employee.setName(name);
         employee.setEmail("employee1@genuitec.com");
      return employee; 
      }
  ```

#### context:annotation-config

* context:annotation-config is used for activating annotations in beans already registered in the application context

* It doesn’t bother how it is registered if it is by **context:component-scan** or defined in the **xml** itself.

* It mainly activates the 4 types of **BeanPostProcessors**

  - CommonAnnotationBeanPostProcessor : **@PostConstruct, @PreDestroy**, @Resource
  - AutowiredAnnotationBeanPostProcessor : **@Autowired, @Value, @Inject, @Qualifier**, etc
  - RequiredAnnotationBeanPostProcessor : **@Required** annotation
  - PersistenceAnnotationBeanPostProcessor :**@PersistenceUnit** and **@PersistenceContext**annotations

  

#### context:component-scan

* can also do the same job like context:annotation-config , but context:component-scan will also scan the packages for registering the beans to application context. 
* **context:component-scan = context:annotation-config + Bean Registration**

#### mvc:annotation-driven

- Enable Spring MVC-specific annotations like @Controller

- If this tag is not added to the XML, then you will have to manually define the beans for components like HandlerAdapter, HandlerMapping, Binding Initializer, Request Message converters, etc. This tag helps registering the following components

  - **DefaultAnnotationHandlerMapping** - This is a HandlerMapping implementation which maps the HTTP requests to the handler methods defined using the @RequestMapping annotation
  - **AnnotationMethodHandlerAdapter** - It is responsible for scanning the controllers to identify methods (and parameters) annotated with @MVC annotations. It scans and caches handler methods annotated with @RequestMapping. Also handles the @RequestParam, @ModelAttribute, @SessionAttributes and @InitBinder annotations

- Annotations

  - | XML Tag                       | Annotation       |                         Description                          |
    | :---------------------------- | :--------------- | :----------------------------------------------------------: |
    | context:component-scan/       | @ComponentScan() | Scan starts from base package and registers all controllers, repositories, service, beans, etc. |
    | mvc:annotation-driven/        | @EnableWebMvc    |   Enable Spring MVC-specific annotations like @Controller    |
    | Spring config file - XML file | @Configuration   | Treat as the configuration file for Spring MVC-enabled applications. |

#### @SpringBootApplication

* @SpringBootApplication is a composition of the @Configuration, @ComponentScan, and @EnableAutoConfiguration annotations

  ```java
  @ComponentScan(“com.test”)
  @SpringBootApplication
  public class SpringbootIn10StepsApplication {...}
  ```

  

#### @EnableAutoConfiguration

* `@EnableAutoConfiguration` annotation auto-configures the beans that are present in the classpath. This simplifies the developers work by guessing the required beans from the classpath and configure it to run the application. 
* This annotation is part of the spring boot project
* For example, if you have `tomcat-embedded.jar` in the classpath, then you will need a `TomcatEmbeddedServletContainerFactory` bean to configure the tomcat server. This will be searched and configured without any manual XML configurations
* In Spring MVC project, Dao layer we need to inject JdbcTemplate to our Dao class’ objects. So we need to configure the JdbcTemplate object either through xml or through java class
* @EnableAutoConfiguration gives the default configuration to our spring application like creating JdbcTemplate bean
* Spring Boot it will check dependencies in the classpath and in certain conditions it will configure something, like a database when it detects a DB driver

#### Migrate Spring MVC servlet.xml to Java Config

* Refer https://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/

#### Spring Framework Annotations

*  Core Spring Framework Annotations
*  Spring Framework Stereotype Annotations
*  Spring Boot Annotations
*  Spring MVC and REST Annotations
*  Composed @RequestMapping Variants
  * https://dzone.com/articles/a-guide-to-spring-framework-annotations

#### **@RequestParam** 

* RequestParam annotation used for accessing the query parameter values from the request. Look at the following request URL:

```java
http://localhost:8080/springmvc/hello/101?param1=10&param2=20
```

In the above URL request, the values for param1 and param2 can be accessed as below:

```java
public String getDetails(
    @RequestParam(value="param1", required=true) String param1,
        @RequestParam(value="param2", required=false) String param2){
...
}
```

#### **@PathVariable**

* @*PathVariable* identifies the pattern that is used in the URI for the incoming request. Let’s look at the below request URL:

  ```java
  http://localhost:8080/springmvc/hello/101?param1=10&param2=2
  ```

The above URL request can be written in your Spring MVC as below:

```java
@RequestMapping("/hello/{id}")
public String getDetails(@PathVariable(value="id") String id,
    @RequestParam(value="param1", required=true) String param1,
    @RequestParam(value="param2", required=false) String param2){.......}
```

#### **@MatrixVariable**

* Matrix variables can appear in any path segment, each matrix variable separated with a “;” (semicolon)

* For example: `"/cars;color=red;year=2012"`

* Multiple values may be either "," (comma) separated `"color=red,green,blue"`or the variable name may be repeated `"color=red;color=green;color=blue"`

  ```java
  public Response getBooks(@PathParam("year") String year,
  			@MatrixParam("author") String author,
  			@MatrixParam("country") String country) {
    
  }
  URI Pattern : /books/2011;author=mkyong;country=malaysia
  ```

#### @FormParam

```java
public Response validateUser(
		@FormParam("username") String userName,
		@FormParam("password") String password) {
		return Response.status(200)
			.entity("addUser is called, name : " + name + ", age : " + age)
			.build();
	}
```

#### RestFul Webservice Exception Handling



MultiValueMap

