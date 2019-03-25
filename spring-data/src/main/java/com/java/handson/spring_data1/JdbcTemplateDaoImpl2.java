package com.java.handson.spring_data1;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateDaoImpl2 {

	DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void dataBaseCall()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {

		// JdbcTemplate jdbcTemplate = new JdbcTemplate();

		// jdbcTemplate.setDataSource(dataSource);

		System.out.println(jdbcTemplate);
		int count = jdbcTemplate.queryForInt("select count(*) from test");
		System.out.println("Total Count using JdbcTemplate " + count);
	}

}
