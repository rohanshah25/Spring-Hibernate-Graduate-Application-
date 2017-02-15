package gapp.web.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gapp.model.Academicrecord;
import gapp.model.Application;
import gapp.model.CustomField;
import gapp.model.CustomValue;
import gapp.model.Department;
import gapp.model.Educationalinfo;
import gapp.model.Program;
import gapp.model.Status;
import gapp.model.Student;
import gapp.model.Users;
import gapp.model.dao.AcademicrecordDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.CustomvaluesDao;
import gapp.model.dao.CustormFieldDao;
import gapp.model.dao.DepartmentDAO;
import gapp.model.dao.EducationalinfoDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.StatusDao;
import gapp.model.dao.StudentDao;
import gapp.model.dao.UserDao;









































import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@SessionAttributes({"academicrecord", "application"})
public class ApplicationController {
	
	
	@Autowired
	private ApplicationDao applicationdao;
	
	
	@Autowired
	private UserDao userdao;
	
	
	
	@Autowired
	private ProgramDao programdao;
	
	@Autowired
	private CustormFieldDao custormfielddao;
	
	@Autowired
	private CustomvaluesDao customdao;
	
	@Autowired
	private AcademicrecordDao academicrecorddao;
	
	@Autowired
	private DepartmentDAO departmentdao;
	
	@Autowired
	private StatusDao statusdao;
	
	@Autowired
	private EducationalinfoDao educationalinfodao;
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private CustomvaluesDao customvaluesdao;
	
	@Autowired
	private ServletContext servletcontext;
	
	
	
	static final ObjectMapper objectMapper = new ObjectMapper();
	
	
	   private java.io.File getFileDirectory(){
	    	String path = servletcontext.getRealPath("WEB-INF/files");
	    	return new java.io.File(path);
	    }
	
	
	@RequestMapping(value = "/users/student/applicationlist/{id}.html", method = RequestMethod.GET)
    public String listApplication(ModelMap models, @PathVariable int id , HttpSession session) {
		if(session.getAttribute("userid") != null) {
			String userid = session.getAttribute("userid").toString();
			Users u = userdao.getUserById(id);
			models.put("user", u);
			
			ArrayList<Application> appliedApplications = (ArrayList<Application>) applicationdao.listApplication(Integer.parseInt(userid));
			
			models.put("application", new Application());
	        models.put("listapplication", appliedApplications);
	        
	        return "/users/student/applicationlist";
			
		} else {
			
			return "redirect:/login.html";
			
		}
		
        
		
 	
        
    }
		 
	  @RequestMapping(value="/users/student/applicationview/{applicationid}.html")
	  public String applicationview(@PathVariable Integer applicationid, ModelMap models,HttpSession session){
		  if(session.getAttribute("userid") != null) {
	 	 Application application = applicationdao.getApplicationById(applicationid);
	 
	 	 			models.put("applications",application);
	 	 			
	 	 			
	 	 			return "/users/student/applicationview";
	 	 			
	 	 				 	 }
		  
		  
		  else{
			return "redirect:/login.html";  
		  	}
		  }
	
