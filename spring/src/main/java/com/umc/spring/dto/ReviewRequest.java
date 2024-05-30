package com.umc.spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequest {

    @Getter
    @NoArgsConstructor
    public static class CreateReviewRequest{
        @Positive
        private Long user;
        @Positive
        private Long restaurant;
        @Positive
        private Float rating;
        @NotNull
        private String content;
    }
}
