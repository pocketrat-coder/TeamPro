package com.koreait.vo;

import java.util.Date;

public class EtcSpendingVO {

	private String id;
	private String name;
	private int price;
	private Date datetime;
	
	public EtcSpendingVO() {;}

	public EtcSpendingVO(String id, String name, int price, Date datetime) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.datetime = datetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "EtcSpendingVO [id=" + id + ", name=" + name + ", price=" + price + ", datetime=" + datetime + "]";
	}
}
