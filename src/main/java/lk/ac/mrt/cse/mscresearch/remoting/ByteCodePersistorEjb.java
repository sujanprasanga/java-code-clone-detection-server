package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import lk.ac.mrt.cse.mscresearch.persistance.service.ByteCodePersistorService;
import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;
import lk.ac.mrt.cse.mscresearch.spring.ApplicationContextInitializer;

@Stateless
@Remote(ByteCodePersistor.class)
public class ByteCodePersistorEjb implements ByteCodePersistor{

	private ByteCodePersistorService service;
	
	@PersistenceContext
	private Session session;
	
	@PostConstruct
	public void startup()
	{
		 ApplicationContextInitializer.initialize();
		 service = ApplicationContextInitializer.get(ByteCodePersistorService.class);
	}
	
	@Override
	public Set<JarDTO> getIndexedJars(Set<JarDTO> jars) {
		return service.getIndexedJars(jars, session);
	}

	@Override
	public void indexJar(JarDTO jar) {
		service.indexJar(jar, session);
	}

	@Override
	public Map<String, ClassDTO> getIndexedClasses(Set<ClassDTO> classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJarIndexed(String hash) {
		return service.isJarIndexed(hash, session);
	}

	@Override
	public Map<String, ClassDTO> getIndexedClasses(Collection<String> hashes) {
		Map<String, ClassDTO> map = new HashMap<>();
		splitCollectionToParamLimit(hashes).forEach(h->map.putAll(service.getIndexedClasses(h, session)));
		return map;
	}

	private List<List<String>> splitCollectionToParamLimit(Collection<String> hashes) {
		List<List<String>> l = new ArrayList<>();
		List<String> tmp = new ArrayList<>(hashes);
		for(int i=0; i<hashes.size(); i+=2000) {
			if(hashes.size() >= i+2000)
			{
				l.add(tmp.subList(i, i + 2000));
			} else {
				l.add(tmp.subList(i, hashes.size()));
			}
		}
		return l;
	}

	@Override
	public ClassDTO indexClass(ClassDTO classDTO) {
//		try {
			return service.indexClass(classDTO, session);
//		} catch(Exception e) {
//			return null;
//		}
	}

	@Override
	public List<ClassDTO> indexClasses(List<ClassDTO> classDTO) {
		return classDTO.stream().map(this::indexClass).filter(e->e!=null).collect(Collectors.toList());
	}

	@Override
	public Map<String, Boolean> isIndexed(Set<String> jarHashes) {
		return service.isIndexed(jarHashes, session);
	}

}
