package gapp.model.dao.jpa;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.Student;
import gapp.model.dao.ApplicationDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





@Repository
public class ApplicationDaoImpl implements ApplicationDao  {
	
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Application> listApplication(int id) {
		
		return entityManager.createQuery( "from Application where applicant_userid = :id", Application.class ).setParameter("id", id)
	            .getResultList();
	
		}


/*@Override
	public List<Application> listSubmitted() {
		return entityManager.createQuery( "from Application where student.user.username = 'student1' and student.user.email = 'student1@localhost.localdomain'", Application.class )
	            .getResultList();
		
	}*/


@Override
public Application getApplicationById(int applicationid) {
	// TODO Auto-generated method stub
	return entityManager.find(Application.class, applicationid );
}




@Override
@Transactional
public Application saveApplication(Application application) {
	
	return entityManager.merge(application);
 }


@Override
public List<Application> getApplicationByUserId(int userid) {
	List<Application> app =entityManager.createQuery( "from Application where applicant_userid="+userid, Application.class ).getResultList();
	
	return app;
}
	
@Override
public List<Application> getApplicationByStudentId(int studentid){
	List<Application> stu =entityManager.createQuery("from Application where applicantid="+studentid, Application.class).getResultList();
	
				return stu;
	}







}
