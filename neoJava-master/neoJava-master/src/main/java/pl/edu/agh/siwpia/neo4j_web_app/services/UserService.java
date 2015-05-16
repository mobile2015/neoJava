package pl.edu.agh.siwpia.neo4j_web_app.services;

import pl.edu.agh.siwpia.neo4j_web_app.dtos.RegistrationDto;
import pl.edu.agh.siwpia.neo4j_web_app.entities.User;
import pl.edu.agh.siwpia.neo4j_web_app.enums.UserRole;

public interface UserService extends AbstractService<User> {

	void grantRole(Long userId, UserRole role);

	User registerUser(RegistrationDto registrationDto);

	void revokeRole(Long userId, UserRole role);

	User select();

}
