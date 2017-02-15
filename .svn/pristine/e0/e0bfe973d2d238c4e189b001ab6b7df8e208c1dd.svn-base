package gapp.web.controller;

import javax.servlet.ServletContext;

import gapp.model.Users;
import gapp.model.dao.UserDao;
import gapp.web.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;




@Controller

public class UserController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserDao userdao;
	
	 @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(userValidator);
	    }
	    
	@RequestMapping(value = "/add.html", method=RequestMethod.GET)
	public String add(ModelMap models){
		models.put("user",new Users());
		return "add";
				
	}
	
	@RequestMapping(value= "/add.html", method=RequestMethod.POST)
	public String add(@ModelAttribute("user") Users user, BindingResult bindingResult)
	{	
		
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors())
    		return "add";
		
		user.setActive(true);
		System.out.println("Hello");
		user = userdao.addUser(user);
		return "redirect:login.html";
	}
	

	
	    
	    
	    

}
