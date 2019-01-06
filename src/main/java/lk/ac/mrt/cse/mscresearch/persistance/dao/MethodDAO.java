package lk.ac.mrt.cse.mscresearch.persistance.dao;

import java.util.List;

import org.hibernate.Session;
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
}
