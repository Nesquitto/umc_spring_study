package com.umc.spring.repository;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.User;
import com.umc.spring.domain.mapping.UserMission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    List<UserMission> findAllByUserAndMission(User user, Mission mission);

}
