package com.jx372.bookmall.vo;

public class OrderListVo {
	private Long no;
	private Long orNo;
	private Long bookNo;
	private Long cnt;
	private String bookName;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOrNo() {
		return orNo;
	}
	public void setOrNo(Long orNo) {
		this.orNo = orNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return no + ", " + bookName + ", " + cnt;
	}
	
	
	
	
	

}

