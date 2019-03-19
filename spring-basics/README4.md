# Spring Basics Concepts 4

### Program & Concepts (com.java.handson.spring_basics4)

* STEP 1 : Introduction to Annotations and the Required Annotation 
	*  Used to check for mandatory Annotations
	* @Required ** Refer : Messenger.java **
	* RequiredAnnotationBeanPostProcessor ** Refer XML File

* STEP 2 :  @Autowired Annotation
	* @Autowired ** Refer : Messenger.java **
	* AutowiredAnnotationBeanPostProcessor ** Refer XML File
	
	* Annotate @Autowired in Setter methods or Properties first looks for ** TYPE **, if TYPE not found then looks for Name
	* if name found then it will auto wire the dependency
	* If there is no name match and if two Types are found then it will throw "No unique bean of type" found exception
	
	* Annotate @Autowired in constructor, then looks for ** TYPE **
	* if two Types are found then it will throw "No unique bean of type" found exception
	
* STEP 3 :  @Qualifier Annotation
	* 
	

	