package gapp.model.dao.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import org.springframework.stereotype.Repository;

import gapp.model.Academicrecord;
import gapp.model.Department;
import gapp.model.dao.AcademicrecordDao;


@Repository
public class AcademicrecordDaoImpl implements AcademicrecordDao {
	
		@PersistenceContext
		private EntityManager entityManager;


		public List<Academicrecord> listAcademicrecord() {
			
				return entityManager.createQuery( "from Academicrecord", Academicrecord.class )
			            .getResultList();
	}

	public Academicrecord getAcademicrecordById(int academicrecordid) {
		 
		     return entityManager.find( Academicrecord.class, academicrecordid );
				
	}

	
	public Academicrecord getAcademicrecordByStudentId(int studentid) {
		Academicrecord p=null;
		List<Academicrecord> result = entityManager.createQuery( " from Academicrecord where studentid="+studentid, Academicrecord.class ).getResultList();
		if(!result.isEmpty()){
			p=result.get(0);
		}
		return p;
	}

}
