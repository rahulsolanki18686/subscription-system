package com.conneqt.subscription.conroller;

import com.conneqt.subscription.dto.PackageDto;
import com.conneqt.subscription.service.PackageService;
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
        name = "CRUD Rest APIS for Package Desc",
        description = "CRUD Rest APIs - Create Package, Update Package, Get Package, Get All Packages, Delete Package"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/package1s")
public class PackageController {

    private PackageService package1Service;

    @Operation(
            summary = "Create Package Rest API",
            description = "Create Package Rest API used to save package1 in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )

    @PostMapping
    public ResponseEntity<PackageDto> createPackage(@RequestBody @Valid PackageDto package1Dto) {

        PackageDto savedPackage = package1Service.createPackage(package1Dto);
        return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get Package by ID Rest API",
            description = "Get Package By Id REST API used to get single package1 from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )

    @GetMapping("{id}")
    public ResponseEntity<PackageDto> getPackageById(@PathVariable("id") Long package1Id) {

        PackageDto package1Dto = package1Service.getPackageById(package1Id);

        return new ResponseEntity<>(package1Dto, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Packages Rest API",
            description = "Get All Package REST API used to get All package1 from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @GetMapping
    public ResponseEntity<List<PackageDto>> getAllPackages() {

        List<PackageDto> package1sDto = package1Service.getAllPackages();
        return new ResponseEntity<>(package1sDto, HttpStatus.OK);
    }

    @GetMapping("testm")
    public String testMethod() {

        return "test method";
    }
    @Operation(
            summary = "Update Package by ID Rest API",
            description = "Update Package By Id REST API used to update particular package1 in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @PutMapping("{id}")
    public ResponseEntity<PackageDto> updatePackage(@PathVariable("id") Long package1Id, @RequestBody @Valid PackageDto package1Dto) {
        package1Dto.setId(package1Id);
        PackageDto updatePackage = package1Service.updatePackage(package1Dto);

        return new ResponseEntity<>(updatePackage, HttpStatus.OK);


    }
    @Operation(
            summary = "Delete Package by ID Rest API",
            description = "Delete Package By Id REST API used to delete particular package1 from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePackage(@PathVariable("id") Long package1Id) {
        package1Service.deletePackage(package1Id);
        return new ResponseEntity<>("Package successfully Deleted", HttpStatus.OK);
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
