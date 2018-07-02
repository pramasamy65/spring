# Spring-Mvc

https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=2&mode=live

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
	Based on the model(which is returned by the controller), Front controller will consult with "View Template" and get the view
	Finally front controller will return the view as a response

Vocabulary
	DispatcherServlet
	Controller - Handles the request and determines which view to route
	RequestMapping - URL mapping and request type the method is tied to 
	ViewResolver - Map to respective views(JSP or other technology)
	Bean - Spring configured POJO
	
	
	
	