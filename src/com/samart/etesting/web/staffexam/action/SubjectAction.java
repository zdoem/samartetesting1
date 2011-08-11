package com.samart.etesting.web.staffexam.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.bean.staffexam.Subject;
import com.samart.etesting.services.ManageUserService;
import com.samart.etesting.services.StaffExamService;
import com.samart.etesting.web.admin.form.ManageUserForm;
import com.samart.etesting.web.staffexam.form.SubjectForm;
import com.samart.etesting.web.staffexam.form.SubjectMngForm;

public class SubjectAction extends Action{
	
	private static org.apache.log4j.Logger Log = Logger.getLogger(SubjectAction.class);	
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
		throws Exception{	 
		String commandMode = actionMapping.getParameter();
		ActionForward forward = null;

       if(commandMode.equals("ADD")){
			forward = this.doAddSubject(actionMapping, actionForm, request, response);
		}
       else if(commandMode.equals("LOAD")){
			forward = this.doListSubject(actionMapping, actionForm, request, response);
		}
       else if(commandMode.equals("VIEW")){
			forward = this.doViewSubject(actionMapping,actionForm,request,response);
		}  
		else if(commandMode.equals("EDIT")){
			forward = this.doEditSubject(actionMapping, actionForm, request, response);
		}   
		else if(commandMode.equals("DELETE")){
			forward = this.doDeleteSubject(actionMapping,actionForm,request,response);
		}
		return forward;
	 }
	
	//method doDeleteSubject
	private ActionForward doDeleteSubject(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{
			Log.debug("doDeleteSubject.");
			SubjectMngForm form = (SubjectMngForm)actionForm;
			StaffExamService staffService = new StaffExamService();
			
			Log.debug("Before Delete Subject.");
			//call Search  service
			boolean isResult = staffService.DeleteSubject(Integer.parseInt(form.getRefId().trim()));
			
	        //true = fail
	        //false = success
			if(!isResult){
				Log.debug("Delete Subject success.");
				request.setAttribute("msg", "Delete Subject success.");
				forward = actionMapping.findForward("SUCCESS");
				
			}else{
				Log.debug("Delete Subject Fail.");
				request.setAttribute("msg", "Delete Subject Fail.");	
				forward = actionMapping.findForward("ERROR");
			}
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	//method doEditSubject
	private ActionForward doEditSubject(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		
		ActionForward forward = null;
		try{				
			Log.debug("doEditSubject..");
			SubjectMngForm form =(SubjectMngForm)actionForm;//Form
			StaffExamService staffService = null;// new StaffExamService();
			Subject sub = new Subject();
			
			if(form.getCommand()==null){
				//Fetch data from db & go to EditForm
				Log.debug("go to doEditSubjectForm.");
				staffService = new StaffExamService();		
				//find from table book
				sub = staffService.GetSubjectID(form.getRefId());
				
				//Log.debug("User : "+usr.toString());
				
				form.setSubjectObj(sub);
				form.setRefId(form.getRefId());
				
				forward = actionMapping.findForward("EDIT_FORM");
			}
			else{				
				//TODO::Update to database
				 Log.debug("Update to database..");
				 staffService = new StaffExamService();			 
				 sub = form.getSubjectObj();
				 sub.setSubjectId(Integer.parseInt(form.getRefId()));
				 
				 Log.debug(sub.toString());	
				 boolean isResult = staffService.UpdateSubject(sub);//call update	

				//true = fail
		        //false = success
				if(!isResult){
					Log.debug("Update Subject success.");
					request.setAttribute("msg", "Update Subject success.");
					forward = actionMapping.findForward("SUCCESS");					
				}else{
					Log.debug("Update Subject Fail.");
					request.setAttribute("msg", "Update Subject Fail.");	
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
	
	//method doViewSubject
	private ActionForward doViewSubject(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{							
			//TODO::************
			Log.debug("doViewSubject.");
						
			SubjectMngForm form = (SubjectMngForm)actionForm;
			StaffExamService staffService = new StaffExamService();
			//call Search  service
			Subject sub = staffService.GetSubjectID(form.getRefId().trim());
			ArrayList result = new ArrayList();
			result.add(sub);//add object
			form.setSubjectList(result); //setForm arrayList
			
			forward = actionMapping.findForward("SUCCESS");
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	//method doListSubject
	private ActionForward doListSubject(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		try{	
			
			ArrayList<Subject> subjectList = new ArrayList<Subject>();
			Log.debug("SubjectAction list.");
			SubjectMngForm form = (SubjectMngForm)actionForm;
			StaffExamService staffService = new StaffExamService();
			//call Search  service
			subjectList = staffService.ListSubject(form.getSubjectCode(), form.getSubjectName());
			
			form.setSubjectList(subjectList);
			Log.debug("SubjectAction get Size:"+subjectList.size());
			forward = actionMapping.findForward("SUCCESS");
			
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	//method doAdd
	private ActionForward doAddSubject(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		
		ActionForward forward = null;
		try{							
			Log.debug("doAddSubject..");
			SubjectForm form =(SubjectForm)actionForm;//Form
			StaffExamService staffService = new StaffExamService();
			Subject obj = new Subject();
				
			obj.setSubjectCode(form.getSubjectCode());
			obj.setSubjectName(form.getSubjectName());
			obj.setSubjectDetails(form.getSubjectDetails());
			
			//TODO::Insert to database
			Log.debug("Insert to database..");	
			 
			boolean result =  staffService.InsertSubject(obj);//call insert	
		    //true = fail
		    //false = success
			if(!result){
				Log.debug("Insert success.");
				request.setAttribute("msg", "Insert  success.");
				forward = actionMapping.findForward("SUCCESS");					
			}else{
				Log.debug("Insert  Fail.");
				request.setAttribute("msg", "Insert Fail.");	
				forward = actionMapping.findForward("ERROR");
			}	
				
		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
		}
		return forward;
	}
	
	
}
