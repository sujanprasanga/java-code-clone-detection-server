package lk.ac.mrt.cse.mscresearch.persistance.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.codeclones.Clone;
import lk.ac.mrt.cse.mscresearch.codeclones.CodeFragmentData;
import lk.ac.mrt.cse.mscresearch.persistance.dao.MethodDAO;
import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;
import lk.ac.mrt.cse.mscresearch.util.ResultMapper;

@Singleton
@Component
public class CloneFinderService {

	@Autowired
	private MethodDAO methodDao;
	
	public List<Clone> find(List<CodeFragmentData> codeFragments, Map<String, Set<String>> dependencyMapping, Session session){
		Set<String> hashes = codeFragments.stream().map(CodeFragmentData::getMethodHash).collect(Collectors.toSet());
		List<MethodIndex> results = methodDao.findByBodyHash(hashes, session);
		if(results.isEmpty()) {
			return Collections.emptyList();
		}
		return new ResultMapper(codeFragments, results, dependencyMapping).map();
	}
}
