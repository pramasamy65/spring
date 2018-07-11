# Spring-MVC

https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=2&mode=live

http://localhost:8080/springmvc/addGoal


What is Spring MVC ?

	Web framework build around Spring
	Based on Front controller pattern(Dispatcher servlet)
	Build from shortcomings of Struts 1
	Spring MVC can be REST based/ JSP based
	
Architecture

	Spring MVC/Spring frameworks are based on Java servlets/J2EE
	
Request/Response LifeCycle

	Incoming Request->Front Controller-> Delegate Request to CONTROLLER
	Controller will handle the request the and if it requires then delegate to backend and get the model
	Based on the model(which is returned by the controller), Front controller will consult with "View Template" 
	and get the view
	Finally front controller will return the view as a response

Vocabulary

	DispatcherServlet
	Controller - Handles the request and determines which view to route
	RequestMapping - URL mapping and request type the method is tied to 
	ViewResolver - Map to respective views(JSP or other technology)
	Bean - Spring configured POJO
	
Spring MVC

	Web framework build around the principles of Spring
	Based on Dispatcher Servlet/Front Controller pattern
	Spring is based on Java Servlets/JEE
	Spring MVC based on Spring
	
	Incoming Request -> Front Controller(Dispatcher Servlet)-> Delegate to Controller -> Controller will handle the request to backend/webservices 
	Based on webservices/backend data, model will be created
	Controller will delegate to Front controller with model and view name
	FC will pass the model to View template and View template will populate the values in jsp pages using model

Annotations

	<mvc:annotation-driven/> - Using annotation to configure our applications
	<context:component-scan base-package="com...."/>
	@Controller
	@RequestMapping(value="/...")
	Model -> Like Hash Map mode.addAttribute("Key", Value)
	view -> ${Key}
	ModelView
	InternalResourceViewResolver -> Prefix and Suffix
	
Components

	@Controllers
		Handling incoming requests and building Response
		Transform user inputs into model
		Interact with services
		Should not contain Business logic
		Route to views
	@Service
		Business logic
		Starting poing of Transactions 
	@Repository
		Database/storage/Transactions related stuffs
		Will transform DB related error to Spring related errors
	
Tags - Spring tags
	
	JSP - Used to embed Java code inside HTML with the help of JSTL
	JSTL - Java Standard Tag libraries
	
	Tag Library's are used in views to display the data
	Spring tags libs are Used to interact with data in the pages
	Spring Tag libraries are based on JSTL
	Spring tag libraries are included in spring.jar
	
	Spring tags are helpful to develop views and used to bind the views
	Used for form binding & evaluating errors, themes
	Spring tags - Validating erros and setting themes
	Spring form tags - Processing forms and its a mirror of HTML Forms
	
	Putting data to the model from controller
		model.addAttribute("greeting","Welcome")
		
	Retrive data in the view using JSTL expression
		 	${greeting}
		 
	Form binding - Putting html form values into models and vice versa
		Spring tag library tags help us to bind the HTML tag element’s values to a form backing bean in the Model
		Controller can retrieve the formbacking bean from the Model using the @ModelAttribute
		
	Example : 
			JSP	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
					<form:form modelAttribute="exercise"> - exercise is model like POJO class
					<form:input path="minutes" /> minutes - pojo property
					Forms attributes will be mapped to model object in controller
			Controller 
				public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {}
				
Externalize the String in JSP pages Using Message tag

		Include Spring tags <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		<spring:message code="goal.text" /> --> goal.text should be mentioned in messages.properties
		<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
			<property name="basename" value="messages" /></bean> 
			Value is file name like messages.properties
			
	
Views

	WEB-INF/jsp/... -> Security reasons -> access by routed through our applications via controller
	Multiple view resolvers available 
		Tiles view Resolver
		contentNegoatingViewResolver

	forward
		@RequestMapping("/addMinutes")
			forward:addMoreMinutes
		@RequestMapping("/addMoreMinutes") 
			Internally it will redirect to another resource. client doesn't know about the change
			there is no change in the url to the end user

	redirect
		@RequestMapping("/addMinutes")
			redirect:addMoreMinutes
		@RequestMapping("/addMoreMinutes")
			redirect will go out of application and client sees 302 redirection and url also points to new url
			
	Resolving static files
		<mvc:resources location="/WEB-INF/pdfs/" mapping="/static/**/"></mvc:resources> --> loading static resources
			
