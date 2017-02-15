package gapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import gapp.model.CustomField;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.Users;
import gapp.model.dao.CustormFieldDao;
import gapp.model.dao.DepartmentDAO;
import gapp.model.dao.ProgramDao;






import gapp.model.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DepartmentController {
	

	
	
	@Autowired
	private DepartmentDAO departmentdao;
	
	@Autowired
	private CustormFieldDao custormfielddao;
	

	@Autowired
	private ProgramDao programdao;
	
	@Autowired
	private UserDao userdao;
	
	
	@RequestMapping(value = "/users/admin/list.html", method = RequestMethod.GET)
    public String listDepartment(ModelMap models,HttpSession session) {
		//String userid = session.getAttribute("userid").toString();
		//Users u = userdao.getUserById((Integer.parseInt(userid)));
		//models.put("user", u);
		//List<Department> departments = departmentdao.getDepartments();
		if(session.getAttribute("userid") != null){
        models.put("department", new Department());
        models.put("listDepartment", this.departmentdao.getDepartments());
        return "/users/admin/list";
		}
		else{
			return "redirect:/login.html";
		}
    }


   @RequestMapping(value="/users/logout.html")
     public String logout(HttpSession session){
     session.invalidate();
	     return "redirect:/home.html";
}
	
	
   
   
  
   
 @RequestMapping(value="/users/admin/view/{departmentid}.html")
 public String view(@PathVariable Integer departmentid, ModelMap models,HttpSession session){
	 if(session.getAttribute("userid") != null){
	 Department department = departmentdao.getDepartmentById(departmentid);
	 			models.put("department",department);
	 			//System.out.println(department.getDepartmentid());
	 			//models.put("listDepartment", this.departmentdao.getDepartments());
	 			return "/users/admin/view";
	 	}
	 else{
		 return "redirect:/login.html";
	 }
	 }
 
	@RequestMapping(value = "/users/admin/adddepartment.html", method=RequestMethod.GET)
	public String adddepartment(ModelMap models,HttpSession session){
		if(session.getAttribute("userid") != null){
		models.put("department",new Department());
		return "/users/admin/adddepartment";
	}else{
			return "redirect:/login.html";
		}
	}
 
 @RequestMapping(value="/users/admin/adddepartment.html",method= RequestMethod.POST)
 public String adddepartment(@ModelAttribute("department") Department department,HttpSession session){
	 if(session.getAttribute("userid") != null){
	
	 		
			if(department.getDepartmentid() == 0){
				department = departmentdao.addDepartment(department);
			}
				return"redirect:/users/admin/list.html"; 
	 }	
	 else{
		 
		 return "redirect:/login.html";
	 }
				 			
	 }
 
	@RequestMapping(value = "/users/admin/addprogram.html", method=RequestMethod.GET)
	public String addprogram(ModelMap models, HttpSession session){
		if(session.getAttribute("userid") != null){
		models.put("program",new Program());
		List<Department> dep = departmentdao.getDepartments();
		System.out.println(dep);
		models.put("depts", dep);
		return "/users/admin/addprogram";
		}
		else{
			return "redirect:/login.html";
		}
	}

	@RequestMapping(value="/users/admin/addprogram.html", method= RequestMethod.POST)
	public String addprogram(@ModelAttribute("program") Program program,HttpSession session){
		if(session.getAttribute("userid") != null){
			//System.out.println(program.getDepartment());
				
				program = programdao.addProgram(program);
				return"redirect:/users/admin/list.html"; 
 
	}else{
			return "redirect:/login.html";
		}
	}
	
	

	@RequestMapping(value = "/users/admin/addadditional.html", method=RequestMethod.GET)
	public String addadditional(ModelMap models, HttpSession session){
		if(session.getAttribute("userid") != null){
		models.put("additional",new CustomField());
		List<Department> dep = departmentdao.getDepartments();
		System.out.println(dep);
		models.put("addi", dep);
		return "/users/admin/addadditional";
	}else{
			return "redirect:/login.html";
		}
	}
	
	@RequestMapping(value="/users/admin/addadditional.html", method= RequestMethod.POST)
	public String addadditional(@ModelAttribute("additional") CustomField additional,HttpSession session){
		if(session.getAttribute("userid") != null){
				System.out.println(additional.getDepartment());	
				additional = custormfielddao.addadditional(additional);
				return "redirect:/users/admin/list.html"; 
 
	}	else{
			return "redirect:/login.html";
			}
	}
	
	@RequestMapping(value = "/users/admin/editdepartment/{id}.html", method = RequestMethod.GET)
    public String editDepartment(@PathVariable Integer id, ModelMap models,HttpSession session ){
		//System.out.println(id);
		if(session.getAttribute("userid") != null){
		models.put("department", departmentdao.getDepartmentById(id));
        return "/users/admin/editdepartment";
        
    }else{
    		return "redirect:/login.html";
    	}
    }
	
	@RequestMapping(value = "/users/admin/editdepartment/{id}.html", method = RequestMethod.POST)
    public String editDepartment( @ModelAttribute("department") Department department, @PathVariable Integer id, ModelMap models,HttpSession session ){
		if(session.getAttribute("userid") != null){
		department.setDepartmentid(id);
		departmentdao.saveDepartment( department);
        models.put("department",department);
        return "redirect:/users/admin/view/{id}.html";
    }else{
    	return "redirect:/login.html";
    }
    }
	
	@RequestMapping(value = "/users/admin/editprogram/{id}/{programid}.html", method = RequestMethod.GET)
    public String editprogram(@PathVariable Integer programid, ModelMap models,HttpSession session ){
		if(session.getAttribute("userid") != null){
		models.put("program", programdao.getProgramById(programid));
		List<Department> dep = departmentdao.getDepartments();
		models.put("depts", dep);
        return "/users/admin/editprogram";
        
    }else{
    		return "redirect:/login.html";
    	}
    }
	
	@RequestMapping(value = "/users/admin/editprogram/{id}/{programid}.html", method = RequestMethod.POST)
    public String editprogram( @ModelAttribute("program") Program program,HttpSession session, @PathVariable Integer id, @PathVariable Integer programid, ModelMap models ){
		if(session.getAttribute("userid") != null){
		program.setDepartment(departmentdao.getDepartmentById(id));
		program.setProgramid(programid);
		programdao.saveProgram(program);
        models.put("program",program);
        return "redirect:/users/admin/view/{id}.html";
    } else {
    	return "redirect:/login.html";
    }
    }
	
	   
    @RequestMapping(value = "/users/admin/editadditional/{id}/{controlid}.html", method = RequestMethod.GET)
    public String editadditional( @PathVariable Integer id, @PathVariable Integer controlid, ModelMap models,HttpSession session ){
    	if(session.getAttribute("userid") != null){
    	CustomField cusstominfo = custormfielddao.getCustomformById(controlid);
    	
        models.put("customfield",cusstominfo);
        List<Department> dep1 = departmentdao.getDepartments();
        models.put("depta", dep1);
        return "users/admin/editadditional";
    } else{
    		return "redirect:/login.html";
    	}
    }
    
    @RequestMapping(value = "/users/admin/editadditional/{id}/{controlid}.html", method = RequestMethod.POST)
    public String editadditional( @ModelAttribute("customfield") CustomField customfield, @PathVariable Integer id, 
    		@PathVariable Integer controlid, ModelMap models , HttpSession session ){
    	if(session.getAttribute("userid") != null){
    	customfield.setDepartment(departmentdao.getDepartmentById(id));
    	customfield.setControlid(controlid);
    	custormfielddao.save( customfield );
        models.put( "customfield",customfield);
        return "redirect:/users/admin/view/{id}.html";
	
	
    }else{
    		return "redirect:/login.html";
    	}
    }
    
    @RequestMapping(value = "/users/admin/removeProg/{id}/{programid}.html", method = RequestMethod.GET)
    public String removeProgram( @PathVariable Integer id, @PathVariable Integer programid, ModelMap models ){
    	Program program = programdao.getProgramById(programid);
    	programdao.remove(program);
        return "redirect:/users/admin/view/{id}.html";
    }
    
    @RequestMapping(value = "/users/admin/removeCust/{id}/{controlid}.html", method = RequestMethod.GET)
    public String removeAdditional( @PathVariable Integer id, @PathVariable Integer controlid, ModelMap models ){
    CustomField custominfo = custormfielddao.getCustomformById(controlid);
    custormfielddao.removeCustom(custominfo);
        return "redirect:/users/admin/view/{id}.html";
    }
  
    
    
   }		
