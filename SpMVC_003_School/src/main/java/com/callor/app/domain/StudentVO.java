package com.callor.app.domain;

public class StudentVO {
	
	private String stNum;
	private String stName;
	private int intGrade;
	private String stTel;
	private String stAddr;
	private String stDept;
	
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getIntGrade() {
		return intGrade;
	}
	public void setIntGrade(int intGrade) {
		this.intGrade = intGrade;
	}
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}
	public String getStAddr() {
		return stAddr;
	}
	public void setStAddr(String stAddr) {
		this.stAddr = stAddr;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	//변수의 값이 정확히 저장되어있나 확인하기 위해 재정의 한 메소드
	@Override
	public String toString() {
		return "StudentVO [stNum=" + stNum + ", stName=" + stName + ", intGrade=" + intGrade + ", stTel=" + stTel
				+ ", stAddr=" + stAddr + ", stDept=" + stDept + "]";
	}
	
	

}
