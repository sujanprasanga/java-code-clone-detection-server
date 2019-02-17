package lk.ac.mrt.cse.mscresearch.codeclones;

import java.io.Serializable;

public class CodeFragmentData implements Serializable{

	private static final long serialVersionUID = -483950264039728711L;
	
	private String project;
	private String clazz;
	private String method;
	private int transformerType;
	private String lineRange;
	
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
	public int getTransformerType() {
		return transformerType;
	}
	public void setTransformerType(int transformerType) {
		this.transformerType = transformerType;
	}
	public String getLineRange() {
		return lineRange;
	}
	public void setLineRange(String lineRange) {
		this.lineRange = lineRange;
	}
}
