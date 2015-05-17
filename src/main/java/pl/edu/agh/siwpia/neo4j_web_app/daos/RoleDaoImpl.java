package pl.edu.agh.siwpia.neo4j_web_app.daos;

import org.springframework.stereotype.Repository;

import pl.edu.agh.siwpia.neo4j_web_app.entities.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role> implements RoleDao {

	@Override
	public Class<Role> getEntityclass() {
		return Role.class;
	}
}
