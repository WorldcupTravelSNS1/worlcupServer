package com.example.travelsnsproject.domain.worldcup.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/worldcupdata")
public class WorldCupDataController {
    @GetMapping
    public void getWorldCupData(){
        //world cup 반환
    }

    @PostMapping
    public void postWorldCupData(){
        //world cup 저장
    }

    @PutMapping
    public void putWorldCupData(){
        //world cup 수정
    }

    @DeleteMapping
    public void deleteWorldCupData(){
        //world cup 삭제
    }

}
