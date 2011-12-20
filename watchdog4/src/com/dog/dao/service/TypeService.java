package com.dog.dao.service;
import java.util.ArrayList;
import com.dog.model.bean.Type;
import com.dog.model.domain.TypeForm;

/*
 * date:2011-12-14
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */
public interface TypeService {
	
	public boolean insert(TypeForm eType) throws Exception;
	public boolean update(TypeForm eType) throws Exception;
	public boolean delete(int eId) throws Exception;
	public Type getType(int eId) throws Exception;
	public ArrayList  list() throws Exception;
}
