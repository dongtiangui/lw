package com.lw.model;

import java.io.Serializable;
import java.util.List;
/**
 * 用户类
 * @author apple
 *
 */
public class UserInfoModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	// 用户ID
	private Long userId;
	//用户名
	private String userName;
	// 用户密码
	private String passWord;
	// 用户手机号
	private String userPhone;
	//用户年龄
	private String userAge;
	// 性别 0 代表男生 1代表女生
	private Integer userGender;
	// 目前登陆时间	
	private String nowLoginTime;
	// 上一次登陆时间	
	private String lastLoginTime;
	// 用户登陆手机验证码	
	private String loginCode;
	// 用户是否为会员 0不是 1 是
	private Integer isMember;
//	会员
	private MemberModel memberId;
	// 用户头像
	private List<PhotoUserModel> photoUserModels;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public Integer getUserGender() {
		return userGender;
	}
	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}
	public String getNowLoginTime() {
		return nowLoginTime;
	}
	public void setNowLoginTime(String nowLoginTime) {
		this.nowLoginTime = nowLoginTime;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public Integer getIsMember() {
		return isMember;
	}
	public void setIsMember(Integer isMember) {
		this.isMember = isMember;
	}
	
	public MemberModel getMemberId() {
		return memberId;
	}
	public void setMemberId(MemberModel memberId) {
		this.memberId = memberId;
	}
	public List<PhotoUserModel> getPhotoUserModels() {
		return photoUserModels;
	}
	public void setPhotoUserModels(List<PhotoUserModel> photoUserModels) {
		this.photoUserModels = photoUserModels;
	}
	
	
}
