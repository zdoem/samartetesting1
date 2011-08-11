package com.samart.etesting.report.form;

import org.apache.struts.action.ActionForm;

public class StatReportForm extends ActionForm{
	
	private String testerName;
	private String fromDate;
	private String toDate;
	
	
	public String getTesterName() {
		return testerName;
	}
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
}
