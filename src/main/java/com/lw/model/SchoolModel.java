package com.lw.model;

import java.io.Serializable;

public class SchoolModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 学校 ID
	private Long schoolId;
	// 学校 地址
	private String schoolAdress;
	// 学校名
	private String schoolName;
	// 学校标签
	private String schoolTag;

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolAdress() {
		return schoolAdress;
	}

	public void setSchoolAdress(String schoolAdress) {
		this.schoolAdress = schoolAdress;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolTag() {
		return schoolTag;
	}

	public void setSchoolTag(String schoolTag) {
		this.schoolTag = schoolTag;
	}
	
	
	
	

}
