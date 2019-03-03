package lk.ac.mrt.cse.mscresearch.persistance.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lk.ac.mrt.cse.mscresearch.util.Hashing;

@Entity
@Table(name="method_index")
public class MethodIndex  implements EntityId {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="primaryKey")
	private int primaryKey;
	
	@Transient
	private String body;
	
	@Column(name="bodyhash")
	private String bodyhash;
	
	@Column(name="body_signature_hash")
	private String uniqueHash;
	
	@Column(name="pluginid")
	private int pluginid;
	
	@Column(name="methodsignature")
	private String signature;
	
	@Column(name="size")
	private int size;
	
	@ManyToMany(mappedBy = "methods")
	private Set<ClassIndex> classes = new HashSet<>();

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Transient
	public String getBody() {
		return body;
	}

	public void setBody(MethodBody body) {
		this.body = body.getBody();
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

	public String getUniqueHash() {
		return uniqueHash;
	}

	public void setUniqueHash(String uniqueHash) {
		this.uniqueHash = uniqueHash;
	}

	public int getPluginid() {
		return pluginid;
	}

	public void setPluginid(int pluginid) {
		this.pluginid = pluginid;
	}

	public Set<ClassIndex> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassIndex> classes) {
		this.classes = classes;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public MethodBody getBodyEntity() {
		MethodBody methodBody = new MethodBody();
		methodBody.setBody(body);
		methodBody.setPrimaryKey(primaryKey);
		return methodBody;
	}

	public void calculateUniqueHash() {
		setUniqueHash(Hashing.hash(bodyhash + signature));
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "MethodIndex [primaryKey=" + primaryKey + ", body=" + body + ", bodyhash=" + bodyhash + ", uniqueHash="
				+ uniqueHash + ", pluginid=" + pluginid + ", signature=" + signature + ", size=" + size + "]";
	}
}
