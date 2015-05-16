package pl.edu.agh.siwpia.neo4j_web_app.services;

import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;

import pl.edu.agh.siwpia.neo4j_web_app.daos.AbstractDao;

public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

	@Override
	@Transactional
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		getDao().delete(getDao().retrive(id));
	}

	@Override
	@Transactional
	public abstract AbstractDao<T> getDao();

	@Override
	@Transactional
	public T retrtive(Long id) {
		T entity = getDao().retrive(id);
		entity.toString();
		return entity;
	}

	@Override
	public T selectEntityBy(SingularAttribute attribute, Object value) {
		return getDao().selectEntityBy(attribute, value);
	}

	@Override
	@Transactional
	public T update(T entity) {
		return getDao().update(entity);
	}
}
