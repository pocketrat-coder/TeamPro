package com.koreait.vo;

import java.util.Date;

public class NoticeVO {
	private Date datetime;
	private String content;

	
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [datetime=" + datetime + ", content=" + content + "]";
	}

}
