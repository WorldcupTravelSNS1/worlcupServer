package com.example.travelsnsproject.domain.member.service;

import com.example.travelsnsproject.config.Dto.MemberDto;
import com.example.travelsnsproject.config.entity.Member;
import com.example.travelsnsproject.domain.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto getMemberDtoById(Long memberId){
        Member member=memberRepository.findById(memberId).get();
        return new MemberDto(member);
    }

    public Member getMeberById(Long memberId){
        return memberRepository.findById(memberId).get();
    }

    public Member memberSaveByUserInfo(Map userInfo){
        Member member = new Member(userInfo);
        return memberRepository.save(member);
    }

    public Optional<Member> findByEmailId(String emailId){
        return memberRepository.findByEmailId(emailId);
    }
}
