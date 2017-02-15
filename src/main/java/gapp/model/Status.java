package gapp.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "status")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int statusid;

	private String comment;

	private String status;

	private Timestamp timestamp;

	
	@ManyToOne
	private Application application;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Users user;

	
	
	

	

	public Status() {
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
}