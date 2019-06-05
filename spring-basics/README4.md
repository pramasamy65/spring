# Spring Basics Concepts 4

### Program & Concepts (com.java.handson.spring_basics4)
 * https://github.com/pramasamy65/spring/tree/master/spring-basics/src/main/java/com/java/handson/spring_basics4
 * STEP 1 : Introduction to Annotations and the Required Annotation 
	*  Used to check for mandatory Annotations
	* @Required ** Refer : Messenger.java **
	* RequiredAnnotationBeanPostProcessor ** Refer XML File

 * STEP 2 :  @Autowired Annotation
	* @Autowired ** Refer : Messenger.java **
	* AutowiredAnnotationBeanPostProcessor ** Refer XML File
	
	* Annotate @Autowired in Setter methods or Properties or first looks for ** TYPE **
	* if one Type found then inject the dependency
	* If 2 types found then will try to match with name
	* if name found then it will auto wire the dependency
	* If there is no name match and if two Types are found then it will throw "No unique bean of type" found exception
	
	* Annotate @Autowired in constructor, firsts looks for ** TYPE **
	* if one Type found then inject the dependency
	* If 2 types found then will try to match with name
	* if name found then it will auto wire the dependency
	* If there is no name match and if two Types are found then it will throw "No unique bean of type" found exception
	
 * STEP 3 :  @Qualifier Annotation
	* Create more than one bean of the same type and want to wire only one of them with a property. 
	* In such cases, you can use the @Qualifier annotation along with @Autowired to remove the confusion by specifying which exact bean will be wired
	* Only Applicable for Setter based or Property based Injection. Not constructor based.
	
	
 * STEP 4 : JSR-250 Annotations -> Java Specification Annotation not Spring Based

	* @Resource
		* @Resource(name="center")
			* This looks for bean name "center" and will do dependency injection
		* @Resource
			```
			private Point pointC;
			
			@Resource
			Setter() for pointC
			```
			
			* This looks for bean name "pointC" Since there is no name mentioned in @Resource
	* @PostConstruct
		```
		@PostConstruct
		public void myInit(){
			...
		}
		```
	* @PreDestroy
		```
		@PreDestroy
		public void myInit(){
			...
		}
		```
	* @PostConstruct and @PreDestroy are alternate for disposal bean and Destroy bean or XML init-method and destroy-method
	
	* How annotations select the right implementation?
		* @Autowired and @Inject
			* Matches by Type
			* Restricts by Qualifiers
			* Matches by Name
		
		* @Resource
			* Matches by Name
			* Matches by Type
			* Restricts by Qualifiers (ignored if match is found by name)