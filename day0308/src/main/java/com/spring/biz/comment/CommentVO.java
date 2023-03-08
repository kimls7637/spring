package com.spring.biz.comment;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentVO {
	private int cNum;
	private int cGroup;
	private int cSequence;
	private String cContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cDate;
	private String cId;
	private int cBnum;
	private int heartCnt;
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public int getcSequence() {
		return cSequence;
	}
	public void setcSequence(int cSequence) {
		this.cSequence = cSequence;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public LocalDateTime getcDate() {
		return cDate;
	}
	public void setcDate(LocalDateTime cDate) {
		this.cDate = cDate;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public int getcBnum() {
		return cBnum;
	}
	public void setcBnum(int cBnum) {
		this.cBnum = cBnum;
	}
	public int getHeartCnt() {
		return heartCnt;
	}
	public void setHeartCnt(int heartCnt) {
		this.heartCnt = heartCnt;
	}
}
