package com.umc.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateReviewRequest{
        private Long user;
        private Long restaurant;
        private Float rating;
        private String content;
    }
}
