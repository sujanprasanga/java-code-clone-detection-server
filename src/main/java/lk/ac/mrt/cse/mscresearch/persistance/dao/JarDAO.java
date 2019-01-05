package lk.ac.mrt.cse.mscresearch.persistance.dao;

import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;

@Component
public class JarDAO extends AbstractDAO<JarIndex> {

	@Override
	public Class<JarIndex> getEntityClass() {
		return JarIndex.class;
	}

	@Override
	public String getHashQuarryValue(JarIndex entity) {
		return entity.getJarHash();
	}

	@Override
	public String getHashQuarryValueField() {
		return "jarHash";
	}

}
