package com.samart.etesting.web.staffexam.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class ObjectiveForm extends ActionForm{
	
	private String subjectRefId;
	private FormFile imgFile;
	private String question;
	private String subjectName;
	

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public FormFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(FormFile imgFile) {
		this.imgFile = imgFile;
	}

	public String getSubjectRefId() {
		return subjectRefId;
	}

	public void setSubjectRefId(String subjectRefId) {
		this.subjectRefId = subjectRefId;
	}
	
	
	/*public ActionErrors validate(ActionMapping mapping,
			   HttpServletRequest request) {
		 
			    ActionErrors errors = new ActionErrors();
		 
			    if( getImgFile().getFileSize()== 0){
			       errors.add("common.file.err",
			    	new ActionMessage("error.common.file.required"));
			       return errors;
			    }
		 
			    //only allow textfile to upload
			    if(!"text/plain".equals(getImgFile().getContentType())){
			        errors.add("common.file.err.ext",
			    	 new ActionMessage("error.common.file.textfile.only"));
			        return errors;
			    }
		 
		        //file size cant larger than 10kb :1048kb
			    System.out.println(getImgFile().getFileSize());
			    if(getImgFile().getFileSize() > 20480){ //20kb
			       errors.add("common.file.err.size",
				    new ActionMessage("error.common.file.size.limit", 20480));
			       return errors;
			    }
		 
			    return errors;
			}*/


}
