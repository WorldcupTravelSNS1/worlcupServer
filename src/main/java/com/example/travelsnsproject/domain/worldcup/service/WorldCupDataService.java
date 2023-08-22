package com.example.travelsnsproject.domain.worldcup.service;

import com.example.travelsnsproject.domain.worldcup.repository.WorldCupDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldCupDataService {
    private final WorldCupDataRepository worldcupDataRepository;
}