	  @RequestMapping(value="/users/student/newapplication/{id}.html",method = RequestMethod.GET)
	  public String chooseDepartment(@PathVariable int id, ModelMap models, HttpSession session){
		  if(session.getAttribute("userid") != null) {
		  Users user = userdao.getUserById(id);
		  models.put("user", user);
			
			Student s= studentdao.getStudentByUserId(id);
			models.put("student", s);
			List<Department> dept = departmentdao.getDepartments();
			
			
			Application application = new Application();
			//application.setApplicant(user);
			
			//Student stu = new Student();
			//application.setStudent(stu);
			//List<Department> dept=new ArrayList<Department>();
			//application.setDepartment();
			
			//application.setDepartment(dept);
			models.put("application", application);
			
			models.put("departmentlist",dept);
			
			
		  return "/users/student/newapplication";
		  }
		  else{
			  
			  return "redirect:/login.html";
		  }
	  }
	  
	  
	    @RequestMapping(value="/users/student/newapplication/{id}.html",method = RequestMethod.POST)
	    public String chooseDepartment(@ModelAttribute("application") Application application, @PathVariable int id,HttpServletRequest request, HttpServletResponse response, ModelMap models,HttpSession session){
	    	 if(session.getAttribute("userid") != null) {
	    	System.out.println(request.getParameter("departmentname"));
	    	Application app = new Application();
	    	Users us = userdao.getUserById(id);
	    	app.setApplicant(us);
	    	app.setDepartment(departmentdao.getDepartmentById(Integer.parseInt(request.getParameter("departmentname"))));
	    	app.setProgram(programdao.getProgramById(Integer.parseInt(request.getParameter("programname"))));
	    	app.setTerm(application.getTerm());
	    	app = applicationdao.saveApplication(app);
	    	/*Student s=studentdao.getStudentByUserId(id);
	    	app.setStudent(s);*/
	    	Status status = new Status();
	    	status.setStatus("Not Submitted");
	    //	status.setTimestamp("");
	    	status.setApplication(app);
	    	status.setUser(us);
	    	status = statusdao.saveStatus(status);
	    	

	    	
	    	
	    	models.put("application", app);
	    	
	    	//return "redirect:/users/student/studentinformation/"+id+"/"+app.getApplicationid()+".html";
	    	return "redirect:/users/student/additionalfields/"+app.getApplicationid()+".html";
	    }
	    
	    	 else{
	    		 return "redirect:/login.html";
	    	 }
	  }

  
	  @RequestMapping(value = "/users/student/editnewapplication/{userid}/{applicationid}", method = RequestMethod.GET)
		public String showEditApplication(ModelMap models,@PathVariable Integer applicationid,@PathVariable Integer userid,HttpSession session) {
			
			if(session.getAttribute("userid") != null) {
			String uid = session.getAttribute("userid").toString();
			Users u = userdao.getUserById(Integer.parseInt(uid));
			models.put("user", u);
//			List<Department> dept = this.departmentdao.getDepartments();
			Application app=applicationdao.getApplicationById(applicationid);
			Student s=studentdao.getStudentByUserId(Integer.parseInt(uid));
			models.put("student", s);
			List<Department> dept=new ArrayList<Department>();
			dept.add(app.getDepartment());
			models.put("departmentlist", dept);
			
			models.put("application", app);
			return "/users/student/editnewapplication";
			
	  }	else{
		  
			return "redirect:/login.html";
	  
	  			}
	  }
	  	
	  
	  
	  @RequestMapping(value = "/users/student/editnewapplication/{userid}/{applicationid}", method = RequestMethod.POST)
		public String showEditApplication(@ModelAttribute("application") Application application,@PathVariable Integer applicationid,@PathVariable Integer userid,ModelMap models,HttpServletRequest request,HttpSession session) {
		  if(session.getAttribute("userid") != null) {
			  String uid = session.getAttribute("userid").toString();
			Users u = userdao.getUserById(Integer.parseInt(uid));
			
			Application app=applicationdao.getApplicationById(applicationid);
			app.setProgram(programdao.getProgramById(Integer.parseInt(request.getParameter("programname"))));
	    	app.setTerm(application.getTerm());
	    	app = applicationdao.saveApplication(app);
	    	
	    	return "redirect:/users/student/editadditionalfields/"+applicationid+".html";
			//return "redirect:/users/student/"+userid+"/"+applicationid+"/"+app.getStudent().getStudentid()+"/editstudentinformation.html";
	    
			
	  }	
		  else{
			  
			  return "redirect:/login.html";
		  
		  		}
		  }
	  
	    
	    @RequestMapping(value="/users/student/studentinformation/{userid}/{applicationid}.html",method = RequestMethod.GET)
	     public String nextStudent(@PathVariable int applicationid,HttpSession session,@PathVariable int userid,ModelMap models ){
	    	 if(session.getAttribute("userid") != null) {
	    	Users user = userdao.getUserById(userid);
			models.put("user", user);
			Application application = applicationdao.getApplicationById(applicationid);
	    	models.put("application",application);
	    	models.put("student",new Student());
	    	System.out.println("reached");
	    		
	    		return "/users/student/studentinformation";
	    	}
	    	 else{
	    		 return "redirect:/login.html";
	    	 }
	    }
	    @RequestMapping(value="/users/student/studentinformation/{userid}/{applicationid}.html",method = RequestMethod.POST)
	     public String nextStudent(@ModelAttribute("student") Student student, HttpSession session, @PathVariable int applicationid, @PathVariable int userid, ModelMap models ){
	    		//System.out.println("bye");
	    	 if(session.getAttribute("userid") != null) {
	    		 
	    		Users u = userdao.getUserById(userid);	
	    		student.setUser(u);
	    		student = studentdao.save(student);
	    		Application application = applicationdao.getApplicationById(applicationid);
	    		application.setStudent(student);
	    		application = applicationdao.saveApplication(application);
	    
	    		//System.out.println("hey");
	    			return "redirect:/users/student/"+userid+"/"+applicationid+"/studentacademic/"+student.getStudentid()+".html";
	    		
	    	 }
	    	 else{
	    		 
	    		 return "redirect:/login.html";
	    	 }
	    }
	    
