package com.samart.etesting.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.samart.etesting.bean.login.UserInfo;
import com.samart.etesting.bean.register.UserReg;
import com.samart.etesting.common.CommonServiceMySQL;

public class ManageUserService  extends CommonServiceMySQL{	
	
	private static org.apache.log4j.Logger Log = Logger.getLogger(ManageUserService.class);
	static{
		//for test
		CommonServiceMySQL.setConfig("localhost", "3306", "db_etesting", "root", "root");
	}
	
	public ArrayList<UserInfo> ListUserInfo(String userLogin,String firstName,String roleId)  {	
		Log.debug("ListUserInfo..");
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				= "";
	    UserInfo  usrInfo =null;
	    ArrayList<UserInfo> result = new ArrayList<UserInfo>();
		
	    try{	 
			 //connection
	    	 conn = open();
	    	 Log.debug("Open connection");	    	 
	    	 //setTransaction
	    	 sql="SELECT user.UserId,user.Login,user.Password,person.FirstName,person.LastName,person.EMail,person.RefNumber,user.RoleId,user.PersonPersonId,role.RoleName " +
	    	 " FROM (db_etesting.user user INNER JOIN db_etesting.role role ON (user.RoleId = role.RoleId))" +
	    	 " INNER JOIN db_etesting.person person ON (user.PersonPersonId = person.PersonId) ";
	    	 
	    	 String where = " WHERE";	    	   		 	               
	    	        if (!userLogin.equals("")) { 
	                	where+= " (user.Login = ? ) OR (user.Login LIKE ?)   AND";
	                	//where+= " (user.Login = ? ) AND"; 
	                }
	                if (!firstName.equals("")) {
	                	 where += " (person.FirstName = ? ) OR (person.FirstName LIKE ?)   AND"; 
	                }
	                if(!roleId.equals("")){
	                	 where += " (user.RoleId = ? )  AND"; 
	                }
	                
	                //Cutting
	                sql += where.trim().substring(0, where.length()-6);
	    	 	
  
	    	  pstmt = conn.prepareStatement(sql);
	    	  Log.debug(sql);
	    	  
	    	 int i=1;
	         if (!userLogin.equals("")) { 
	              pstmt.setString(i++, userLogin);
	              pstmt.setString(i++,"%"+userLogin+"%");	                	
	              Log.debug("-------userLogin process---------");
	         }
	         if (!firstName.equals("")) {
	               pstmt.setString(i++, firstName);
	               pstmt.setString(i++,"%"+firstName+"%");
	               Log.debug("--------firstName process----------");
	          }
	         if (!roleId.equals("")) {
	               pstmt.setInt(i++, Integer.parseInt(roleId));
	               Log.debug("--------roleId process----------");
	          }

	    	  Log.equals("---->>"+pstmt.toString());
		      rs = pstmt.executeQuery();
		      Log.debug("execute SQL Query.");
	    	  
		      int c=0;
	 		  while(rs.next()){
	 			  
	 			 usrInfo = new UserInfo();
	 			 usrInfo.setUserId(rs.getInt("user.UserId"));
	 			 usrInfo.setLogIn(rs.getString("user.Login"));
	 			 usrInfo.setPassword(rs.getString("user.Password"));
	 			 usrInfo.setRole(rs.getString("role.RoleName"));
	 			 usrInfo.setPersonId(rs.getInt("user.PersonPersonId"));
	 			 usrInfo.setFirstName(rs.getString("person.FirstName"));
	 			 usrInfo.setLastName(rs.getString("person.LastName"));
	 			 usrInfo.setEmail(rs.getString("person.EMail"));
	 			 usrInfo.setRefNumber(rs.getString("person.RefNumber"));
	 			 result.add(usrInfo);
	 			 c++;
	 		}
	 		Log.debug("get UserInfo FetchSize :"+c);
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
	
	public ArrayList<UserInfo> ListUserInfo(String userLogin,String firstName)  {	
		Log.debug("ListUserInfo..");
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				="";
	    UserInfo  usrInfo =null;
	    ArrayList<UserInfo> result = new ArrayList<UserInfo>();
		
	    try{	 
			 //connection
	    	 conn = open();
	    	 Log.debug("Open connection");	    	 
	    	 //setTransaction
	    	 sql="SELECT user.Login,user.UserId,user.Password, user.RoleId,user.PersonPersonId,person.PersonId,person.LastName,person.FirstName, person.EMail,person.RefNumber " +
	    	 		"FROM db_etesting.user user INNER JOIN db_etesting.person person ON (user.PersonPersonId = person.PersonId) ";
	    	 
	    	 String where = " WHERE";	    	   		 	               
	    	 if (!userLogin.equals("")) { 
	                	where+= " (user.Login = ? ) OR (user.Login LIKE ?)   AND";
	                	//where+= " (user.Login = ? ) AND"; 
	                }
	                if (!firstName.equals("")) {
	                	 where += " (person.FirstName = ? ) OR (person.FirstName LIKE ?)   AND"; 
	                }
	                //Cutting
	                sql += where.trim().substring(0, where.length()-6);
	    	 	
  
	    	  pstmt = conn.prepareStatement(sql);
	    	  Log.debug(sql);
	    	  
	    	 int i=1;
	         if (!userLogin.equals("")) { 
	              pstmt.setString(i++, userLogin);
	              pstmt.setString(i++,"%"+userLogin+"%");	                	
	              Log.debug("-------userLogin process---------");
	         }
	         if (!firstName.equals("")) {
	               pstmt.setString(i++, firstName);
	               pstmt.setString(i++,"%"+firstName+"%");
	               Log.debug("--------firstName process----------");
	          }

	    	  Log.equals("---->>"+pstmt.toString());
		      rs = pstmt.executeQuery();
		      Log.debug("execute SQL Query.");
	    	  
		      int c=0;
	 		  while(rs.next()){
	 			  
	 			 usrInfo = new UserInfo();
	 			 usrInfo.setUserId(rs.getInt("user.UserId"));
	 			 usrInfo.setLogIn(rs.getString("user.Login"));
	 			 usrInfo.setPassword(rs.getString("user.Password"));
	 			 usrInfo.setRole(rs.getString("user.RoleId"));
	 			 usrInfo.setPersonId(rs.getInt("user.PersonPersonId"));
	 			 usrInfo.setFirstName(rs.getString("person.FirstName"));
	 			 usrInfo.setLastName(rs.getString("person.LastName"));
	 			 usrInfo.setEmail(rs.getString("person.EMail"));
	 			 usrInfo.setRefNumber(rs.getString("person.RefNumber"));
	 			 result.add(usrInfo);
	 			 c++;
	 		}
	 		Log.debug("get UserInfo FetchSize :"+c);
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
	
	public boolean DeleteUser(int id)  {	
		Log.debug("DeleteUser");		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		boolean isUpdate = true;
		try{
				// TODO 	
				conn = open();
				Log.debug("Before DeleteUser");
				clbstmt = conn.prepareCall("{call DELETE_USERINFO(?)}");
				clbstmt.setInt(i++,id);
		    
			    isUpdate = clbstmt.execute();			    
		        Log.debug("Execute DeleteUser");	
		        //true = fail
		        //false = success
		        if(!isUpdate)  {
		        	Log.debug("DeleteUser success .");
		        }
		        else{
		        	Log.debug("DeleteUser Fail .");
		        }
		}
		catch(Exception e){
			e.fillInStackTrace();
			Log.debug("DeleteUser Exception e:"+e.toString());
		}
		finally{
			try {
				if(clbstmt!=null)
					clbstmt.close();
				if(conn!=null)
					conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//*******Return*********
		return isUpdate;//#End
	}
	
	public boolean UpdateUser(UserInfo userObj)  {	
		Log.debug("UpdateUser");
		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		boolean isUpdate = true;
		try{
				// TODO 	
				conn = open();
				Log.debug("Before update");
			    //Insert to DB
				clbstmt = conn.prepareCall("{call UPDATE_USERINFO(?,?,?,?,?,?)}");
				clbstmt.setInt(i++,userObj.getUserId());
				clbstmt.setString(i++,userObj.getPassword());
				clbstmt.setString(i++,userObj.getFirstName());
				clbstmt.setString(i++,userObj.getLastName());
			    clbstmt.setString(i++,userObj.getEmail());			    
			    clbstmt.setInt(i++, Integer.parseInt(userObj.getRoleId()));			    
			    
			    isUpdate = clbstmt.execute();
				//result = clbstmt.executeUpdate();	
		        Log.debug("Execute Update");	
		        //true = fail
		        //false = success
		        if(!isUpdate)  {
		        	Log.debug("Update success .");
		        }
		        else{
		        	Log.debug("Update Fail .");
		        }
		}
		catch(Exception e){
			e.fillInStackTrace();
			Log.debug("Update Exception e:"+e.toString());
		}
		finally{
			try {
				if(clbstmt!=null)
					clbstmt.close();
				if(conn!=null)
					conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//*******Return*********
		return isUpdate;//#End
	}
	
	public int Register(UserReg reg)  {	
		Log.debug("Register");		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		int resultInt = 1;
		//***********
		try{
			    //connection db
			    conn = open();
			    Log.debug("Before Register");
			    //Insert to DB
				//CallableStatement stmt = null;
			    i=1;
				clbstmt = conn.prepareCall("{call INSERT_REGISTER(?,?,?,?,?,?)}");
				clbstmt.setString(i++,reg.getUserName());
				clbstmt.setString(i++,reg.getPassword());
				clbstmt.setString(i++,reg.getFname());
				clbstmt.setString(i++,reg.getLname());
			    clbstmt.setString(i++,reg.getEmail());
			    clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);
			    
			    clbstmt.execute();
				//result = clbstmt.executeUpdate();	
		        Log.debug("Execute Register");
		        
		        //get out parameter
		        resultInt = clbstmt.getInt(6);
		        if(resultInt== 0)  {
		        	Log.debug("Register success :"+resultInt);
		        }
		        else{
		        	Log.debug("Register Fail :"+resultInt);
		        }		        
		}
		catch(Exception e){
			e.fillInStackTrace();
		}
		finally{
			try {
				if(clbstmt!=null)
					clbstmt.close();
				if(conn!=null)
					conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//*******Return*********
		return resultInt;//#End
	}
	
	public UserInfo GetUserID(String id){
		Log.debug("GetUserID");
		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		UserInfo user;

		try{
				//connection db
				conn = open();
				Log.debug("Before GetUserID");
			    i=1;
				clbstmt = conn.prepareCall("{call GET_USER(?,?,?,?,?,?,?,?)}");
				clbstmt.setString(i++,id);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);
				
			    
			    clbstmt.execute();
				//result = clbstmt.executeUpdate();	
		        Log.debug("Execute GetUserID");
		        
		        //get out parameter
		        //resultInt = clbstmt.getInt(6);
		        user = new UserInfo();
		        user.setUserId(Integer.parseInt(id));
		        user.setLogIn(clbstmt.getString("p_login"));
		        user.setPassword(clbstmt.getString("p_password"));
		        user.setRole(clbstmt.getString("p_role"));
		        user.setFirstName(clbstmt.getString("p_fname"));
		        user.setLastName(clbstmt.getString("p_lname"));
		        user.setEmail(clbstmt.getString("p_email"));	
		        user.setRoleId(clbstmt.getString("p_roleid"));
	           //************END************
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
}
