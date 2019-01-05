package lk.ac.mrt.cse.mscresearch.persistance.dao;

import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;

public class ClassDAO extends AbstractDAO<ClassIndex> {

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
