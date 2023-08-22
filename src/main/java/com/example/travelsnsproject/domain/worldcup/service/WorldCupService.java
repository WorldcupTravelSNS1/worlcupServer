package com.example.travelsnsproject.domain.worldcup.service;

import com.example.travelsnsproject.domain.worldcup.repository.WorldCupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldCupService {
    private final WorldCupRepository worldcupRepository;
}