	   @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/editstudentinformation.html",method = RequestMethod.GET)
	   public String editstudent(@PathVariable int applicationid,@PathVariable int userid,@PathVariable int studentid,ModelMap models,HttpSession session){
		   if(session.getAttribute("userid") != null) {
			   
			   	Users user = userdao.getUserById(userid);
				models.put("user", user);
				Application application = applicationdao.getApplicationById(applicationid);
		    	models.put("application",application);
		    	Student student = studentdao.getStudentById(studentid);
		    	models.put("student",student);
		    	
		    	return "/users/student/editstudentinformation";
		   }
		   else{
			   
			   return "redirect:/login.html";
			   
		   }
		   
		   
	   }
	   
	   @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/editstudentinformation.html",method = RequestMethod.POST)
	   public String editstudent(@ModelAttribute("student")Student student,@PathVariable int applicationid,@PathVariable int userid,@PathVariable int studentid,ModelMap models,HttpSession session){
		   if(session.getAttribute("userid") != null) {
			   
			   	Users user = userdao.getUserById(userid);
			//	models.put("user", user);
				//Student s = studentdao.
			   Academicrecord record = academicrecorddao.getAcademicrecordByStudentId(studentid);
			   	student.setAcademicrecord(record);
			   	student.setUser(user);
		    	 student = studentdao.save(student);
		    	//models.put("student",student);
		    	
		    	return  "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/editstudentacademic.html";
		   }
		   else{
			   
			   return "redirect:/login.html";
			   
		   }
		   
		   
	   }
	   
	    
	    
	    
	    
	    
	    
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/studentacademic/{studentid}.html", method = RequestMethod.GET)
	    public String academic(@PathVariable int studentid,HttpSession session, @PathVariable int userid,@PathVariable int applicationid,ModelMap models){
	    	 if(session.getAttribute("userid") != null) {
	    	
	    	Users u = userdao.getUserById(userid);
	    	models.put("user",u);
	    	
	    	Application a = applicationdao.getApplicationById(applicationid);
	    	models.put("application",a);
	    	
	    	models.put("academicrecord",new Academicrecord());
	    	
	    	Student student = studentdao.getStudentById(studentid);
	    	
	    	
	    	models.put("student",student);
	    	return "/users/student/studentacademic";
	    }
	    	 else{
	    		 
	    		 return "redirect:/login.html";
	    		 
	    	 }	 
	    } 	 
	    
	    
	    
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/studentacademic/{studentid}.html", method = RequestMethod.POST)
	    public String academic(HttpSession session,@ModelAttribute("student")Student student,@ModelAttribute("academicrecord") Academicrecord academicrecord,@PathVariable int studentid, @PathVariable int userid,@PathVariable int applicationid,ModelMap models){
	    	//academicrecord.
	    	//Student s = studentdao.getStudentById(studentid)
	    	 if(session.getAttribute("userid") != null) {
	    	Student s = studentdao.getStudentById(studentid);
	    	academicrecord.setStudent(s);
	    	academicrecord = academicrecorddao.saveacademic(academicrecord);
//	    
	    	s.setAcademicrecord(academicrecord);
	    	s= studentdao.save(s);
	    	
	    
	    	//return "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/studenteducational.html";
	    	return "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/uploadtranscript.html";
	    }
	    	 else{
	    		 
	    		 return "redirect:/login.html"
;	    	 }
	    }
	   
	    
	    
	    
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/editstudentacademic.html",method=RequestMethod.GET)
	    public String editacademic(@PathVariable int studentid, @PathVariable int userid,@PathVariable int applicationid,HttpSession session,ModelMap models){
	    	 if(session.getAttribute("userid") != null) {
	    		Academicrecord record = academicrecorddao.getAcademicrecordByStudentId(studentid);
	    		System.out.println(record);
	    		models.put("academicrecord",record);
	    		 return "/users/student/editstudentacademic";
	    }else{
	    	
	    	return "redirect:/login.html";
	    
	    }
	    
	    }   
	    
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/editstudentacademic.html",method=RequestMethod.POST)
	    public String editacademic(@ModelAttribute("academicrecord") Academicrecord academic,ModelMap models, @PathVariable int studentid, @PathVariable int userid,@PathVariable int applicationid,HttpSession session){
	    	 if(session.getAttribute("userid") != null) {
	    		 
	    		 Student student = studentdao.getStudentById(studentid);
	    		 academic.setStudent(student);
	    		 academic = academicrecorddao.saveacademic(academic);
	    		 
	    		 
	    		 return "redirect:/users/student/edittranscript/"+userid+"/"+applicationid+"/"+studentid+".html";
	    	 }
	    	 
	    	 else{
	    		 
	    		 return "redirect:/login.html";
	    	 }
	    }
	    
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/uploadtranscript.html",method=RequestMethod.GET)
	    	public String upload(HttpSession session,@PathVariable int applicationid,@PathVariable int userid, @PathVariable int studentid, ModelMap models){
	    	 if(session.getAttribute("userid") != null) {
	    	Student student = studentdao.getStudentById(studentid);
	    	models.put("student",student);	
	    	Application application = applicationdao.getApplicationById(applicationid);
	    	models.put("application", application);
	    	
	    	Users u = userdao.getUserById(userid);
	    	models.put("user", u);
	    		
	    		
	    	
	    	 
	    	
	    return "/users/student/uploadtranscript";	
	   }
	    	 else{
	    		 return "redirect:/login.html";
	    	 }
	    }
	  
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/uploadtrancsript.html",method=RequestMethod.POST)
    	public  String upload(HttpSession session,@PathVariable int applicationid,@PathVariable int userid, @PathVariable int studentid,@RequestParam MultipartFile transcript )throws IllegalStateException, IOException{
    
	    	 if(session.getAttribute("userid") != null) {
	    	//Student student = studentdao.getStudentById(studentid);
	    	String filename = null;
	    	if(!transcript.isEmpty()){
	    		int lastIndex = transcript.getOriginalFilename().lastIndexOf(".");
	    		String ext = transcript.getOriginalFilename().substring(lastIndex);
	    		filename = studentid+"transcript"+ext;
	    		transcript.transferTo(new java.io.File(getFileDirectory(),filename));
	    		Academicrecord academic = academicrecorddao.getAcademicrecordByStudentId(studentid);
	    		academic.setFilename(filename);
	    		academic = academicrecorddao.saveacademic(academic);
	    		
	    	}
		
	    		
	    	return "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/studenteducational.html";
			
	   }
	    	 else{
	    		 return "redirect:/login.html";
	    	 }
	    }  	 
	    
