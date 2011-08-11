package com.samart.etesting.web.staffexam.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.samart.etesting.services.StaffExamService;

public class SetExamAction  extends Action{
	private static org.apache.log4j.Logger Log = Logger.getLogger(ObjectiveAction.class);	
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
	throws Exception{	 
	String commandMode = actionMapping.getParameter();
	ActionForward forward = null;

   if(commandMode.equals("ADD")){
		//forward = this.doAddSubject(actionMapping, actionForm, request, response);
	}
   else if(commandMode.equals("LOAD")){
		forward = this.doPageLoad(actionMapping, actionForm, request, response);
	}
   else if(commandMode.equals("VIEW")){
		//forward = this.doViewSubject(actionMapping,actionForm,request,response);
	}  
	else if(commandMode.equals("EDIT")){
		//forward = this.doEditSubject(actionMapping, actionForm, request, response);
	}   
	else if(commandMode.equals("DELETE")){
		//forward = this.doDeleteSubject(actionMapping,actionForm,request,response);
	}
	return forward;
 }
	
	//method doPageLoad
	private ActionForward doPageLoad(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		HttpSession session = request.getSession();
		try{
			Log.debug("doPageLoad.");
			
			StaffExamService staffService = new StaffExamService();
			
			Log.debug("Before doPageLoad.");
			//call Search  service		
			ArrayList result = staffService.ListSubject("", "");
			
			session.setAttribute("subjectDLL", result);
			forward = actionMapping.findForward("SUCCESS");

		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
}
