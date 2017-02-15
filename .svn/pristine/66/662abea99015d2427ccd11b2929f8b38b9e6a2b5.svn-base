package gapp.model.dao.jpa;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;








import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Academicrecord;
import gapp.model.Users;
import gapp.model.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao{
	
	
	@PersistenceContext
    private EntityManager entityManager;
	
	

	@Override
	public List<Users> getUsers() {
		return entityManager.createQuery("from Users", Users.class).getResultList();
	}


	@Override
	public Users getUserById(int userid) {
		return entityManager.find( Users.class, userid );
		
	}
	
	@Override
	@Transactional
	public Users addUser(Users user) {
		
			return entityManager.merge(user);
		}
	
	@Override
	@Transactional
	public Users updateUser(Users s) {
		
		
		try{
			Users p = (Users) entityManager.find(Users.class, new Integer(s.getUserid()));
			
			//p.setRole(s.getRole());
			return entityManager.merge(p);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return s;
		
	}

	@Override
	public Users removeUsers(int userid) {
		
		Users p = (Users) entityManager.find(Users.class, new Integer(userid));
		
		try{
			
			p.setActive(false);
			return entityManager.merge(p);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return p;
		

	}

	@Override
	public List<Users> login(String email, String password) {
		List<Users> user1 = entityManager.createQuery("from Users where email =:email and password =:password", Users.class).setParameter("email", email).setParameter("password", password)
				.getResultList();
		
		return user1;
	}

	
	
   }

	
	
	
	
	
	
	

