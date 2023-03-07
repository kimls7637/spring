package com.spring.biz.board;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bNum;
	private String bTitle;
	private String bContent;
	private String bCate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bDate;
	private int bHits;
	private String bId;
	private String grade;
	private String mNickName;
	private int commentCnt;
	private int heartCnt;
	private int reportCnt;
	private String tag;
	private String multiId;
	private String multiPw;
	private String multiContent;
	private MultipartFile uploadFile;
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbCate() {
		return bCate;
	}
	public void setbCate(String bCate) {
		this.bCate = bCate;
	}
	public LocalDateTime getbDate() {
		return bDate;
	}
	public void setbDate(LocalDateTime bDate) {
		this.bDate = bDate;
	}
	public int getbHits() {
		return bHits;
	}
	public void setbHits(int bHits) {
		this.bHits = bHits;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getmNickName() {
		return mNickName;
	}
	public void setmNickName(String mNickName) {
		this.mNickName = mNickName;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getHeartCnt() {
		return heartCnt;
	}
	public void setHeartCnt(int heartCnt) {
		this.heartCnt = heartCnt;
	}
	public int getReportCnt() {
		return reportCnt;
	}
	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String getMultiId() {
		return multiId;
	}
	public void setMultiId(String multiId) {
		this.multiId = multiId;
	}
	public String getMultiPw() {
		return multiPw;
	}
	public void setMultiPw(String multiPw) {
		this.multiPw = multiPw;
	}
	public String getMultiContent() {
		return multiContent;
	}
	public void setMultiContent(String multiContent) {
		this.multiContent = multiContent;
	}
	@Override
	public String toString() {
		return "BoardVO [bNum=" + bNum + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bCate=" + bCate
				+ ", bDate=" + bDate + ", bHits=" + bHits + ", bId=" + bId + ", grade=" + grade + ", mNickName="
				+ mNickName + ", commentCnt=" + commentCnt + ", heartCnt=" + heartCnt + ", reportCnt=" + reportCnt
				+ ", tag=" + tag + "]";
	}
	
	
}
