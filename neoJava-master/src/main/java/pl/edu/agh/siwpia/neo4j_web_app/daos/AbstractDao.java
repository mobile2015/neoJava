package pl.edu.agh.siwpia.neo4j_web_app.daos;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;

public abstract interface AbstractDao<T> {

	T create(T entity);

	void delete(T entity);

	Class<T> getEntityclass();

	EntityManager getEntityManager();

	T retrive(Long id);

	T selectEntityBy(SingularAttribute attribute, Object value);

	T update(T entity);
}
