package com.kh.finalProject.place.model.vo;

import java.sql.Date;

public class Place {
   private int fieldNo; //경기장 번호
   private String fieldName; //경기장 이름
   private String fieldArea; //경기장 장소
   private String fieldDate; //경기 날짜
   private Date fieldEnrollDate; // 경기장 등록 날짜
   private int fieldCount; //총 인원수
   private String fieldSize; //경기장 규모(소, 중, 대)로 구분
   private int parking; //주차장 1: 무료주차 2.유료주차  3.주차장 없음
   private int matchGender; // 성별  1:남성만  2:여성만  3:남녀모두
   private String shoes; //신발 조건     축구:축구화     농구: 농구화    야구: 야구화
   private String manager; //매니저(작성자)
   private String matchLevel; //경기 레벨 (모든레벨, 아마추어 이하, 아마추어 이상, 프로)
   private String matchType; //경기 타입(축구: 6vs6, 3vs3 야구: 팀매치, 용병매치 농구: 3vs3, 5vs5)
   private String startTime; //경기 시작 시간
   private String endTime; //경기 종료 시간
   private int matchPay; //경기 금액
   private int categoryNum; //운동 카테고리 1축구 2야구 3농구
   
   
   public Place() {}


   public int getFieldNo() {
      return fieldNo;
   }
   
   
   public void setFieldNo(int fieldNo) {
      this.fieldNo = fieldNo;
   }
   
   
   public String getFieldName() {
      return fieldName;
   }
   
   
   public void setFieldName(String fieldName) {
      this.fieldName = fieldName;
   }
   
   
   public String getFieldArea() {
      return fieldArea;
   }
   
   
   public void setFieldArea(String fieldArea) {
      this.fieldArea = fieldArea;
   }
   
   
   public String getFieldDate() {
      return fieldDate;
   }
   
   
   public void setFieldDate(String fieldDate) {
      this.fieldDate = fieldDate;
   }
   
   
   public Date getfieldEnrollDate() {
      return fieldEnrollDate;
   }
   
   
   public void setfieldEnrollDate(Date enrollDate) {
      this.fieldEnrollDate = fieldEnrollDate;
   }
   
   
   public int getFieldCount() {
      return fieldCount;
   }
   
   
   public void setFieldCount(int fieldCount) {
      this.fieldCount = fieldCount;
   }
   
   
   public String getFieldSize() {
      return fieldSize;
   }
   
   
   public void setFieldSize(String fieldSize) {
      this.fieldSize = fieldSize;
   }
   
   
   public int getParking() {
      return parking;
   }
   
   
   public void setParking(int parking) {
      this.parking = parking;
   }
   
   
   public int getMatchGender() {
      return matchGender;
   }
   
   
   public void setMatchGender(int matchGender) {
      this.matchGender = matchGender;
   }
   
   
   public String getShoes() {
      return shoes;
   }
   
   
   public void setShoes(String shoes) {
      this.shoes = shoes;
   }
   
   
   public String getManager() {
      return manager;
   }
   
   
   public void setManager(String manager) {
      this.manager = manager;
   }
   
   
   public String getMatchLevel() {
      return matchLevel;
   }
   
   
   public void setMatchLevel(String matchLevel) {
      this.matchLevel = matchLevel;
   }
   
   
   public String getMatchType() {
      return matchType;
   }
   
   
   public void setMatchType(String matchType) {
      this.matchType = matchType;
   }
   
   
   public String getStartTime() {
      return startTime;
   }
   
   
   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }
   
   
   public String getEndTime() {
      return endTime;
   }
   
   
   public void setEndTime(String endTime) {
      this.endTime = endTime;
   }
   
   
   public int getMatchPay() {
      return matchPay;
   }
   
   
   public void setMatchPay(int matchPay) {
      this.matchPay = matchPay;
   }
   
   
   public int getCategoryNum() {
      return categoryNum;
   }
   
   
   public void setCategoryNum(int categoryNum) {
      this.categoryNum = categoryNum;
   }


   @Override
   public String toString() {
      return "Place [fieldNo=" + fieldNo + ", fieldName=" + fieldName + ", fieldArea=" + fieldArea + ", fieldDate="
            + fieldDate + ", enrollDate=" + fieldEnrollDate + ", fieldCount=" + fieldCount + ", fieldSize=" + fieldSize
            + ", parking=" + parking + ", matchGender=" + matchGender + ", shoes=" + shoes + ", manager=" + manager
            + ", matchLevel=" + matchLevel + ", matchType=" + matchType + ", startTime=" + startTime + ", endTime="
            + endTime + ", matchPay=" + matchPay + ", categoryNum=" + categoryNum + "]";
   }


   

}