package com.dkmk.s3.notice;

import java.sql.Date;

public class NoticeDTO {
	
	private long noticeNum;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContents;
	private long noticeHit;
	private Date noticeDate;
	
	public long getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(long noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public long getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(long noticeHit) {
		this.noticeHit = noticeHit;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}


	

}
