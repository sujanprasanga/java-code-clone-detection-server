package lk.ac.mrt.cse.mscresearch.persistance.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Singleton;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.dao.JarDAO;
import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;
import lk.ac.mrt.cse.mscresearch.persistance.mappers.JarMapper;
import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;

@Singleton
@Component
public class ByteCodePersistorService {
	
	@Autowired
	private JarDAO jarDao;
	
	@Autowired
	private JarMapper jarMapper;
	
	public Set<JarDTO> getIndexedJars(Set<JarDTO> jars, Session session) {
		List<JarIndex> indexedJars = jarDao.getByHashOf(jars.stream().map(JarDTO::getJarHash).collect(Collectors.toSet()), session);
		return jarMapper.mapToDTO(indexedJars);
	}

	public void index(JarDTO jar, Session session) {
		jarDao.save(jarMapper.mapFromDTO(jar), session);
	}

	public Map<String, ClassDTO> getIndexedClasses(Set<ClassDTO> classes) {
		// TODO Auto-generated method stub
		return null;
	}
}
