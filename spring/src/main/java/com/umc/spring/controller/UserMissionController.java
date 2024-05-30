package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.dto.MissionResponse.GetMissionDetail;
import com.umc.spring.dto.ReviewResponse.GetReviewDetail;
import com.umc.spring.dto.UserMissionRequest.CreateUserMissionRequest;
import com.umc.spring.service.MissionService;
import com.umc.spring.service.UserMissionService;
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
@RequestMapping("/usermission")
@RequiredArgsConstructor
public class UserMissionController {
    private final UserMissionService userMissionService;


    @PostMapping("/")
    public ApiResponse<String> createUserMission(
        @RequestBody @Valid CreateUserMissionRequest createUserMissionRequest
    ){
        return ApiResponse.onSuccess(userMissionService.createUserMission(createUserMissionRequest));
    }

    @GetMapping("/")
    @Operation(summary = "유저 수행 미션 가져오기", description = "사용자가 수행중인 미션목록을 가져옵니다.")
    public ApiResponse<List<GetMissionDetail>> getUserMissionList(
        @RequestParam Long id, @CheckPage @RequestParam Integer page
    ){
        return ApiResponse.onSuccess(userMissionService.getActiveUserMission(id, page));
    }
}