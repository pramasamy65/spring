# Spring DATA Concepts

### Program (com.java.handson.spring_data1)

* STEP 1 : Spring data setup
	* Download Derby  -  db-derby-10.14.2.0-bin.zip
	* Start Server : ./startNetworkServer (in BIN Folder)
	* Start Client : ./ij (in BIN Folder)
		* connect 'jdbc:derby://localhost:1527/db;create=true';
		* CREATE TABLE test (id integer);
		* insert into test values(1);
		* insert into test values(100);
		
		
* STEP 2 : JDBC Without Spring - **Refer - JdbcWithoutSpring.java**

* STEP 3 : JDBC With Spring using org.springframework.jdbc.datasource.DriverManagerDataSource - 
**Refer - JdbcWithSpring.java and spring-config1.xml** 
	* DriverManagerDataSource - Returning a new java.sql.Connection Obj from every getConnection call
	* This class is not an actual connection pool
	* Useful for test or standalone environments outside of a J2EE container

* STEP 4 : JDBC With Spring using org.apache.commons.dbcp.BasicDataSource - **Refer - spring-config1.xml** 
	* property name="initialSize" value="2"
	* property name="maxActive" value="5"
	
* STEP 5 : Using JdbcTemplate - **Refer : JdbcTemplateDaoImpl.java**
	* Creating JdbcTemplate Object for each call
	
* STEP 6 : Using JdbcTemplate - **Refer : JdbcTemplateDaoImpl2.java**
	* Injecting datasouce to JdbcTemplate 
	* Using same JdbcTemplate Object for each call

* STEP 7 : Returning Other Data types from JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**
	* Pass Parameters to the JDBC Template Queries

* STEP 8 : Implementing RowMapper **Refer : JdbcTemplateDaoImpl3.java**

* STEP 9 : Implementing RowMapper and returning List **Refer : JdbcTemplateDaoImpl3.java**

* STEP 10 : Performing Write Operations with JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**
	* Insert values in to Data base
	
* STEP 11 : Performing Delete Operations with JdbcTemplate **Refer : JdbcTemplateDaoImpl3.java**

* STEP 12 : Performing Create Operations with JdbcTemplate 
	* jdbcTemplate.execute("CREATE TABLE test (id integer)")
	
* STEP 13 : Named Parameter JDBC Template **Refer : JdbcTemplateDaoImpl3.java**

	* Question Mark place holder - Re-arrange the parameters each and every time when new params added
	* NamedParameterJdbcTemplate
		* Support both Question Mark place holder and Named Parameters
	* JdbcTemplate
		* Supports only Named Parameters
	* SimpleJdbcTemplate	
	
* STEP 14 : DAO Support Classes **REFER JdbcDaoSupportImpl.java**
	* Use JdbcTemplate and JdbcDaoSupport classes to simplify the overall database operation processes
	* By extended the JdbcDaoSupport, set the datasource and JdbcTemplate in your class is no longer required, you just need to inject the correct datasource into JdbcCustomeJdbcDaoSupportImplrDAO
	* And you can get the JdbcTemplate by using a getJdbcTemplate() method.
	
* STEP 15 : Using Hibernate with Spring
	* 