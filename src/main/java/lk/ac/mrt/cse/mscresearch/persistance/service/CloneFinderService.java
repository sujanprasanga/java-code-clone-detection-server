package lk.ac.mrt.cse.mscresearch.persistance.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.codeclones.Clone;
import lk.ac.mrt.cse.mscresearch.codeclones.Clone.CloneType;
import lk.ac.mrt.cse.mscresearch.codeclones.CodeFragmentData;
import lk.ac.mrt.cse.mscresearch.codeclones.LibMapping;
import lk.ac.mrt.cse.mscresearch.persistance.dao.MethodDAO;
import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;

@Singleton
@Component
public class CloneFinderService {

	@Autowired
	private MethodDAO methodDao;
	
	public List<Clone> find(List<CodeFragmentData> codeFragments, Session session){
		Set<String> hashes = codeFragments.stream().map(CodeFragmentData::getMethod).collect(Collectors.toSet());
		List<MethodIndex> results = methodDao.findByBodyHash(hashes, session);
		if(results.isEmpty()) {
			return Collections.emptyList();
		}
		return mapResults(codeFragments, results);
	}

	private List<Clone> mapResults(List<CodeFragmentData> codeFragments, List<MethodIndex> results) {
		Map<String, MethodIndex> map = results.stream().collect(Collectors.toMap(MethodIndex::getBodyhash, Function.identity()));
		return codeFragments.stream().filter(f->map.containsKey(f.getMethod()))
		                             .map(f->mapResult(f, map.get(f.getMethod())))
		                             .collect(Collectors.toCollection(ArrayList::new));
	}

	private Clone mapResult(CodeFragmentData f, MethodIndex methodIndex) {
		Clone c = new Clone();
		c.setType(CloneType.LIB);
		c.setProject(f.getProject());
		c.setClazz(f.getClazz());
		c.setMethod(f.getMethod());
		c.setLineRange(f.getLineRange());
		c.setLibMapping(toLibMapping(methodIndex));
		return c;
	}

	private Set<LibMapping> toLibMapping(MethodIndex methodIndex) {
		return methodIndex.getClasses().stream().map(this::toLibMapping).flatMap(Set::stream).collect(Collectors.toSet());
	}
	
	private Set<LibMapping> toLibMapping(ClassIndex classIndex) {
		return classIndex.getJars().stream().map(j->toLibMapping(j,classIndex)).collect(Collectors.toSet());
	}
	
	private LibMapping toLibMapping(JarIndex j, ClassIndex c) {
		return new LibMapping(c.getClassName(), c.getClassHash(), j.getName(), j.getJarHash());
	}
}
