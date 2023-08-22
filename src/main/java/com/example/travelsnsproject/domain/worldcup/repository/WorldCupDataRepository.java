package com.example.travelsnsproject.domain.worldcup.repository;

import com.example.travelsnsproject.config.entity.WorldCupData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldCupDataRepository extends JpaRepository<WorldCupData, Long> {
}
