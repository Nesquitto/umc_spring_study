package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.MissionStatus;
import com.umc.spring.dto.MissionRequest.CreateMissionRequest;
import com.umc.spring.dto.RestaurantRequest.CreateRestaurantRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String missionStatus;

    @Column(nullable = false)
    private LocalDateTime deadline;

    public static Mission toEntity(CreateMissionRequest requestDto, Restaurant restaurant){
        return Mission.builder()
            .name(requestDto.getName())
            .point(requestDto.getPoint())
            .description(requestDto.getDescription())
            .restaurant(restaurant)
            .missionStatus("ACTIVE")
            .deadline(LocalDateTime.now())
            .build();
    }
}