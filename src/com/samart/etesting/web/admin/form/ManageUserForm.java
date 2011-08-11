package com.samart.etesting.web.admin.form;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.samart.etesting.bean.login.UserInfo;
public class ManageUserForm  extends ActionForm{
	
	private String userName=""; //search
	private String firstName=""; //search
	private String command; //Mode ADD,UPDATE,DELTE,LIST
	private String refId;   //ID form
	private ArrayList<UserInfo> userInfoList;
	private UserInfo userInfo = new UserInfo();  // object
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(ArrayList<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	/*public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      if( getUserName() == null || getUserName().length() < 1 ) {
			        errors.add("userName",new ActionMessage("error.userName.required"));
			      }
		      return null;
		  }*/
	
}
