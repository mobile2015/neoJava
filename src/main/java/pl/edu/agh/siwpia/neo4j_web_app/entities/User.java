package pl.edu.agh.siwpia.neo4j_web_app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.edu.agh.siwpia.neo4j_web_app.enums.UserRole;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 3619456577115103463L;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String password;

	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private List<Role> roles;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public boolean hasRole(String stringRole) {
		UserRole role;
		role = UserRole.valueOf(stringRole);
		for (Role roleIt : roles) {
			if (roleIt.getRole().equals(role)) {
				return true;
			}
		}
		return false;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}