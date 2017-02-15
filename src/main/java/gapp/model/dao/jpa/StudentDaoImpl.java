package gapp.model.dao.jpa;


import gapp.model.Student;
import gapp.model.dao.StudentDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class StudentDaoImpl implements StudentDao {
	
	
	
	@PersistenceContext
    private EntityManager entityManager;


	

	@Override
	public List<Student> listStudent() {
		 return entityManager.createQuery( "from Student order by studentid", Student.class )
		            .getResultList();
	}

	@Override
	public Student getStudentById(int studentid) {
		
		return entityManager.find( Student.class, studentid );
		
	}

	
	public Student getStudentByUserId(int userid) {
		List<Student> stu=entityManager.createQuery( "from Student where userid="+userid, Student.class ).getResultList();
		if(stu.size()>0){
			return stu.get(0);
		}
		return null;
	
		
	}

	

	@Override
	@Transactional
	public Student save(Student student) {
		return entityManager.merge(student);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return entityManager.merge(student);
	}

	@Override
	public Student getStudentByAcademic(int academicid) {
		List<Student> stud = entityManager.createQuery("from Student where academicrecord_academicrecordid="+academicid,Student.class).getResultList();
		if(stud.size()>0){
			return stud.get(0);
		}
		return null;
	}

	

	

	
	

}
