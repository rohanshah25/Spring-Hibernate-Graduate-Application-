package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Academicrecord;
import gapp.model.CustomField;
import gapp.model.Department;
import gapp.model.dao.CustormFieldDao;


@Repository
public class CustormFieldDaoImpl implements CustormFieldDao {

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

	@Override
	@Transactional
	public CustomField addadditional(CustomField additional) {
		return entityManager.merge(additional);
	}

	
	@Override
	@Transactional
	public CustomField save(CustomField additional){
		return entityManager.merge(additional);
		
		
	}
	@Override
	@Transactional
	public void removeCustom(CustomField additional){
		entityManager.remove(additional);
		
	}

	@Override
	public List<CustomField> getCustomFormByDepartment(int departmentid) {
			List<CustomField> result = entityManager.createQuery( " from CustomField where departmentid="+departmentid, CustomField.class ).getResultList();
			return result;
		}
	}

