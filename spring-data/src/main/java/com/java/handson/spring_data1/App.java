package com.java.handson.spring_data1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config1.xml");

		// STEP 2 : JDBC Without Spring - **Refer - JdbcWithoutSpring.java**

		// JdbcWithoutSpring jdbcWithoutSpringObj = context.getBean("jdbcWithoutSpring",
		// JdbcWithoutSpring.class);

		// jdbcWithoutSpringObj.dataBaseCall();

		// STEP 3 : JDBC With Spring using
		// org.springframework.jdbc.datasource.DriverManagerDataSource

		// JdbcWithSpring jdbcWithSpringObj = context.getBean("jdbcWithSpring",
		// JdbcWithSpring.class);

		// jdbcWithSpringObj.dataBaseCall();

		// STEP 5 : Using JdbcTemplate

		//JdbcTemplateDaoImpl3 jdbcTemplateDaoImpl = context.getBean("jdbcTemplateDaoImpl3", JdbcTemplateDaoImpl3.class);

		//jdbcTemplateDaoImpl.dataBaseCall();
		
		
		// STEP 14 : Using JdbcTemplate

		JdbcDaoSupportImpl jdbcTemplateDaoImpl = context.getBean("jdbcDaoSupportImpl", JdbcDaoSupportImpl.class);

		jdbcTemplateDaoImpl.getCount();
		
	}
}
