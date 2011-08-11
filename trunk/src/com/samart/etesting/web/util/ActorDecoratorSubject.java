
package com.samart.etesting.web.util;
import org.displaytag.decorator.TableDecorator;
import com.samart.etesting.bean.staffexam.Subject;
public class ActorDecoratorSubject extends TableDecorator{
	
	public String getDoViewId() {		
		 //int row = getListIndex();
		 Subject sub = (Subject)getCurrentRowObject();
	     return "<a href=\"javascript:doView(" + "'" + sub.getSubjectId()+
	                "'" + ")\">View</a>";
	}
	public String getDoEditId() {		
		Subject sub = (Subject)getCurrentRowObject();
	     return "<a href=\"javascript:doEdit(" + "'" + sub.getSubjectId() +
	                "'" + ")\">Edit</a>";
	}
	public String getDoDeleteId() {		
		Subject sub = (Subject)getCurrentRowObject();
	     return "<a href=\"javascript:doDelete(" + "'" + sub.getSubjectId() +
	                "'" + ")\">Delete</a>";
	}

}

