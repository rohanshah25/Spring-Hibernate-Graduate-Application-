package gapp.model;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name = "educationalinfo")
public class Educationalinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int educationalid;

	private String collegeuniversity;

	private String degreename;

	private String majorfield;

	private int periodofdegree;

	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;
	
	
	public Educationalinfo() {
	}

	public int getEducationalid() {
		return educationalid;
	}

	public void setEducationalid(int educationalid) {
		this.educationalid = educationalid;
	}

	public String getCollegeuniversity() {
		return collegeuniversity;
	}

	public void setCollegeuniversity(String collegeuniversity) {
		this.collegeuniversity = collegeuniversity;
	}

	public String getDegreename() {
		return degreename;
	}

	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}

	public String getMajorfield() {
		return majorfield;
	}

	public void setMajorfield(String majorfield) {
		this.majorfield = majorfield;
	}

	public int getPeriodofdegree() {
		return periodofdegree;
	}

	public void setPeriodofdegree(int periodofdegree) {
		this.periodofdegree = periodofdegree;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}