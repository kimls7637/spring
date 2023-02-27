package com.spring.biz.member;

public class MemberVO {
	private String mId;
	private String mPw;
	private String mName;
	private String role; // 권한
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberVO [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", role=" + role + "]";
	}
	



}
