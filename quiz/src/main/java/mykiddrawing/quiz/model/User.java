package mykiddrawing.quiz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "user")
public class User extends AuditModel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@NotNull
	@Column(name="user_name")
	@Size(max=50)
	private String user_name;
	
	@NotNull
	@Email
	@Column(name="user_mail",unique=true)
	@Size(max=50)
	private String user_mail;
	
	
	@Column(name="user_address")
	@Size(max=50)
	private String user_address;
	
	
	@Column(name="user_gender")
	@Size(max=50)
	private String user_gender;
	


	@OneToMany(mappedBy = "user", cascade = {
        CascadeType.ALL
    })
    private List<Result> results;
	 

	 public User()
	 {
		 
	 }
	

	public User(String user_name, String user_mail, String user_address, String user_gender) {
		super();
		this.user_name = user_name;
		this.user_mail = user_mail;
		this.user_address = user_address;
		this.user_gender = user_gender;
	}



    public List<Result> getResults() {
		return results;
	}


	public void setResults(List<Result> results) {
		this.results = results;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	

	
}
