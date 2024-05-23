package com.umc.spring.repository;

import com.umc.spring.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

}
