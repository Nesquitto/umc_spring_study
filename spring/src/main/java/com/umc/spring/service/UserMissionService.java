package com.umc.spring.service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.User;
import com.umc.spring.domain.mapping.UserMission;
import com.umc.spring.dto.UserMissionRequest.CreateUserMissionRequest;
import com.umc.spring.repository.MissionRepository;
import com.umc.spring.repository.UserMissionRepository;
import com.umc.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionService {
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    public String createUserMission(CreateUserMissionRequest requestDto) {
        User user = userRepository.findById(requestDto.getUser())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(requestDto.getMission())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));

        userMissionRepository.save(UserMission.toEntity(mission, user, requestDto.getMissionState(),
            requestDto.getPoint()));

        return "Success";
    }
}
