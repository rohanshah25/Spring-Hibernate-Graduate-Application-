package gapp.model.dao;

import gapp.model.Academicrecord;
import gapp.model.Status;

import java.util.List;

public interface StatusDao {
	
	public List<Status> listStatus();
    public Status getStatusById(int statusid);
    public Status saveStatus(Status status);
    public List<Status> liststatus(int applicationid);

}
