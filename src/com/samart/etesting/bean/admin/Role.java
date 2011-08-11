package com.samart.etesting.bean.admin;

import java.lang.reflect.Field;

public class Role {
	
	private int roleId;
	private String roleName;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
