package com.java.handson.spring_data1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class JdbcWithoutSpring {

	public static void main(String[] args) throws Exception {

		new JdbcWithoutSpring().dataBaseCall();
		// new JdbcWithoutSpring().test();

	}

	public void dataBaseCall()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");

		java.sql.Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from test");

		while (rs.next()) {
			System.out.println(rs.getString("id"));
		}

		rs.close();
		conn.close();

	}

	@SuppressWarnings("unused")
	private int test() throws Exception {

		try {
			if (true) {
				// return 5;
				throw new Exception();
			}
			System.out.println("Return 5");
		} finally {
			System.out.println("Finally");
			System.out.println("Return Finally 5");
		}
		System.out.println("END");
		return 0;
	}

}
