package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;



import org.springframework.transaction.annotation.Transactional;

import gapp.model.Academicrecord;
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

	@Override
	public List<Educationalinfo> getEducationalByStudentId(int studentid) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Educationalinfo where student.studentid=" +studentid,Educationalinfo.class).getResultList();
	}

	@Override
	@Transactional
	public Educationalinfo saveeducational(Educationalinfo educationalinfo) {
		// TODO Auto-generated method stub
		return entityManager.merge(educationalinfo);
	}

	@Override
	@Transactional
	public void removeEducationalinfo(int educationalid) {
		
		Educationalinfo p = (Educationalinfo) entityManager.find(Educationalinfo.class, new Integer(educationalid));
			try {
				if (null != p) {
					entityManager.remove(p);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}


