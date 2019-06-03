# JDBC and Spring JDBC Concepts

## Program Package(com.java.handson.spring_data1)
 * https://github.com/pramasamy65/spring/tree/master/spring-data/src/main/java/com/java/handson/spring_data1

### STEP 1 : Database - Derby setup
 * Download Derby  -  db-derby-10.14.2.0-bin.zip
 * Start Server : ./startNetworkServer (in BIN Folder)
 * Start Client : ./ij (in BIN Folder)
	* connect 'jdbc:derby://localhost:1527/db;create=true';
	* CREATE TABLE test (id integer);
	* insert into test values(1);
	* insert into test values(100);
		
		
### STEP 2 : Normal JDBC(Without Spring)- **Refer - JdbcWithoutSpring.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcWithoutSpring.java
 * JDBC technology exceptions are checked, so we must use try, catch blocks in the code at various places which increases the complexity of the application
 * And that to this may cause to have lot of repetitive code to perform the database operations
 * some thing like we may need to write loading driver, connection, creating statement lot of times
 * In JDBC if we open the connection with database, we only responsible to close that connection. If not we may get some connection issues

### Spring JDBC Concepts
 * https://www.java4s.com/spring/spring-jdbc-complete-introduction/
 * Spring-JDBC layer will take cares about connection management and error managements, and programmers will concentrate on their logics
 * Spring framework has provided an exception translator and it translates the checked exceptions obtained using JDBC to un-checked exceptions of spring type
 * So developerss get unchecked exceptions which is not required to handle

 * Java application can get connection with database using following 2 ways
  * By using java.sql.DriverManager [ Class ]
  * By using javax.sql.DataSource [ Interface ]
 
 * 2 implementation classes of DataSource interface, So Spring framework uses these implementations to obtain the connection with database internally
  * Org.springframework.jdbc.datasource.DriverManagerDataSource [ class ]
  * Org.apache.commons.dbcp.BasicDataSource [ class ]
 
 * In above 2 classes DriverManagerDataSource is given by spring framework and it is equal to DriverManager class
 * It means spring framework internally opens a new connection and closes the connection for each operation done on the database
 * BasicDataSource is given by apache, and this is better than DriverManagerDataSource because BasicDataSource having inbuilt connection pooling implementation
 
### STEP 3 : JDBC With Spring using org.springframework.jdbc.datasource.DriverManagerDataSource - 
**Refer - JdbcWithSpring.java and spring-config1.xml**
 * Just Injecting Datesouce from xml
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcWithSpring.java
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/resources/spring-config1.xml
 * DriverManagerDataSource - Returning a new java.sql.Connection Obj from every getConnection call
 * This class is not an actual connection pool
 * Useful for test or standalone environments outside of a J2EE container

### STEP 4 : JDBC With Spring using org.apache.commons.dbcp.BasicDataSource - **Refer - spring-config1.xml** 
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcWithSpring.java
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/resources/spring-config1.xml
 * Connection pool properties
  * property name="initialSize" value="2"
  * property name="maxActive" value="5"
	
### STEP 5 : Using JdbcTemplate - **Refer : JdbcTemplateDaoImpl.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl.java
 * Creating JdbcTemplate Object for each call
	
### STEP 6 : Using JdbcTemplate - **Refer : JdbcTemplateDaoImpl2.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl2.java
 * Using same JdbcTemplate Object for each call
 * Injecting datasouce to JdbcTemplate 

### STEP 7 : Returning Other Data types(Like String as Query Response) from JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java
	* Pass Parameters to the JDBC Template Queries

### STEP 8 : Implementing RowMapper **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java

### STEP 9 : Implementing RowMapper and returning List **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java

### STEP 10 : Performing Write Operations with JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java
 * Insert values in to Data base
	
### STEP 11 : Performing Delete Operations with JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java

### STEP 12 : Performing Create Operations with JdbcTemplate 
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java
 * jdbcTemplate.execute("CREATE TABLE test (id integer)")
	
### STEP 13 : Named Parameter JDBC Template **Refer : JdbcTemplateDaoImpl3.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcTemplateDaoImpl3.java

 * Question Mark place holder - Re-arrange the parameters each and every time when new params added
 * NamedParameterJdbcTemplate
  * Support both Question Mark place holder and Named Parameters
 * JdbcTemplate
  * Supports only Named Parameters
 * SimpleJdbcTemplate	
	
### STEP 14 : org.springframework.jdbc.core.support.JdbcDaoSupport **REFER JdbcDaoSupportImpl.java**
 * https://github.com/pramasamy65/spring/blob/master/spring-data/src/main/java/com/java/handson/spring_data1/JdbcDaoSupportImpl.java
 * JdbcDaoSupport classes to simplify the overall database operation processes
 * Extended the JdbcDaoSupport and set the datasource. So, JdbcTemplate in your class is no longer required, you just need to inject the correct datasource 
 * And you can get the JdbcTemplate by using a getJdbcTemplate() method
 * getJdbcTemplate().queryForObject("select count(*) from test", Integer.class)
	