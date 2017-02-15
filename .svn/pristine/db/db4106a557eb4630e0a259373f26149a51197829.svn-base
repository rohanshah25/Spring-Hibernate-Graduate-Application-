package gapp.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;



@Entity
@Table(name="customdata")
public class CustomField implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	
	private int controlid;
	
	
	private String fieldname;

	private String fieldtype;
	
	
	@Column()
	private boolean required;
	
	@ManyToOne
	@JoinColumn(name="programid")
	private Program program;
	
	
	@OneToMany(mappedBy="customfield")
	private List<CustomValue> customvalues;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="applicationid")
	private Application  application;
	
	

	

	
	public CustomField() {
	}

	public int getControlid() {
		return controlid;
	}

	public void setControlid(int controlid) {
		this.controlid = controlid;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<CustomValue> getCustomvalues() {
		return customvalues;
	}

	public void setCustomvalues(List<CustomValue> customvalues) {
		this.customvalues = customvalues;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}