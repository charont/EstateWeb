package com.thanhcompany.converter;

import org.modelmapper.ModelMapper;

import com.thanhcompany.dto.BuildingDTO;
import com.thanhcompany.entity.BuildingEntity;

public class BuildingConverter {
	private ModelMapper modelMapper =new ModelMapper();
	public BuildingDTO convertEntityToDTO(BuildingEntity entity) {
		BuildingDTO buildingDTO=modelMapper.map(entity,BuildingDTO.class);
		return buildingDTO;
	}
	public BuildingEntity convertDTOToEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=modelMapper.map(buildingDTO,BuildingEntity.class);
		return buildingEntity;
	}
	
}
