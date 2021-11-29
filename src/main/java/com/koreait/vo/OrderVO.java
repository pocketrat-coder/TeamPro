package com.koreait.vo;

import java.util.Date;

public class OrderVO {

	private String id;
	private String name;
	private int num;
	private int price;
	private Date datetime;
	
	public OrderVO() {;}

	public OrderVO(String id, String name, int num, int price, Date datetime) {
		this.id = id;
		this.name = name;
		this.num = num;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
		return "OrderVO [id=" + id + ", name=" + name + ", num=" + num + ", price=" + price + ", datetime=" + datetime
				+ "]";
	}
}
