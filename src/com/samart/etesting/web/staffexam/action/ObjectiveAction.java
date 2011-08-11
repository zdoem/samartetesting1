package com.samart.etesting.web.staffexam.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.samart.etesting.services.StaffExamService;
import com.samart.etesting.web.staffexam.form.ObjectiveForm;
import com.samart.etesting.web.staffexam.form.SubjectMngForm;
public class ObjectiveAction  extends Action{
	private static org.apache.log4j.Logger Log = Logger.getLogger(ObjectiveAction.class);	
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
	throws Exception{	 
	String commandMode = actionMapping.getParameter();
	ActionForward forward = null;

   if(commandMode.equals("ADD")){
		forward = this.doAddObjective(actionMapping, actionForm, request, response);
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
	
	//method doAddObjective
	private ActionForward doAddObjective(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response){
		ActionForward forward = null;
		//HttpSession session = request.getSession();
		try{
			
			Log.debug("doAddObjective.");		
			
			boolean errorFlag=false;
			ObjectiveForm form = (ObjectiveForm) actionForm;
			//ActionMessages errors = new ActionMessages();
			//FormFile uploadFile   = (FormFile)uploadForm.get("uFile");
			FormFile uploadFile   = (FormFile)form.getImgFile();
			
			String uploadingFileName    = uploadFile.getFileName();
			//String uploadPath=getServlet().getServletContext().getRealPath("/") +"/upload";			
			String uploadPath=getServlet().getServletContext().getRealPath("/");	
			System.out.println("Test path:"+uploadPath);
			
			if(!uploadingFileName.equals("")){
				File uploadFileObject = new File(uploadPath, uploadingFileName);
				FileOutputStream fileOutStream = new FileOutputStream(uploadFileObject);
				fileOutStream.write(uploadFile.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}
			else{
				errorFlag=true;
			}

			if(errorFlag==true){
				//errors.add("submitError",new ActionMessage("error.save.saveError"));
				//saveErrors(request,errors);
				forward = actionMapping.findForward("SUCCESS");
			}
			else {
				//errors.add("submitSuccess",new ActionMessage("error.save.success"));
				//saveErrors(request,errors);
				//return (mapping.findForward("success"));				
				forward = actionMapping.findForward("ERROR");
			}

		}catch(Exception e){
			Log.debug(e.toString());
			request.setAttribute("msg", e.getMessage());
			forward = actionMapping.findForward("ERROR");
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
