package com.dog.web.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dog.model.domain.TypeForm;


public class TypeValidator  implements Validator{

	@Override
	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(TypeForm.class);
	}
	
	@Override
	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		
		 TypeForm eType = (TypeForm)obj;
		if (!StringUtils.hasLength(eType.getTypeName())) {
			error.rejectValue("typeName", "required", "required");
		}
	}

}
