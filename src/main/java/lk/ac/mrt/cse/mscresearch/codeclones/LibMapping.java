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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archiveHash == null) ? 0 : archiveHash.hashCode());
		result = prime * result + ((archiveName == null) ? 0 : archiveName.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((clazzHash == null) ? 0 : clazzHash.hashCode());
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
		LibMapping other = (LibMapping) obj;
		if (archiveHash == null) {
			if (other.archiveHash != null)
				return false;
		} else if (!archiveHash.equals(other.archiveHash))
			return false;
		if (archiveName == null) {
			if (other.archiveName != null)
				return false;
		} else if (!archiveName.equals(other.archiveName))
			return false;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (clazzHash == null) {
			if (other.clazzHash != null)
				return false;
		} else if (!clazzHash.equals(other.clazzHash))
			return false;
		return true;
	}
}
