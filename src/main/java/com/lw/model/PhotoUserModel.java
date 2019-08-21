package com.lw.model;

import java.io.Serializable;

public class PhotoUserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long photoId;
	
	private String photoUrl;
	
	private String photoPath;
	
	private Long photoSize;
	
	private String photoType;
	
	private String upTime;
	
	private UserInfoModel userInfoModel;

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Long getPhotoSize() {
		return photoSize;
	}

	public void setPhotoSize(Long photoSize) {
		this.photoSize = photoSize;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public UserInfoModel getUserInfoModel() {
		return userInfoModel;
	}

	public void setUserInfoModel(UserInfoModel userInfoModel) {
		this.userInfoModel = userInfoModel;
	}
	
}
