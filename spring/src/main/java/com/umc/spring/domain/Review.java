package com.umc.spring.domain;


import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.dto.ReviewRequest.CreateReviewRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private float rating;

    private String content;

    public static Review toEntity(User user, Restaurant restaurant, CreateReviewRequest requestDto){
        return Review.builder()
            .user(user)
            .restaurant(restaurant)
            .rating(requestDto.getRating())
            .content(requestDto.getContent())
            .build();
    }

}
