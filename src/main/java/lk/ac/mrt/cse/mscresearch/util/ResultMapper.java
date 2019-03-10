package lk.ac.mrt.cse.mscresearch.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lk.ac.mrt.cse.mscresearch.codeclones.Clone;
import lk.ac.mrt.cse.mscresearch.codeclones.Clone.CloneType;
import lk.ac.mrt.cse.mscresearch.codeclones.CodeFragmentData;
import lk.ac.mrt.cse.mscresearch.codeclones.LibMapping;
import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;

public class ResultMapper {

	private final List<CodeFragmentData> codeFragments;
	private final List<MethodIndex> results;
	private final Map<String, Set<String>> dependencyMapping;
	
	
	public ResultMapper(List<CodeFragmentData> codeFragments, List<MethodIndex> results, Map<String, Set<String>> dependencyMapping) {
		this.codeFragments = codeFragments;
		this.results = results;
		this.dependencyMapping = dependencyMapping;
	}

	public List<Clone> map() {
		if(dependencyMapping.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, List<MethodIndex>> resultMap = results.stream().collect(Collectors.groupingBy(MethodIndex::getBodyhash));
		Map<String, List<CodeFragmentData>> f = codeFragments.stream().collect(Collectors.groupingBy(CodeFragmentData::getMethodHash));
		return resultMap.keySet().stream().map(r->this.mapResult(f.get(r), resultMap.get(r))).flatMap(List::stream).collect(Collectors.toList());
	}

	private List<Clone> mapResult(List<CodeFragmentData> f,  List<MethodIndex> methodIndexes) {
		return f.stream().map(e->mapResult(e, methodIndexes)).flatMap(List::stream).collect(Collectors.toList());
	}
	
	private List<Clone> mapResult(CodeFragmentData f,  List<MethodIndex> methodIndexes) {
		return methodIndexes.stream().map(m->mapResult(f, m)).flatMap(List::stream).collect(Collectors.toList());
	}
	
	private List<Clone> mapResult(CodeFragmentData f,  MethodIndex methodIndex) {
		Set<LibMapping> libMapping = findLibMapping(f.getProject(), methodIndex);
		if(libMapping.isEmpty()) {
			return Collections.emptyList();
		}
		return libMapping.stream().map(l->mapResult(f, methodIndex, l)).collect(Collectors.toList());
	}
	
	private Clone mapResult(CodeFragmentData f,  MethodIndex methodIndex, LibMapping libMapping) {
		Clone c = new Clone();
		c.setType(CloneType.LIB);
		c.setProject(f.getProject());
		c.setClazz(f.getClazz());
		c.setMethodHash(f.getMethodHash());
		c.setMethod(f.getMethodSignature());
		c.setLineRange(f.getLineRange());
		c.setLibMapping(libMapping);
		c.setTargetMethod(methodIndex.getSignature());
		c.setPluginCode(methodIndex.getPluginid());
		return c;
	}

	private Set<LibMapping> findLibMapping(String project, MethodIndex methodIndex) {
		return methodIndex.getClasses().stream().map(c->toLibMapping(c, project)).flatMap(Set::stream).collect(Collectors.toSet());
	}

	private Set<LibMapping> toLibMapping(ClassIndex classIndex, String project) {
		return classIndex.getJars().stream().map(j->toLibMapping(j,classIndex, project))
				                            .filter(Optional::isPresent)
				                            .map(Optional::get)
				                            .collect(Collectors.toSet());
	}
	
	private Optional<LibMapping> toLibMapping(JarIndex j, ClassIndex c, String project) {
		Set<String> projectDependencies = dependencyMapping.get(project);
		if(projectDependencies!= null && projectDependencies.contains(j.getJarHash())) {
			return Optional.of(new LibMapping(c.getClassName(), c.getClassHash(), j.getName(), j.getJarHash()));
		} else {
			return Optional.empty();
		}
	}
}
