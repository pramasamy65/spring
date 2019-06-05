# Spring Basics Concepts 5

### Program & Concepts (com.java.handson.spring_basics5)
* https://github.com/pramasamy65/spring/tree/master/spring-basics/src/main/java/com/java/handson/spring_basics5
* Step 1 : Component Annotation			
	* @Component - Refer : **Messenger.java and  spring-config5.xml**
		* Define the class using this annotations, So no need to define as a separate bean in XML
		* To active this annotation use "context:component-scan" in XML
		
* Step 2 : Other Stereotype Annotation
	* Controller
	* Service - **Refer EmailMessageService.java**
	* Repository
	
* Step 3 : <context:annotation-config> and <context:component-scan>
	* <context:component-scan> 
		* Scan all the classes and register it as a bean
		* Automatically register the beans and wire automatically
	* <context:annotation-config>
		* Only wire the beans and explicitly need to define the beans
		* If beans are not defined then nothing will happen
		
* Step 4 : Using MessageSource To Get Text From Property Files - Refer : **mymessage5.properties and spring-config5.xml**
	* org.springframework.context.support.ResourceBundleMessageSource
		* Access properties using Context
			* context.getMessage("greeting", null, "HI... I am Default", null) 
		* Access properties using Message Source - **Refer : Messenger.java**
			* messageSource.getMessage("greeting", null, "HI... I am Default", null)
			* Parameter Substitution for properties
				* messageSource.getMessage("printNames", new Object[] {"Don of Beans"}, "HI... I am Default", null));

		
		