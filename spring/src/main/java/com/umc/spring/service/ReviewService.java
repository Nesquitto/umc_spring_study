package com.umc.spring.service;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHandler;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.domain.User;
import com.umc.spring.dto.ReviewRequest.CreateReviewRequest;
import com.umc.spring.dto.ReviewResponse.GetReviewDetail;
import com.umc.spring.repository.RestaurantRepository;
import com.umc.spring.repository.ReviewRepository;
import com.umc.spring.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public String createReview(CreateReviewRequest requestDto) {
        User user = userRepository.findById(requestDto.getUser())
            .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurant())
                .orElseThrow(() -> new TempHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        reviewRepository.save(Review.toEntity(user, restaurant, requestDto));

        return "Success";
    }

    public List<GetReviewDetail> getMyReviewList(Long id, int page){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Page<Review> reviewList = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));

        return reviewList.stream()
            .map(GetReviewDetail::toDto)
            .toList();

    }
}
