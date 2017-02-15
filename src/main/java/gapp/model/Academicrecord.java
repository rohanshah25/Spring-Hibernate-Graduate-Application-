package gapp.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;



@Entity
@Table(name = "academicrecord")
public class Academicrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique=true, nullable=false)
	private int academicrecordid;

	private double gpa;

	


	private double grescore;

	private double toeflscore;
	
	
	private String filename;

	
	@OneToOne
	@JoinColumn(name="studentid")
	private Student student;

	public Academicrecord() {
	}

	public int getAcademicrecordid() {
		return academicrecordid;
	}

	public void setAcademicrecordid(int academicrecordid) {
		this.academicrecordid = academicrecordid;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getGrescore() {
		return grescore;
	}

	public void setGrescore(double grescore) {
		this.grescore = grescore;
	}

	public double getToeflscore() {
		return toeflscore;
	}

	public void setToeflscore(double toeflscore) {
		this.toeflscore = toeflscore;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	


	
	
	
}
