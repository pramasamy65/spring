# Spring Basics Concepts 2

### Program (com.java.handson.spring_basics2)

* STEP 1 : Initializing Collections  - List
	
	```
	<bean id="messenger" class="....Messenger">
		<property name="serviceList" />
		<list>
			<ref bean="emailService"></ref>
			<ref bean="smsService"></ref>
		</list>
	</bean>
	```

* STEP 2 : Initializing Collections  - Set

	```
	<bean id="messenger" class=".....Messenger">
		<property name="serviceSet">
		<set>
			<ref bean="emailService"></ref>
			<ref bean="smsService"></ref>
		</set>
	</bean>
	```
	
* STEP 3 : Initializing Collections  - Map

	```
	<bean id="messenger" class=".....Messenger">
		<property name="serviceMap">
		<map>
			<entry key="emailService" value-ref="emailService">
			<entry key="smsService" value-ref="emailService">
		</map>
	</bean>
	```
	
* STEP 4 : Initializing Collections  - Property

	```
	private Properties pros;
	
	<bean id="messenger" class=".....Messenger">
		<property name="serviceProperty">
		<property>
			<prop key="" value="">
		</property>
	</bean>
	```

* STEP 5 : Auto wiring by name - Reference : spring-config2.xml
	* If no bean is found by name then nothing will be injecting and on accessing the Object/property will get NPE

* STEP 6 : Auto wiring by type - Reference : spring-config2.xml
	* if two types are found then it will throw "No unique bean of type" Exception
	* If no bean is found by type then nothing will be injecting and on accessing the Object/property will get NPE

* STEP 7 : Auto wiring by constructor - Reference : spring-config2.xml
	* If no unique/single bean is found by type and name then nothing will be injecting and on accessing the Object/property will get NPE
	* By Default constructor looks for Simlar Type based injection
	* Only one type is found then it will inject the dependency
	* More than one type found then it will try to match with name
	* More than one type found and there is no name match then nothing will be injected & on accessing the Object/property will get NPE

* STEP 8 : Understanding Bean Scopes

* STEP 9 : Using BeanFactoryAware, ApplicationContextAware & BeanNameAware - Reference : Messenger.java

* STEP 10 : Bean Definition Inheritance  : **Parent and List merge**
	```
	
	<bean id ="parentBean" class=".....">
		<property name="serviceList">
		<list>
			<ref-bean="pointA"
		<list>
	</bean>
	
	<bean id ="BeanName" class="......" parent="parentBean">
	<property name="serviceList">
		<list merge="true">
			<ref-bean="pointB">
		<list>
	</bean>
	```
* STEP 11 : Bean Lifecycle Callbacks :
	
	* Spring Based Lifecycle Methods
		* AbstractApplicationContext : Refer App.java
		* InitializingBean Interface : Refer EmailMessageService.java
			* afterPropertiesSet() : will be called once beans completed the initialization
		* DisposableBean : Refer EmailMessageService.java
			* context.registerShutdownHook() is required to perform the clean up activities(DisposableBean)
	
	* XML Based Lifecycle Methods
		* init-method="myInit"
			*  mention the method name in Bean class
		* destroy-method="myDestroyCleanUp"
			*  mention the method name in Bean class
		* Default init and destroy in Beans level
			* <beans default-init-method="myInit" default-destroy-method>
				* No Need to define in method levels instead of that we can define Global level
	
	* Both XML based config and Spring based Life cycle methods are defined then, first calls the Class level methods and followed by XML based init methods
	* For prototype Scope, destroy method will not be invoked for both XML and class based Config
	
	
### Concepts (com.java.handson.spring_basics2)

* STEP 5- 7 : Auto Wiring
	* By default there is no auto wiring
	* Auto wiring Good for small amount of coding
	
* STEP 8 : Understanding Bean Scopes
	* Multiple Spring container will reside in JVM. Bean scopes are specific to container
	* By default, Spring container will create beans during the container initialization based on config not during getBean() call
	* Singleton scope="singleton"
		* Single Object for Spring container. By default all beans are Singleton
	* Prototype scope="prototype"
		* Every request, Spring container will create new Objects basically beans
		* Spring Container will wait for getBean() call and creates the instance not during container initialization time
	* Web-aware Context Bean Scopes - For Web Application
		* Request - New Bean per Servlet Request
		* Session - New Bean per Session
		* Global Session - Portlet Applications - New bean for Global HTTP session

* STEP 9 : Using BeanFactoryAware, ApplicationContextAware & BeanNameAware
	* BeanFactoryAware
		*  Used to get the factory objects or Container beans in any where in the application
	* ApplicationContextAware 
		* Used to get the context objects or Container beans in any where in the application
		* Since container loads the context only once using config
		* Programmatic retrieval of other beans using the application contex
	* BeanNameAware
		* When a bean wants it id or name configured in xml file ,then that bean should implements BeanNameAware Inteface and overide a method called setBeanName( String name).
	
* STEP 10 : Bean Definition Inheritance  : **Parent and List merge**
	* Inheritance : Parent
		* Will Inherit and overridde as well
	* List merge
		* Merge with parents property
	
* STEP 11 : Bean Lifecycle Callbacks 
	* AbstractApplicationContext
		* context.registerShutdownHook();
			* Register a shutdown hook with the JVM runtime, closing this context on JVM shutdown unless it has already been closed at that time
			* shut down IoC container in non-web applications like desktop based applicaiton
			
