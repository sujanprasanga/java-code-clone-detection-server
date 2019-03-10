package lk.ac.mrt.cse.mscresearch.codeclones;

import java.io.Serializable;

public class Clone implements Serializable {

	private static final long serialVersionUID = -2463612326510616129L;
	
	public enum CloneType{
		LOCAL,
		LIB
	}
	
	private String project;
	private String clazz;
	private String method;
	private String methodHash;
	private String lineRange;
	private String targetArchive;
	private String targetClass;
	private String targetMethod;
	private CloneType type;
	private LibMapping libMapping;
	private int pluginCode;
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getLineRange() {
		return lineRange;
	}
	public void setLineRange(String lineRange) {
		this.lineRange = lineRange;
	}
	public String getTargetArchive() {
		return targetArchive;
	}
	public void setTargetArchive(String targetArchive) {
		this.targetArchive = targetArchive;
	}
	public String getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public CloneType getType() {
		return type;
	}
	public void setType(CloneType type) {
		this.type = type;
	}
	public LibMapping getLibMapping() {
		return libMapping;
	}
	public void setLibMapping(LibMapping libMapping) {
		this.libMapping = libMapping;
	}
	public String getMethodHash() {
		return methodHash;
	}
	public void setMethodHash(String methodHash) {
		this.methodHash = methodHash;
	}
	public int getPluginCode() {
		return pluginCode;
	}
	public void setPluginCode(int pluginCode) {
		this.pluginCode = pluginCode;
	}
	
	public int getCloneUniqueHash() {
		return hashCode();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((libMapping == null) ? 0 : libMapping.hashCode());
		result = prime * result + ((lineRange == null) ? 0 : lineRange.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
//		result = prime * result + ((methodHash == null) ? 0 : methodHash.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((targetArchive == null) ? 0 : targetArchive.hashCode());
		result = prime * result + ((targetClass == null) ? 0 : targetClass.hashCode());
		result = prime * result + ((targetMethod == null) ? 0 : targetMethod.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clone other = (Clone) obj;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (libMapping == null) {
			if (other.libMapping != null)
				return false;
		} else if (!libMapping.equals(other.libMapping))
			return false;
		if (lineRange == null) {
			if (other.lineRange != null)
				return false;
		} else if (!lineRange.equals(other.lineRange))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		// do not compare method hash they are different for different plugin types
//		if (methodHash == null) {
//			if (other.methodHash != null)
//				return false;
//		} else if (!methodHash.equals(other.methodHash))
//			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (targetArchive == null) {
			if (other.targetArchive != null)
				return false;
		} else if (!targetArchive.equals(other.targetArchive))
			return false;
		if (targetClass == null) {
			if (other.targetClass != null)
				return false;
		} else if (!targetClass.equals(other.targetClass))
			return false;
		if (targetMethod == null) {
			if (other.targetMethod != null)
				return false;
		} else if (!targetMethod.equals(other.targetMethod))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	}
