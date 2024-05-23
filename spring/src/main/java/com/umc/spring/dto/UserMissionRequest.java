package com.umc.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserMissionRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateUserMissionRequest {
        private Long mission;
        private Long user;
        private String missionState;
        private int point;
    }
}