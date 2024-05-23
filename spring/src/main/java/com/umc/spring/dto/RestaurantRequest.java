package com.umc.spring.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RestaurantRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateRestaurantRequest{
        @NotNull
        private String name;
        @NotNull
        private String address;
        @NotNull
        private String category;
        @NotNull
        private String imgUrl;
        @Positive
        private Float rating;

    }
}
