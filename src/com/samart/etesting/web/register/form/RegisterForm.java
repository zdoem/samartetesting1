package com.samart.etesting.web.register.form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class RegisterForm extends ActionForm{
	
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
	
	public ActionErrors validate( 
		      ActionMapping mapping, HttpServletRequest request ) {
		      ActionErrors errors = new ActionErrors();
		      
		      if( getUserName() == null || getUserName().length() < 1 ) {
		        errors.add("userName",new ActionMessage("error.userName.required"));
		      }
		      if( getPassword() == null || getPassword().length() < 1 ) {
		        errors.add("password",new ActionMessage("error.password.required"));
		      }
		      if( getFname() == null || getFname().length() < 1 ) {
			        errors.add("fname",new ActionMessage("error.firstName.required"));
			      }
		      if(getLname() == null || getLname().length() < 1 ) {
			        errors.add("lname",new ActionMessage("error.lastName.required"));
			      }
		      if( getEmail() == null || getEmail().length() < 1 ) {
			        errors.add("email",new ActionMessage("error.email.required"));
			      }
		      return errors;
		  }
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// reset properties
		this.userName="";
		this.password="";
		this.fname="";
		this.lname="";
		this.email="";
	}

}
