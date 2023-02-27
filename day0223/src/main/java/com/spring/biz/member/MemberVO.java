package com.spring.biz.member;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {
    private String id;
    private String pw;
    private String mName;
    private String mNickname;
    private String mEmail;
    private int mEmailChk;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mJoinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime mStopDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public int getmEmailChk() {
		return mEmailChk;
	}
	public void setmEmailChk(int mEmailChk) {
		this.mEmailChk = mEmailChk;
	}
	public LocalDateTime getmJoinDate() {
		return mJoinDate;
	}
	public void setmJoinDate(LocalDateTime mJoinDate) {
		this.mJoinDate = mJoinDate;
	}
	public LocalDateTime getmStopDate() {
		return mStopDate;
	}
	public void setmStopDate(LocalDateTime mStopDate) {
		this.mStopDate = mStopDate;
	}
}