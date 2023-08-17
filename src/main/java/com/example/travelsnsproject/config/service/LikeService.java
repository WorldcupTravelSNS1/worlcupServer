package com.example.travelsnsproject.config.service;

import com.example.travelsnsproject.config.Dto.LikeDto;
import com.example.travelsnsproject.config.entity.Member;
import com.example.travelsnsproject.config.repository.LikeRepository;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberService memberService;

    public LikeDto saveLike(Long memberId, Long boardId){
        //member가져와서 boardId likeTable에 있는지 확인한 이후에=>이 로직 할려니까 좀 많이 필요하다. 잠시 대기
        //없으면 like save하고, board값 +1
        Member member = memberService.getMeberById(memberId);
        return null;

    }
}
