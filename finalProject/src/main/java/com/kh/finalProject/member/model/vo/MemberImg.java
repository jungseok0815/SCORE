package com.kh.finalProject.member.model.vo;

public class MemberImg {
		private int memberImgNo;
		private String memberUrl;
		private String memberOriginName;
		private String memberChangeName;
		private String deleteMemberImg;
		private int userNo;
	
		public MemberImg() {}

		public MemberImg(int memberImgNo, String memberUrl, String memberOriginName, String memberChangeName,
				String deleteMemberImg, int userNo) {
			super();
			this.memberImgNo = memberImgNo;
			this.memberUrl = memberUrl;
			this.memberOriginName = memberOriginName;
			this.memberChangeName = memberChangeName;
			this.deleteMemberImg = deleteMemberImg;
			this.userNo = userNo;
		}

		public int getMemberImgNo() {
			return memberImgNo;
		}

		public void setMemberImgNo(int memberImgNo) {
			this.memberImgNo = memberImgNo;
		}

		public String getMemberUrl() {
			return memberUrl;
		}

		public void setMemberUrl(String memberUrl) {
			this.memberUrl = memberUrl;
		}

		public String getMemberOriginName() {
			return memberOriginName;
		}

		public void setMemberOriginName(String memberOriginName) {
			this.memberOriginName = memberOriginName;
		}

		public String getMemberChangeName() {
			return memberChangeName;
		}

		public void setMemberChangeName(String memberChangeName) {
			this.memberChangeName = memberChangeName;
		}

		public String getDeleteMemberImg() {
			return deleteMemberImg;
		}

		public void setDeleteMemberImg(String deleteMemberImg) {
			this.deleteMemberImg = deleteMemberImg;
		}

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		@Override
		public String toString() {
			return "MemberImg [memberImgNo=" + memberImgNo + ", memberUrl=" + memberUrl + ", memberOriginName="
					+ memberOriginName + ", memberChangeName=" + memberChangeName + ", deleteMemberImg="
					+ deleteMemberImg + ", userNo=" + userNo + "]";
		}
		
		
}
