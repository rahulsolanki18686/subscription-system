package com.conneqt.subscription.conroller;

import com.conneqt.subscription.dto.SubscriptionDto;
import com.conneqt.subscription.service.SubscriptionService;
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
        name = "CRUD Rest APIS for Subscription Desc",
        description = "CRUD Rest APIs - Create Subscription, Update Subscription, Get Subscription, Get All Subscriptions, Delete Subscription"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/subscriptions")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Operation(
            summary = "Create Subscription Rest API",
            description = "Create Subscription Rest API used to save subscription in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )

    @PostMapping
    public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody @Valid SubscriptionDto subscriptionDto) {

        SubscriptionDto savedSubscription = subscriptionService.createSubscription(subscriptionDto);
        return new ResponseEntity<>(savedSubscription, HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get Subscription by ID Rest API",
            description = "Get Subscription By Id REST API used to get single subscription from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )

    @GetMapping("{id}")
    public ResponseEntity<SubscriptionDto> getSubscriptionById(@PathVariable("id") Long subscriptionId) {

        SubscriptionDto subscriptionDto = subscriptionService.getSubscriptionById(subscriptionId);

        return new ResponseEntity<>(subscriptionDto, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Subscriptions Rest API",
            description = "Get All Subscription REST API used to get All subscription from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> getAllSubscriptions() {

        List<SubscriptionDto> subscriptionsDto = subscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptionsDto, HttpStatus.OK);
    }

    @GetMapping("testm")
    public String testMethod() {

        return "test method";
    }
    @Operation(
            summary = "Update Subscription by ID Rest API",
            description = "Update Subscription By Id REST API used to update particular subscription in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @PutMapping("{id}")
    public ResponseEntity<SubscriptionDto> updateSubscription(@PathVariable("id") Long subscriptionId, @RequestBody @Valid SubscriptionDto subscriptionDto) {
        subscriptionDto.setSubscriptionId(subscriptionId);
        SubscriptionDto updateSubscription = subscriptionService.updateSubscription(subscriptionDto);

        return new ResponseEntity<>(updateSubscription, HttpStatus.OK);


    }
    @Operation(
            summary = "Delete Subscription by ID Rest API",
            description = "Delete Subscription By Id REST API used to delete particular subscription from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable("id") Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return new ResponseEntity<>("Subscription successfully Deleted", HttpStatus.OK);
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
