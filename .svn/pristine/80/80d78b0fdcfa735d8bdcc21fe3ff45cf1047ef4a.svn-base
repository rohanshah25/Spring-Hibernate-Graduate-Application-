package gapp.model;

import java.io.Serializable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "users")

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int userid;
    
    @Column(nullable=false, length=50)
	private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
	private byte active;
    
	  @ElementCollection
	  @CollectionTable(name = "rolevalues",
	        joinColumns = @JoinColumn(name = "user_id"))
	  @Column(name = "role_name")
	    private List<String> roles;
	  
	  	@OneToMany(mappedBy="user")
		private List<Student> students;  
	  
	  
	 // @OneToMany(mappedBy = "applicant")
	 // private List<Application> applications; 
		
		
	public Users(){
		
	}	
	

	public byte getActive() {
		return active;
	}


	public void setActive(byte active) {
		this.active = active;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	
	

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	
   
}
