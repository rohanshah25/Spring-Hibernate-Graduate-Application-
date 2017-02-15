package gapp.web.validator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.Users;
import gapp.model.dao.UserDao;

@Component
public class UserValidator implements Validator{

	@Autowired
    private UserDao userdao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Users user = (Users) target;
		System.out.println("hey");
		if(!StringUtils.hasText(user.getFirstName()))
			errors.rejectValue("firstName", "error.field.empty");
		if(!StringUtils.hasText(user.getLastName()))
			errors.rejectValue("lastName", "error.field.empty");
		
		if(!StringUtils.hasText(user.getEmail()))
			errors.rejectValue("email", "error.field.empty");
		else if (hasEmail(user.getEmail()))
			errors.rejectValue("email", "error.email.taken");
		else if (isValidEmail(user.getEmail()))
			errors.rejectValue("email","error.email.invalid");
		if(!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.field.empty");
		
	}
	
	
	public static boolean isValidEmail(String email){
		String reg = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)* @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pa = Pattern.compile(reg);
        Matcher m = pa.matcher(email);
        return m.matches();
	}
	
	

	private boolean hasEmail(String email) {
		ArrayList<Users> users = (ArrayList<Users>)userdao.getUsers();
		for(Users user: users){
			if(user.getEmail().equalsIgnoreCase(email))
				return true;
		}
		return false;
	
	}
}