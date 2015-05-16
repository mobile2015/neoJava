package pl.edu.agh.siwpia.neo4j_web_app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.edu.agh.siwpia.neo4j_web_app.enums.UserRole;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 208096052950284616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private UserRole role;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_id") },
			inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private List<User> users;

	public Role() {
		super();
	}

	public Role(UserRole role) {
		this.role = role;
	}

	public UserRole getRole() {
		return role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
