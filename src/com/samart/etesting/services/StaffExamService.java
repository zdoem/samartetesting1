package com.samart.etesting.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.samart.etesting.bean.staffexam.Subject;
import com.samart.etesting.common.CommonServiceMySQL;

public class StaffExamService extends CommonServiceMySQL{
	private static org.apache.log4j.Logger Log = Logger.getLogger(StaffExamService.class);
	static{
		//for test
		CommonServiceMySQL.setConfig("localhost", "3306", "db_etesting", "root", "root");
	}
	
	//Delete
	public boolean DeleteSubject(int id)  {	
		Log.debug("DeleteSubject");		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		boolean isUpdate = true;
		try{
				// TODO 	
				conn = open();
				Log.debug("Before DeleteSubject");
				clbstmt = conn.prepareCall("{call DELETE_SUBJECT(?)}");
				clbstmt.setInt(i++,id);
		    
			    isUpdate = clbstmt.execute();			    
		        Log.debug("Execute DeleteSubject");	
		        //true = fail
		        //false = success
		        if(!isUpdate)  {
		        	Log.debug("DeleteSubject success .");
		        }
		        else{
		        	Log.debug("DeleteSubject Fail .");
		        }
		}
		catch(Exception e){
			e.fillInStackTrace();
			Log.debug("DeleteSubject Exception e:"+e.toString());
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
	
	//List
	public ArrayList<Subject> ListSubject(String subjectCode,String subjectName)  {	
		Log.debug("ListSubject..");
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				="";
		Subject  subject = null;
	    ArrayList<Subject> result = new ArrayList<Subject>();
		
	    try{	 
			 //connection
	    	 conn = open();
	    	 Log.debug("Open connection");	    	 
	    	 //setTransaction
	    	 sql="SELECT s.SubjectId,s.Code,s.Name,s.Description FROM db_etesting.subject s ";
	    	 
	    	 String where = "WHERE";	    	 
   		 
	                if (!subjectCode.equals("")) { 
	                	where+= " (s.Code = ? ) OR (s.Code LIKE ?)  AND";

	                }
	                if (!subjectName.equals("")) {
	                	 where += " (s.Name = ? ) OR (s.Name LIKE ?)  AND"; 
	                }
	                //Cutting
	                sql += where.trim().substring(0, where.length()-5);

	    	 	    	 
	    	  pstmt = conn.prepareStatement(sql);
	    	  Log.debug(sql);
	    	  
	    		    int i=1;
	                if (!subjectCode.equals("")) { 
	                	pstmt.setString(i++, subjectCode);
	                	pstmt.setString(i++, "%"+subjectCode+"%");	                	
	                	Log.debug("--------------subjectCode process------------------");
	                }
	                if (!subjectName.equals("")) {
	                	pstmt.setString(i++, subjectName);
	                	pstmt.setString(i++, "%"+subjectName+"%");
	                	Log.debug("--------------subjectName process------------------");
	                }

	    	  Log.equals(pstmt.toString());
		      rs = pstmt.executeQuery();
		      Log.debug("execute SQL Query.");
	    	  
		      int c=0;
	 		  while(rs.next()){
	 			 subject = new Subject();
	 			 
	 			 subject.setSubjectId(rs.getInt("s.SubjectId"));
	 			 subject.setSubjectCode(rs.getString("s.Code"));
	 			 subject.setSubjectName(rs.getString("s.Name"));
	 			 subject.setSubjectDetails(rs.getString("s.Description"));
	 			 
	 			 result.add(subject);
	 			 c++;
	 		}
	 		Log.debug("get Subject FetchSize :"+c);
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
	
	//Insert
	public boolean InsertSubject(Subject obj)  {	
		Log.debug("InsertSubject");
		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		boolean isInsert = true; //true is fail
		try{
				// TODO 	
				conn = open();
				Log.debug("Before Insert");
			    //Insert to DB
				clbstmt = conn.prepareCall("{call INSERT_SUBJECT(?,?,?,?)}");
				clbstmt.setString(i++,obj.getSubjectCode());
				clbstmt.setString(i++,obj.getSubjectName());
				clbstmt.setString(i++,obj.getSubjectDetails());
			    clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);	
			    
			    isInsert = clbstmt.execute();
				//result = clbstmt.executeUpdate();	
			    Log.debug("Execute Insert");
			    
		        //get out parameter
		        int resultInt = clbstmt.getInt(4);
		        
		        if(resultInt== 0)	{
		        	//not duplicate
		        	//true = fail
			        //false = success
			        if(!isInsert)  {
			        	Log.debug("Insert success .");
			        	isInsert = false;
			        }
			        else{
			        	Log.debug("Insert Fail .");
			        	isInsert = true;
			        }
		        	
		        }else{
		        	Log.debug("Insert duplicate subject Code .");
		        	isInsert = true;
		        }    
		}
		catch(Exception e){
			e.fillInStackTrace();
			Log.debug("Insert Exception e:"+e.toString());
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
		return isInsert;//#End
	}
	
	//method getSubjectID
	public Subject GetSubjectID(String id){
		Log.debug("GetSubjectID");
		
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		Subject sub;

		try{
				//connection db
				conn = open();
				Log.debug("Before GetSubjectID");
			    i=1;
				clbstmt = conn.prepareCall("{call GET_SUBJECT(?,?,?,?)}");
				clbstmt.setString(i++,id);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//code
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//name
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);//desc
			    
			    clbstmt.execute();
				//result = clbstmt.executeUpdate();	
		        Log.debug("Execute GetSubjectID");     
		        
		        //get out parameter
		        //resultInt = clbstmt.getInt(6);
		        sub = new Subject();
		        sub.setSubjectId(Integer.parseInt(id));
		        sub.setSubjectCode(clbstmt.getString("p_code"));
		        sub.setSubjectName(clbstmt.getString("p_name"));
		        sub.setSubjectDetails(clbstmt.getString("p_description"));       
	           //************END************
		}
		catch(Exception e){
			e.fillInStackTrace();
			sub = null;
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
		return sub;//#End	
	}

	//Update Subject
	public boolean UpdateSubject(Subject obj)  {	
		Log.debug("UpdateSubject");
		
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
				clbstmt = conn.prepareCall("{call UPDATE_SUBJECT(?,?,?,?)}");
				clbstmt.setInt(i++,obj.getSubjectId());//id
				clbstmt.setString(i++,obj.getSubjectCode());//code
				clbstmt.setString(i++,obj.getSubjectName());//name
				clbstmt.setString(i++,obj.getSubjectDetails());//desc
			    //clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);
				
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
}
