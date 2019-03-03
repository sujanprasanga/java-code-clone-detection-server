package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;

public interface ByteCodePersistor {

	boolean isJarIndexed(String hash);
	Set<JarDTO> getIndexedJars(Set<JarDTO> jars);
	void indexJar(JarDTO jar);
	Map<String, ClassDTO> getIndexedClasses(Set<ClassDTO> classes);
	Map<String, ClassDTO> getIndexedClasses(Collection<String> values);
	ClassDTO indexClass(ClassDTO classDTO);
	List<ClassDTO> indexClasses(List<ClassDTO> classDTO);
	Map<String, Boolean> isIndexed(Set<String> jarHashes);
}