	    @RequestMapping(value="/users/student/edittranscript/{userid}/{applicationid}/{studentid}.html",method=RequestMethod.GET)
		public String edittranscript(@PathVariable int studentid,@PathVariable int userid, @PathVariable int applicationid, ModelMap models,HttpSession session){
	    	if(session.getAttribute("userid") != null) {
	    		
    		//Academicrecord record = academicrecorddao.getAcademicrecordByStudentId(studentid);
	    		Users u = userdao.getUserById(userid);
	    		models.put("user", u);
	    		Application application = applicationdao.getApplicationById(applicationid);
	    		models.put("application",application);
	    		Student student = studentdao.getStudentById(studentid);
	    		models.put("student", student);
	    		
    		
    		 return "/users/student/edittranscript";
    }else{
    	
    	return "redirect:/login.html";
    		}
	   }
	    
	    @RequestMapping(value="/users/student/edittranscript/{userid}/{applicationid}/{studentid}.html",method=RequestMethod.POST)
	  		public String edittranscript(@PathVariable int studentid,@PathVariable int applicationid,@PathVariable int userid, HttpSession session,@RequestParam MultipartFile transcript )throws IllegalStateException, IOException{
	  	    	if(session.getAttribute("userid") != null) {
	  	    	String filename = null;
	  		    	if(!transcript.isEmpty()){
	  		    		int lastIndex = transcript.getOriginalFilename().lastIndexOf(".");
	  		    		String ext = transcript.getOriginalFilename().substring(lastIndex);
	  		    		filename = studentid+"transcript"+ext;
	  		    		transcript.transferTo(new java.io.File(getFileDirectory(),filename));
	  		    		Academicrecord record = academicrecorddao.getAcademicrecordByStudentId(studentid);
	  		    		record.setFilename(filename);
	  		    		record = academicrecorddao.saveacademic(record);
	  		    	}
	  		    			return "redirect:/users/student/editstudenteducational/"+userid+"/"+applicationid+"/"+studentid+".html";
	  		    	
	  		  }else{
	      	
	      	return "redirect:/login.html";
	      	}
	      		
	   }
	    	
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/studenteducational.html", method = RequestMethod.GET)
	    public String educational(HttpSession session,ModelMap models,@PathVariable int userid,@PathVariable int studentid,@PathVariable int applicationid){
	    	
	    	 if(session.getAttribute("userid") != null) {
	    	models.put("educationalinfo", new Educationalinfo());
	    	Users u = userdao.getUserById(userid);
	    	models.put("user",u);
	    	Application application = applicationdao.getApplicationById(applicationid);
	    	models.put("application",application);
	    	
	    	Student student = studentdao.getStudentById(studentid);
	    	models.put("student",student);
	    	
	    	models.put("listEducationalinfo",student.getEducationalinfos());
	    	
	    	
	    	
	    	return "users/student/studenteducational";
	    }
	    	 else{
	    		 
	    		 return "redirect:/login.html";
	    	 }
	  } 
	    @RequestMapping(value="/users/student/{userid}/{applicationid}/{studentid}/studenteducational.html", method = RequestMethod.POST)
	    public String educational(HttpSession session,@ModelAttribute("student") Student student,@ModelAttribute("educationalinfo") Educationalinfo educationalinfo,@PathVariable int userid,@PathVariable int studentid,@PathVariable int applicationid){
	    	 if(session.getAttribute("userid") != null) {
	    	
	    	educationalinfo.setStudent(student);
	    	educationalinfo = educationalinfodao.saveeducational(educationalinfo);
	    	//List<Educationalinfo> educational = educationalinfodao.getEducationalByStudentId(studentid);
	    	//educational.add(educationalinfo);
	    	//student.setEducationalinfos(educational);
	    	
	    	
	    	return "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/studenteducational.html";
	    }
	    	 else{
	    		 return "redirect:/login.html";
	    	 }
 }   	 
	    
	    
	    @RequestMapping(value="/users/student/editstudenteducational/{userid}/{applicationid}/{studentid}.html",method=RequestMethod.GET)
	    public String editeducational(ModelMap models,@PathVariable int userid,@PathVariable int applicationid,@PathVariable int studentid,HttpSession session){
	    	if(session.getAttribute("userid") != null) {
	    		
	    		Users u = userdao.getUserById(userid);
	    		models.put("user",u);
	    		
	    		Application application = applicationdao.getApplicationById(applicationid);
	    		models.put("application",application);
	    		
	    		System.out.println(application.getApplicationid());
	    		Student student = studentdao.getStudentById(studentid);
	    		models.put("student",student);
	    		//models.put("application",applicationdao.getApplicationByStudentId(student.getStudentid()));
	    		models.put("educationalinfo", new Educationalinfo());
	    		List<Educationalinfo> educationallist = student.getEducationalinfos();
	    		models.put("listEducationalinfo", educationallist);
	    		
	    		return "/users/student/editstudenteducational";
	    	}
	    	else{
		      	
		      	return "redirect:/login.html";
		      	}
	    }
	    
