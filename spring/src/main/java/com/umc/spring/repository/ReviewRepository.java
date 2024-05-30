package com.umc.spring.repository;

import com.umc.spring.domain.Review;
import com.umc.spring.domain.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
