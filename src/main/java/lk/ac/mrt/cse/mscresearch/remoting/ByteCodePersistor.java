package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.Map;
import java.util.Set;

import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;

public interface ByteCodePersistor {

	Set<JarDTO> getIndexedJars(Set<JarDTO> jars);
	void index(JarDTO jar);
	Map<String, ClassDTO> getIndexedClasses(Set<ClassDTO> classes);
}
