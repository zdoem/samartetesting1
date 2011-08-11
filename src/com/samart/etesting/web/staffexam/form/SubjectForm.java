package com.samart.etesting.web.staffexam.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SubjectForm extends ActionForm {
	
	private int subjectId;
	private String subjectCode;
	private String subjectName;
	private String subjectDetails;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
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
	public String getSubjectDetails() {
		return subjectDetails;
	}
	public void setSubjectDetails(String subjectDetails) {
		this.subjectDetails = subjectDetails;
	}
	
	public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      
		      if( getSubjectCode() == null || getSubjectCode().length() < 1 ) {
		        errors.add("subjectCode",new ActionMessage("error.subjectCode.required"));
		      }
		      
		      if( getSubjectName() == null || getSubjectName().length() < 1 ) {
			        errors.add("subjectName",new ActionMessage("error.subjectName.required"));
			      }
		      if( getSubjectDetails() == null || getSubjectDetails().length() < 1 ) {
			        errors.add("subjectDetails",new ActionMessage("error.subjectDetails.required"));
			      }

		      return errors;
		  }
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		this.subjectCode = null;
		this.subjectName = null;
		this.subjectDetails =null;

	}

}
