package com.samart.etesting.report.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class StatReportAction extends Action {
	
   private static org.apache.log4j.Logger Log = Logger.getLogger(StatReportAction.class);	
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
		throws Exception{	 
		//String commandMode = actionMapping.getParameter();
		ActionForward forward = null;

		try{
			//TODO:: Gen Report
		}catch(Exception e){
			//TODO :: Exception
			
		}
		return forward;
	 }

}
