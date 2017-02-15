package gapp.model;


import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "program")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int programid;
	private String programname;
	


	
	@ManyToOne
	@JoinColumn(name="departmentid")
	private Department department;



//	@OneToMany(mappedBy="program")
//	private List<Application> application;
	
	@OneToMany(mappedBy="program")
	private List<CustomField> customfields;
	
	public Program() {
	}

	public int getProgramid() {
		return programid;
	}
	
	


	public void setProgramid(int programid) {
		this.programid = programid;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	



	public List<CustomField> getCustomfields() {
		return customfields;
	}

	public void setCustomfields(List<CustomField> customfields) {
		this.customfields = customfields;
	}

	
	
	
	
}
