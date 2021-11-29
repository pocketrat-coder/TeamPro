package com.koreait.vo;

import java.util.Date;
// 테이블 생성 X
public class SpendingVO implements Comparable<SpendingVO>{
	private String name;
	private int price;
	private Date datetime;
//	개수 / 시간 등 체크용 etc 
	private int etc;
//	수입/ 지출 금액 칸  
	private int income;
	private int spending;
//	판매/주문/지출 정의칸 
	private String item; 
	
	

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
//	수정된 etc getter/setter
	public int getEtc() {
		return etc;
	}
	public void setEtc(int etc) {
		this.etc = etc;
	}
//	수입/ 지출칸
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSpending() {
		return spending;
	}
	public void setSpending(int spending) {
		this.spending = spending;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return "SpendingVO [name=" + name + ", price=" + price + ", datetime=" + datetime + ", etc=" + etc + ", income="
				+ income + ", spending=" + spending + ", item=" + item + "]";
	}
	@Override
	public int compareTo(SpendingVO o) {
		long thisDate=this.getDatetime().getTime();
		long oDate=o.getDatetime().getTime();
		
		if     (thisDate > oDate) return  1;
		else if(thisDate < oDate) return -1;
		else                      return  0;
	}
	
	
}
