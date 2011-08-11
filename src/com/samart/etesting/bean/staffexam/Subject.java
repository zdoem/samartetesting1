package com.samart.etesting.bean.staffexam;

import java.lang.reflect.Field;

public class Subject {
	
	private int subjectId;
	private String subjectCode;
	private String subjectName;
	private String subjectDetails;
	
	
	private int doViewId;
	private int doEditId;
	private int doDeleteId;
	
	public int getDoViewId() {
		return doViewId;
	}
	public void setDoViewId(int doViewId) {
		this.doViewId = doViewId;
	}
	public int getDoEditId() {
		return doEditId;
	}
	public void setDoEditId(int doEditId) {
		this.doEditId = doEditId;
	}
	public int getDoDeleteId() {
		return doDeleteId;
	}
	public void setDoDeleteId(int doDeleteId) {
		this.doDeleteId = doDeleteId;
	}
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
	
	@Override
	public String toString() {
	       Class c = this.getClass();
	       StringBuilder buffer = new StringBuilder();
	       for (Field field :c.getDeclaredFields()) {
	           try {
	               buffer.append("   ");
	               buffer.append(field.getName());
	               buffer.append(":");
	               buffer.append(field.get(this));
	           } catch (IllegalArgumentException ex) {
	               //Logger.getLogger(TollLaneEvents.class.getName()).log(Level.SEVERE, null, ex);
	           } catch (IllegalAccessException ex) {
	               //Logger.getLogger(TollLaneEvents.class.getName()).log(Level.SEVERE, null, ex);
	           }
	       }
	       return buffer.toString();
	   }

}
