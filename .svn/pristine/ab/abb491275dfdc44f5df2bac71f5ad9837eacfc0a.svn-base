package gapp.model.dao.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Users;
import gapp.model.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao{
	
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<Users> getUsers() {
		 return entityManager.createQuery( "from Users order by userid", Users.class )
		            .getResultList();
		
		
	}

	@Override
	public Users getUserById(int id) {
		return entityManager.find( Users.class, id );
		
	}


}
