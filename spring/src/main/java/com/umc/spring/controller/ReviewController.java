package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.ReviewRequest.CreateReviewRequest;
import com.umc.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;


    @PostMapping("/")
    public ApiResponse<String> createRestaurant(
        @RequestBody CreateReviewRequest createReviewRequest
    ){
        return ApiResponse.onSuccess(reviewService.createReview(createReviewRequest));
    }
}