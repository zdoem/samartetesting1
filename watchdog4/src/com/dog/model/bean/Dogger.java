package com.dog.model.bean;

/*
 * date:2011-12-13
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */


public class Dogger {
	private String dogId;
	private int dogTypeId; 
	private String dogTypeName; 
	private String dogSubject;
	private String dogDesc;
	private String dogSolution;
	private String dogComment1;
	private String createDate;
	private String updateDate;
	

	public int getDogTypeId() {
		return dogTypeId;
	}
	public void setDogTypeId(int dogTypeId) {
		this.dogTypeId = dogTypeId;
	}
	public String getDogTypeName() {
		return dogTypeName;
	}
	public void setDogTypeName(String dogTypeName) {
		this.dogTypeName = dogTypeName;
	}
	
	
	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
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
