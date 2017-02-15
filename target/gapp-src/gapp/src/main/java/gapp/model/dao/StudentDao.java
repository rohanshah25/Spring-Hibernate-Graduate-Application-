package gapp.model.dao;

import gapp.model.Student;


import java.util.List;

public interface StudentDao {
	
	public List<Student> listStudent();
    public Student getStudentById(int studentid);
    
 
}
