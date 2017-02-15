package gapp.model.dao;

import java.util.List;

import gapp.model.CustomValue;

public interface CustomvaluesDao {
	
	public List<CustomValue> listCustomvalue();
	 public CustomValue getCustomvalueById(int valueid);
	 public List<CustomValue> listCustomvalue(int studentid);
	 public CustomValue getCustomvalueById(int studentid,int controlid);

}
