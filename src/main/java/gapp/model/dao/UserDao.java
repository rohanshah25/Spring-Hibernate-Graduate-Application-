package gapp.model.dao;

import gapp.model.CustomField;
import gapp.model.Users;

import java.util.List;

public interface UserDao {
	

    List<Users> getUsers();
    public Users getUserById(int userid);
    Users addUser(Users user);
    Users updateUser(Users user);
    List<Users> login(String email, String password);
	Users removeUsers(int userid);
	
	//Users getUsersByRoleName(String name);
	
	
    
    	
    	
    
    
 

}
