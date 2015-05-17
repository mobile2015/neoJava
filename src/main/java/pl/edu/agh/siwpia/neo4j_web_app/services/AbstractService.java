package pl.edu.agh.siwpia.neo4j_web_app.services;

import javax.persistence.metamodel.SingularAttribute;

import pl.edu.agh.siwpia.neo4j_web_app.daos.AbstractDao;

public abstract interface AbstractService<T> {

	T create(T entity);

	void delete(Long id);

	AbstractDao<T> getDao();

	T retrtive(Long id);

	T selectEntityBy(SingularAttribute attribute, Object value);

	T update(T entity);
}
