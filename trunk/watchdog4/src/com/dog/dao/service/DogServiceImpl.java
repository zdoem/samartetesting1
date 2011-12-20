package com.dog.dao.service;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.dog.model.bean.Dogger;
import com.dog.model.domain.DogForm;
import com.dog.web.util.DogUtils;
import com.dog.web.util.GenID;


/*
 * date:2011-12-15
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */

public class DogServiceImpl  extends Common implements DogService{
	
	static String INSTANT_DB_NAME ="db2_watchdog";
	static{
		String dataSource = "jdbc/Datasource_watchdog";
		Common.setConfigForConnectionPool("", dataSource);		
		/*Common.setConfig(host, port, dns, usr, pwd);*/
	}
	

	@Override
	public boolean insertDog(DogForm eDog) throws Exception {	
				CallableStatement clbstmt = null;
				Connection conn = null;
				int i = 1;
			    //***********
				boolean isIns = true; //true is fail
				try{
						conn = open();
						conn.setAutoCommit(false);
						System.out.println("-->Before Insert");
					    //Insert to DB
						clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".INSERT_DOG(?,?,?,?,?,?)}");
						clbstmt.setLong(i++,Long.parseLong(GenID.getInstance().getId()));
						clbstmt.setInt(i++,Integer.parseInt(eDog.getDogTypeIdDDL()));	
						clbstmt.setString(i++,eDog.getDogSubject());	
						clbstmt.setString(i++,eDog.getDogDesc());	
						clbstmt.setString(i++,eDog.getDogSolution());	
						clbstmt.setString(i++,eDog.getDogComment1());	

					    isIns = clbstmt.execute();
						//result = clbstmt.executeUpdate();	
					    System.out.println("-->Execute Insert");		    
					    conn.commit();
						conn.setAutoCommit(true);
				}
				catch(Exception e){
					 e.printStackTrace();
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
				return isIns;//#End		
	}

