package com.samart.etesting.web.staffexam.form;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;
import com.samart.etesting.bean.staffexam.Subject;

public class SubjectMngForm extends ActionForm{
	
	private String subjectCode=""; //search
	private String subjectName=""; //search
	private String command; //Mode ADD,UPDATE,DELTE,LIST
	private String refId;   //ID form
	private ArrayList <Subject> subjectList;
	private Subject subjectObj = new Subject();
	
	public Subject getSubjectObj() {
		return subjectObj;
	}
	public void setSubjectObj(Subject subjectObj) {
		this.subjectObj = subjectObj;
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
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
