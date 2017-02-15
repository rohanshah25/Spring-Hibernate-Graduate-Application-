package gapp.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="customvalue")
public class CustomValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int valueid;

	private String value;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="controlid")
	private CustomField customfield;
	
	@ManyToOne
	@JoinColumn(name="applicationid")
	private Application application;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studentid")
	private Student student;

	public CustomValue() {
	}

	public int getValueid() {
		return valueid;
	}

	public void setValueid(int valueid) {
		this.valueid = valueid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CustomField getCustomfield() {
		return customfield;
	}

	public void setCustomfield(CustomField customfield) {
		this.customfield = customfield;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}	

}





