package com.example.travelsnsproject.config.repository;

import com.example.travelsnsproject.config.entity.LikeCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeCount,Long> {
}
