package com.umc.spring.dto;

import com.umc.spring.domain.Mission;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetMissionDetail{

        private LocalDateTime deadLine;
        private String name;
        private String description;
        private String status;
        private int point;


        public static GetMissionDetail toDto(Mission mission){
            return GetMissionDetail.builder()
                .name(mission.getName())
                .description(mission.getDescription())
                .status(mission.getMissionStatus())
                .point(mission.getPoint())
                .build();
        }
    }

}
