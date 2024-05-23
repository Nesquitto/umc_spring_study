package com.umc.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class RestaurantRequest {
    @Getter
    @NoArgsConstructor
    public static class CreateRestaurantRequest{
        private String name;
        private String address;
        private String category;
        private String imgUrl;
        private Float rating;

    }
}
