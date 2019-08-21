package com.lw.model;

import java.io.Serializable;

/**
 * 会员类
 * @author apple
 *
 */

public class MemberModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 会员 ID
	private Long memberId;
	// 会员名
	private String memberName;
	// 会员类型
	private String memberType;
	// 会员状态
	private Integer memberStatus;
	// 会员注册时间
	private String memberRegisterTime;
	// 会员余额
	private Double memberBalance;

	private String memberGrade;
	
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Integer getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberRegisterTime() {
		return memberRegisterTime;
	}

	public void setMemberRegisterTime(String memberRegisterTime) {
		this.memberRegisterTime = memberRegisterTime;
	}

	public Double getMemberBalance() {
		return memberBalance;
	}

	public void setMemberBalance(Double memberBalance) {
		this.memberBalance = memberBalance;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	
	

}