	    @RequestMapping(value="/users/student/editstudenteducational/{userid}/{applicationid}/{studentid}.html",method=RequestMethod.POST)
	    public String editeducational(HttpSession session,@PathVariable int userid,@PathVariable int applicationid,@PathVariable int studentid,@ModelAttribute("educationalinfo") Educationalinfo educationalinfo,@ModelAttribute("student") Student student){
	    if(session.getAttribute("userid") != null) {
	    	
	    	educationalinfo.setStudent(student);
	    	educationalinfo = educationalinfodao.saveeducational(educationalinfo);
	    	return "redirect:/users/student/editstudenteducational/"+userid+"/"+applicationid+"/"+studentid+".html";
	    }else{
	    	
	    	return "redirect:/login.html";
	    }
	  } 
	    
	    
	    
	    
	    @RequestMapping(value="/users/student/educationalinfo/remove/{userid}/{applicationid}/{studentid}/{educationalid}.html",method=RequestMethod.GET)
	    
	    public String removeEducationalinfo(@PathVariable int educationalid,@PathVariable int userid,@PathVariable int studentid,@PathVariable int applicationid, ModelMap models) {
			
	    	
	    	educationalinfodao.removeEducationalinfo(educationalid);
			
			return "redirect:/users/student/"+userid+"/"+applicationid+"/"+studentid+"/studenteducational.html";
			
	    }
	    @RequestMapping(value="/users/student/educationaleditinfo/remove/{userid}/{applicationid}/{studentid}/{educationalid}.html",method=RequestMethod.GET)
	    	public String removeEditEducationalinfo(@PathVariable int educationalid,@PathVariable int userid,@PathVariable int studentid,@PathVariable int applicationid, ModelMap models) {
			
	    	
	    	educationalinfodao.removeEducationalinfo(educationalid);
			
			return "redirect:/users/student/editstudenteducational/"+userid+"/"+applicationid+"/"+studentid+".html";
			
	    }
	  
