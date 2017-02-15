package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;





@Entity
@Table(name = "application" )
public class Application implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue
	@Column(unique=true, nullable=false)
    private int applicationid;
	
	private String term;
	

	
	@ManyToOne
	@JoinColumn(name="applicantid")
	private Student student;
	
	
	
	
	
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL)
	@OrderBy("statusid desc")
	private List<Status> status;

	
	@ManyToOne
	@JoinColumn(name="programid")
	private Program program;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="departmentid")
	private Department department;
	
	
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL)
	private List<CustomField> customfield;
	
	
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL)
	private List<CustomValue> customvalues;
	
	@ManyToOne
	private Users applicant;
	
	
	
	
	public List<CustomValue> getCustomvalues() {
		return customvalues;
	}

	public void setCustomvalues(List<CustomValue> customvalues) {
		this.customvalues = customvalues;
	}

	
	
/*	@ManyToOne
	@JoinColumn(name="changedby")
	private Users user;*/
	
	
	
	
	

	public Application(Users applicant){
		this.applicant = applicant;
	}
	
	public Application(){
		
	}


	public int getApplicationid() {
		return applicationid;
	}


	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	
	


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}







	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<CustomField> getCustomfield() {
		return customfield;
	}


	public void setCustomfield(List<CustomField> customfield) {
		this.customfield = customfield;
	}




	

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Users getApplicant() {
		return applicant;
	}

	public void setApplicant(Users applicant) {
		this.applicant = applicant;
	}

	
}