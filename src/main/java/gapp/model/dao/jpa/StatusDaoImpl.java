package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Academicrecord;
import gapp.model.Status;
import gapp.model.dao.StatusDao;

@Repository
public class StatusDaoImpl implements StatusDao{
	
	


	@PersistenceContext
    private EntityManager entityManager;


	

	@Override
	public List<Status> listStatus() {
		 return entityManager.createQuery( "from Status order by statusid", Status.class )
		            .getResultList();
	}

	@Override
	public Status getStatusById(int statusid) {
		
		return entityManager.find( Status.class, statusid );
		
	}

	@Override
	@Transactional
	public Status saveStatus(Status status) {
		
		return entityManager.merge(status);
	}


	
	@Override
	public List<Status> liststatus(int applicationid) {
		
		return entityManager.createQuery("from Status where application.applicationid=" +applicationid,Status.class).getResultList();
	}
	
}
