package pl.edu.agh.siwpia.neo4j_web_app.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.edu.agh.siwpia.neo4j_web_app.daos.AbstractDao;
import pl.edu.agh.siwpia.neo4j_web_app.daos.UserDao;
import pl.edu.agh.siwpia.neo4j_web_app.dtos.RegistrationDto;
import pl.edu.agh.siwpia.neo4j_web_app.entities.Role;
import pl.edu.agh.siwpia.neo4j_web_app.entities.Role_;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User_;
import pl.edu.agh.siwpia.neo4j_web_app.enums.UserRole;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

	@Autowired
	public RoleService roleService;

	@Autowired
	private UserDao userDao;

	@Override
	public AbstractDao<User> getDao() {
		return userDao;
	}

	@Override
	@Transactional
	public void grantRole(Long userId, UserRole role) {
		User user = retrtive(userId);
		Role roleEntity = roleService.selectEntityBy(Role_.role, role);
		if (roleEntity == null) {
			roleEntity = new Role(role);
			roleService.create(roleEntity);
		}
		List<User> users = roleEntity.getUsers();
		if (users == null) {
			users = new ArrayList<>();
		}
		users.add(user);
		roleService.update(roleEntity);
	}

	@Override
	@Transactional
	public User registerUser(RegistrationDto registrationDto) {
		User user = new User();
		List<Role> roles = new LinkedList<>();

		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setRoles(roles);
		user = create(user);
		Logger.getLogger(UserService.class).warn(user.getId());
		return user;
	}

	@Override
	@Transactional
	public void revokeRole(Long userId, UserRole role) {
		Role roleEntity = roleService.selectEntityBy(Role_.role, role);
		User user = retrtive(userId);
		roleEntity.getUsers().remove(user);
		roleService.update(roleEntity);
	}

	@Override
	@Transactional
	public User select() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userDao.selectEntityBy(User_.email, auth.getName());
	}

}
