package gapp.model.dao;

import gapp.model.Academicrecord;

import java.util.List;

public interface AcademicrecordDao {
	
	
	 public List<Academicrecord> listAcademicrecord();
	    public Academicrecord getAcademicrecordById(int academicrecordid);
	    public Academicrecord getAcademicrecordByStudentId(int studentid);
	    public Academicrecord saveacademic(Academicrecord academicrecords);

}