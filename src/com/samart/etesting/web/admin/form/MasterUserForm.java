package com.samart.etesting.web.admin.form;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.samart.etesting.bean.login.UserInfo;
public class MasterUserForm  extends ActionForm{
	private String userName=""; //search
	private String firstName=""; //search
	private String command; //Mode ADD,UPDATE,DELTE,LIST
	private String refId;   //ID form
	private String roleIdDDL="";	
	private ArrayList<UserInfo> userInfoList;
	private UserInfo userInfo = new UserInfo();  // object
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public ArrayList<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(ArrayList<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getRoleIdDDL() {
		return roleIdDDL;
	}
	public void setRoleIdDDL(String roleIdDDL) {
		this.roleIdDDL = roleIdDDL;
	}	
	
/*	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		this.userName="";
		this.firstName="";
		this.command="";
		this.refId="";
		this.roleIdDDL="";
		//this.userInfoList = null;
		//this.userInfo = null;
	}*/
	
	 @Override
	   public String toString() {
	       Class c = this.getClass();
	       StringBuilder buffer = new StringBuilder();
	       for (Field field : c.getDeclaredFields()) {
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
