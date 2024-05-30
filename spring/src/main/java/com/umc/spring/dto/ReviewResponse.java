package com.umc.spring.dto;

import com.umc.spring.domain.Review;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetReviewDetail{
        @NotNull
        private String name;
        @Positive
        private Float rating;
        @NotNull
        private String content;

        public static GetReviewDetail toDto(Review review){
            return GetReviewDetail.builder()
                .name(review.getUser().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .build();
        }
    }

}
