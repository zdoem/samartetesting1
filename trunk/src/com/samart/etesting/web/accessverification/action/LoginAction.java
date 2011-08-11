package com.samart.etesting.web.accessverification.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.services.ManageAdminService;
import com.samart.etesting.web.accessverification.form.LoginForm;



public class LoginAction extends Action{
	
	 private static org.apache.log4j.Logger Log = Logger.getLogger(LoginAction.class);
	 
	 public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		    
		    HttpSession session = request.getSession();
			//String commandMode = actionMapping.getParameter();
			ActionForward forward = null;					
			//Role 1: Admin
			//Role 2: Tester
			//Role 3: Staffexam
			//Error or login invalid.
			//return forward = actionMapping.findForward("SUCCESS");
			
			try{	
				Log.debug("Login process.");
				
				LoginForm form =(LoginForm)actionForm;//Form
				ManageAdminService msgService = new ManageAdminService();	
				
			    UserInfo usr = msgService.GetUserLogIn(form.getUserName().trim(), form.getPassword().trim());
				
			    Log.debug("-->UserInfo :"+usr);
			    
				if(usr == null || usr.getUserId()== 0){
					Log.debug("--->Login invalid.");
					request.setAttribute("msg", "Login invalid..");
				    return	forward = actionMapping.findForward("AGAIN_LOGIN");						
					//END go to Login
				}
				
				//set session for object
				session.setAttribute("UserProfile", usr);
				
				//set session for check usr
				session.setAttribute("usr", usr.getLogIn());
				session.setAttribute("status", usr.getRoleId());
				session.setAttribute("role", usr.getRoleId());
							
				if(usr.getRoleId().equals("1")){
					//ADMIN
					Log.debug("[ADMIN]Login by :"+usr.getLogIn());
					forward = actionMapping.findForward("ADMIN_PAGE");					
					//go to admin page
					
				}else if(usr.getRoleId().equals("2")){
					//staffexam
					Log.debug("[Staffexam]Login by :"+usr.getLogIn());
					forward = actionMapping.findForward("STAFFEXAM_PAGE");
					//go to staffexam page
					
				}else if(usr.getRoleId().equals("3")){
					//Testers
					Log.debug("[Testers]Login by :"+usr.getLogIn());
					forward = actionMapping.findForward("TESTERS_PAGE");
					//go to Testers page
				}
				else{
					Log.debug("[Anonymous]Login by :"+usr.getLogIn());
					request.setAttribute("msg", "Login anonymous user or please your check contact administrator.");
					forward = actionMapping.findForward("ERROR");
					//anonymous user or NONE
				}
			}catch(Exception e){
				Log.debug(e.toString());
				request.setAttribute("msg", e.getMessage());
				forward = actionMapping.findForward("ERROR");
				
				//clear all session
				session.invalidate();
			}
			return forward;
	 }
}
