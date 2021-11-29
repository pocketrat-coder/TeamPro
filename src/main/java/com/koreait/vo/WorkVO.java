package com.koreait.vo;

import java.util.Date;

public class WorkVO {

	private String id;
	private int idx;
	private String name;
	private float time;
	private int pay;
	private Date datetime;
	
	public WorkVO() {}
	public WorkVO(String id, int idx, String name, float time, int pay, Date datetime) {
		super();
		this.id = id;
		this.idx = idx;
		this.name = name;
		this.time = time;
		this.pay = pay;
		this.datetime = datetime;
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

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	@Override
	public String toString() {
		return "WorkVO [id=" + id + ", idx=" + idx + ", name=" + name + ", time=" + time + ", pay=" + pay
				+ ", datetime=" + datetime + "]";
	}


	
}
