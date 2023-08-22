package com.conneqt.subscription.service.impl;

import com.conneqt.subscription.dto.PlanDto;
import com.conneqt.subscription.entity.Plan;
import com.conneqt.subscription.exception.EmailAlreadyExistsException;
import com.conneqt.subscription.exception.ResourceNotFoundException;
import com.conneqt.subscription.mapper.AutoPlanMapper;
import com.conneqt.subscription.repository.PlanRepository;
import com.conneqt.subscription.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {

    private PlanRepository userRepository;
    @Override
    public PlanDto createPlan(PlanDto userDto) {
//        Plan user = PlanMapper.mapTOPlan(userDto);
        //   Plan user = modelMapper.map(userDto,Plan.class);

        Optional<Plan> optionalPlan = userRepository.findByName(userDto.getName());
        if(optionalPlan.isPresent()){

            throw new EmailAlreadyExistsException("Plan Name Already Exists for Plan");
        }

        Plan user = AutoPlanMapper.MAPPER.mapTOPlan(userDto);

        Plan savedPlan =userRepository.save(user);
        //  PlanDto savedPlanDto = PlanMapper.mapToPlanDto(savedPlan);
        // PlanDto savedPlanDto = modelMapper.map(savedPlan,PlanDto.class);
        PlanDto savedPlanDto = AutoPlanMapper.MAPPER.mapToPlanDto(savedPlan);
        return savedPlanDto;
    }

    @Override
    public PlanDto getPlanById(Long userId) {

        Plan user = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("Plan","id",userId));
        //Plan user = optionalPlan.get();
        //   return PlanMapper.mapToPlanDto(user);
        //  return modelMapper.map(user,PlanDto.class);
        return AutoPlanMapper.MAPPER.mapToPlanDto(user);
    }

    @Override
    public List<PlanDto> getAllPlans() {

        List<Plan> users = userRepository.findAll();
        //  return users.stream().map(PlanMapper::mapToPlanDto).collect(Collectors.toList());
        //   return users.stream().map((user) -> modelMapper.map(user,PlanDto.class)).collect(Collectors.toList());
        return  users.stream().map((user) -> AutoPlanMapper.MAPPER.mapToPlanDto(user)).collect(Collectors.toList());
    }

    @Override
    public PlanDto updatePlan(PlanDto plan) {
        Plan existingPlan = userRepository.findById(plan.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Plan","id",plan.getId())
        );

        existingPlan.setName(plan.getName());
        existingPlan.setPrice(plan.getPrice());
        existingPlan.setPlanDuration(plan.getPlanDuration());
        existingPlan.setChannel(plan.getChannel());
        Plan updatedPlan = userRepository.save(existingPlan);

        // return PlanMapper.mapToPlanDto(updatedPlan);
        // return modelMapper.map(updatedPlan, PlanDto.class);
        return AutoPlanMapper.MAPPER.mapToPlanDto(updatedPlan);
    }

    @Override
    public void deletePlan(Long planId) {
        Plan existingPlan = userRepository.findById(planId).orElseThrow(
                () -> new ResourceNotFoundException("Plan","id",planId)
        );
        userRepository.deleteById(planId);
    }
}
