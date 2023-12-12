package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class Reservation {
	private int res_no;
	private Date resDate;
	private int resUserNo;
	private int fieldNo;
	
	public Reservation() {}
	
	public Reservation(int res_no, Date resDate, int resUserNo, int fieldNo) {
		super();
		this.res_no = res_no;
		this.resDate = resDate;
		this.resUserNo = resUserNo;
		this.fieldNo = fieldNo;
	}

	public int getRes_no() {
		return res_no;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public int getResUserNo() {
		return resUserNo;
	}

	public void setResUserNo(int resUserNo) {
		this.resUserNo = resUserNo;
	}

	public int getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}

	@Override
	public String toString() {
		return "Reservation [res_no=" + res_no + ", resDate=" + resDate + ", resUserNo=" + resUserNo + ", fieldNo="
				+ fieldNo + "]";
	}
	
	
}
