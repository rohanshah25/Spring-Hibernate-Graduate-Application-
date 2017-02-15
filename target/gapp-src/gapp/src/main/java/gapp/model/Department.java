package gapp.model;


import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int departmentid;
	
	private String departmentname;
	
	
	
	
	@OneToMany(mappedBy="department")
	private List<Program> programs;

	public Department() {
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	


}
