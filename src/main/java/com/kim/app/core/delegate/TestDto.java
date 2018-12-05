package com.kim.app.core.delegate;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kim.app.core.domain.TestTable1;
import com.kim.app.core.domain.TestTable2;
import com.kim.app.core.enumeration.ActionType;

public class TestDto {

	private Long id;

	private Long secondId;

	private Pageable pageable;

	private TestTable2 testTable2;

	private TestTable1 testTable1;

	private String actionType = ActionType.READ.name();

	private Boolean state;

	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSecondId() {
		return secondId;
	}

	public void setSecondId(Long secondId) {
		this.secondId = secondId;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public TestTable2 getTestTable2() {
		return testTable2;
	}

	public void setTestTable2(TestTable2 testTable2) {
		this.testTable2 = testTable2;
	}

	public TestTable1 getTestTable1() {
		return testTable1;
	}

	public void setTestTable1(TestTable1 testData) {
		this.testTable1 = testData;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
