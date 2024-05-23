package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.dto.UserMissionRequest.CreateUserMissionRequest;
import com.umc.spring.service.MissionService;
import com.umc.spring.service.UserMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usermission")
@RequiredArgsConstructor
public class UserMissionController {
    private final UserMissionService userMissionService;


    @PostMapping("/")
    public ApiResponse<String> createUserMission(
        @RequestBody CreateUserMissionRequest createUserMissionRequest
    ){
        return ApiResponse.onSuccess(userMissionService.createUserMission(createUserMissionRequest));
    }
}