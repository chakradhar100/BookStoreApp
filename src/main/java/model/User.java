package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class User {

    @Id
	@NotEmpty
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable = false , unique = true, length = 50)
	private String email;
	
	@Column(nullable = false , length = 50)
	private String firstName;
	
	@Column(nullable = false , length = 50)	
	private String lastName;
	
	@Column(nullable = false , length = 64)
	private String password;

	public User() {
    }

    

    public User(long id, String email, String firstName, String lastName, String password) {
        this.id = id;
        this.email= email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }



    public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
}

