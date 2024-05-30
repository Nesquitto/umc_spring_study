package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.dto.ReviewRequest.CreateReviewRequest;
import com.umc.spring.dto.ReviewResponse.GetReviewDetail;
import com.umc.spring.service.ReviewService;
import com.umc.spring.validation.annotation.CheckPage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;


    @PostMapping("/")
    public ApiResponse<String> createRestaurant(
        @RequestBody @Valid CreateReviewRequest createReviewRequest
    ){
        return ApiResponse.onSuccess(reviewService.createReview(createReviewRequest));
    }

    @GetMapping("/")
    @Operation(summary = "유저의 리뷰 리스트 가져오기", description = "유저가 작성한 모든 리뷰를 가져옵니다.")
    public ApiResponse<List<GetReviewDetail>> getMyReviewList(
        @RequestParam Long id, @CheckPage @RequestParam Integer page
    ){
        return ApiResponse.onSuccess(reviewService.getMyReviewList(id, page));
    }
}