package pl.edu.agh.siwpia.neo4j_web_app.daos;

import org.springframework.stereotype.Repository;

import pl.edu.agh.siwpia.neo4j_web_app.entities.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

	@Override
	public Class<User> getEntityclass() {
		return User.class;
	}
}
