package com.koreait.vo;

public class EmployeeVO {

	private String id;
	private int idx;
	private String name;
	private int wage;
	
	public EmployeeVO() {;}

	public EmployeeVO(String id, int idx, String name, int wage) {
		this.id = id;
		this.idx = idx;
		this.name = name;
		this.wage = wage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", idx=" + idx + ", name=" + name + ", wage=" + wage + "]";
	}
	
}
