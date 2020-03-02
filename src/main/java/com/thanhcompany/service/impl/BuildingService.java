package com.thanhcompany.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.thanhcompany.builder.BuildingSearchBuilder;
import com.thanhcompany.converter.BuildingConverter;
import com.thanhcompany.dto.BuildingDTO;
import com.thanhcompany.entity.BuildingEntity;
import com.thanhcompany.repository.IBuildingRepository;
import com.thanhcompany.repository.impl.BuildingRepository;
import com.thanhcompany.service.IBuildingService;

public class BuildingService implements IBuildingService {
	private IBuildingRepository buildingRepository = new BuildingRepository();
	private BuildingConverter buildingConverter = new BuildingConverter();

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
		List<BuildingDTO> results = new ArrayList<>();
		Map<String, Object> params = convertToMapProperties(builder);
		/*
		 * params.put("name", builder.getName()); params.put("district",
		 * builder.getDistrict()); params.put("numberOfBasement",
		 * StringUtils.isNotBlank(builder.getNumberOfBasement())?
		 * Integer.parseInt(builder.getNumberOfBasement()) : null);
		 * params.put("floorArea", StringUtils.isNotBlank(builder.getFloorArea()) ?
		 * Integer.parseInt(builder.getFloorArea() ) : null);
		 */

		List<BuildingEntity> entities = buildingRepository.findAll(params, builder);
		/*
		 * ===============JAVA 7
		 * 
		 * for(BuildingEntity item:entities) { BuildingDTO
		 * dto=buildingConverter.convertEntityToDTO(item); results.add(dto); }
		 */

//		=============JAVA 8
		results = entities.stream().map(item -> buildingConverter.convertEntityToDTO(item))
				.collect(Collectors.toList());

		return results;
	}

	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder builder) {
		Map<String, Object> properties = new HashMap<>();

		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				
				if (!field.getName().startsWith("rentCost") && !field.getName().startsWith("rentArea") && !field.getName().equals("types") && !field.getName().equals("staffId")) {
					System.out.println(field.getName());
					field.setAccessible(true);
					if (field.get(builder) instanceof String) {
						properties.put(field.getName().toLowerCase(), field.get(builder));
					}else {
						if(field.get(builder)!=null && StringUtils.isNotEmpty((String)field.get(builder))) {
							properties.put(field.getName().toLowerCase(), Integer.parseInt((String)field.get(builder)));
						}
						
					}
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}

	@Override
	public void save(BuildingDTO dto) {
		BuildingEntity entity=buildingConverter.convertDTOToEntity(dto);
		buildingRepository.insert(entity);
		
	}

	@Override
	public void upgrade(BuildingDTO dto, Object... where) {
		// TODO Auto-generated method stub
		BuildingEntity entity=buildingConverter.convertDTOToEntity(dto);
		buildingRepository.update(entity,where);
	}

	@Override
	public List<BuildingDTO> findById(Object...ids) {
		List<BuildingDTO> results = new ArrayList<>();
		/*
		 * params.put("name", builder.getName()); params.put("district",
		 * builder.getDistrict()); params.put("numberOfBasement",
		 * StringUtils.isNotBlank(builder.getNumberOfBasement())?
		 * Integer.parseInt(builder.getNumberOfBasement()) : null);
		 * params.put("floorArea", StringUtils.isNotBlank(builder.getFloorArea()) ?
		 * Integer.parseInt(builder.getFloorArea() ) : null);
		 */

		List<BuildingEntity> entities = buildingRepository.findById(ids);
		/*
		 * ===============JAVA 7
		 * 
		 * for(BuildingEntity item:entities) { BuildingDTO
		 * dto=buildingConverter.convertEntityToDTO(item); results.add(dto); }
		 */

//		=============JAVA 8
		results = entities.stream().map(item -> buildingConverter.convertEntityToDTO(item))
				.collect(Collectors.toList());

		return results;
	}
	@Override
	public void dropById(Object... ids) {
		// TODO Auto-generated method stub
		buildingRepository.deleteById(ids);
	}

	@Override
	public void dropRandom(BuildingDTO dto) {
		BuildingEntity entity=buildingConverter.convertDTOToEntity(dto);
		buildingRepository.deleteRandom(entity);
		
	}

}
