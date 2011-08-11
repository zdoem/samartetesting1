package com.samart.etesting.web.util;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.tiles.TilesRequestProcessor;
import com.samart.etesting.bean.login.UserInfo;

/**
 * 
 */
public class WebRequestController extends TilesRequestProcessor{
   
	public boolean processPreprocess(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();

        UserInfo usrInfo = null;
        usrInfo = (UserInfo) session.getAttribute("UserProfile");
   
        try 
        {
        	request.setCharacterEncoding("UTF-8");
            // check session
            if(usrInfo == null)
            {                   	
            	System.out.println("-------------->>TEST XXXXXXXXXXXXXxxx");
                session = request.getSession(true);  
               // session.setAttribute("URL",request.getContextPath() + "/LoginFormAction.do");
                try{
                	
                    response.sendRedirect(request.getContextPath() + "/LoginFormAction.do");
                    return true;
                }
                catch(Exception e){
                    System.out.print("WebRequestController::WebRequestController occure Exception");
                    System.out.print(e.getMessage());
                }
                /////////////////////////////////////////
                return false;
            }
            else{            	
            	System.out.println("---->Login OK..");
            	
            	return true;
            }//#End else check session
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
