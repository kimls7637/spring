package com.spring.biz.board;

public class BoardVO {
	private int bid;
	private String title;
	private String writer;
	private String content;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
}
