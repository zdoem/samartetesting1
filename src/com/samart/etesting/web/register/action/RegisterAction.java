package com.samart.etesting.web.register.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.samart.etesting.bean.register.UserReg;
import com.samart.etesting.services.ManageUserService;
import com.samart.etesting.web.register.form.RegisterForm;

public class RegisterAction extends Action {
 private static org.apache.log4j.Logger Log = Logger.getLogger(RegisterAction.class);
	 
	 public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
		throws Exception{
		 ActionForward forward = null;
		 
		 try{
			 	//TODO::************
				Log.debug("RegisterAction.");
				RegisterForm regForm =(RegisterForm)actionForm;//Form
				ManageUserService usrService = new ManageUserService(); //Service
				
				UserReg  regObj = new UserReg();
				regObj.setUserName(regForm.getUserName());
				regObj.setPassword(regForm.getPassword());
				regObj.setFname(regForm.getFname());
				regObj.setLname(regForm.getLname());
				regObj.setEmail(regForm.getEmail());
				
				int resultIn = usrService.Register(regObj);//call Register
						
				if(resultIn == 0){
						Log.debug("Register success.");
						request.setAttribute("msg", "Register success.");
						forward = actionMapping.findForward("SUCCESS");	
				}else{
						Log.debug("Register Fail is user name duplicate.");
						request.setAttribute("msg", "Register Fail is user name duplicate.");	
						forward = actionMapping.findForward("ERROR");
					}		
			}
			catch(Exception e){
				Log.debug(e.toString());
				request.setAttribute("msg", e.getMessage());
				forward = actionMapping.findForward("ERROR");
			}
			return forward;
	 }

}
