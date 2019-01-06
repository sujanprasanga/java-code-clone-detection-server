package lk.ac.mrt.cse.mscresearch.persistance.mappers;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.ClassIndex;
import lk.ac.mrt.cse.mscresearch.remoting.dto.ClassDTO;

@Component
@Singleton
public class ClassMapper extends CollectionMapper<ClassIndex, ClassDTO> {

	@Autowired
	private JarMapper jarMapper;
	@Autowired
	private MethodMapper methodMapper;
	
	public ClassIndex mapFromDTO(ClassDTO dto) {
		ClassIndex index = new ClassIndex();
		index.setPrimaryKey(dto.getPrimaryKey());
		index.setClassName(dto.getClassName());
		index.setClassHash(dto.getClassHash());
		index.setJar(jarMapper.mapFromDTO(dto.getJars()));
		index.setMethods(methodMapper.mapFromDTO(dto.getMethods()));
		System.out.println(index.getClassName() + " " + index.getClassHash());
		return index;
	}
	
	public ClassDTO mapToDTO(ClassIndex index) {
		ClassDTO dto = new ClassDTO();
		dto.setPrimaryKey(index.getPrimaryKey());
		dto.setClassName(index.getClassName());
		dto.setClassHash(index.getClassHash());
		dto.setJar(jarMapper.mapToDTO(index.getJars()));
		dto.setMethods(methodMapper.mapToDTO(index.getMethods()));
		return dto;
	}
}
