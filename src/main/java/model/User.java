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
	private String Email;
	
	@Column(nullable = false , length = 50)
	private String FirstName;
	
	@Column(nullable = false , length = 50)	
	private String LastName;
	
	@Column(nullable = false , length = 64)
	private String password;

	public User() {
    }

    

    public User(long id, String email, String firstName, String lastName, String password) {
        this.id = id;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        this.password = password;
    }



    public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
}

