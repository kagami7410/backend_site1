package com.mysite.site1.repository;

import com.mysite.site1.models.SingleContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<SingleContent, Long> {
}
