package gapp.web.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import gapp.model.Student;
import gapp.model.Users;
import gapp.model.dao.StudentDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.LoginValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"user"})
public class LoginController {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@RequestMapping(value = "/users/admin/{userid}/adminhome.html", method = RequestMethod.GET)
	public String adminhome(HttpSession session){
		if(session.getAttribute("userid")!=null){
			 return "/users/admin/adminhome";
		}
		else{
			return "redirect:/login.html";
		}
		
	}
	
	@RequestMapping(value = "/users/student/underconstruction.html", method = RequestMethod.GET)
	public String studenthome(){
		
		return "/users/student/underconstruction";
		
	}
	
	@RequestMapping(value = "/users/staff/underconstruction.html", method = RequestMethod.GET)
	public String staffhome(){
		
		return "/users/staff/underconstruction";
		
	}
	
	
	
	
	
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
		public String login(ModelMap models){
		models.put("user", new Users());
		//System.out.println("One");
		return "login";
		
	}
	
	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") Users user, BindingResult result, HttpSession session){
		//System.out.println("two");
		loginValidator.validate(user, result);
		if(result.hasErrors()) {return "login";}
		
		Users user9 = userdao.login(user.getEmail(), user.getPassword()).get(0);
		System.out.println(user9.getRoles());
		if(user9!=null){
			
			session.setAttribute("userid",user9.getUserid());
		}
		
		if(user9.getRoles().contains("ROLE_ADMIN")){
			return "redirect:/users/admin/"+user9.getUserid()+"/adminhome.html";

		}
		else if(user9.getRoles().contains("ROLE_STAFF")){
			
			
			return "redirect:/users/staff/underconstruction.html";
		}
		
		else {
			//System.out.println("Hey");
			//Student s = studentdao.getStudentByUserId(user9.getUserid());
			//session.setAttribute("student",s);
			
			return "redirect:/users/student/applicationlist/"+user9.getUserid()+".html";
			
			
			
			
		}	
		
		
		
	}
	
	@RequestMapping(value="/logout.html")
	public String logout(HttpSession s){
		s.invalidate();
		return "redirect:/home.html";
	}
	
}
	
