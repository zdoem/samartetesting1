package com.samart.etesting.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.samart.etesting.bean.admin.Role;
import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.common.CommonServiceMySQL;

public class ManageAdminService  extends CommonServiceMySQL {
	private static org.apache.log4j.Logger Log = Logger.getLogger(ManageAdminService.class);
	
	static{
		//for test
		CommonServiceMySQL.setConfig("localhost", "3306", "db_etesting", "root", "root");
	}
	
	//Check Login 
	public UserInfo GetUserLogIn(String userId,String password){
		Log.debug("GetUserLogIn");
		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		UserInfo user;

		try{
				//connection db
				conn = open();
				Log.debug("Before GetUserLogIn");
			    i=1;
			    
				clbstmt = conn.prepareCall("{call GET_LOGIN(?,?,?,?,?,?,?,?,?,?)}");
				
				//In parameter
				clbstmt.setString(i++,userId.trim());//IN,UserID
				clbstmt.setString(i++,password.trim());//IN, password
				
				//out parameter
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);//p_flag
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);//p_userid
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);//p_roleId
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//p_role
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);//p_personPersonId
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//p_fname
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//p_lname
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//p_email
			    
			    clbstmt.execute();
				//result = clbstmt.executeUpdate();	
		        Log.debug("Execute GetUserLogIn");
		        
		        //get out parameter
		        int resultInt = clbstmt.getInt("p_flag"); // 0=Fails ,1=login passed
		        
		        user = new UserInfo();
		        
		        if(resultInt==1){
	        	
		        	//passed	
		        	Log.debug("--->Login passed.");
			        user.setUserId(clbstmt.getInt("p_userid")); //id
			        user.setLogIn(userId);//p_login
			        user.setPassword(password);//p_password
			        user.setRoleId(clbstmt.getString("p_roleId"));//roleId
			        user.setRole(clbstmt.getString("p_role"));//role
			        user.setPersonId(clbstmt.getInt("p_personPersonId"));//p_personPersonId
			        user.setFirstName(clbstmt.getString("p_fname"));//fname
			        user.setLastName(clbstmt.getString("p_lname"));//lname
			        user.setEmail(clbstmt.getString("p_email"));//email
	
		           //************END************
		        }else{
		        	Log.debug("--->Login false.");
		        }
		}
		catch(Exception e){
			e.fillInStackTrace();
			user = null;
		}
		finally{
			try {
				if(clbstmt!=null)
					clbstmt.close();
				if(conn!=null)
					conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//*******Return*********
		return user;//#End	
	}
	
	
	//--------------->>Action
	public ArrayList ListRole()  {	
		Log.debug("ListRole..");
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				="";
		Role  role =null;
	   
		ArrayList result = new ArrayList();
		
	    try{	 
			 //connection
	    	 conn = open();
	    	 Log.debug("Open connection");	    	 
	    	 //setTransaction
	    	 sql="SELECT RoleId, RoleName FROM db_etesting.role;";
	    	 
	    	  pstmt = conn.prepareStatement(sql);
	    	  Log.debug(sql);

	    	  Log.equals("---->>"+pstmt.toString());
		      rs = pstmt.executeQuery();
		      Log.debug("execute SQL Query.");
	    	  
		      int c=0;
	 		  while(rs.next()){	 			  
	 			 role = new Role();
	 			 role.setRoleId(rs.getInt("RoleId"));
	 			 role.setRoleName(rs.getString("RoleName"));	 			 
	 			 
	 			 result.add(role);	 			
	 			 c++;
	 		}
	 		Log.debug("get Role FetchSize :"+c);
	        //Commit Transaction
		}catch(Exception e){
			e.printStackTrace();
			 Log.debug(" "+e.getMessage());
		}
		finally{ 
			//close
			try{
			rs.close();
			pstmt.close();
		    close(conn); 
			}catch(Exception e){}
		    
			Log.debug("close connection ");
		} 
	   return result;
	}

}
