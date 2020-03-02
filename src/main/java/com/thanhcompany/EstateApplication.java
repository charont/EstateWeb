package com.thanhcompany;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.thanhcompany.builder.BuildingSearchBuilder;
import com.thanhcompany.dto.BuildingDTO;
import com.thanhcompany.entity.BuildingEntity;
import com.thanhcompany.service.IBuildingService;
import com.thanhcompany.service.impl.BuildingService;

public class EstateApplication {

	public static void main(String[] args) {

//		String name = "building";
//		String district = "QUAN_1";
//		String[] types = new String[] { "TANG_TRET","NOI_THAT"};/*"NGUYEN_CAN"*/
//		String rentAreaFrom = "500";
//		String rentAreaTo = "500";
//		String rentCostFrom = "1";
//		String rentCostTo = "2";
//		String numberOfBasement = "2";
//		String floorArea = "500";
//		Long staffId=2L;
//		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
//				.setName(name)
//				//.setDistrict(district)
//				//.setFloorArea(floorArea).setNumberOfBasement(numberOfBasement)
//			//	.setRentAreaFrom(rentAreaFrom)
//				//.setRentAreaTo(rentAreaTo)
//			//	.setTypes(types)
//			//	.setRentCostFrom(rentCostFrom).setRentCostTo(rentCostTo)
//				//.setStaffId(staffId)
//				.build();
//		IBuildingService buildingService = new BuildingService();
//		List<BuildingDTO> result = buildingService.findAll(builder);
//		System.out.println(result);
//		
//		BuildingDTO dto=new BuildingDTO();
//		dto.setName("Phước Thành");
//		dto.setWard("Phường 10");
//		dto.setCreateddate(new Date());
//		dto.setId(5L);
//		IBuildingService buildingService=new BuildingService();
//		buildingService.upgrade(dto,dto.getId(),6L);
		
		
//		StringBuilder sqlQuery=new StringBuilder("Update set sdadsa, dasdasd, dsadasd,,");
//		sqlQuery.deleteCharAt(sqlQuery.lastIndexOf(","));
//		System.out.println(sqlQuery.toString());
//		System.out.println(sqlQuery.lastIndexOf(","));
			
<<<<<<< HEAD
		IBuildingService buildingService = new BuildingService();
		 buildingService.dropById(3L);
//		BuildingDTO dto=new BuildingDTO();
//		dto.setName("Phước Thành");
//		dto.setWard("Phường 10");
//		IBuildingService buildingService = new BuildingService();
//		 buildingService.save(dto);
=======
//		IBuildingService buildingService = new BuildingService();
//		 buildingService.dropById(5L,6L);
		BuildingDTO dto=new BuildingDTO();
		dto.setName("Mỹ Linh TOWER");
		dto.setWard("Phường 12");
		dto.setNumberOfBasement(5);
		IBuildingService buildingService = new BuildingService();
		buildingService.dropRandom(dto);
//		IBuildingService buildingService = new BuildingService();
//		 buildingService.save(dto);
		
>>>>>>> DeleteRandom
	}

}
