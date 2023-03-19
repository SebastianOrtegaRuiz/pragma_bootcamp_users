package com.pragma.foodCourt.infraestructure.input.rest;

import com.pragma.foodCourt.application.dto.request.RolesRequestDto;
import com.pragma.foodCourt.application.dto.response.RolesResponseDto;
import com.pragma.foodCourt.application.handler.IRolesHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Api(value = "Roles CRUD")
public class RolesRestController {
    private final IRolesHandler rolesHandler;

    @ApiOperation(value = "Save a role ")
    @PostMapping("/")
    public ResponseEntity<Void> saveRoles(@ApiParam(value = "require a JSON format Object to save a rol, only if necessary", required = true) @RequestBody RolesRequestDto rolesRequestDto) {
        rolesHandler.saveRoles(rolesRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all roles", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<RolesResponseDto>> getAllRoles() {
        return ResponseEntity.ok(rolesHandler.getAllRoles());
    }
}
