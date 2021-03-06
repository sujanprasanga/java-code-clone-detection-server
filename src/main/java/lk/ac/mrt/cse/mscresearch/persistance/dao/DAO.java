package lk.ac.mrt.cse.mscresearch.persistance.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import lk.ac.mrt.cse.mscresearch.persistance.entities.EntityId;

public interface DAO<T extends EntityId> {

	T save(T entity, Session session);
	T getById(int id, Session session);
	List<T> saveAll(Collection<T> entities, Session session);
//	T update(T entity);
//	List<T> updateAll(List<T> entities);
	List<T> getByHashOf(Collection<String> hash, Session session);
	List<T> getByIds(List<Integer> ids, Session session);
	T createIfNotExists(T entity, Session session);
	Class<T> getEntityClass();
	List<T> getByHashOf(String hash, Session session);
}
