package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Program;

import gapp.model.dao.ProgramDao;



@Repository
public class ProgramDaoImpl implements ProgramDao {

	@PersistenceContext
    private EntityManager entityManager;


	public List<Program> listProgram() {
		 return entityManager.createQuery( "from Program order by programid", Program.class )
		            .getResultList();
	}

	public Program getProgramById(int programid) {
		return entityManager.find( Program.class, programid);
	}
}
