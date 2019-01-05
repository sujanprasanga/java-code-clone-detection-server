package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
	public void index(JarDTO jar) {
		service.index(jar, session);
	}

	@Override
	public Map<String, ClassDTO> getIndexedClasses(Set<ClassDTO> classes) {
		// TODO Auto-generated method stub
		return null;
	}

}
