package com.dog.web.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dog.dao.service.TypeServiceImpl;
import com.dog.model.bean.Type;
import com.dog.model.domain.TypeForm;

/*
 * date:2011-12-12
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */

@Controller
@SessionAttributes
public class TypeController  {	
	//protected ApplicationContext springAppContext = null;
	//Show From ADD 
	@RequestMapping("/typeAddForm")
	public ModelAndView doShowTypeFromAction() {
		System.out.println("--->Show TypeAddForm.dog");		
		return new ModelAndView("typeAddForm", "command", new TypeForm());
	}
	
	
	//for TestForm
	@RequestMapping("/test")
	public ModelAndView doTestTypeFromAction() {
		System.out.println("--->Show TypeAddForm.dog");
		
		return new ModelAndView("test", "command", new TypeForm());
	}
	
	
	//for TestForm
	@RequestMapping("/typeList")
	public ModelAndView doTypeListAction(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		System.out.println("--->List typeList.dog");

		TypeServiceImpl typeService = new TypeServiceImpl();
		
		List searchResults = typeService.list();
		
		System.out.println("--->Result :"+searchResults.size());
		// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
		PagedListHolder pagedListHolder = new PagedListHolder(searchResults);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		
		//Log.debug("--->initialize PagedListHolder with our list");
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		//mav.addObject("pagedListHolder", pagedListHolder);				
		return new ModelAndView("typeList", "pagedListHolder",pagedListHolder);
	}
	
	
	
	//doAction ADD TypeForm Form
	@RequestMapping(value = "/typeAddAction", method = RequestMethod.POST)
	public String doAddTypeAction(@ModelAttribute("typeForm")
							TypeForm eType, BindingResult result) {
		System.out.println("--->ADD  typeAddAction.dog");	
		System.out.println("TypeName:"+eType.getTypeName());
		System.out.println("TypeDesc:"+eType.getTypeDesc());	
		TypeServiceImpl typeServer = new TypeServiceImpl();
		boolean isIns = typeServer.insert(eType);		
		System.out.println("Result Insert:"+isIns);		
		if(isIns){
			//TODO :Error insert 
			return "redirect:error.dog?msg=Insert Data is Error&url=home.dog";
		}else{
			//TODO: insert success.			
			return "redirect:success.dog?msg=Successfully&url=typeList.dog";
		}				
	}
	
	
	//doAction GetData TypeForm Form
	@RequestMapping("/typeRetrieveData")
	public ModelAndView doTypeRetrieveAction(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		System.out.println("---> typeRetrieveData.dog");
		TypeServiceImpl typeService = new TypeServiceImpl();
		//Get Data
		Type obj = (Type)typeService.getType(Integer.parseInt(request.getParameter("typeId")));				
		if(obj == null){
			return new ModelAndView("msg_errors", "command",null);			
		}else{		
			//mapping Form
			TypeForm objForm = new TypeForm();
			objForm.setTypeId(""+obj.getTypeID());
			objForm.setTypeName(obj.getTypeName());
			objForm.setTypeDesc(obj.getTypeDesc());			
			return new ModelAndView("typeEditForm", "command",objForm);
		}
	}
	
	
	//doAction GetData TypeForm Form
	@RequestMapping("/typeDelete")
	public String doTypeDeleteAction(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		System.out.println("---> typeDelete.dog");
		TypeServiceImpl typeService = new TypeServiceImpl();
		
		//call Delete Implement	
		boolean isDel = typeService.delete(Integer.parseInt(request.getParameter("typeId")));
		if(isDel){
			//TODO :Error insert 
			return "redirect:error.dog?msg=Delete Record is invalid.&url=home.dog";
		}else{
			//TODO: insert success.			
			return "redirect:success.dog?msg=Successfully&url=typeList.dog";
		}		
	}

	
	//doAction ADD TypeForm Form
	@RequestMapping(value = "/typeUpdateAction", method = RequestMethod.POST)
	public String doTypeUpdateAction(@ModelAttribute("typeForm")
							TypeForm eType, BindingResult result) {
		System.out.println("--->Update  typeUpdateAction.dog");	
		System.out.println("TypeName:"+eType.getTypeName());
		System.out.println("TypeDesc:"+eType.getTypeDesc());	
		
		TypeServiceImpl typeServer = new TypeServiceImpl();
		boolean isUpd = typeServer.update(eType);		
		System.out.println("Result Update:"+isUpd);		
		if(isUpd){
			//TODO :Error insert 
			return "redirect:error.dog?msg=Insert Data is Error&url=home.dog";
		}else{
			//TODO: insert success.			
			return "redirect:success.dog?msg=Successfully&url=typeList.dog";
		}			
	}


}
