package com.example.travelsnsproject.domain.member.controller;


import com.example.travelsnsproject.config.Dto.MemberDto;
import com.example.travelsnsproject.config.aspect.TokenCheck;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable("memberId") Long memberId){
        //멤버 리턴
        return memberService.getMemberDtoById(memberId);
    }

    @TokenCheck
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        //멤버 삭제기능은 나중에 진행하자
    }

}
