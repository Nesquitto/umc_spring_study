package com.umc.spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserMissionRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateUserMissionRequest {
        @Positive
        private Long mission;
        @Positive
        private Long user;
        @NotNull
        private String missionState;
        @Positive
        private int point;
    }
}