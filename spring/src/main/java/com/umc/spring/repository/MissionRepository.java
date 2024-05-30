package com.umc.spring.repository;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
