package gapp.model.dao.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		List<Academicrecord> academicrecord = entityManager.createQuery("from Academicrecord where studentid="+studentid, Academicrecord.class).getResultList();
		if(academicrecord.size()>0){
			return academicrecord.get(0);
		}
		return null;
	}
	@Transactional
	@Override
	public Academicrecord saveacademic(Academicrecord academicrecords) {
		// TODO Auto-generated method stub
		return entityManager.merge(academicrecords);
	}

	
	
	

	

}
