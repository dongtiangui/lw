package com.lw.base;

import java.util.List;


public class BaseTableResult<T> {
	
	public int draw;
	public int recordsTotal;
	public int recordsFiltered;
	public String error;
	public List<T> aaData;

	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public  List<T> getAaData() {
		return aaData;
	}
	public void setAaData( List<T> aaData) {
		this.aaData = aaData;
	}
	
	
    
}
