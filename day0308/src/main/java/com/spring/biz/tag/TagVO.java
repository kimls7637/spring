package com.spring.biz.tag;

public class TagVO {
	private int tnum;
	private String tcontent;
	private int tbnum;
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public int getTbnum() {
		return tbnum;
	}
	public void setTbnum(int tbnum) {
		this.tbnum = tbnum;
	}
	@Override
	public String toString() {
		return "TagVO [tnum=" + tnum + ", tcontent=" + tcontent + ", tbnum=" + tbnum + "]";
	}
	
}
