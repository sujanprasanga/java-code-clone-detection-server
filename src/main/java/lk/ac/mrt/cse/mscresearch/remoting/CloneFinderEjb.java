package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.ArrayList;
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
		List<Clone> l = new ArrayList<>();
		splitCollectionToParamLimit(codeFragment).forEach(f->l.addAll(service.find(f, dependencyMapping, session)));
		return l;
	}

	private List<List<CodeFragmentData>> splitCollectionToParamLimit(List<CodeFragmentData> fragments) {
		List<List<CodeFragmentData>> l = new ArrayList<>();
		List<CodeFragmentData> tmp = new ArrayList<>(fragments);
		for(int i=0; i<fragments.size(); i+=2000) {
			if(fragments.size() >= i+2000)
			{
				l.add(tmp.subList(i, i + 2000));
			} else {
				l.add(tmp.subList(i, fragments.size()));
			}
		}
		return l;
	}
	
	@PostConstruct
	public void startup()
	{
		 ApplicationContextInitializer.initialize();
		 service = ApplicationContextInitializer.get(CloneFinderService.class);
	}
}
