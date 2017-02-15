 package gapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "students")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int studentid;
	private long cin;

	private String citizenship;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	
	private String email;
	private String firstname;
	private String gender;
	private String lastname;
	private String phoneno;

	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;
	
	
	
	@OneToOne
	private Academicrecord academicrecord;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Application> applications;

	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	@OrderBy("periodofdegree desc")
	private List<Educationalinfo> educationalinfos;

	@OneToMany(mappedBy="student")
	private List<CustomValue> customvalues;
	
	
	

	
	public Student() {
		this.setEducationalinfos(new ArrayList<Educationalinfo>());
	}
	

	

	public Academicrecord getAcademicrecord() {
		return academicrecord;
	}




	public void setAcademicrecord(Academicrecord academicrecord) {
		this.academicrecord = academicrecord;
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