package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.dto.MissionResponse.GetMissionDetail;
import com.umc.spring.dto.ReviewResponse.GetReviewDetail;
import com.umc.spring.service.MissionService;
import com.umc.spring.validation.annotation.CheckPage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;


    @PostMapping("/")
    public ApiResponse<String> createMission(
        @RequestBody @Valid CreateMissionRequest createMissionRequest
    ){
        return ApiResponse.onSuccess(missionService.createMission(createMissionRequest));
    }

    @GetMapping("/")
    @Operation(summary = "식당의 미션 리스트 가져오기", description = "특정 식당에서 관리하는 모든 미션의 리스트를 가져옵니다.")
    public ApiResponse<List<GetMissionDetail>> getMissionList(
        @RequestParam Long id, @CheckPage @RequestParam Integer page
    ){
        return ApiResponse.onSuccess(missionService.getRestaurantMissionList(id, page));
    }
}