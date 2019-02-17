package lk.ac.mrt.cse.mscresearch.persistance.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;

@Component
public class MethodDAO extends AbstractDAO<MethodIndex> {

	private MethodBodyDAO methodBodyDAO;
	
	@Autowired
	public MethodDAO(MethodBodyDAO methodBodyDAO) {
		this.methodBodyDAO = methodBodyDAO;
	}

	@Override
	public Class<MethodIndex> getEntityClass() {
		return MethodIndex.class;
	}

	@Override
	protected String getHashQuarryValueField() {
		return "uniqueHash";
	}

	@Override
	protected String getHashQuarryValue(MethodIndex entity) {
		return entity.getUniqueHash();
	}

	@Override
	public MethodIndex createIfNotExists(MethodIndex entity, Session session) {
		List<MethodIndex> byHashOf = getByHashOf(getHashQuarryValue(entity), session);
		if(byHashOf.isEmpty()){
			MethodIndex saved = save(entity, session);
			methodBodyDAO.save(saved.getBodyEntity(), session);
			return saved;
		}
		else{
			return byHashOf.get(0);
		}
	}
	
	public List<MethodIndex> findByBodyHash(Set<String> hashes, Session session){
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<MethodIndex> criteria = builder.createQuery(getEntityClass());
		Root<MethodIndex> root = criteria.from(getEntityClass());
		Path<MethodIndex> hashColumn = root.<MethodIndex> get("bodyhash");
		Predicate in = hashColumn.in(hashes);
		criteria.where(in);
		Query<MethodIndex> quarry = session.createQuery(criteria);
		return quarry.getResultList();
	}
}
