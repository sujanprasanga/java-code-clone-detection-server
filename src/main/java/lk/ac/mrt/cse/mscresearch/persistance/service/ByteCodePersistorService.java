package lk.ac.mrt.cse.mscresearch.persistance.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.dao.ClassDAO;
import lk.ac.mrt.cse.mscresearch.persistance.dao.JarDAO;
import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;
import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;
import lk.ac.mrt.cse.mscresearch.persistance.mappers.ClassMapper;
import lk.ac.mrt.cse.mscresearch.persistance.mappers.JarMapper;
import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;

@Singleton
@Component
public class ByteCodePersistorService {
	
	@Autowired
	private JarDAO jarDao;
	
	@Autowired
	private ClassDAO classDao;
	
	@Autowired
	private JarMapper jarMapper;
	
	@Autowired
	private ClassMapper classMapper;
	
	public Set<JarDTO> getIndexedJars(Set<JarDTO> jars, Session session) {
		List<JarIndex> indexedJars = jarDao.getByHashOf(jars.stream().map(JarDTO::getJarHash).collect(Collectors.toSet()), session);
		return jarMapper.mapToDTO(indexedJars);
	}

	public void indexJar(JarDTO jar, Session session) {
		jarDao.save(jarMapper.mapFromDTO(jar), session);
	}

	public boolean isJarIndexed(String hash, Session session) {
		List<JarIndex> j = jarDao.getByHashOf(hash, session);
		return j != null && !j.isEmpty();
	}

	public Map<String, ClassDTO> getIndexedClasses(Collection<String> hashes, Session session) {
		List<ClassIndex> c = classDao.getByHashOf(hashes, session);
		return c.stream().map(classMapper::mapToDTO)
				         .collect(Collectors.toMap(ClassDTO::getClassName, Function.identity()));
	}

	public ClassDTO indexClass(ClassDTO classDTO, Session session) {
		return classMapper.mapToDTO(classDao.save(classMapper.mapFromDTO(classDTO), session));
		
	}

	public Map<String, Boolean> isIndexed(Set<String> jarHashes, Session session) {
		Set<String> existing = jarDao.getByHashOf(jarHashes, session).stream().map(JarIndex::getJarHash).collect(Collectors.toSet());
		return jarHashes.stream().collect(Collectors.toMap(Function.identity(), s->existing.contains(s)));
	}
}
