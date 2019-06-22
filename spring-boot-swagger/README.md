# Spring Boot Swagger Integration

* Refer https://blog.napagoda.com/2017/09/integrating-swagger-with-spring-boot.html

* [http://localhost:8085/v2/api-docs](http://localhost:8085/v2/api-docs)

* [http://localhost:8085/swagger-ui.html](http://localhost:8085/swagger-ui.html)

  

  ### **What is Swagger?**

  * [Swagger](https://swagger.io/)(Swagger 2) is a specification for describing and documenting a REST API. It specifies the format of the REST web services including URL, Resources, methods, etc. Swagger will generate documentation from the application code

  * Using [Springfox](http://springfox.github.io/springfox/) implementation to generate the swagger documentation

  * Springfox works by examining an application at runtime using API semantics based on spring configurations

  * **Springfox provides two dependencies** to generate API Doc and Swagger UI. If you are not expecting to integrate Swagger UI into your API level, no need to add  **Swagger UI dependency**

  * <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.7.0</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.7.0</version>
    </dependency>

    <dependency>
        <groupId>guava</groupId>
        <artifactId>com.google.guava</artifactId>
        <type>jar</type>

    ​    <version>15.0</version>

    </dependency>

  ## ApiInfo

  * The ApiInfo class contains **custom information** about the API
  * Can change these default values by adding apiInfo(**ApiInfo apiInfo**) method
  * Refer https://github.com/pramasamy65/spring/blob/master/spring-boot-swagger/src/main/java/com/exaple/springboot/swagger/config/**ApplicationConfig.java**

  

### ApplicationConfig.java

* @Configuration & @Bean - **JavaConfig**

  * Annotating a class with the @Configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions

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

### Difference between @Component, @Service, @Controller, and @Repository in Spring

* Major difference between these stereotypes is they are used for different classification
* Provide better Modularity to the Enterprise application
* In a multitier application, we will have different layers like presentation, service, business, data access etc
  * @Service – Service layer level
    * Service Hold business Logic, Calculations etc.
  * @Controller – presentatione layer level
    * Controllers just do stuff like dispatching, forwarding, calling service methods etc.
    * Classes annotated with this, are intended to receive a request from the client side. The first request comes to the Dispatcher Servlet, from where it passes the request to the particular controller using the value of `@RequestMapping` annotation
  * @Repository – persistence layer level
    * Are the DAOs (Data Access Objects), they access the database directly

* **@Service, @Controller, @Repository = {@Component + some more special functionality}**
* 

### @RestController

* Combines @Controller and @ResponseBody
* Every request handling method of the controller class automatically serializes return objects into *HttpResponse*

* 

#### @Component

##### @Component Vs @Bean

* @Component **auto detects** and configures the beans using classpath scanning whereas @Bean **explicitly declares** a single bean, rather than letting Spring (IOC container) do it automatically
* @Component **does not decouple** the declaration of the bean from the class definition where as @Bean **decouples** the declaration of the bean from the class definition
* @Component is a **class level annotation** where as @Bean is a **method level annotation** and name of the method serves as the bean name
* @Component **need not to be used with the @Configuration** annotation where as @Bean annotation has to be **used within the class which is annotated with @Configuration**
* @Component has **different specializations** like @Controller, @Repository and @Service whereas @Bean has **no specializations**

## Topics Covered

* Swagger, @Configuration, @Bean, @Component, 

----

Junk 

https://dzone.com/articles/a-guide-to-spring-framework-annotations

https://examples.javacodegeeks.com/enterprise-java/spring/spring-pathvariable-annotation-example/

https://www.javacodegeeks.com/2017/10/differences-requestparam-pathvariable-annotations-spring-mvc.html

https://www.javacodegeeks.com/2017/08/difference-restcontroller-controller-annotation-spring-mvc-rest.html

https://www.javacodegeeks.com/2017/11/difference-component-service-controller-repository-spring.html

https://www.javacodegeeks.com/2013/07/spring-mvc-requestbody-and-responsebody-demystified.html

https://www.javacodegeeks.com/2012/11/spring-mvc-rest-calls-with-ajax.html

https://www.javacodegeeks.com/2019/05/using-responsestatus-http-status-spring.html

https://www.baeldung.com/spring-requestmapping

Spring read post params