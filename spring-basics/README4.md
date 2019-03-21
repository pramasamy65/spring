# Spring Basics Concepts 4

### Program & Concepts (com.java.handson.spring_basics4)

* STEP 1 : Introduction to Annotations and the Required Annotation 
	*  Used to check for mandatory Annotations
	* @Required ** Refer : Messenger.java **
	* RequiredAnnotationBeanPostProcessor ** Refer XML File

* STEP 2 :  @Autowired Annotation
	* @Autowired ** Refer : Messenger.java **
	* AutowiredAnnotationBeanPostProcessor ** Refer XML File
	
	* Annotate @Autowired in Setter methods or Properties or Constructor first looks for ** TYPE **, 
	* if single TYPE found then it will wire the dependency
	* if more than one type found then it will try to match the name and if name matches then it will wire the dependency
	* If there is no name match and if two Types are found then it will throw "No unique bean of type" found exception
	
* STEP 3 :  @Qualifier Annotation
	* Create more than one bean of the same type and want to wire only one of them with a property. 
	* In such cases, you can use the @Qualifier annotation along with @Autowired to remove the confusion by specifying which exact bean will be wired
	* Only Applicable for Setter based or Property based Injection. Not constructor based.
	
	
* STEP 4 : JSR-250 Annotations -> Java Specification Annotation not Spring Based
	* How annotations select the right implementation?
		* @Autowired and @Inject
			* Matches by Type
			* Restricts by Qualifiers
			* Matches by Name
		
		* @Resource
			* Matches by Name
			* Matches by Type
			* Restricts by Qualifiers (ignored if match is found by name)