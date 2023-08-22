package com.conneqt.subscription.conroller;

import com.conneqt.subscription.dto.PlanDto;
import com.conneqt.subscription.service.PlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD Rest APIS for Plan Desc",
        description = "CRUD Rest APIs - Create Plan, Update Plan, Get Plan, Get All Plans, Delete Plan"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/plans")
public class PlanController {

    private PlanService planService;

    @Operation(
            summary = "Create Plan Rest API",
            description = "Create Plan Rest API used to save plan in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )

    @PostMapping
    public ResponseEntity<PlanDto> createPlan(@RequestBody @Valid PlanDto planDto) {

        PlanDto savedPlan = planService.createPlan(planDto);
        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get Plan by ID Rest API",
            description = "Get Plan By Id REST API used to get single plan from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )

    @GetMapping("{id}")
    public ResponseEntity<PlanDto> getPlanById(@PathVariable("id") Long planId) {

        PlanDto planDto = planService.getPlanById(planId);

        return new ResponseEntity<>(planDto, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Plans Rest API",
            description = "Get All Plan REST API used to get All plan from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @GetMapping
    public ResponseEntity<List<PlanDto>> getAllPlans() {

        List<PlanDto> plansDto = planService.getAllPlans();
        return new ResponseEntity<>(plansDto, HttpStatus.OK);
    }

    @GetMapping("testm")
    public String testMethod() {

        return "test method";
    }
    @Operation(
            summary = "Update Plan by ID Rest API",
            description = "Update Plan By Id REST API used to update particular plan in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @PutMapping("{id}")
    public ResponseEntity<PlanDto> updatePlan(@PathVariable("id") Long planId, @RequestBody @Valid PlanDto planDto) {
        planDto.setId(planId);
        PlanDto updatePlan = planService.updatePlan(planDto);

        return new ResponseEntity<>(updatePlan, HttpStatus.OK);


    }
    @Operation(
            summary = "Delete Plan by ID Rest API",
            description = "Delete Plan By Id REST API used to delete particular plan from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlan(@PathVariable("id") Long planId) {
        planService.deletePlan(planId);
        return new ResponseEntity<>("Plan successfully Deleted", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
//
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
