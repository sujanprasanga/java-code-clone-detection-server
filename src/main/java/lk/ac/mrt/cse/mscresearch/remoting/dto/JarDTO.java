package lk.ac.mrt.cse.mscresearch.remoting.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class JarDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7074754021644367326L;

	private int primaryKey;
	
	private String name;
	
	private String jarHash;
	
	private String artifact;

	private Set<ClassDTO> classes = new HashSet<>();
	
	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJarHash() {
		return jarHash;
	}

	public void setJarHash(String jarHash) {
		this.jarHash = jarHash;
	}

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public Set<ClassDTO> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassDTO> classes) {
		this.classes = classes;
	}
}
