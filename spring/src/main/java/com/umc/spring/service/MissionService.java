package com.umc.spring.service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.dto.MissionResponse.GetMissionDetail;
import com.umc.spring.repository.MissionRepository;
import com.umc.spring.repository.RestaurantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    public String createMission(CreateMissionRequest requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurant())
            .orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        missionRepository.save(Mission.toEntity(requestDto, restaurant));

        return "Success";
    }

    public List<GetMissionDetail> getRestaurantMissionList(Long id, int page){
        Restaurant restaurant = restaurantRepository.findById(id)
            .orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Page<Mission> missionList = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));

        return missionList.stream()
            .map(GetMissionDetail::toDto)
            .toList();
    }
}