Interceptors

	Registered part of the request lifecycle
	Part of Request life cycle will be called before reaching to controller
	Having ability to handle pre-handle and post-handle web requests
	Common Example - Locale exchange interceptor
	Example
		JSP <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
		Config <bean id="localeResolver" class="org.springframework.web.servlet.i18n.sessionLocaleResolver"
					p:defaultLocale="en"></bean>
		Above line will be used to select the current locale used for current session
	
Spring Internationalization using interceptor

	<mvc:interceptors>
		<bean id="localeChangeInterceptor"
			class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
			<property name="paramName" value="language" />
		</bean>
	</mvc:interceptors>
	
Spring form tags

	Checkbox, form, hidden, input, label, 
	Bind objects from our model into Views
	Easily bind errors
	
@SessionAttributes("goal")

	When developing web applications, we often need to refer to the same attributes in several views. For example, 
	we may have shopping cart contents that need to be displayed on multiple pages.
	
	The @ModelAttribute and @SessionAttributes strategy for storing an attribute in the session is a 
	straightforward solution that requires no additional context configuration or Spring-managed @Beans
	
	A good location to store those attributes is in the user’s session
	we declare it as a @ModelAttribute and specify the @SessionAttributes annotation to scope it to the session 
	for the controller

@ModelAttribute

	It's an annotation that binds a method parameter or method return value to a named model attribute and then 
	exposes it to a web view.
	
	@ModelAttribute - At the Method Level
	public void addAttributes(Model model) {
   		 model.addAttribute("msg", "Welcome to the Netherlands!");
	}
	@ModelAttribute methods are invoked before the controller methods annotated with @RequestMapping are invoked. 
	The logic behind the sequence is that, the model object has to be created before any processing starts 
	inside the controller methods
	
	@ModelAttribute - Method Argument
		model attribute is populated with data from a form submitted
	
Validation

	Constraint validation -> Like fields validation. password, email format etc...
	Business logic validation -> Should be in service layer
	
	JSP
		<form:errors path="minutes" cssClass="error">
		<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
			minutes - Filed name
	Model
		@Range(min = 1, max = 60) -> POJO Field level Configuration
	
	Controller
		public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
			- binding the validation to the model Goal and result will be present in BindingResult

@Configuration - servlet.xml java based Config

<mvc:annotation-driven /> or @EnableWebMvc
	
	Supports MVC related annotations like @RequestMapping, @ResponseBody, @RequestBody
	
<context:annotation-config />
	
	Wire/Inject them if its registered
	Supports Spring related Config like @AutoWiring, @Required, @Qualifier
	Activates the bean which is already registered in the application Context
	
	It mainly activates the 4 types of BeanPostProcessors
		CommonAnnotationBeanPostProcessor : @PostConstruct, @PreDestroy, @Resource
		AutowiredAnnotationBeanPostProcessor : @Autowired, @Value, @Inject, @Qualifier, etc
		RequiredAnnotationBeanPostProcessor : @Required annotation
		PersistenceAnnotationBeanPostProcessor :@PersistenceUnit and @PersistenceContext annotations
	
<context:component-scan> or @ComponentScan(basepackages={... , ...})
	
	Create Beans and wire/inject them automatically
	Register the bean + Activates the Bean
	<context:component-scan> = <context:annotation-config>+Bean Registration
	
@RequestBody and @ResponseBody
	
	Object serialization(@ResponseBody) and deserialization(@RequestBody)
	Will help to avoid boiler-plate code for message conversion
	These annotations used to convert the request and response on the fly using Message Converters
 	
	@RequestBody or @ResponseBody annotations loops through all registered HttpMessageConverters seeking for the 
	 first  that fits the given mime type and class and then uses it for the actual conversion
	 
	 Whenever you use the @ResponseBody, @RequestBody annotation you will be using a HttpMessageConverter 
	
