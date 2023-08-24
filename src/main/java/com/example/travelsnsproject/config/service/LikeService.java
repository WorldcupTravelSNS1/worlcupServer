package com.example.travelsnsproject.config.service;

import com.example.travelsnsproject.config.Dto.LikeDto;
import com.example.travelsnsproject.config.entity.Board;
import com.example.travelsnsproject.config.entity.LikeCount;
import com.example.travelsnsproject.config.entity.Member;
import com.example.travelsnsproject.config.repository.LikeRepository;
import com.example.travelsnsproject.domain.board.service.BoardService;
import com.example.travelsnsproject.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {
    private final LikeRepository likeRepository;
    private final BoardService boardService;

    public LikeDto saveOrDeleteLike(Long memberId, Long boardId){
        Member member = Member.builder().id(memberId).build();
        Board board = boardService.findById(boardId);
        Optional<LikeCount> likeCount= likeRepository.findByMemberIdAndBodarId(member,board);
        LikeCount check = likeCount.orElse(null);
        if (check == null){
            LikePlus(member,board);
        }
        else {
            LikeMinus(check, board);
        }
        return null;
    }

    public void LikePlus(Member member, Board board){
        LikeCount likeCount1=likeRepository.save(new LikeCount(null,board,member));
        //여기서 로직 오류가 발생
        board.setLikeCount(board.getLikeCount()+1);
    }

    public void LikeMinus(LikeCount likeCount,Board board){
        board.setLikeCount(board.getLikeCount()-1);
        likeRepository.delete(likeCount);
    }



}
