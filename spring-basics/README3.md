# Spring Basics Concepts 3

### Program (com.java.handson.spring_basics3)

* STEP 1 : Implements BeanPostProcessor
	* Init and Destroy callback methods are part of Spring bean life cycle phases. The init method is going to be executed after bean instantiation. Similarly, The destroy method is going to be executed before bean finalization.

	* We can implement this functionality using implementing interfaces InitializingBean and DisposableBean, or using annotations @postconstruct and @predestroy, or declare the <bean> with init-method and destroy-method attributes.

	* BeanPostProcessor interface is used for extending the functionality of framework if want to do any configuration Pre- and Post- bean initialization done by spring container.
	
	* postProcessBeforeInitialization
		* As name clearly says that it's used to make sure required actions are taken before initialization. 
		* e.g. you want to load certain property file/read data from the remote source/service.
	* PostProcessAfterInitialization
		* Any thing that you want to do after initialization before bean reference is given to application.
	* Sequence of the questioned methods in life cycle as follows :
			* BeanPostProcessor.postProcessBeforeInitialization()
			* @postConstruct or InitializingBean.afterPropertiesSet() or initialization method which is defining in xml
			* @preDestroy or DisposibleBean.destroy() or destroy method which is defining in xml
			* destroy()

* STEP 2 : Implements BeanFactoryPostProcessor
	
	
### Concepts (com.java.handson.spring_basics3)

* STEP 1 : Implements BeanPostProcessor

* STEP 2 : Implements BeanFactoryPostProcessor
	
