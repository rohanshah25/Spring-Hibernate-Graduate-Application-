package gapp.model.dao.jpa;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import  gapp.model.Department;
import gapp.model.dao.DepartmentDAO;


	
	
		@Repository
		public class DepartmentDaoImpl implements DepartmentDAO {
		
		
		@PersistenceContext
	    private EntityManager entityManager;

		
		@Override
		public List<Department> getDepartments() {
			return entityManager.createQuery( "from Department", Department.class )
		            .getResultList();
		
		}


		public Department getDepartmentById(int departmentid) {
			 
			     return entityManager.find( Department.class, departmentid );
				}


		@Override
		@Transactional
		public Department addDepartment(Department department) {
			
			return entityManager.merge(department);
			
		}

		
		@Override
		@Transactional
		public Department saveDepartment(Department department) {
			return entityManager.merge( department );
		}	

}