	@Override
	public boolean updateDog(DogForm eDog) throws Exception {
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		boolean isUpd = true; //true is fail
		try{	
			conn = open();
			conn.setAutoCommit(false);
			System.out.println("-->Before Update");
			 
			//Update to DB
			clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".UPDATE_DOG(?,?,?,?,?,?)}");
			
			System.out.println(eDog.getDogId());
			System.out.println(eDog.getDogSubject());
			
			clbstmt.setString(i++,eDog.getDogId());
			clbstmt.setString(i++,eDog.getDogSubject());
			clbstmt.setString(i++,eDog.getDogDesc());
			clbstmt.setString(i++,eDog.getDogSolution());
			clbstmt.setString(i++,eDog.getDogComment1());
			clbstmt.setInt(i++,Integer.parseInt(eDog.getDogTypeIdDDL()));
			isUpd = clbstmt.execute();
			System.out.println("--> updateDog() success");
			//result = clbstmt.executeUpdate();		    
			conn.commit();
			conn.setAutoCommit(true);
		}catch(Exception e){
			 e.printStackTrace();
			//Log.debug("Insert Exception e:"+e.toString());
			try{
				conn.rollback();
			}catch(Exception ex){}
		}finally{
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
	public boolean deleteDog(String eId) throws Exception {
		// TODO Auto-generated method stub					
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		//***********
		boolean isDel = true;  //true is success,false is error
		try{
				//connection db
				conn = open();
				conn.setAutoCommit(false);
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".DELETE_DOG(?)}");
				clbstmt.setString(i++,eId);				    
				clbstmt.execute();				
				//result = clbstmt.executeUpdate();	
				System.out.println("--->Execute delete()");     			        
				//get out parameter
				conn.commit();	
				conn.setAutoCommit(true);
			}catch(Exception e){
				
				e.fillInStackTrace();
				try{
					conn.rollback();
				}catch(Exception ex){}
				isDel = false;
			}finally{
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
			return isDel;
	}
	

	@Override
	public Dogger getDoger(String eId) throws Exception {
		// TODO Auto-generated method stub					
		CallableStatement clbstmt = null;
		Connection conn = null;
		int i = 1;
		Dogger obj;
		try{
				//connection db
				conn = open();
				clbstmt = conn.prepareCall("{call "+INSTANT_DB_NAME+".GET_DOG(?,?,?,?,?,?,?,?,?)}");
				
				clbstmt.setString(1,eId.trim());
				clbstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(3, java.sql.Types.VARCHAR);	
				clbstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
				clbstmt.registerOutParameter(5, java.sql.Types.VARCHAR);					
				clbstmt.registerOutParameter(6, java.sql.Types.VARCHAR);	
				clbstmt.registerOutParameter(7, java.sql.Types.VARCHAR);	
				clbstmt.registerOutParameter(8, java.sql.Types.VARCHAR);	
				clbstmt.registerOutParameter(9, java.sql.Types.INTEGER);	
				clbstmt.execute();
				//result = clbstmt.executeUpdate();	
				System.out.println("--->Execute getDoger()");     			        
				//----------->get out parameter
				obj = new Dogger();			
				obj.setDogId(""+eId);  
				obj.setDogSubject(clbstmt.getString("p_dogSubject")); 
				obj.setDogDesc(clbstmt.getString("p_dogDesc")); 
				obj.setDogSolution(clbstmt.getString("p_dogSolution"));
				obj.setDogComment1(clbstmt.getString("p_dogComment1"));
				obj.setCreateDate(clbstmt.getString("p_createDate"));
				obj.setUpdateDate(clbstmt.getString("p_updateDate"));
				obj.setDogTypeName(clbstmt.getString("p_dogTypeName"));
				obj.setDogTypeId(clbstmt.getInt("p_dogTypeId"));
			}catch(Exception e){
					obj = null;
				    e.printStackTrace();
			}finally{
			   try{
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
	public ArrayList listDog(DogForm eDog) throws Exception {
		Connection conn		=	null;
		ResultSet rs 		= 	null;
		PreparedStatement pstmt = null;
		String sql				="";
		Dogger  dog =null;
		ArrayList result = new ArrayList();		
		try{	 
			 conn = open();    	 
			 //setTransaction
			  sql=	" SELECT doger.D_ID, doger.D_TYPE_ID, doger.D_SUBJECT, "+
					" doger.D_DESC, doger.D_SOLUTION, doger.D_COMMENT1, "+
					" doger.UPDATE_DATE, doger.CREATE_DATE, type.TYPE_NAME," +
					"  type.TYPE_DESC,type.TYPE_ID " +
					" FROM db2_watchdog.doger doger INNER JOIN db2_watchdog.type type " +
					" ON (doger.D_TYPE_ID = type.TYPE_ID) " ;
			  String Where = " WHERE ";

			 if (!eDog.getDogSubject().equals("")) { 
				 Where+= " (doger.D_SUBJECT = ? ) OR (doger.D_SUBJECT LIKE ?)   AND";
             	//where+= " (user.Login = ? ) AND"; 
             }
             if (!eDog.getDogSolution().equals("")) {
            	 Where += " (doger.D_SOLUTION = ? ) OR (doger.D_SOLUTION LIKE ?)   AND"; 
             }
             if(!eDog.getDogTypeIdDDL().equals("")){
            	 Where += " (doger.D_TYPE_ID = ? )   AND"; 
             }
             
             //Cutting
             sql += Where.trim().substring(0, Where.length()-7);
             sql +=" ORDER BY doger.D_ID ASC, doger.D_SUBJECT ASC ";
             
            // System.out.println("SQL :"+sql);
			 pstmt = conn.prepareStatement(sql);
			 int i=1;
			 if (!eDog.getDogSubject().equals("")) { 
	              pstmt.setString(i++, eDog.getDogSubject());
	              pstmt.setString(i++,"%"+eDog.getDogSubject()+"%");	                	
	         }
			 if (!eDog.getDogSolution().equals("")) {
	               pstmt.setString(i++, eDog.getDogSolution());
	               pstmt.setString(i++,"%"+eDog.getDogSolution()+"%");
	          }
			  if(!eDog.getDogTypeIdDDL().equals("")){
	               pstmt.setInt(i++, Integer.parseInt(eDog.getDogTypeIdDDL()));
	          }
			
			rs = pstmt.executeQuery();
			System.out.println("--->execute SQL Query.");
					    	  
			int c=0;
			while(rs.next()){	 			  
				 	dog = new Dogger();	
				 	dog.setDogId(""+rs.getLong("D_ID"));
				 	dog.setDogSubject(DogUtils.getSubString(rs.getString("D_SUBJECT")));
				 	dog.setDogDesc(DogUtils.getSubString(rs.getString("D_DESC")));
				 	dog.setDogSolution(DogUtils.getSubString(rs.getString("D_SOLUTION")));
				 	dog.setDogComment1(DogUtils.getSubString(rs.getString("D_COMMENT1")));
				 	dog.setCreateDate(rs.getDate("CREATE_DATE").toString());
				 	dog.setUpdateDate(rs.getDate("UPDATE_DATE").toString());				 	
				 	dog.setDogTypeName(rs.getString("TYPE_NAME"));				 	
				 	result.add(dog);	
				 	c++;
			 	}	
			}catch(Exception e){
				 e.printStackTrace();
				// Log.debug(" "+e.getMessage());
			}finally{ 
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
