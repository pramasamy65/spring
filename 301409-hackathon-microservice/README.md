# Microservices

## EurekaDiscoveryServer project
	* default port of Eureka server:8671 and now configured as 8989
	* @EnableEurekaServer
	* Eureka Server Port http://localhost:8989

## ZuulService project
	* Port 9090
	* @EnableDiscoveryClient
	* @EnableZuulProxy
	* Register ZuulService as eureka client and register current server url to Eureka server - Refer application.yml
	* Zuul Routes which has all the microservice configuration
	
## SkillsTechnologies project
	* Port 8930
	* Register SkillsTechnologies as eureka client and register current server url to Eureka server
	
## 301409-hackathon-backend project
	* Port 8950
	* Register 301409-hackathon-backend as eureka client and register current server url to Eureka server
	
	
## Running Procedure
	* Run EurekaDiscoveryServer, ZuulService and SkillsTechnologies in the order
	
	* http://localhost:9090/hackFsePortal/sampleMetricsService/skillstech/hello 
	
	* cd /Users/Softwares/mongodb-osx-x86_64-4.0.8/bin
	* sudo -s
	* ./mongod -> Mongodb runs on port 27017
	
	* Run 301409-hackathon-backend project
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/genericMetric/uniqueVolunteeringDetails\
	* http://localhost:9090/hackFsePortal/hackFseMetricsService/genericMetric/volunteeringEffort
	

	


