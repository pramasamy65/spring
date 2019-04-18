# spring

https://github.com/deanwong/spring-batch-excel


https://jitpack.io/p/deanwong/spring-batch-excel

https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-an-excel-file/


4.0.5.RELEASE

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
		
		
		
		https://keyholesoftware.com/2018/05/14/reading-and-writing-from-excel-in-spring-batch/
		
		https://github.com/spring-projects/spring-batch-extensions
		
		
show dbs

use databaseName

show collections;


db.<collectionName>.find();

db.fileModificationdetails.find();

db.<collection_name>.drop() -> db.fileModificationdetails.drop()

db.eventInformation.update({'employeeId':287469},{$set:{'employeeName':'Rock'}},{multi:true});

"baseLocation"

eventInformation
db.eventInformation.update({'baseLocation':'Chennai'},{$set:{'employeeId':287469}},{multi:true});


	Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.match(Criteria.where("employeeId").lt(99999999)),
				Aggregation.group("employeeId").addToSet("employeeId").as("employeeId").sum("volunteerHours").as("totalVolunteerHours"));