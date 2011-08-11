package com.samart.etesting.report.form;

import org.apache.struts.action.ActionForm;

public class HistoryReportForm extends ActionForm{

	private String subjectCode;
	private String subjectName;
	
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
