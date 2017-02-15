package gapp.model.dao;

import gapp.model.Student;


import java.util.List;

public interface StudentDao {
	
	public List<Student> listStudent();
    public Student getStudentById(int studentid);
    public Student getStudentByUserId(int userid);
    public Student getStudentByAcademic(int academicid);
    //public Student getStudentByApplicationId(int studentid);
    //public Student getStudentByApplicationId(int applicationid);
    public Student save(Student student);
    public Student update(Student student);
    
 
}
