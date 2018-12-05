package com.kim.app.core.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.kim.app.core.delegate.TestDto;
import com.kim.app.core.domain.TestTable2;

public interface AppService {

	TestDto processTestData(TestDto testDto);

	TestDto createTestTable2(@Valid TestDto testDto);

	Page<TestTable2> readTestTable2Page(TestDto testDto);

	Iterable<TestTable2> readAllTestTable2();

	Optional<TestTable2> readOneTestTable2(TestDto testDto);

	TestDto updateTestTable2(@Valid TestDto testDto);

	Boolean deleteTestTable2(Long id);

	void deleteAllTestTable2();
}
