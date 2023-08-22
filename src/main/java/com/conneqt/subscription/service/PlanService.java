package com.conneqt.subscription.service;

import com.conneqt.subscription.dto.PlanDto;

import java.util.List;

public interface PlanService {

    PlanDto createPlan(PlanDto userDto);
    PlanDto getPlanById(Long userId);

    List<PlanDto> getAllPlans();

    PlanDto updatePlan(PlanDto userDto);

    void deletePlan(Long userId);
}
