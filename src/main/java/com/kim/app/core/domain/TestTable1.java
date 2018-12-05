package com.kim.app.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.kim.app.base.domain.BaseDomainObject;

@Entity
@Table(name = "test_tbl_1")
public class TestTable1 extends BaseDomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = "var_col_1")
	private String varCol1;

	@Column(name = "var_col_2")
	private String varCol2;

	@Column(name = "var_col_3")
	private String varCol3;

	@Column(name = "num_col_1")
	private int numCol1;

	@Column(name = "num_col_2")
	private int numCol2;

	@Column(name = "num_col_3")
	private int numCol3;

	public TestTable1() {
	}

	public TestTable1(Long id, String varCol1, String varCol3, int numCol1, int numCol2, int numCol3) {

		super();

		this.id = id;
		this.varCol1 = varCol1;
		this.varCol3 = varCol3;
		this.numCol1 = numCol1;
		this.numCol2 = numCol2;
		this.numCol3 = numCol3;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVarCol1() {
		return varCol1;
	}

	public void setVarCol1(String varCol1) {
		this.varCol1 = varCol1;
	}

	public String getVarCol2() {
		return varCol2;
	}

	public void setVarCol2(String varCol2) {
		this.varCol2 = varCol2;
	}

	public String getVarCol3() {
		return varCol3;
	}

	public void setVarCol3(String varCol3) {
		this.varCol3 = varCol3;
	}

	public int getNumCol1() {
		return numCol1;
	}

	public void setNumCol1(int numCol1) {
		this.numCol1 = numCol1;
	}

	public int getNumCol2() {
		return numCol2;
	}

	public void setNumCol2(int numCol2) {
		this.numCol2 = numCol2;
	}

	public int getNumCol3() {
		return numCol3;
	}

	public void setNumCol3(int numCol3) {
		this.numCol3 = numCol3;
	}

}
