package com.samart.etesting.web.admin.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.services.ManageUserService;
import com.samart.etesting.web.admin.form.ManageUserForm;

public class ManageUserAction extends Action {
	
	private static org.apache.log4j.Logger Log = Logger.getLogger(ManageUserAction.class);	
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
		throws Exception{	 
		String commandMode = actionMapping.getParameter();
		ActionForward forward = null;

       if(commandMode.equals("LOAD")){
			forward = this.doListManageUser(actionMapping, actionForm, request, response);
		}
		else if(commandMode.equals("EDIT")){
			forward = this.doEditManageUser(actionMapping, actionForm, request, response);
		} 
		else if(commandMode.equals("VIEW")){
			forward = this.doViewManageUser(actionMapping,actionForm,request,response);
		}    
		else if(commandMode.equals("DELETE")){
			forward = this.doDeleteManageUser(actionMapping,actionForm,request,response);
		}
		return forward;
	 }
	
	//method doDeleteManageUser
	private ActionForward doDeleteManageUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{	
			Log.debug("doDeleteManageUser.");
			
			ManageUserForm form =(ManageUserForm)actionForm;//Form
			ManageUserService msgService = new ManageUserService();	
			
			Log.debug("Before Delete User.");
			boolean result = msgService.DeleteUser(Integer.parseInt(form.getRefId().trim()));
			
			if(!result){
				Log.debug("Delete User success.");
				request.setAttribute("msg", "Delete User success.");
				forward = actionMapping.findForward("SUCCESS");
				
			}else{
				Log.debug("Delete User Fail.");
				request.setAttribute("msg", "Delete User Fail.");	
				forward = actionMapping.findForward("ERROR");
			}
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	//method doListManageUser
	private ActionForward doListManageUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{	

			ArrayList<UserInfo> result = new ArrayList<UserInfo>();
			//TODO::************
			Log.debug("ManageUserAction.");
			ManageUserForm form =(ManageUserForm)actionForm;//Form
			ManageUserService msgService = new ManageUserService();			
			//call Search UserInfo service
			 result = msgService.ListUserInfo(form.getUserName(), form.getFirstName());		
			form.setUserInfoList(result); //setForm
			Log.debug("ManageUserAction get Size:"+result.size());		
			forward = actionMapping.findForward("SUCCESS");
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
		
	//method doViewManageUser
	private ActionForward doViewManageUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{							
			//TODO::************
			Log.debug("doViewManageUser.");
			
			ManageUserForm form =(ManageUserForm)actionForm;//Form
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
	
	//method doListManageUser
	private ActionForward doEditManageUser(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		
		ActionForward forward = null;
		try{				
			Log.debug("doEditManageUser..");
			ManageUserForm form =(ManageUserForm)actionForm;//Form
			ManageUserService msgService = null;
			UserInfo usr = new UserInfo();
			
			if(form.getCommand()==null){
				//Fetch data from db & go to EditForm
				Log.debug("go to EditManageUserForm.");
				msgService = new ManageUserService();			
				//find from table book
				usr = msgService.GetUserID(form.getRefId());
				Log.debug("User : "+usr.toString());
			
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
}
