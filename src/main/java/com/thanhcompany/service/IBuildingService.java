package com.thanhcompany.service;

import java.util.List;
import com.thanhcompany.builder.BuildingSearchBuilder;
import com.thanhcompany.dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	List<BuildingDTO> findById(Object...ids);
	void save(BuildingDTO dto);
	void upgrade(BuildingDTO dto,Object ...where);
	void dropById(Object... ids);
	void dropRandom(BuildingDTO dto);
}
