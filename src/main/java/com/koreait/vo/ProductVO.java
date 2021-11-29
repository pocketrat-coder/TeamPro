package com.koreait.vo;

import java.util.Date;

public class ProductVO {

	private String id;
	private String name;
	private String code;
	private int price;
	private Date expireDate;
	private int count;
	 
	public ProductVO() {;}

	public ProductVO(String id, String name, String code, int price, Date expireDate, int count) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.expireDate = expireDate;
		this.count = count;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", code=" + code + ", price=" + price + ", expireDate="
				+ expireDate + ", count=" + count + "]";
	}

	
}
