package lk.ac.mrt.cse.mscresearch.persistance.mappers;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class CollectionMapper<E,D> {
	
	public abstract E mapFromDTO(D d);
	public abstract D mapToDTO(E e);
	
	public Set<E> mapFromDTO(Collection<D> t) {
		return map(t, this::mapFromDTO);
	}
	
	public Set<D> mapToDTO(Collection<E> t) {
		return map(t, this::mapToDTO);
	}
	
	private <T,R> Set<R> map(Collection<T> t, Function<T,R> mapper) {
		if(t == null || t.isEmpty()) {
			return Collections.emptySet();
		}
		return t.stream().map(mapper).collect(Collectors.toSet());
	}
}
