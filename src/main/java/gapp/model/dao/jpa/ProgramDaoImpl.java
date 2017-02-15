package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
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

	
	@Override
	@Transactional
	public Program addProgram(Program program) {
		
		return entityManager.merge(program);
		
	}

	@Override
	@Transactional
	public Program saveProgram(Program program) {
		return entityManager.merge( program );
	}	
	
	
	@Transactional
	public void remove(Program program){
		entityManager.remove(program);
		
	}

	@Override
	public List<Program> listProgram(int departmentid) {
	
		return entityManager.createQuery("from Program where department.departmentid=" +departmentid,Program.class).getResultList();
	}
	
	
	
	
}