	   @RequestMapping(value="users/student/saveapplication/{userid}/{applicationid}.html",method=RequestMethod.GET)
	   public String saveapplication(ModelMap models,@PathVariable int applicationid,@PathVariable int userid){
		   
		   
		   return "redirect:/users/student/applicationlist/"+userid+".html";
	   }
	   
	   
	    @RequestMapping(value="users/student/submitapplication/{userid}/{applicationid}.html" ,method=RequestMethod.GET)
	    	
	    	public String submitapplication(ModelMap models,@PathVariable int applicationid,@PathVariable int userid){
	    	Users us = userdao.getUserById(userid);
	    	Application application=applicationdao.getApplicationById(applicationid);
	    	System.out.println(applicationid);
	    	Status status = new Status();
	    	status.setStatus("Submitted");
	    	status.setTimestamp(new Timestamp(new Date().getTime()));
	    	status.setApplication(application);
	    	status.setUser(us);
	    	status = statusdao.saveStatus(status);
	    	
	    	
	    	//application = applicationdao.saveApplication(application);
	    	
	    	return "redirect:/users/student/applicationlist/"+userid+".html";
	    }
	    
	    @RequestMapping("/users/student/download.html")
	    public String download(HttpServletResponse response, @RequestParam String filename) throws IOException{
	    	if(filename != null && filename.trim().length() != 0){
	    		String mimeType = servletcontext.getMimeType(filename);
	    		response.setContentType(mimeType);
	    		response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
	    		FileInputStream in = new FileInputStream(new java.io.File(getFileDirectory(), filename));
	    		OutputStream out = response.getOutputStream();
	    		byte buffer[] = new byte[2048];
	    		int bytesRead;
	    		while((bytesRead = in.read(buffer))>0){
	    			out.write(buffer, 0, bytesRead);
	    		}
	    		in.close();
	    	}
	    	return null;
	    }
	
	    
	    @RequestMapping(value="/users/student/additionalfields/{applicationid}.html", method= RequestMethod.GET)
	    public String loadAdditionalfield(HttpSession session,@PathVariable int applicationid,ModelMap models){
	        //JSONArray jarr= new JSONArray();
		   // List<CustomField>  customfields = custormfielddao.getCustomFormByDepartment(deptid);
	    	if(session.getAttribute("userid") != null){
	    	Application app = applicationdao.getApplicationById(applicationid);	
	    	List<CustomField> field = app.getDepartment().getCustomfield();
	    	List<CustomValue> customvalues = new ArrayList<CustomValue>();
	    	   
		    for (int i = 0; i < field.size(); i++) {
		  
		    		CustomValue custom = new CustomValue();
		    		custom.setCustomfield(field.get(i));
		    		custom.setApplication(app);
		    		customvalues.add(custom);
		    }
		    app.setCustomvalues(customvalues);
		    //app = applicationdao.saveApplication(app);
		    models.put("application", app);
		 
		    
	    	return "/users/student/additionalfields";
	    	
	    }else{
	    	
	    	return "redirect:/login.html";
	    }
}  
	    @RequestMapping(value="/users/student/additionalfields/{applicationid}.html", method= RequestMethod.POST)
	    public String loadAdditionalfield(HttpSession session,@ModelAttribute("application") Application application,@PathVariable int applicationid,ModelMap models){
	    	if(session.getAttribute("userid") != null){
	    	String userid = session.getAttribute("userid").toString();	
	    	Users u = userdao.getUserById(Integer.parseInt(userid));
	    	//Application	app = applicationdao.getApplicationById(application.getApplicationid());
	    	for(int i = 0; i < application.getCustomvalues().size(); i++ ) {
	    		CustomValue av = application.getCustomvalues().get(i);
	    		if(!av.getCustomfield().getFieldtype().equals("File")) {
	    			CustomValue front = application.getCustomvalues().get(i);
	    			//System.out.println(front.getCustomfield().getControlid());
	    			CustomValue c = new CustomValue();
	    			c.setApplication(applicationdao.getApplicationById(applicationid));
	    			c.setCustomfield(front.getCustomfield());
	    			c.setValue(front.getValue());
	    			c = customdao.save(c);	
	    			}
		    	}
	    		
	    		//return "redirect:/users/student/studentinformation/"+u.getUserid()+"/"+application.getApplicationid()+".html";
	    		return "redirect:/users/student/uploadadditional/"+applicationid+".html";
	    	}
	    
	    
	    else{
	    	
	    	return "redirect:/login.html";
	    }
	    
}    
	    @RequestMapping(value="/users/student/editadditionalfields/{applicationid}.html", method= RequestMethod.GET)
	    public String Additionalfield(HttpSession session,@PathVariable int applicationid,ModelMap models){
	    	if(session.getAttribute("userid") != null){
	    		Application app = applicationdao.getApplicationById(applicationid);
			    //app = applicationdao.saveApplication(app);
			    models.put("application", app);
			 return "/users/student/editadditionalfields";
	    		
	    		
	    	}else{
	    		
	    			return "redirect:/login.html";
	    		
	    		}
	    	}
	    
