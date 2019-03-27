package com.java.handson.spring_data1;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoSupportImpl extends JdbcDaoSupport {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	// OR

	@Autowired
	JdbcDaoSupportImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public void getCount() {
		System.out.println(getJdbcTemplate().queryForInt("select count(*) from test"));
	}

}
