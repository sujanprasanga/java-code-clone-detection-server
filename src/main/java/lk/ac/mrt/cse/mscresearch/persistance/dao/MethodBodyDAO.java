package lk.ac.mrt.cse.mscresearch.persistance.dao;

import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodBody;

@Component
public class MethodBodyDAO extends AbstractDAO<MethodBody> {

	@Override
	public Class<MethodBody> getEntityClass() {
		return MethodBody.class;
	}

	@Override
	protected String getHashQuarryValueField() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected String getHashQuarryValue(MethodBody entity) {
		throw new UnsupportedOperationException();
	}

}
