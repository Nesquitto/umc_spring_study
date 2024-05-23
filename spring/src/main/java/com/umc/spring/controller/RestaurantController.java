package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.RestaurantRequest.CreateRestaurantRequest;
import com.umc.spring.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/")
    public ApiResponse<String> createRestaurant(
        @RequestBody CreateRestaurantRequest createRestaurantRequest
    ){
        return ApiResponse.onSuccess(restaurantService.createRestaurant(createRestaurantRequest));
    }
}