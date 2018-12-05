package com.kim.app.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.kim.app.core.dao.AppJdbcDao;
import com.kim.app.core.dao.impl.TestTable2Repository;
import com.kim.app.core.delegate.TestDto;
import com.kim.app.core.domain.TestTable2;
import com.kim.app.core.enumeration.ActionType;
import com.kim.app.core.exception.ResourceNotFoundException;
import com.kim.app.core.service.AppService;

@Service
public class AppServiceImpl implements AppService {

	private static Logger logger = Logger.getLogger(AppServiceImpl.class.getName());

	private final static String CREATED_MESSAGE = "Created Successfully.";
	private final static String READ_MESSAGE = "Read Successfully.";
	private final static String UPDATED_MESSAGE = "Updated Successfully.";
	private final static String DELETED_MESSAGE = "Deleted Successfully.";

	@Autowired
	private AppJdbcDao testJdbcDao;

	@Autowired
	private TestTable2Repository testTable2Repository;

	@Override
	public TestDto processTestData(TestDto testDto) {

		switch (ActionType.valueOf(testDto.getActionType())) {

		case CREATE:

			createTestData(testDto);
			break;

		case READ:

			readTestData(testDto);

			break;

		case UPDATE:

			updateTestData(testDto);
			break;

		case DELETE:

			deleteTestData(testDto);
			break;

		default:
			break;
		}

		return testDto;
	}

	private TestDto createTestData(TestDto testDto) {

		testJdbcDao.create(testDto);

		return testDto;
	}

	private TestDto readTestData(TestDto testDto) {

		testJdbcDao.read(testDto);
		// testDto.setVoiceCall(voiceCallRepository.findOne("Ming"));

		return testDto;
	}

	private TestDto updateTestData(TestDto testDto) {

		testJdbcDao.update(testDto);

		return testDto;
	}

	private TestDto deleteTestData(TestDto testDto) {

		testJdbcDao.delete(testDto);

		return testDto;
	}

	public TestDto createTestTable2(TestDto testDto) {

		TestTable2 createdTestTable2 = testTable2Repository.save(testDto.getTestTable2());

		testDto.setTestTable2(createdTestTable2);
		testDto.setMessage(CREATED_MESSAGE);

		return testDto;
	}

	public Page<TestTable2> readTestTable2Page(TestDto testDto) {

		Page<TestTable2> testTable2Page = testTable2Repository.findAll(testDto.getPageable());

		return testTable2Page;
	}

	public Iterable<TestTable2> readAllTestTable2() {

		return testTable2Repository.findAll();
	}

	public Optional<TestTable2> readOneTestTable2(TestDto testDto) {

		return testTable2Repository.findById(testDto.getId());
	}

	public TestDto updateTestTable2(TestDto testDto) {

		TestTable2 latestTestTable2 = testDto.getTestTable2();

		return testTable2Repository.findById(testDto.getId()).map(testTable2 -> {

			testTable2.setVarCol1(latestTestTable2.getVarCol1());
			testTable2.setVarCol2(latestTestTable2.getVarCol2());
			testTable2.setVarCol3(latestTestTable2.getVarCol3());
			testTable2.setNumCol1(latestTestTable2.getNumCol1());
			testTable2.setNumCol2(latestTestTable2.getNumCol2());
			testTable2.setNumCol3(latestTestTable2.getNumCol3());

			TestTable2 savedTestTable2 = testTable2Repository.save(testTable2);

			testDto.setTestTable2(savedTestTable2);

			return testDto;

		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id" + testDto.getId()));
	}

	public Boolean deleteTestTable2(Long id) {

		return testTable2Repository.findById(id).map(testTable2 -> {

			testTable2Repository.delete(testTable2);

			return true;

		}).orElseThrow(() -> new ResourceNotFoundException());
	}

	public void deleteAllTestTable2() {

		testTable2Repository.deleteAll();
	}
}
