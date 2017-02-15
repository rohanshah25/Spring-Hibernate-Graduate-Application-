package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import gapp.model.CustomValue;
import gapp.model.dao.CustomvaluesDao;


@Repository
public class CustomvaluesDaoImpl implements CustomvaluesDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<CustomValue> listCustomvalue() {
		return entityManager.createQuery( "from CustomValue", CustomValue.class )
	            .getResultList();

	}

	@Override
	public CustomValue getCustomvalueById(int valueid) {
		 return entityManager.find( CustomValue.class, valueid );
		
	}

	@Override
	public List<CustomValue> listCustomvalue(int studentid) {
		List<CustomValue> forrmvalueList = entityManager.createQuery(" from CustomValue where studentid="+studentid,CustomValue.class).getResultList();
		return forrmvalueList;
	}

	@Override
	public CustomValue getCustomvalueById(int studentid, int controlid) {
		CustomValue frm=null;
		List<CustomValue> forrmvalueList = entityManager.createQuery(" from CustomValue where studentid="+studentid +" and contorlid="+controlid,CustomValue.class).getResultList();
		if(!forrmvalueList.isEmpty()){
			frm=forrmvalueList.get(0);
		}
		
		return frm;
	}

}
