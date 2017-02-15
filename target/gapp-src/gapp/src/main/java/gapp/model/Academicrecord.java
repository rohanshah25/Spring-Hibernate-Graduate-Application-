package gapp.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;



@Entity
@Table(name = "academicrecord")
public class Academicrecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique=true, nullable=false)
	private int academicrecordid;

	private BigDecimal gpa;

	


	private BigDecimal grescore;

	private BigDecimal toeflscore;

	private byte[] transcript;

	
	@ManyToOne
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

	public BigDecimal getGpa() {
		return gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa;
	}

	public BigDecimal getGrescore() {
		return grescore;
	}

	public void setGrescore(BigDecimal grescore) {
		this.grescore = grescore;
	}

	public BigDecimal getToeflscore() {
		return toeflscore;
	}

	public void setToeflscore(BigDecimal toeflscore) {
		this.toeflscore = toeflscore;
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

	public byte[] getTranscript() {
		return transcript;
	}

	public void setTranscript(byte[] transcript) {
		this.transcript = transcript;
	}

	public String toString() {
		return "Academicrecord [gpa=" + gpa + ", grescore=" + grescore
				+ ", toeflscore=" + toeflscore + ", transcript=" + transcript
				+ "]";
	}
	
	
	
}
