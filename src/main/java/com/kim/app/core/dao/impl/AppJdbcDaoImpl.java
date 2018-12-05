package com.kim.app.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kim.app.core.dao.AppJdbcDao;
import com.kim.app.core.delegate.TestDto;
import com.kim.app.core.domain.TestTable1;
import com.kim.app.core.exception.TestDataNotFoundException;

@Repository
public class AppJdbcDaoImpl implements AppJdbcDao {

	private static Logger logger = Logger.getLogger(AppJdbcDaoImpl.class.getName());

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public AppJdbcDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public TestDto read(TestDto testDto) {

		logger.debug("#####::id:" + testDto.getId());

		RowMapper rowMapper = new RowMapper() {

			public TestTable1 mapRow(ResultSet rs, int rowNum) throws SQLException {

				TestTable1 testData = new TestTable1();
				testData.setId(rs.getLong("id"));
				testData.setVarCol1(rs.getString("var_col_1"));
				testData.setVarCol2(rs.getString("var_col_2"));
				testData.setVarCol3(rs.getString("var_col_3"));
				testData.setNumCol1(rs.getInt("num_col_1"));
				testData.setNumCol2(rs.getInt("num_col_2"));
				testData.setNumCol3(rs.getInt("num_col_3"));

				return testData;
			}
		};

		Map<String, Object> namedParameters = new HashMap<String, Object>();

		namedParameters.put("id", testDto.getId());

		String readSqlStr = "SELECT * FROM test_tbl_1 where id = :id ";

		try {

			TestTable1 testData = (TestTable1) namedParameterJdbcTemplate.queryForObject(readSqlStr, namedParameters,
					rowMapper);

			testDto.setTestTable1(testData);

		} catch (EmptyResultDataAccessException e) {

			throw new TestDataNotFoundException(e.getMessage(), e.getCause());
		}

		testDto.setState(Boolean.TRUE);
		testDto.setMessage("Read successfully.");

		return testDto;
	}

	@Override
	public TestDto create(TestDto testDto) {

		TestTable1 testData = testDto.getTestTable1();

		Date currentDate = new Date();

		String createSqlStr = "INSERT into test_tbl_1(id, var_col_1, var_col_2, var_col_3, num_col_1, num_col_2, num_col_3, created_date, updated_date) VALUES (:id,:var_col_1,:var_col_2,:var_col_3,:num_col_1,:num_col_2,:num_col_3,:created_date,:updated_date)";

		Map<String, Object> namedParameters = new HashMap<String, Object>();

		System.out.println(testData.getId());
		System.out.println(testData.getNumCol1());
		System.out.println(testData.getNumCol2());
		System.out.println(testData.getNumCol3());
		System.out.println(testData.getVarCol1());
		System.out.println(testData.getVarCol2());
		System.out.println(testData.getVarCol3());
		namedParameters.put("id", testData.getId());
		namedParameters.put("var_col_1", testData.getVarCol1());
		namedParameters.put("var_col_2", testData.getVarCol2());
		namedParameters.put("var_col_3", testData.getVarCol3());
		namedParameters.put("num_col_1", testData.getNumCol1());
		namedParameters.put("num_col_2", testData.getNumCol2());
		namedParameters.put("num_col_3", testData.getNumCol3());
		namedParameters.put("updated_date", currentDate);
		namedParameters.put("created_date", currentDate);

		namedParameterJdbcTemplate.update(createSqlStr, namedParameters);

		testDto.setState(Boolean.TRUE);

		testDto.setMessage("Created successfully.");

		return testDto;
	}

	@Override
	public TestDto update(TestDto testDto) {

		logger.debug("######::id:" + testDto.getId());

		TestTable1 testData = testDto.getTestTable1();

		Date currentDate = new Date();

		String createSqlStr = "UPDATE test_tbl_1 SET var_col_1=:var_col_1, var_col_2=:var_col_2, var_col_3=:var_col_3, num_col_1=:num_col_1, num_col_2=:num_col_2, num_col_3=:num_col_3 WHERE id=:id";

		Map<String, Object> namedParameters = new HashMap<String, Object>();

		namedParameters.put("id", testDto.getId());
		namedParameters.put("var_col_1", testData.getVarCol1());
		namedParameters.put("var_col_2", testData.getVarCol2());
		namedParameters.put("var_col_3", testData.getVarCol3());
		namedParameters.put("num_col_1", testData.getNumCol1());
		namedParameters.put("num_col_2", testData.getNumCol2());
		namedParameters.put("num_col_3", testData.getNumCol3());
		namedParameters.put("updated_date", currentDate);
		namedParameters.put("created_date", currentDate);

		namedParameterJdbcTemplate.update(createSqlStr, namedParameters);

		testDto.setState(Boolean.TRUE);

		testDto.setMessage("Updated successfully.");

		return testDto;
	}

	@Override
	public TestDto delete(TestDto testDto) {

		logger.debug("######::id:" + testDto.getId());

		TestTable1 testData = testDto.getTestTable1();

		String deleteSqlStr = "DELETE FROM test_tbl_1 WHERE id=:id";

		Map<String, Object> namedParameters = new HashMap<String, Object>();

		namedParameters.put("id", testDto.getId());

		namedParameterJdbcTemplate.update(deleteSqlStr, namedParameters);

		testDto.setState(Boolean.TRUE);

		testDto.setMessage("Deleted successfully.");

		return testDto;
	}
}
