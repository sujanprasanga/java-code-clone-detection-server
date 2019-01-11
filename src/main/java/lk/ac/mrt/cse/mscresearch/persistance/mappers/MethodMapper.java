package lk.ac.mrt.cse.mscresearch.persistance.mappers;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lk.ac.mrt.cse.mscresearch.persistance.entities.MethodIndex;
import lk.ac.mrt.cse.mscresearch.remoting.dto.MethodDTO;

@Component
@Singleton
public class MethodMapper extends CollectionMapper<MethodIndex, MethodDTO> {

	@Autowired
	private ClassMapper classMapper;

	public MethodIndex mapFromDTO(MethodDTO dto) {
		MethodIndex index = new MethodIndex();
		index.setBody(dto.getBody());
		index.setBodyhash(dto.getBodyhash());
		index.setClasses(classMapper.mapFromDTO(dto.getClasses()));
		index.setPluginid(dto.getPluginid());
		index.setPrimaryKey(dto.getPrimaryKey());
		index.setSignature(dto.getSignature());
		index.calculateUniqueHash();
		index.setSize(dto.getSize());
		return index;
	}
	
	public MethodDTO mapToDTO(MethodIndex index) {
		MethodDTO dto = new MethodDTO();
		dto.setBody(index.getBody());
		dto.setBodyhash(index.getBodyhash());
//		dto.setClasses(classMapper.mapToDTO(index.getClasses()));
		dto.setPluginid(index.getPluginid());
		dto.setPrimaryKey(index.getPrimaryKey());
		dto.setSignature(index.getSignature());
		dto.setSize(index.getSize());
		return dto;
	}

}
