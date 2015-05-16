package pl.edu.agh.siwpia.neo4j_web_app.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public T create(T entity) {

		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	public EntityManager getEm() {
		return em;
	}

	@Override
	public abstract Class<T> getEntityclass();

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public T retrive(Long id) {
		return em.getReference(getEntityclass(), id);
	}

	@Override
	public T selectEntityBy(SingularAttribute attribute, Object value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityclass());
		Root<T> root = cq.from(getEntityclass());
		cq.where(cb.equal(root.get(attribute), value));
		TypedQuery<T> query = em.createQuery(cq);
		T result = null;
		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			// nothing has to happen
		}

		return result;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public T update(T entity) {
		em.merge(entity);
		return entity;
	}

}
