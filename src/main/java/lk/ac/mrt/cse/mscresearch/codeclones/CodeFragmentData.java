package lk.ac.mrt.cse.mscresearch.codeclones;

import java.io.Serializable;
import java.util.Set;

public class CodeFragmentData implements Serializable{

	private static final long serialVersionUID = -483950264039728711L;
	
	private String project;
	private String clazz;
	private String methodHash;
	private String methodSignature;
	private int transformerType;
	private boolean isSegment;
	private int[] lineRange;
	
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
	public String getMethodHash() {
		return methodHash;
	}
	public void setMethodHash(String method) {
		this.methodHash = method;
	}
	public int getTransformerType() {
		return transformerType;
	}
	public void setTransformerType(int transformerType) {
		this.transformerType = transformerType;
	}
	public int[] getLineRange() {
		return lineRange;
	}
	public void setLineRange(int[] lineRange) {
		this.lineRange = lineRange;
	}
	public String getMethodSignature() {
		return methodSignature;
	}
	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}
	public boolean isSegment() {
		return isSegment;
	}
	public void setSegment(boolean isSegment) {
		this.isSegment = isSegment;
	}
}
