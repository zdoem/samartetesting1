package com.samart.etesting.web.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.services.ManageAdminService;
import com.samart.etesting.services.ManageUserService;
import com.samart.etesting.web.admin.form.ManageUserForm;
import com.samart.etesting.web.admin.form.MasterUserForm;

public class MasterUserAction extends Action {
	private static org.apache.log4j.Logger Log = Logger.getLogger(MasterUserAction.class);	

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
	throws Exception{	 
	String commandMode = actionMapping.getParameter();
	ActionForward forward = null;

   if(commandMode.equals("LOAD")){
		forward = this.doPageLoadMasterUser(actionMapping, actionForm, request, response);
	}
	else if(commandMode.equals("EDIT")){
		forward = this.doEditMasterUser(actionMapping, actionForm, request, response);
	} 
	else if(commandMode.equals("VIEW")){
		forward = this.doViewMasterUser(actionMapping,actionForm,request,response);
	}    
	else if(commandMode.equals("DELETE")){
		//forward = this.doDeleteManageUser(actionMapping,actionForm,request,response);
	}
	return forward;
   }
   
	//method doEditMasterUser
	private ActionForward doEditMasterUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		
		ActionForward forward = null;
		try{				
			Log.debug("doEditMasterUser..");
			MasterUserForm form =(MasterUserForm)actionForm;//Form
			
			ManageUserService msgService = null;
			UserInfo usr = new UserInfo();
			
			System.out.println("********************************>>:"+form.getCommand());
			
			if(form.getCommand()==null || form.getCommand().equals("")){
				
				//Fetch data from db & go to EditForm
				Log.debug("go to EditMasterUserForm.");
				msgService = new ManageUserService();			
				//find from table 
				usr = msgService.GetUserID(form.getRefId());
				Log.debug("User : "+usr.toString());
			
				//**********Role DDL
				ManageAdminService  mngAdmin = new ManageAdminService();
				ArrayList resultRole = mngAdmin.ListRole();
				request.setAttribute("roleDLL", resultRole);
				Log.debug("Role get Size:"+resultRole.size());	
				
				
				form.setUserInfo(usr);
				form.setRefId(form.getRefId());
				forward = actionMapping.findForward("EDIT_FORM");
			}
			else{
				
				//TODO::Update to database
				 Log.debug("Update to database..");
				 msgService = new ManageUserService();	
				 
				 usr = form.getUserInfo();	
				 usr.setUserId(Integer.parseInt(form.getRefId()));
				 usr.setRoleId(form.getRoleIdDDL());
				 
				 Log.debug(usr.toString());				 
				boolean result = msgService.UpdateUser(usr);//call update	
		        //true = fail
		        //false = success
				if(!result){
					Log.debug("Update userInfo success.");
					request.setAttribute("msg", "Update userInfo success.");
					forward = actionMapping.findForward("SUCCESS");					
				}else{
					Log.debug("Update userInfo Fail.");
					request.setAttribute("msg", "Update userInfo Fail.");	
					forward = actionMapping.findForward("ERROR");
				}						
			}
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	//MasterUserView
	//method doViewManageUser
	private ActionForward doViewMasterUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{							
			//TODO::************
			Log.debug("doViewMasterUser.");
			
			MasterUserForm form =(MasterUserForm)actionForm;//Form
			ManageUserService msgService = new ManageUserService();						
			//call Search UserInfo service
			UserInfo usr = msgService.GetUserID(form.getRefId().trim());
			Log.debug("User : "+usr.toString());			
			ArrayList obj = new ArrayList();
			obj.add(usr);
			form.setUserInfoList(obj); //setForm			
			forward = actionMapping.findForward("SUCCESS");//VIEW			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}

	
	//method doLoadMasterUser
	private ActionForward doPageLoadMasterUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		//HttpSession session = request.getSession();
		try{	

			ArrayList<UserInfo> result = new ArrayList<UserInfo>();
			ArrayList resultRole = new ArrayList();
			
			//TODO::************
			Log.debug("doPageLoadMasterUser..");
			MasterUserForm form =(MasterUserForm)actionForm;//Form
			
			//***********UserInfo
			ManageUserService msgService = new ManageUserService();		
			
			//call Search UserInfo service
			result = msgService.ListUserInfo(form.getUserName(), form.getFirstName(),form.getRoleIdDDL());		
			Log.debug("UserInfo get Size:"+result.size());	
			
			form.setUserInfoList(result); //setForm
			
			//**********Role DDL
			ManageAdminService  mngAdmin = new ManageAdminService();
			resultRole = mngAdmin.ListRole();
			request.setAttribute("roleDLL", resultRole);
			Log.debug("Role get Size:"+resultRole.size());	
	
			forward = actionMapping.findForward("SUCCESS");
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
}
