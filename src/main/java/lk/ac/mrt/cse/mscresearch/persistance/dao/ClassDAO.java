package lk.ac.mrt.cse.mscresearch.persistance.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;

@Component
public class ClassDAO extends AbstractDAO<ClassIndex> {

	@Autowired
	private MethodDAO methodDao;
	
	@Override
	public ClassIndex save(ClassIndex entity, Session session) {
		List<MethodIndex> saved = methodDao.saveAll(entity.getMethods(), session);
		entity.setMethods(saved.stream().collect(Collectors.toSet()));
		return super.save(entity, session);
	}
	
	@Override
	public Class<ClassIndex> getEntityClass() {
		return ClassIndex.class;
	}

	@Override
	protected String getHashQuarryValueField() {
		return "classHash";
	}

	@Override
	protected String getHashQuarryValue(ClassIndex entity) {
		return entity.getClassHash();
	}

}
