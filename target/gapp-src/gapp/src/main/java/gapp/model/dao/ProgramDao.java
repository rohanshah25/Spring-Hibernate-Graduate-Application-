package gapp.model.dao;

import gapp.model.Program;

import java.util.List;

public interface ProgramDao {
	
	
	  public List<Program> listProgram();
	    public Program getProgramById(int programid);

}
