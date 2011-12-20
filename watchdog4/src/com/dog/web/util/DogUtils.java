package com.dog.web.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/*
 * date:2011-12-12
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: this is class Utility for use  frequent 
 * */
public class DogUtils {
	
	//return format  YYYYMMDD,20110119
	public static String getYYYYmmDD(){
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd",Locale.US);
		 return sdf.format(date);
	}
	
	public static  String getSubString(String str){
		String result = "";
		if(str == null)
			return "";
		
		if(str.length()>60){
			 return result = str.substring(0,60)+"...";
		}else{
			return str;
		}	
	}

	//Generate New ID
    public static String GenNewId(int b){
      // String temp=""+(Integer.parseInt(b)+1);
       String temp=""+b;
       String newSp_id;
       switch(temp.length()){
         // case 1: newSp_id="00000"+temp; break; // case 2: newSp_id="0000"+temp; break; //case 1: newSp_id="000"+temp; break;
          case 1: newSp_id="00"+temp; break;
          case 2: newSp_id="0"+temp; break;
          default:newSp_id=temp;
       }
       return newSp_id;
    }

}
