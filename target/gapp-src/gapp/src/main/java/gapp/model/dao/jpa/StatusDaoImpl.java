package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Status;
import gapp.model.dao.StatusDao;

@Repository
public class StatusDaoImpl implements StatusDao{
	
	


	@PersistenceContext
    private EntityManager entityManager;


	

	@Override
	public List<Status> listStatus() {
		 return entityManager.createQuery( "from Student order by statusid", Status.class )
		            .getResultList();
	}

	@Override
	public Status getStatusById(int statusid) {
		
		return entityManager.find( Status.class, statusid );
		
	}
	
}
