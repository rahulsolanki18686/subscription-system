package com.conneqt.subscription.conroller;

import com.conneqt.subscription.dto.ChannelDto;
import com.conneqt.subscription.service.ChannelService;
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
        name = "CRUD Rest APIS for Channel Desc",
        description = "CRUD Rest APIs - Create Channel, Update Channel, Get Channel, Get All Channels, Delete Channel"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/channels")
public class ChannelController {

    private ChannelService channelService;

    @Operation(
            summary = "Create Channel Rest API",
            description = "Create Channel Rest API used to save channel in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )

    @PostMapping
    public ResponseEntity<ChannelDto> createChannel(@RequestBody @Valid ChannelDto channelDto) {

        ChannelDto savedChannel = channelService.createChannel(channelDto);
        return new ResponseEntity<>(savedChannel, HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get Channel by ID Rest API",
            description = "Get Channel By Id REST API used to get single channel from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )

    @GetMapping("{id}")
    public ResponseEntity<ChannelDto> getChannelById(@PathVariable("id") Long channelId) {

        ChannelDto channelDto = channelService.getChannelById(channelId);

        return new ResponseEntity<>(channelDto, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Channels Rest API",
            description = "Get All Channel REST API used to get All channel from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @GetMapping
    public ResponseEntity<List<ChannelDto>> getAllChannels() {

        List<ChannelDto> channelsDto = channelService.getAllChannels();
        return new ResponseEntity<>(channelsDto, HttpStatus.OK);
    }

    @GetMapping("testm")
    public String testMethod() {

        return "test method";
    }
    @Operation(
            summary = "Update Channel by ID Rest API",
            description = "Update Channel By Id REST API used to update particular channel in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @PutMapping("{id}")
    public ResponseEntity<ChannelDto> updateChannel(@PathVariable("id") Long channelId, @RequestBody @Valid ChannelDto channelDto) {
        channelDto.setId(channelId);
        ChannelDto updateChannel = channelService.updateChannel(channelDto);

        return new ResponseEntity<>(updateChannel, HttpStatus.OK);


    }
    @Operation(
            summary = "Delete Channel by ID Rest API",
            description = "Delete Channel By Id REST API used to delete particular channel from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChannel(@PathVariable("id") Long channelId) {
        channelService.deleteChannel(channelId);
        return new ResponseEntity<>("Channel successfully Deleted", HttpStatus.OK);
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
