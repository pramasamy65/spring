package com.java.handson.spring_data1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcWithSpring {

	@Autowired
	DataSource dataSource;

	public void dataBaseCall()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {

		System.out.println("Jdbc With Spring...dataSource " + dataSource);
		Connection conn = dataSource.getConnection();

		java.sql.Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from test");

		while (rs.next()) {
			System.out.println(rs.getString("id"));
		}

		rs.close();
		conn.close();

	}

}
