package com.kh.finalProject.place.model.vo;

public class PlaceImg {
	private int fieldImgNo;
	private String fieldUrl;
	private String fieldOriginName;
	private String fieldChangeName;
	private String deleteFieldImg;
	private int fieldNo;
	
	public PlaceImg ( ) {}

	public PlaceImg(int fieldImgNo, String fieldUrl, String fieldOriginName, String fieldChangeName,
			String deleteFieldImg, int fieldNo) {
		super();
		this.fieldImgNo = fieldImgNo;
		this.fieldUrl = fieldUrl;
		this.fieldOriginName = fieldOriginName;
		this.fieldChangeName = fieldChangeName;
		this.deleteFieldImg = deleteFieldImg;
		this.fieldNo = fieldNo;
	}

	public int getFieldImgNo() {
		return fieldImgNo;
	}

	public void setFieldImgNo(int fieldImgNo) {
		this.fieldImgNo = fieldImgNo;
	}

	public String getFieldUrl() {
		return fieldUrl;
	}

	public void setFieldUrl(String fieldUrl) {
		this.fieldUrl = fieldUrl;
	}

	public String getFieldOriginName() {
		return fieldOriginName;
	}

	public void setFieldOriginName(String fieldOriginName) {
		this.fieldOriginName = fieldOriginName;
	}

	public String getFieldChangeName() {
		return fieldChangeName;
	}

	public void setFieldChangeName(String fieldChangeName) {
		this.fieldChangeName = fieldChangeName;
	}

	public String getDeleteFieldImg() {
		return deleteFieldImg;
	}

	public void setDeleteFieldImg(String deleteFieldImg) {
		this.deleteFieldImg = deleteFieldImg;
	}

	public int getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}

	@Override
	public String toString() {
		return "PlaceImg [fieldImgNo=" + fieldImgNo + ", fieldUrl=" + fieldUrl + ", fieldOriginName=" + fieldOriginName
				+ ", fieldChangeName=" + fieldChangeName + ", deleteFieldImg=" + deleteFieldImg + ", fieldNo=" + fieldNo
				+ "]";
	}
	
}
