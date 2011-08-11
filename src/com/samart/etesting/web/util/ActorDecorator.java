package com.samart.etesting.web.util;

import org.displaytag.decorator.TableDecorator;
import com.samart.etesting.bean.login.UserInfo;
public class ActorDecorator extends TableDecorator{
	
	public String getDoViewId() {		
		 //int row = getListIndex();
		 UserInfo urs = (UserInfo)getCurrentRowObject();
	     return "<a href=\"javascript:doView(" + "'" + urs.getPersonId() +
	                "'" + ")\">View</a>";
	}
	public String getDoEditId() {		
		 UserInfo urs = (UserInfo)getCurrentRowObject();
	     return "<a href=\"javascript:doEdit(" + "'" + urs.getPersonId() +
	                "'" + ")\">Edit</a>";
	}
	public String getDoDeleteId() {		
		 UserInfo urs = (UserInfo)getCurrentRowObject();
	     return "<a href=\"javascript:doDelete(" + "'" + urs.getPersonId() +
	                "'" + ")\">Delete</a>";
	}

}
