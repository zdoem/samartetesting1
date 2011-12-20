package com.dog.model.domain;
/*
 * date:2011-12-13
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */

public class DogForm {
	private String dogId;	
	//private int dogTypeId; 
	private String dogTypeIdDDL; //DDL subject code
	//private String[] dogTypeID;
	private String dogSubject;
	private String dogDesc;
	private String dogSolution;
	private String dogComment1;
	private String createDate;
	private String updateDate;	
	private String cmd;
	
	
	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getDogTypeIdDDL() {
		return dogTypeIdDDL;
	}
	public void setDogTypeIdDDL(String dogTypeIdDDL) {
		this.dogTypeIdDDL = dogTypeIdDDL;
	}
	
	public String getDogSubject() {
		return dogSubject;
	}
	public void setDogSubject(String dogSubject) {
		this.dogSubject = dogSubject;
	}
	public String getDogDesc() {
		return dogDesc;
	}
	public void setDogDesc(String dogDesc) {
		this.dogDesc = dogDesc;
	}
	public String getDogSolution() {
		return dogSolution;
	}
	public void setDogSolution(String dogSolution) {
		this.dogSolution = dogSolution;
	}
	public String getDogComment1() {
		return dogComment1;
	}
	public void setDogComment1(String dogComment1) {
		this.dogComment1 = dogComment1;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}

