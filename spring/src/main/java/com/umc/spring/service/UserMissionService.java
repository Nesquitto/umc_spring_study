package com.umc.spring.service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.User;
import com.umc.spring.domain.mapping.UserMission;
import com.umc.spring.dto.MissionResponse.GetMissionDetail;
import com.umc.spring.dto.UserMissionRequest.CreateUserMissionRequest;
import com.umc.spring.repository.MissionRepository;
import com.umc.spring.repository.UserMissionRepository;
import com.umc.spring.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

        // 검증
        List<UserMission> userMissionList = userMissionRepository.findAllByUserAndMission(user, mission);
        if(!userMissionList.isEmpty()){
            throw new TempHandler(ErrorStatus.USERMISSION_ALREADY_EXIST);
        }

        userMissionRepository.save(UserMission.toEntity(mission, user, requestDto.getMissionState(),
            requestDto.getPoint()));

        return "Success";
    }

    public List<GetMissionDetail> getActiveUserMission(Long id, int page){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<UserMission> userMissionList = userMissionRepository.findAllByUserAndMissionStatus(user, "IN_PROGRESS", PageRequest.of(page, 10));
        List<Mission> missionList = userMissionList.stream()
            .map(UserMission::getMission)
            .toList();

        return missionList.stream()
            .map(GetMissionDetail::toDto)
            .toList();
    }
}
