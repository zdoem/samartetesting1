package com.samart.etesting.web.util;

public class Utitity {

	public  static boolean isSession(Object userLogin, Object status, String role) {
		try {		
			if (!(userLogin.equals("") || userLogin == null || (!status.equals(role)))){
				//session expire
				return true;
			}else{
				//session keep alive
				return false;
			}
		} catch (NullPointerException e) {
			//session keep alive
			return false;
		}
	}

}
