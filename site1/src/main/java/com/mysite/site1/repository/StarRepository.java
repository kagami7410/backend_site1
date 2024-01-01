package com.mysite.site1.repository;

import com.mysite.site1.models.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
}
