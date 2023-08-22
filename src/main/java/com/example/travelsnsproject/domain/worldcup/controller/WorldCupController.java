package com.example.travelsnsproject.domain.worldcup.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/worldcup")
public class WorldCupController {

    @GetMapping
    public void getWorldCup(){
        //world cup 반환
    }

    @PostMapping
    public void postWorldCup(){
        //world cup 저장
    }
    @PutMapping
    public void putWorldCup(){
        //world cup 수정
    }
    @DeleteMapping
    public void deleteWorldCup(){
        //world cup 삭제
    }

}
