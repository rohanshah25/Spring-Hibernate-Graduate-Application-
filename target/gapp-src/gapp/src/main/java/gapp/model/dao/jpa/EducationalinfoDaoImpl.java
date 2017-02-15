package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import gapp.model.Educationalinfo;
import gapp.model.dao.EducationalinfoDao;




@Repository
public class EducationalinfoDaoImpl implements EducationalinfoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Educationalinfo> listEducationalinfo() {
		return entityManager.createQuery( "from Educationalinfo", Educationalinfo.class )
	            .getResultList();
	}

	@Override
	public Educationalinfo getEducationalinfoById(int educationalid) {
	     return entityManager.find( Educationalinfo.class, educationalid );
			     
	}

}
