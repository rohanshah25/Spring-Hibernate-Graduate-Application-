package gapp.model.dao.jpa;


import gapp.model.Student;
import gapp.model.dao.StudentDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


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

	
	

}
