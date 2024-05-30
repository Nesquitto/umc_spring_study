package com.umc.spring.service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;
import com.umc.spring.domain.Category;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.dto.MissionResponse.GetMissionDetail;
import com.umc.spring.dto.RestaurantRequest.CreateRestaurantRequest;
import com.umc.spring.repository.CategoryRepository;
import com.umc.spring.repository.RestaurantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final CategoryRepository categoryRepository;
    private final RestaurantRepository restaurantRepository;

    public String createRestaurant(CreateRestaurantRequest requestDto) {
        Category category = categoryRepository.findByName(requestDto.getCategory());
        restaurantRepository.save(Restaurant.toEntity(requestDto, category));
        return "Success";
    }
}
