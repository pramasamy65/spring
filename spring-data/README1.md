# Spring DATA Concepts

### Program (com.java.handson.spring_data1)

* STEP 1 : Spring data setup
	* Download Derby  -  db-derby-10.14.2.0-bin.zip
	* Start Server : ./startNetworkServer
	* Start Client : ./ij
		* connect 'jdbc:derby://localhost:1527/db;create=true';
		* CREATE TABLE test (id integer);
		
		
* STEP 2 : JDBC Without Spring - **Refer - JdbcWithoutSpring.java**

* STEP 3 : JDBC With Spring using org.springframework.jdbc.datasource.DriverManagerDataSource - **Refer - JdbcWithSpring.java and spring-config1.xml** 
	* DriverManagerDataSource - Returning a new java.sql.Connection Obj from every getConnection call
	* This class is not an actual connection pool
	* Useful for test or standalone environments outside of a J2EE container

* STEP 4 : JDBC With Spring using org.apache.commons.dbcp.BasicDataSource - **Refer - spring-config1.xml** 
	* <property name="initialSize" value="2"></property>
	* <property name="maxActive" value="5"></property>
	
* STEP 5 : Using JdbcTemplate - ** Refer : JdbcTemplateDaoImpl.java**
	* Creating JdbcTemplate Object for each call
	
* STEP 6 : Using JdbcTemplate - ** Refer : JdbcTemplateDaoImpl2.java**
	* Using same JdbcTemplate Object for each call
