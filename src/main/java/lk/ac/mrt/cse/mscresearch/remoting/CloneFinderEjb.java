package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import lk.ac.mrt.cse.mscresearch.codeclones.Clone;
import lk.ac.mrt.cse.mscresearch.codeclones.CodeFragmentData;
import lk.ac.mrt.cse.mscresearch.persistance.service.CloneFinderService;
import lk.ac.mrt.cse.mscresearch.spring.ApplicationContextInitializer;

@Stateless
@Remote(CloneFinder.class)
public class CloneFinderEjb implements CloneFinder{

	private CloneFinderService service;

	@PersistenceContext
	private Session session;
	
	@Override
	public List<Clone> find(List<CodeFragmentData> codeFragment, Map<String, Set<String>> dependencyMapping) {
		return service.find(codeFragment, dependencyMapping, session);
	}

	@PostConstruct
	public void startup()
	{
		 ApplicationContextInitializer.initialize();
		 service = ApplicationContextInitializer.get(CloneFinderService.class);
	}
}
