package com.pragma.foodCourt.infraestructure.input.rest;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.application.dto.response.UsersResponseDto;
import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;
import com.pragma.foodCourt.application.handler.IUsersHandler;
import com.pragma.foodCourt.infraestructure.exception.NoValidNumber;
import com.pragma.foodCourt.infraestructure.utility.IUtilities;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Api(value = "Users CRUD")
public class UsersRestController {
    private final IUsersHandler usersHandler;

    private IUtilities utilities;

    @Autowired
    public void setUtilities(IUtilities utilities) { this.utilities = utilities;}

    @ApiOperation(value = "Save an user")
    @PostMapping("/")
    public ResponseEntity<UsersResponseDto> saveUsers(@ApiParam(value = "require a JSON format Object to save an user", required = true) @RequestBody UsersRequestDto usersRequestDto) {

        if(!utilities.validPhoneNumber(usersRequestDto.getCellphone())) {
            throw new NoValidNumber();
        }

        utilities.encryptPass(usersRequestDto);

        return ResponseEntity.ok(usersHandler.saveUsers(usersRequestDto));
    }

    @ApiOperation(value = "Save a Client")
    @PostMapping("/client")
    public ResponseEntity<UsersResponseDto> saveClient(@ApiParam(value = "require a JSON format Object to save an user for client", required = true)
                                                       @RequestBody UsersRequestDto usersRequestDto) {

        if(!utilities.validPhoneNumber(usersRequestDto.getCellphone())) {
            throw new NoValidNumber();
        }

        utilities.encryptPass(usersRequestDto);
        usersRequestDto.setId_rol(4L);
        System.out.println(usersRequestDto.getId_rol());

        return ResponseEntity.ok(usersHandler.saveClient(usersRequestDto));
    }

    @ApiOperation(value = "Get a list of all users", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<UsersResponseDto>> getAllUsers() {
        return ResponseEntity.ok(usersHandler.getAllUsers());
    }

    @ApiOperation(value = "Get a list of all users", response = List.class)
    @GetMapping("/dishes")
    public ResponseEntity<List<RestaurantFeignDto>> getAllRestaurants() {
        return ResponseEntity.ok(usersHandler.getAllRestaurants());
    }

    @ApiOperation(value = "Get one specific user by id", response = UsersResponseDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> getUserById(@ApiParam(value = "id to search for a specific user", required = true) @PathVariable("id") Long id) {
        return ResponseEntity.ok(usersHandler.getUserById(id));
    }

    @ApiOperation(value = "Get one specific user by email", response = UsersResponseDto.class)
    @GetMapping("/byEmail/{email}")
    public ResponseEntity<UsersResponseDto> getUserByEmail(@ApiParam(value = "email to search for a specific user", required = true) @PathVariable("email") String email) {
        return ResponseEntity.ok(usersHandler.getUserByEmail(email));
    }
}
