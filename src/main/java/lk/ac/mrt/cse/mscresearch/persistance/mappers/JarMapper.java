package lk.ac.mrt.cse.mscresearch.persistance.mappers;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.JarIndex;
import lk.ac.mrt.cse.mscresearch.remoting.dto.JarDTO;

@Component
@Singleton
public class JarMapper extends CollectionMapper<JarIndex, JarDTO> {

	@Autowired
	private ClassMapper classMapper;

	public JarIndex mapFromDTO(JarDTO dto) {
		JarIndex index = new JarIndex();
		index.setArtifact(dto.getArtifact());
		index.setClasses(classMapper.mapFromDTO(dto.getClasses()));
		index.setJarHash(dto.getJarHash());
		index.setName(dto.getName());
		index.setPrimaryKey(dto.getPrimaryKey());
		return index;
	}
	
	public JarDTO mapToDTO(JarIndex index) {
		JarDTO dto = new JarDTO();
		dto.setArtifact(index.getArtifact());
		dto.setClasses(classMapper.mapToDTO(index.getClasses()));
		dto.setJarHash(index.getJarHash());
		dto.setName(index.getName());
		dto.setPrimaryKey(index.getPrimaryKey());
		return dto;
	}

}
