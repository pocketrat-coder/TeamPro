package com.koreait.vo;

import java.util.ArrayList;

public class SpendingList {
	ArrayList<SpendingVO> list=new ArrayList<SpendingVO>();
	
	public ArrayList<SpendingVO> getList() {return list;}
	public void setList(ArrayList<SpendingVO> list) {this.list = list;}
	
	@Override
	public String toString() {
		return "SpendingList [list=" + list + "]";
	}
}
