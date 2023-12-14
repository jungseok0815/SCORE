package com.kh.finalProject.team.model.vo;

public class TeamReq {

	private int reqNo;
	private String reqStatus;
	private int reqUserNo;
	private int offerNo;
	private String reqContent;
	
	public TeamReq() {}

	public TeamReq(int reqNo, String reqStatus, int reqUserNo, int offerNo, String reqContent) {
		super();
		this.reqNo = reqNo;
		this.reqStatus = reqStatus;
		this.reqUserNo = reqUserNo;
		this.offerNo = offerNo;
		this.reqContent = reqContent;
	}

	public int getReqNo() {
		return reqNo;
	}

	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public int getReqUserNo() {
		return reqUserNo;
	}

	public void setReqUserNo(int reqUserNo) {
		this.reqUserNo = reqUserNo;
	}

	public int getOfferNo() {
		return offerNo;
	}

	public void setOfferNo(int offerNo) {
		this.offerNo = offerNo;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	@Override
	public String toString() {
		return "TeamReq [reqNo=" + reqNo + ", reqStatus=" + reqStatus + ", reqUserNo=" + reqUserNo + ", offerNo="
				+ offerNo + ", reqContent=" + reqContent + "]";
	}
	
	
	
	
}
