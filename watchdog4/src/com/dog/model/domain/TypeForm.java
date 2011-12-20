package com.dog.model.domain;

import java.io.Serializable;
/*
 * date:2011-12-13
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: 
 * */



public class TypeForm  implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	String typeId;
	String typeName;
	String typeDesc;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	
}
