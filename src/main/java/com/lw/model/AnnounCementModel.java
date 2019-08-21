package com.lw.model;

import java.io.Serializable;

public class AnnounCementModel implements Serializable{
	private static final long serialVersionUID = -5239465296041459932L;

	private Long an_id;
	
	private String an_create_time;
	
	private String an_title;
	
	private String an_content;
	
	private String an_pub_person;
	
	private Integer an_version;
	
	private Integer an_status;

	public Long getAn_id() {
		return an_id;
	}

	public void setAn_id(Long an_id) {
		this.an_id = an_id;
	}

	public String getAn_create_time() {
		return an_create_time;
	}

	public void setAn_create_time(String an_create_time) {
		this.an_create_time = an_create_time;
	}

	public String getAn_title() {
		return an_title;
	}

	public void setAn_title(String an_title) {
		this.an_title = an_title;
	}

	public String getAn_content() {
		return an_content;
	}

	public void setAn_content(String an_content) {
		this.an_content = an_content;
	}

	public String getAn_pub_person() {
		return an_pub_person;
	}

	public void setAn_pub_person(String an_pub_person) {
		this.an_pub_person = an_pub_person;
	}

	public Integer getAn_version() {
		return an_version;
	}

	public void setAn_version(Integer an_version) {
		this.an_version = an_version;
	}

	public Integer getAn_status() {
		return an_status;
	}

	public void setAn_status(Integer an_status) {
		this.an_status = an_status;
	}

	@Override
	public String toString() {
		return "AnnounCementModel [an_id=" + an_id + ", an_create_time=" + an_create_time + ", an_title=" + an_title
				+ ", an_content=" + an_content + ", an_pub_person=" + an_pub_person + ", an_version=" + an_version
				+ ", an_status=" + an_status + "]";
	}
	

}
