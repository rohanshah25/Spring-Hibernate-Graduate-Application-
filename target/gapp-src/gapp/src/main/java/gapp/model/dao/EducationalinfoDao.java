package gapp.model.dao;

import gapp.model.Educationalinfo;

import java.util.List;

public interface EducationalinfoDao {
	
	
	public List<Educationalinfo> listEducationalinfo();
    
    public Educationalinfo getEducationalinfoById(int educationalid);

}
