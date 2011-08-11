package com.samart.etesting.web.staffexam.form;

import org.apache.struts.action.ActionForm;

public class SetExamForm extends ActionForm{
	private String setExamSelect;//check box
	private String subjectRefId; //DDL subject code
	private String subjectName;
	private String question;
	
	
	
	public String getSetExamSelect() {
		return setExamSelect;
	}
	public void setSetExamSelect(String setExamSelect) {
		this.setExamSelect = setExamSelect;
	}
	public String getSubjectRefId() {
		return subjectRefId;
	}
	public void setSubjectRefId(String subjectRefId) {
		this.subjectRefId = subjectRefId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

}
