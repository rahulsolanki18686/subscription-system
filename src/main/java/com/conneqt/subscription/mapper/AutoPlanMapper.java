package com.conneqt.subscription.mapper;


import com.conneqt.subscription.dto.PlanDto;
import com.conneqt.subscription.entity.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoPlanMapper {

    AutoPlanMapper MAPPER = Mappers.getMapper(AutoPlanMapper.class);
    PlanDto mapToPlanDto(Plan user);
    Plan mapTOPlan(PlanDto userDto);
}
