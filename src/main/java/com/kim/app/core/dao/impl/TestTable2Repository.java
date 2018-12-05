package com.kim.app.core.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kim.app.core.domain.TestTable2;

@Repository
public interface TestTable2Repository extends JpaRepository<TestTable2, Long> {

}
