package com.example.travelsnsproject.domain.member.controller;


import com.example.travelsnsproject.config.Dto.MemberDto;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/board/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberid}")
    public MemberDto getMember(@PathVariable("memberId") Long memberId){
        //멤버 리턴
        return memberService.getMemberDtoById(memberId);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        //멤버 삭제기능은 나중에 진행하자
    }

}
