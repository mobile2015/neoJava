package pl.edu.agh.siwpia.neo4j_web_app.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.edu.agh.siwpia.neo4j_web_app.entities.Role;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User_;
import pl.edu.agh.siwpia.neo4j_web_app.services.UserService;

public class AuthenticationService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(AuthenticationService.class);

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		logger.debug("Loading user by username: " + email);

		User user = userService.selectEntityBy(User_.email, email);
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user with email " + email);
		}

		logger.debug("User found");
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().name()));
		}

		org.springframework.security.core.userdetails.User userData = new org.springframework.security.core.userdetails.User(
				email, user.getPassword(), true, true, true, true, authorities);

		return userData;
	}
}
