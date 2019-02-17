package lk.ac.mrt.cse.mscresearch.codeclones;

import java.io.Serializable;

public class LibMapping implements Serializable{

	private static final long serialVersionUID = 6629081535624325714L;

	public LibMapping(String clazz, String clazzHash, String archiveName, String archiveHash) {
		super();
		this.clazz = clazz;
		this.clazzHash = clazzHash;
		this.archiveName = archiveName;
		this.archiveHash = archiveHash;
	}
	
	private final String clazz;
	private final String clazzHash;
	private final String archiveName;
	private final String archiveHash;
	
	public String getClazz() {
		return clazz;
	}
	public String getClazzHash() {
		return clazzHash;
	}
	public String getArchiveName() {
		return archiveName;
	}
	public String getArchiveHash() {
		return archiveHash;
	}
	
	public String toString() {
		return archiveName + ":" + clazz;
	}
}
