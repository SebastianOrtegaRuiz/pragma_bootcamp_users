package com.pragma.foodCourt.application.mapper.feign;

import java.awt.*;
import java.util.List;

import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="restaurantFeign", url="localhost:8082/api2/v1")
public interface RestaurantFeignClient {

    @GetMapping(value = "/dishes/")
    List<RestaurantFeignDto> getAll();

}
