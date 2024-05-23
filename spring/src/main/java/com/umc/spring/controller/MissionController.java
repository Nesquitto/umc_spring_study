package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.service.MissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}