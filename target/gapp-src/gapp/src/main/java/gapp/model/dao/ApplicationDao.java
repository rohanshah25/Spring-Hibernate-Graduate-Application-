package gapp.model.dao;

import gapp.model.Application;

import java.util.List;

public interface ApplicationDao {


	public List<Application> listApplication();
	
	public List<Application> listSubmitted();
	//public Application getApplicationById(int applicationid);

}