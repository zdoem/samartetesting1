package com.samart.etesting.bean.login;

public class UserInfo {
	  private int userId;
	  private String logIn;
	  private String password;
	  private String role;
	  private String roleId;//FK
	  private String lastName;
	  private int personId; //PK,FK of user
	  private String firstName;
	  private String email;
	  private String refNumber;
	  
	  
	  public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	private int doViewId;
	  private int doEditId;
	  private int doDeleteId;
	  
	  	  
	public int getUserId() {
		return userId;
	}
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
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogIn() {
		return logIn;
	}
	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", logIn=" + logIn
				+ ", password=" + password + ", role=" + role + ", lastName="
				+ lastName + ", personId=" + personId + ", firstName="
				+ firstName + ", email=" + email + ", refNumber=" + refNumber
				+ "]";
	}
	  
}
