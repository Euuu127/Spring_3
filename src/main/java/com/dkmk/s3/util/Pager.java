package com.dkmk.s3.util;

public class Pager {
	
	private long curPage;
	private long startRow;
	private long lastRow;
	
	private long startNum;
	private long lastNum;
	private boolean pre; //이전 블럭 있으면 true 
	private boolean next; //
	
	private String kind; //검색할 column명 담은 변수
	private String search; //검색어 담은 변수
	
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		if(search == null) {
			search = "";
		}
		this.search = search;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}



	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	
	public long getCurPage() {
		if(this.curPage<1) { //이걸 설정해놨기 때문에 첫페이지에서 < 눌러도 마이너스가 아니라 1페이지 나오는 거야~
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		if(curPage<1) {
			curPage=1;
		}
		this.curPage = curPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	
	

}