	    @RequestMapping(value="/users/student/editadditionalfields/{applicationid}.html", method= RequestMethod.POST)
	    public String Additionalfield(HttpSession session,@ModelAttribute("application") Application application,@PathVariable int applicationid,ModelMap models){
	    	if(session.getAttribute("userid") != null){
	    		String userid = session.getAttribute("userid").toString();	
		    	Users u = userdao.getUserById(Integer.parseInt(userid));
		    	Application app = applicationdao.getApplicationById(applicationid);
		    	for(int i = 0; i < application.getCustomvalues().size(); i++ ) {
		    		CustomValue av = application.getCustomvalues().get(i);
		    		if(!av.getCustomfield().getFieldtype().equals("File")) {
		    			CustomValue front = application.getCustomvalues().get(i);
		    			//System.out.println(front.getCustomfield().getControlid());
		    		
		    			av.setApplication(applicationdao.getApplicationById(applicationid));
		    			av.setCustomfield(front.getCustomfield());
		    			av.setValue(front.getValue());
		    			av = customdao.save(av);	
		    			}
			    	}
		    	
			    
			// return "redirect:/users/student/"+userid+"/"+applicationid+"/"+app.getStudent().getStudentid()+"/editstudentinformation.html";
	    		return "redirect:/users/student/editadditional/"+applicationid+".html";
	    		
	    	}else{
	    		
	    			return "redirect:/login.html";
	    		
	    		}
	    	}
	    
	    
	    
	    
	    @RequestMapping(value = "/users/student/uploadadditional/{applicationid}.html", method = RequestMethod.GET)
	    public String uploadAdditional(@PathVariable int applicationid, ModelMap models,HttpSession session){
	    	if(session.getAttribute("userid") != null){
	    		Application app = applicationdao.getApplicationById(applicationid);	
		    	List<CustomField> field = app.getDepartment().getCustomfield();
		    	List<CustomValue> customvalues = new ArrayList<CustomValue>();
		    	   
			    for (int i = 0; i < field.size(); i++) {
			  
			    		CustomValue custom = new CustomValue();
			    		custom.setCustomfield(field.get(i));
			    		custom.setApplication(app);
			    		customvalues.add(custom);
			    }
			    app.setCustomvalues(customvalues);
			    //app = applicationdao.saveApplication(app);
			    models.put("application", app);
	    	
	    		return "/users/student/uploadadditional";
	    	
	    	}else{
	    		
    			return "redirect:/login.html";
    		
    		}
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    @RequestMapping(value = "/users/student/uploadadditional/{applicationid}.html", method = RequestMethod.POST)
	    public String uploadAdditional(@PathVariable int applicationid,@ModelAttribute("application")Application application, @RequestParam("file") MultipartFile[] files, ModelMap models,HttpSession session) throws IllegalStateException, IOException{
	    	if(session.getAttribute("userid") != null){
	    		String userid = session.getAttribute("userid").toString();	
	    		int counter = 0;
		    	Users u = userdao.getUserById(Integer.parseInt(userid));
	    		for(int i = 0; i < application.getCustomvalues().size(); i++ ) {
		    		CustomValue av = application.getCustomvalues().get(i);
		    		if(av.getCustomfield().getFieldtype().equals("File")) {
		    			CustomValue front = application.getCustomvalues().get(i);		    		
		    			av.setApplication(applicationdao.getApplicationById(applicationid));
		    			av.setCustomfield(front.getCustomfield());
		    			
		    			
			    	
				    	String filename = null;
				    	
		
								
								System.out.println("Saving file: " + files[counter].getOriginalFilename());
								filename = applicationid+files[counter].getOriginalFilename();
								
								if (!files[counter].getOriginalFilename().equals("")) {
									files[counter].transferTo(new java.io.File(getFileDirectory(),filename));
							counter++;
						}

		  		    		
		  		    		av.setValue(filename);
			    			av = customdao.save(av);
		  			            
		  			         } 
		    		}   
	    			
		  		    		
	    	         
	    	return "redirect:/users/student/studentinformation/"+u.getUserid()+"/"+application.getApplicationid()+".html";
		    		}else{
	    		
    			return "redirect:/login.html";
    		
    		}
			
	    	
	    	
	    	
	    }
	    
	    
	    
	    @RequestMapping(value = "/users/student/editadditional/{applicationid}.html", method = RequestMethod.GET)
	    public String editAdditional(@PathVariable int applicationid, ModelMap models,HttpSession session){
	    	if(session.getAttribute("userid") != null){
	    		Application app = applicationdao.getApplicationById(applicationid);
			    //app = applicationdao.saveApplication(app);
			    
		
			    //app = applicationdao.saveApplication(app);
			    models.put("application", app);
	    	
	    		return "/users/student/editadditional";
	    	
	    	}else{
	    		
    			return "redirect:/login.html";
    		
    		}
	    
	    
	    }
	    
	    @RequestMapping(value = "/users/student/editadditional/{applicationid}.html", method = RequestMethod.POST)
	    public String editAdditional(@PathVariable int applicationid, ModelMap models,HttpSession session,@ModelAttribute("application")Application application, @RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException{
	    	if(session.getAttribute("userid") != null){
	    		String userid = session.getAttribute("userid").toString();	
	    		Application app = applicationdao.getApplicationById(applicationid);
	    		int counter = 0;
		    	Users u = userdao.getUserById(Integer.parseInt(userid));
	    		for(int i = 0; i < application.getCustomvalues().size(); i++ ) {
		    		CustomValue av = application.getCustomvalues().get(i);
		    		if(av.getCustomfield().getFieldtype().equals("File")) {
		    			CustomValue front = application.getCustomvalues().get(i);		    		
		    			av.setApplication(applicationdao.getApplicationById(applicationid));
		    			av.setCustomfield(front.getCustomfield());
		    			
		    			
			    	
				    	String filename = null;
				    	
		
								
								System.out.println("Saving file: " + files[counter].getOriginalFilename());
								filename = applicationid+files[counter].getOriginalFilename();
								
								if (!files[counter].getOriginalFilename().equals("")) {
									files[counter].transferTo(new java.io.File(getFileDirectory(),filename));
							counter++;
						}

		  		    		
		  		    		av.setValue(filename);
			    			av = customdao.save(av);
		  			            
		  			         } 
		    		} 
	    				return "redirect:/users/student/"+userid+"/"+applicationid+"/"+app.getStudent().getStudentid()+"/editstudentinformation.html";
		    		}else{
	    		
    			return "redirect:/login.html";
    		
    		}
			
	    	
	    	
	    	
	    }
	    
	    
	    
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   	    
	    
	    @RequestMapping(value = "/users/student/newapplication/{id}/loadProgram.html", method = RequestMethod.GET)
	    public @ResponseBody String loadProogram(@RequestParam(value = "deptid") int deptid) {
	    List<Program> avaliableprogram = programdao.listProgram(deptid);
	    JSONArray pArry = new JSONArray();
	    for(Program p : avaliableprogram){
	    	try{
	    		JSONObject pObj = new JSONObject();
	    		pObj.put("programid", p.getProgramid());
	    		pObj.put("programname", p.getProgramname());
	    		pArry.put(pObj);
	    		
	    	}catch(JSONException e){
	    		
	    		e.printStackTrace();
	    	}
	    }
	    JSONObject pOb = new JSONObject();
	    try{
	    	pOb.put("programlist", pArry);
	    	
	    }catch(JSONException e){
    		
    		e.printStackTrace();
	    }
	    
	    return pOb.toString();
	    
	}

} 
	    
	

		  
	  
	  
	    
	

	 
	  
	

