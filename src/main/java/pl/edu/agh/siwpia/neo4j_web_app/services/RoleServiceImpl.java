package pl.edu.agh.siwpia.neo4j_web_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.agh.siwpia.neo4j_web_app.daos.AbstractDao;
import pl.edu.agh.siwpia.neo4j_web_app.daos.RoleDao;
import pl.edu.agh.siwpia.neo4j_web_app.entities.Role;

@Service
public class RoleServiceImpl extends AbstractServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public AbstractDao<Role> getDao() {
		return roleDao;
	}

}
