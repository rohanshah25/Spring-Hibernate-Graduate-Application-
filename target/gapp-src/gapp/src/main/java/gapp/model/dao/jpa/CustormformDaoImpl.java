package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Academicrecord;
import gapp.model.CustomField;
import gapp.model.dao.CustormformDao;


@Repository
public class CustormformDaoImpl implements CustormformDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<CustomField> listCustomfield() {
		return entityManager.createQuery( "from CustomField", CustomField.class )
	            .getResultList();

	}

	@Override
	public CustomField getCustomformById(int controlid) {
		 return entityManager.find( CustomField.class, controlid );
	}

	@Override
	public List<CustomField> getCustomFormByProgram(int programid) {
		List<CustomField> result = entityManager.createQuery( " from CustomField where programid="+programid, CustomField.class ).getResultList();
		return result;
	}
	
	

}
