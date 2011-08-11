package com.samart.etesting.bean.login;

import java.lang.reflect.Field;

public class User {
	
	  private String userId;
	  private String logIn;
	  private String password;
	  private String role;
	  private int personPersonId;
	  
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public int getPersonPersonId() {
		return personPersonId;
	}
	public void setPersonPersonId(int personPersonId) {
		this.personPersonId = personPersonId;
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
