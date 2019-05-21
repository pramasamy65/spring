## Running Procedure - MongoDB(Mac)
	
	* cd /Users/Softwares/mongodb-osx-x86_64-4.0.8/bin
	* sudo -s
	* ./mongod -> Mongodb runs on port 27017

## Running Procedure - Microservices
	* Run the projects in the following order
		* EurekaDiscoveryServer -> https://github.com/pramasamy65/spring/tree/master/301409-hackathon-microservice/EurekaDiscoveryServer
		* ZuulService and  -> https://github.com/pramasamy65/spring/tree/master/301409-hackathon-microservice/ZuulService
		* SkillsTechnologies -> https://github.com/pramasamy65/spring/tree/master/301409-hackathon-microservice/SkillsTechnologies
		* 301409-hackathon-backend project -> https://github.com/pramasamy65/spring/tree/master/301409-hackathon-backend
		
		* Running as a JAR file
			* Build above all projects individually using command - mvn clean install
			* java -jar target/EurekaDiscoveryServer-0.0.1-SNAPSHOT.jar
			* java -jar target/ZuulService-0.0.1-SNAPSHOT.jar
			* java -jar target/SkillsTechnologies-0.0.1-SNAPSHOT.jar
			* java -jar target/301409-hackathon-backend-0.0.1-SNAPSHOT.jar

## Test the services using below URL
	* Sample Service - http://localhost:9090/hackFsePortal/sampleMetricsService/skillstech/hello
	
	* Sample Service Using Zull and Eureka Service Concept

	* http://localhost:9090/hackFsePortal/hackFseMetricsService/genericMetric/uniqueVolunteeringDetails
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/genericMetric/volunteeringEffort
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/participationMetrics/headCount
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/participationMetrics/uniqueVolunteeringDetailsByLocation
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/participationMetrics/uniqueVolunteeringDetailsByBU
	
## Running procedure Frond End 
	* 301409-hackathon-frontend -> https://github.com/pramasamy65/angular/tree/master/301409-hackathon-frontend
	* cd 301409-hackathon-frontend
	* npm install
	* ng serve -> run angular Project -> http://localhost:4200/
	
	
## If any Errors while compiling and building the frond end code then Follow the below steps
	
### Error 1 : Access to XMLHttpRequest at 'http://localhost:9090/hackFsePortal/hackFseMetricsService/participationMetrics/headCount' 
	from origin 'http://localhost:4200' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
		
	* Resolution : Install CORS extension in chrome and try again
	