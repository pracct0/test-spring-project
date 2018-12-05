package com.kim.app.core.dao;

import com.kim.app.core.delegate.TestDto;

public interface AppJdbcDao {

	public TestDto create(TestDto testDto);

	public TestDto read(TestDto testDto);

	public TestDto update(TestDto testDto);

	public TestDto delete(TestDto testDto);

}
