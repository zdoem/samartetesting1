package com.samart.etesting.bean.register;

import java.lang.reflect.Field;

public class UserReg {
	private String userName;
	private String password;
	private String fname;
	private String lname;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
