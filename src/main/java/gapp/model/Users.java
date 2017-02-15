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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int userid;
    

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
	private boolean active;
    
	  @ElementCollection
	  @CollectionTable(name = "rolevalues",
	        joinColumns = @JoinColumn(name = "user_id"))
	  @Column(name = "role_name")
	  private Set<String> roles;
	  
	  	@OneToMany(mappedBy="user")
		private List<Student> students;  
	  	
	  /*	@OneToMany(mappedBy="user")
		private List<Status> statuses;*/
	  	
	  
	  	@OneToMany(mappedBy = "applicant")
	  	private List<Application> applications; 
		
	



	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}




	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
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


	


	
	
	
	public Users() {
        roles = new HashSet<String>();
    }

    public boolean isAdmin() {
        return roles.contains("ROLE_ADMIN");
    }

    public boolean isStaff() {
        return roles.contains("ROLE_STAFF");
    }
	
   
}
