package com.umc.spring.dto;

import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.MissionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateMissionRequest {
        @NotNull
        private String name;
        @Positive
        private Integer point;
        @NotNull
        private String description;
        @Positive
        private Long restaurant;
    }
}