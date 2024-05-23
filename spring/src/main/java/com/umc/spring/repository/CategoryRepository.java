package com.umc.spring.repository;

import com.umc.spring.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByName(String name);
}