HTTP Message Converters(HMC)

	Spring Receive request from client -> See content-type header(MIMIE Type) -> HMC will convert to Java 
	Object/entity  based on content Type
	
	Spring send request to client -> See Accept header from client -> HMC will convert from Java Object/entity  
	to response based on accept header
	
	MIME Type -> application/json, application/xml etc...
	
	HttpMessageConverters instances are pre-enabled means HttpMessageConverters registered in the background
		ByteArrayHttpMessageConverter - Convert to Byte Array
		StringHttpMessageConverter - Conver to String 
		MappingJackson2HttpMessageConverter - JSON
		Jaxb2RootElementHttpMessageConverter - XML

Customizing HttpMessageConverters with Spring MVC

	We will also able to write own HTTP message converters
	@Configuration
	@EnableWebMvc
	@ComponentScan("com.doj.restapi.web.controller")
	public class WebConfiguration extends WebMvcConfigurerAdapter{ }
	
	@EnableWebMvc annotation, it automatically registered default Http message converters with application as 
	listed above according to available library in the class path
	
ContentNegotiatingViewResolver
	
	Will be used to return different return types with same code
	Return various content types from our application based on the request
	Use "Accept" header to determine the content type from Requests like XML, JSON, HTML
	Can be combined with multiple view resolvers --> need to maintain the order
	
	Basically we are using internal view resolver and in additional to that we can use 
	JSON/XML based content View Resolvers
	
   CNVR Option 1 – using the extension	
	
	servlet-config.xml
	
	Change the internal view resolver order to 2 and ContentNegotiatingViewResolver order to 1
	
	<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
	
	    <property name="order" value="1">
	    <property name="contentNegotiationManager">
		<bean class="org.springframework.web.accept.ContentNegotiationManager">
		    <constructor-arg>
			<bean class="org.springframework.web.accept.PathExtensionContentNegotiationStrategy">
			   <constructor-arg>
				<map>
					<entry key="json" value="application/json" />
					<entry key="xml" value="application/xml" />
					<entry key="request" value="text/html" />
				</map>
			   </constructor-arg>
			</bean>
		    </constructor-arg>
		</bean>
	   </property>
	   <property name="defaultViews">
		<list>
			<bean class="org.springframework.web.servlet.view.json.MappingJacksonJsonView"/>
			<bean class="org.springframework.web.servlet.view.xml.MarshallingView"/>
				<constructor-arg>
					<bean class="org.springframework.oxm.jaxb.Jaxb2Marshaller">
						<property name="classesToBeBound">
							<list>
								<value>com.intertech.domain.Contact</value>
							</list>
						</property>
					</bean>
				</constructor-arg>				
		</list>		
	  </property>
	</bean>
	
	http://localhost:8080/springmvc/activities.json will return JSON contnet 
	http://localhost:8080/springmvc/activities.xml will return XML content
	http://localhost:8080/springmvc/activities.request will return HTML content
	
	CNVR inspects the incoming URL for a URL extension (.request, .json or .xml in our case) and then uses the 
	mediaType list to match the extension to a media type.  
	
	With an established media type, the CNVR looks for an appropriate view resolver/view bean to produced the 
	requested media type
	
   CNVR Option 2 – using a URL parameter
   
   	URL query parameter (called format by default) is provided in the request, then the parameter value in the request 
	is used to select the media type of the request in the mediaList
	
	http://localhost:8080/springmvc/activities?format=json will return JSON contnet 
	http://localhost:8080/springmvc/activities?format=xml will return XML content

	... per original configuration
	
	<property name="mediaTypes">
    	<map>
     	 	<entry key="json" value="application/json" />
      		<entry key="xml" value="application/xml" />
      		<entry key="request" value="text/html" />
    	</map>
 	</property>
  	<property name="favorPathExtension" value="false" />
  	<property name="favorParameter" value="true" />
  	<property name="defaultViews">
	
	... per original configuration
	
   Option 3 – use the accept header
   
   	HTTP request’s accept header to determine the appropriate response content.  
	If the CNVR’s ignoreAcceptHeader parameter is set to false (true by default)
	
	... per original configuration
   
    	<property name="order" value="1" />
  	<property name="ignoreAcceptHeader" value="false" />
  	<property name="defaultViews">
	
	... per original configuration
	
	

