package com.lw.base;

import java.io.Serializable;

public class BaseQueryRequest implements Serializable{
	
	private static final long serialVersionUID = -4869594085374385813L;
	
	private Integer draw;
	private Integer start;
	private Integer length;
	private String search;
	
	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	
	
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "BaseQueryRequest [draw=" + draw + ", start=" + start + ", length=" + length + ", search=" + search
				+ "]";
	}

	
	
	


}
