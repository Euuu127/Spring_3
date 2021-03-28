package com.dkmk.s3.notice;

import java.sql.Date;

public class NoticeDTO {
	
	private long nNum;
	private String nTitle;
	private String nWriter;
	private String nContents;
	private long nHit;
	private Date nRegdate;
	public long getnNum() {
		return nNum;
	}
	public void setnNum(long nNum) {
		this.nNum = nNum;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnWriter() {
		return nWriter;
	}
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	public String getnContents() {
		return nContents;
	}
	public void setnContents(String nContents) {
		this.nContents = nContents;
	}
	public long getnHit() {
		return nHit;
	}
	public void setnHit(long nHit) {
		this.nHit = nHit;
	}
	public Date getnRegdate() {
		return nRegdate;
	}
	public void setnRegdate(Date nRegdate) {
		this.nRegdate = nRegdate;
	}
	
	

}
