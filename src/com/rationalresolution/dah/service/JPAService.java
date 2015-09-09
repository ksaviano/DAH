package com.rationalresolution.dah.service;

import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAService<T> implements CRUDService<T> {
	// Fields
	@PersistenceContext
	protected EntityManager em;

	private Class<T> cls;
	private String getAllQuery;
	private String getCountQuery;
	private Function<T, Integer> IDGetter;
	private boolean naturalKeys;

	// Constructor
	public JPAService(Class<T> cls, Function<T, Integer> IDGetter) {
		this.cls = cls;
		this.IDGetter = IDGetter;

		getAllQuery = "select x from " + cls.getSimpleName() + " x";
		getCountQuery = "select count(x) from " + cls.getSimpleName() + " x";
	}

	public boolean isNaturalKeys() 					{ return naturalKeys;	}
	public void setNaturalKeys(boolean newValue) 	{ naturalKeys = newValue;	}
	public long getCount() 							{ return em.createQuery(getCountQuery, Long.class).getSingleResult(); }

	@SuppressWarnings("unchecked")
	public List<T> getAll() 						{ return em.createQuery(getAllQuery).getResultList();	}

	public T getByID(int ID) throws NotFoundException {
		T result = em.find(cls, ID);
		if (result == null)
			throw new NotFoundException(cls, ID);

		return result;
	}

	public T add(T newObject) {
		if (naturalKeys) {
			throw new UnsupportedOperationException("This entity type only supports pre-set or \"natural\" IDs.");
		}
		em.persist(newObject);
		return newObject;
	}

	public void add(int ID, T newObject) throws ConflictException {
		if (!naturalKeys) {
			throw new UnsupportedOperationException("This entity type only supports generated IDs.");
		}
		T check = em.find(cls, ID);
		if (check != null) {
			throw new ConflictException(newObject, ID);
		}
		em.persist(newObject);
	}

	public T update(T modifiedObject) throws NotFoundException {
		int ID = IDGetter.apply(modifiedObject);
		T check = em.find(cls, ID);
		if (check == null) {
			throw new CRUDService.NotFoundException(cls, ID);
		}
		return em.merge(modifiedObject);
	}

	public void remove(T oldObject) throws NotFoundException {
		int ID = IDGetter.apply(oldObject);
		T doomed = em.find(cls, ID);
		if (doomed == null) {
			throw new CRUDService.NotFoundException(cls, ID);
		}
		em.remove(doomed);
	}

	public void removeByID(int ID) throws NotFoundException {
		T doomed = em.find(cls, ID);
		if (doomed == null) {
			throw new NotFoundException(cls, ID);
		}
		em.remove(doomed);
	}

	public Class<T> getEntityClass() {
		return cls;
	}
}
