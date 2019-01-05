package lk.ac.mrt.cse.mscresearch.remoting.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MethodDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3854539925616303236L;

	private int primaryKey;
	
	private String body;
	
	private String bodyhash;
	
	private int pluginid;
	
	private String signature;
	
	private Set<ClassDTO> classes = new HashSet<>();

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getBody() {
		return body == null ? "" : body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBodyhash() {
		return bodyhash;
	}

	public void setBodyhash(String bodyhash) {
		this.bodyhash = bodyhash;
	}

	public int getPluginid() {
		return pluginid;
	}

	public void setPluginid(int pluginid) {
		this.pluginid = pluginid;
	}

	public Set<ClassDTO> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassDTO> classes) {
		this.classes = classes;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
