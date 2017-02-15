package gapp.model;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int studentid;
	private long cin;

	private String citizenship;

	private Date dob;

	private String email;

	private String firstname;
	private String gender;
	private String lastname;
	private String phoneno;

	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
	@OneToMany(mappedBy="student")
	private List<Academicrecord> academicrecords;
	
	@OneToMany(mappedBy="student")
	private List<Application> applications;

	
	@OneToMany(mappedBy="student")
	private List<Educationalinfo> educationalinfos;

	@OneToMany(mappedBy="student")
	private List<CustomValue> customvalues;
	
	@OneToMany(mappedBy="student")
	private List<Status> statuses;
	
	@ManyToOne
	@JoinColumn(name="programid")
	private Program program;
	
	
	public Student() {
	}
	

	public List<Academicrecord> getAcademicrecords() {
		return academicrecords;
	}

	public void setAcademicrecords(List<Academicrecord> academicrecords) {
		this.academicrecords = academicrecords;
	}

	public List<Educationalinfo> getEducationalinfos() {
		return educationalinfos;
	}

	public void setEducationalinfos(List<Educationalinfo> educationalinfos) {
		this.educationalinfos = educationalinfos;
	}

	

	public List<CustomValue> getCustomvalues() {
		return customvalues;
	}


	public void setCustomvalues(List<CustomValue> customvalues) {
		this.customvalues = customvalues;
	}


	public Program getProgram() {
		return program;
	}


	public void setProgram(Program program) {
		this.program = program;
	}


	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


	public List<Application> getApplications() {
		return applications;
	}


	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}



}