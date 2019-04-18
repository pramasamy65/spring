# Spring Basics Concepts

### Program (com.java.handson.spring_basics1)
* STEP 1 : Normal way of Injecting Dependency - without Spring
* STEP 2 : Implementing DI using Spring - Bean Factory container
* STEP 3 : Implementing DI using Spring - Application Context Container
* STEP 4 : Property Initialization in Config file(XML) using Setter Injection

	```
	<property name="receiverDetails" value="Steve Jobs... " />
	```
	
* STEP 5 : Property Initialization in Config file(XML) using Constructor Injection

* STEP 5 : Inner Beans
	```
	<bean id="messenger" class="....Messenger">
		<property name="service">
			<bean class="...."></bean>
		</property>
	</bean>
	```
	
* STEP 6 : Aliases
	```
	<alias name="messenger" alias="messenger-alias">
	```
* STEP 7 : idref
	* ref point to another bean reference or another alias reference
	* But idref refer only ID ref bean
	
	

	
### Concepts (com.java.handson.spring_basics1)
* Spring Container
	* Responsible to manage beans and its life cycle
	* Create Objects and wiring dependencies
	* Container is something like Object Factory based on configuration(XML or Annotation base)
	* Spring container can be implemented in two ways **Bean factory and Application Context**
	
* Bean factory
	* Does Basic beans creation and wiring

* Application Context
	* In addition to standard BeanFactory lifecycle capabilities, ApplicationContext implementations detect and invoke **ApplicationContextAware beans as well as ResourceLoaderAware ApplicationEventPublisherAware and MessageSourceAware**


	
	
	
	


