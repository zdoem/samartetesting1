package com.dog.dao.service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.dog.model.domain.TypeForm;
import com.dog.model.bean.Type;


/*
 * date:2011-12-14
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */

public class TypeServiceImpl extends Common implements TypeService {
	//for connection data base
	static{
		String dataSource = "jdbc/Datasource_watchdog";
		Common.setConfigForConnectionPool("", dataSource);		
		/*Common.setConfig(host, port, dns, usr, pwd);*/
	}
	static String INSTANT_DB_NAME ="db2_watchdog";
	

	@Override
	public boolean insert(TypeForm eType) {
		// TODO Auto-generated method stub
		//Log.debug("InsertSubject");	
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
	    //***********
		boolean isInsert = true; //true is fail
		try{
				// TODO 	
				conn = open();
				conn.setAutoCommit(false);
				System.out.println("-->Before Insert");
			    //Insert to DB
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".INSERT_TYPE(?,?)}");
				clbstmt.setString(i++,eType.getTypeName());
				clbstmt.setString(i++,eType.getTypeDesc());					    
			    isInsert = clbstmt.execute();
				//result = clbstmt.executeUpdate();	
			    System.out.println("-->Execute Insert");		    
			    conn.commit();
				conn.setAutoCommit(true);
		}
		catch(Exception e){
			e.fillInStackTrace();
			//Log.debug("Insert Exception e:"+e.toString());
			try{
				conn.rollback();
			}catch(Exception ex){}
		}
		finally{
			try {

				if(clbstmt!=null)
					clbstmt.close();
				if(conn!=null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//*******Return*********
		return isInsert;//#End
	}

	@Override
	public boolean update(TypeForm eType) {
		//Log.debug("InsertSubject");	
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		boolean isUpd = true; //true is fail
		try{	
				conn = open();
				conn.setAutoCommit(false);
				System.out.println("-->Before Update");
				 //Update to DB
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".UPDATE_TYPE(?,?,?)}");
				clbstmt.setInt(i++, Integer.parseInt(eType.getTypeId()));
				clbstmt.setString(i++,eType.getTypeName());
				clbstmt.setString(i++,eType.getTypeDesc());					    
				isUpd = clbstmt.execute();
				System.out.println("-->TypeServiceImpl:Update TypeForm success");
				//result = clbstmt.executeUpdate();		    
				conn.commit();
				conn.setAutoCommit(true);
			}catch(Exception e){
					e.fillInStackTrace();
					//Log.debug("Insert Exception e:"+e.toString());
				try{
					conn.rollback();
				}catch(Exception ex){}
			}
			finally{
				try {
						if(clbstmt!=null)
							clbstmt.close();
						if(conn!=null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			return isUpd;//#End			
	}

	@Override
	public boolean delete(int eId) {
		// TODO Auto-generated method stub					
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		int intRet = 0;
		//***********
		boolean isDel = true;  //true is success,false is error
		try{
				//connection db
				conn = open();
				conn.setAutoCommit(false);
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".DELETE_TYPE(?,?)}");
				clbstmt.setInt(i++,eId);
				clbstmt.registerOutParameter(i++, java.sql.Types.INTEGER);					    
				clbstmt.execute();				
				//result = clbstmt.executeUpdate();	
				System.out.println("--->Execute delete()");     			        
				//get out parameter
				intRet = clbstmt.getInt("p_IntResult"); //name param from  stroeprocedure  
				conn.commit();	
				conn.setAutoCommit(true);
				//intRet 0=Fail
				//intRet 1=success
			}catch(Exception e){
				e.fillInStackTrace();
				try{
					conn.rollback();
				}catch(Exception ex){}
			}
			finally{
				try {
					if(clbstmt!=null)
						clbstmt.close();
					if(conn!=null)
						conn.close();
				 } catch (SQLException e) {
					  e.printStackTrace();
				}
			}			
			
			//*******Return*********
			if(intRet==0){
				return true;//Error #End
			}else{
				return false;//Success #End
			}  
	}
	

	@Override
	public Type getType(int eId) {
		// TODO Auto-generated method stub					
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		//***********
		Type obj;
		try{
				//connection db
				conn = open();
				//Log.debug("Before getWatchdogObj");
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".GET_TYPE(?,?,?)}");
				clbstmt.setInt(i++,eId);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(i++, java.sql.Types.VARCHAR);					    
				clbstmt.execute();
				//result = clbstmt.executeUpdate();	
				System.out.println("--->Execute getType()");     			        
				//get out parameter
				 obj = new Type();
				 obj.setTypeID(eId);  
				 obj.setTypeName(clbstmt.getString("p_typeName")); //name param from  stroeprocedure
				 obj.setTypeDesc(clbstmt.getString("p_typeDesc"));       				        				    
		    }catch(Exception e){
					e.fillInStackTrace();
					obj = null;
			}
			finally{
				try {
					if(clbstmt!=null)
						clbstmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//*******Return*********
			return obj;//#End	
	}

	
	@Override
	public ArrayList list() {
		// TODO Auto-generated method stub
		//Log.debug("List WatchdogForm..");
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				="";
		Type  obj =null;
	    ArrayList result = new ArrayList();				
		try{	 
			    	conn = open();
			    	// Log.debug("Open connection");	    	 
			        //setTransaction 			    	 
			    	 sql=" SELECT type.TYPE_ID, type.TYPE_NAME, type.TYPE_DESC "+
			    		 " FROM "+INSTANT_DB_NAME+".type type "+
			    		 " ORDER BY type.TYPE_NAME ASC" ;			    	 
			    	  pstmt = conn.prepareStatement(sql);
				      rs = pstmt.executeQuery();
				      System.out.println("--->execute SQL Query.");
			    	  
				      int c=0;
			 		  while(rs.next()){	 			  
			 			 obj = new  Type();
			 			 obj.setTypeID(rs.getInt("TYPE_ID"));
			 			 obj.setTypeName(rs.getString("TYPE_NAME"));
			 			 obj.setTypeDesc(rs.getString("TYPE_DESC"));			 			 
			 			 result.add(obj);
			 			 c++;
			 		}	 		  
			 		//Log.debug("get UserInfo FetchSize :"+c);
			        //Commit Transaction
				}catch(Exception e){
					e.printStackTrace();
					// Log.debug(" "+e.getMessage());
				}
				finally{ 
					//close
					try{
						rs.close();
						pstmt.close();
					    close(conn); 
					}catch(Exception e){}		    
					//Log.debug("close connection ");
				} 			    
			   return result;
	}

}
