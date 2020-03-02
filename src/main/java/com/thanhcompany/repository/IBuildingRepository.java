package com.thanhcompany.repository;

import java.util.List;
import java.util.Map;

import com.thanhcompany.builder.BuildingSearchBuilder;
import com.thanhcompany.dto.BuildingDTO;
import com.thanhcompany.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
	List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder);
}
