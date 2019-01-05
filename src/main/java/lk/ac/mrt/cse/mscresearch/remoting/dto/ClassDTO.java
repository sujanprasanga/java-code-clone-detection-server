package lk.ac.mrt.cse.mscresearch.remoting.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ClassDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -21958909194167595L;

	private int primaryKey;
	
	private Set<JarDTO> jars = new HashSet<>();
	
	private String className;
	
	private String classHash;
	
	private Set<MethodDTO> methods = new HashSet<>();

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassHash() {
		return classHash;
	}

	public void setClassHash(String classHash) {
		this.classHash = classHash;
	}

	public Set<JarDTO> getJars() {
		return jars;
	}

	public void setJar(Set<JarDTO> jars) {
		this.jars = jars;
	}

	public Set<MethodDTO> getMethods() {
		return methods;
	}

	public void setMethods(Set<MethodDTO> methods) {
		this.methods = methods;
	}
}
