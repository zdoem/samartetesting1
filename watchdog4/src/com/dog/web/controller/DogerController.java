package com.dog.web.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.dog.dao.service.DogServiceImpl;
import com.dog.dao.service.TypeServiceImpl;
import com.dog.model.bean.Dogger;
import com.dog.model.bean.Type;
import com.dog.model.domain.DogForm;

/*
 * date:2011-12-12
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */

@Controller
@SessionAttributes
public class DogerController {
	
	//Show From DOG_ADD 
	@RequestMapping("/dogAddForm")
	public ModelAndView doFormAddAction(HttpServletRequest request) throws Exception{
			HttpSession session = request.getSession();
			System.out.println("--->Show dogAddForm.dog");	
			
			TypeServiceImpl typeService = new TypeServiceImpl();	
			//call Search  service		
			ArrayList result = typeService.list();	
			Type type = new Type();		
			Map<String,String> mapType = new LinkedHashMap<String,String>();		
			if(result!=null && result.size()>0){
				Iterator it = result.iterator();
				while(it.hasNext()){
					type =(Type)it.next();
					mapType.put(type.getTypeID()+"".trim(), type.getTypeName());
				}
			}
			session.setAttribute("mapTypeDLL", mapType);		
			//jsp file,command is bean,Form bean mapping
			return new ModelAndView("dogerAddForm", "command", new DogForm());
	}
	
	//doAction GetData TypeForm Form
	@RequestMapping("/dogDelete")
	public String doDogDeleteAction(HttpServletRequest request,
				HttpServletResponse response)throws Exception {
			System.out.println("---> dogDelete.dog");
			DogServiceImpl dogService = new DogServiceImpl();
			
			//call Delete Implement	
			boolean isDel = dogService.deleteDog(request.getParameter("dogId").toString());
			if(isDel==false){
				//TODO :Error insert 
				return "redirect:error.dog?msg=Delete Record is invalid.&url=home.dog";
			}else{
				//TODO: insert success.			
				return "redirect:success.dog?msg=Successfully&url=dogList.dog";
			}		
		}
		
	
	//doSaveFormAction
	@RequestMapping(value = "/saveDoger", method = RequestMethod.POST)
	public String doSaveFormAction(@ModelAttribute("dogForm")
							DogForm eDog, BindingResult result) throws Exception {
			System.out.println("--->ADD  saveDoger.dog");				
			DogServiceImpl dogService = new DogServiceImpl();
			boolean isIns = dogService.insertDog(eDog);	
			if(isIns){
				//TODO :Error insert 
				return "redirect:error.dog?msg=Insert Data is Error&url=home.dog";
			}else{
				//TODO: insert success.			
				return "redirect:success.dog?msg=Successfully.&url=dogList.dog";
			}				
	}
	
	
	
	//for TestForm
	@RequestMapping("/dogList")
	public ModelAndView doDogListAction(@ModelAttribute("dogForm")DogForm eDog,
			BindingResult result,
			HttpServletRequest request,
			HttpServletResponse response)throws Exception {
			
			HttpSession session = request.getSession();
		
			System.out.println("--->List dogList.dog");	
			DogServiceImpl dogService = new DogServiceImpl();
			
		   if(eDog==null){
				eDog = new DogForm();
				eDog.setDogSubject("");
				eDog.setDogSolution("");
				eDog.setDogTypeIdDDL("");
			}
		   if(null == eDog.getDogSolution()){
				eDog.setDogSolution("");				
			}
		   if(null == eDog.getDogSubject()){
				eDog.setDogSubject("");
			} 
		   if(null == eDog.getDogTypeIdDDL()){
				eDog.setDogTypeIdDDL("");
			}
		
			List searchResults = dogService.listDog(eDog);			
			System.out.println("--->Result :"+searchResults.size());
			// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
			PagedListHolder pagedListHolder = new PagedListHolder(searchResults);
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);			
			//Log.debug("--->initialize PagedListHolder with our list");
			pagedListHolder.setPage(page);
			int pageSize = 10;
			pagedListHolder.setPageSize(pageSize);
			
			//mav.addObject("pagedListHolder", pagedListHolder);				
			//return new ModelAndView("dogerList", "pagedListHolder",pagedListHolder);
			request.setAttribute("pagedListHolder", pagedListHolder);
			
			//----------List DLL type
			TypeServiceImpl typeService = new TypeServiceImpl();
			ArrayList typeList = typeService.list();
			//-------set DDL for EditForm--------
			Map<String,String> mapType = new LinkedHashMap<String,String>();	
			
			Type type = new Type();		
			if(typeList!=null && typeList.size()>0){
					Iterator it = typeList.iterator();
					while(it.hasNext()){
						type =(Type)it.next();
						mapType.put(type.getTypeID()+"".trim(), type.getTypeName());
					}
			}	
			session.setAttribute("mapTypeDLL", mapType);

			return new ModelAndView("dogerList", "command", eDog);
	}
	
	
	
	//doAction ADD TypeForm Form
	@RequestMapping(value = "/updateDoger", method = RequestMethod.POST)
	public String doDogUpdateAction(@ModelAttribute("dogForm")
								DogForm eDog, BindingResult result) throws Exception {
			System.out.println("--->Update  updateDoger.dog");	
			DogServiceImpl dogService = new DogServiceImpl();
			boolean isUpd = dogService.updateDog(eDog);
			//typeServer.update(eDog);		
			System.out.println("Result Update:"+isUpd);		
			if(isUpd){
				//TODO :Error insert 
				return "redirect:error.dog?msg=Insert Data is Error&url=home.dog";
			}else{
				//TODO: insert success.			
				return "redirect:success.dog?msg=Successfully.&url=dogList.dog";
			}			
		}
	
	
	//doAction GetData TypeForm Form
	@RequestMapping("/RetrieveDogData")
	public ModelAndView doTypeRetrieveAction(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println("---> RetrieveDogData.dog");
		DogServiceImpl dogService = new DogServiceImpl();
		//Get Data
		Dogger obj = (Dogger)dogService.getDoger(request.getParameter("dogId").toString());		
		
		if(obj == null){
			return new ModelAndView("msg_errors", "command",null);			
		}else{				
			
			//----------List DLL type
			TypeServiceImpl typeService = new TypeServiceImpl();
			ArrayList typeList = typeService.list();
			
			//mapping Form
			DogForm form = new DogForm();
			form.setDogId(obj.getDogId());
			form.setDogSubject(obj.getDogSubject());
			form.setDogDesc(obj.getDogDesc());
			form.setDogSolution(obj.getDogSolution());
			form.setDogComment1(obj.getDogComment1());
			form.setCreateDate(obj.getCreateDate());
			form.setUpdateDate(obj.getUpdateDate());
			form.setDogTypeIdDDL(obj.getDogTypeId()+"");
			form.setCmd(request.getParameter("cmd").toString());
			
			//-------set DDL for EditForm--------
			Map<String,String> mapType = new LinkedHashMap<String,String>();	
			if(request.getParameter("cmd").equals("edit")){
				Type type = new Type();		
				if(typeList!=null && typeList.size()>0){
					Iterator it = typeList.iterator();
					while(it.hasNext()){
						type =(Type)it.next();
						mapType.put(type.getTypeID()+"".trim(), type.getTypeName());
					}
				}				
			}else{
				//For Viewer
				mapType.put(obj.getDogTypeId()+"".trim(),obj.getDogTypeName());
			}
			session.setAttribute("mapTypeDLL", mapType);	
			//--------------------------------			
			return new ModelAndView("dogerEditForm", "command",form);
		}
	}
	
	
}
