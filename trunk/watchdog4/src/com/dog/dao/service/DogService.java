package com.dog.dao.service;
import java.util.ArrayList;
import com.dog.model.bean.Dogger;
import com.dog.model.domain.DogForm;

/*
 * date:2011-12-15
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */


public interface DogService {
	
	public boolean insertDog(DogForm eDog) throws Exception;
	public boolean updateDog(DogForm eDog) throws Exception;
	public boolean deleteDog(String eId) throws Exception;
	public Dogger getDoger(String eId) throws Exception;
	public ArrayList  listDog(DogForm eDog) throws Exception;
	

}
