package com.java.handson.spring_data1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateDaoImpl3 {

	DataSource dataSource;

	JdbcTemplate jdbcTemplate;
	
	NamedParameterJdbcTemplate namedParamJdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void dataBaseCall()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		int searchParam = 1040;
		String query = "select id from test where id = ?";
		String allRowValuesQuery = "select * from test";
		System.out.println(jdbcTemplate);

		// STEP 7 : Returning Other Data types from JdbcTemplate
		// Pass Parameters to the JDBC Template Queries
		String idValue = jdbcTemplate.queryForObject(query, new Object[] { searchParam }, String.class);

		System.out.println("Selecting Id using JdbcTemplate " + idValue);

		// STEP 8 : Implementing RowMapper
		TestVO vo = jdbcTemplate.queryForObject(query, new Object[] { searchParam }, new TestRowMapper());
		System.out.println("Get ID Using RowMapper : " + vo.getId());

		// STEP 9 : Implementing RowMapper and returning List
		
		List<TestVO> voList = jdbcTemplate.query(allRowValuesQuery, new TestRowMapper());
		
		System.out.println("Implementing RowMapper and returning List : " + voList.size());
		
		for (TestVO voObj : voList) {
			System.out.println(voObj.getId());
		}
		
		// STEP 10 : Performing Write Operations with JdbcTemplate
		
		String updateQuery= "insert into test (id) values (?)";
		
		jdbcTemplate.update(updateQuery, new Object[]{501});
		
		// STEP 11 : Performing Delete Operations with JdbcTemplate
		
		String deleteQuery= "delete from test where id = ?";
		
		jdbcTemplate.update(deleteQuery, new Object[]{500});
		
		// STEP 13 : Named Parameter JDBC Template

		String namedParamQuery = "insert into test values(:id, :name)";

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", 50).addValue("name", "Tester");

		namedParamJdbcTemplate.update(namedParamQuery, sqlParameterSource);
		
	}

	class TestRowMapper implements RowMapper<TestVO> {

		@Override
		public TestVO mapRow(ResultSet rs, int rowNum) throws SQLException {

			System.out.println("RowNum " + rowNum);

			TestVO vo = new TestVO();

			System.out.println("Fetched Value from Result Set : " + rs.getInt("id"));
			vo.setId(rs.getInt("id"));

			return vo;
		}

	}

}
